package com.infoshareacademy.servlet.servletDao;

import com.infoshareacademy.entity.Subject;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.servisDao.SearchService;
import com.infoshareacademy.service.servisDao.SubjectService;
import com.infoshareacademy.service.servisDao.UserService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    private static Logger LOGGER = LogManager.getLogger(SearchServlet.class.getName());

    @Inject
    private TemplateProvider provider;

    @Inject
    private SearchService searchService;

    @Inject
    private UserService userService;

    @Inject
    private SubjectService subjectService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        Template template = provider.getTemplate(getServletContext(), "search-page.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        HttpSession session = req.getSession();
        String anAuthorizedAccess = (String) session.getAttribute("login");

        if (StringUtils.isEmpty(anAuthorizedAccess)) {
            dataModel.put("message", anAuthorizedAccess);
        }

        String filter = req.getParameter("filter");
        String input = req.getParameter("input");


        if (!StringUtils.isEmpty(filter)) {
            switch (filter) {
                case "name": {
                    if (StringUtils.isEmpty(input) || input.length() < 3) {
                        dataModel.put("searchMessage", "wprowadź co najmniej 3 znaki");
                        break;
                    }
                    searchService.findBySubjectName(input)
                            .ifPresent(subjects -> {
                                if (subjects.size() > 0) dataModel.put("subjects", subjects);
                                else dataModel.put("searchMessage", "brak wyników wyszukiwania do zadancyh parametrów");
                            });
                    break;
                }
                case "topic": {
                    if (StringUtils.isEmpty(input) || input.length() < 3) {
                        dataModel.put("searchMessage", "wprowadź co najmniej 3 znaki");
                        break;
                    }
                    searchService.findBySubjectTopic(input)
                            .ifPresent(subjects -> {
                                if (subjects.size() > 0) dataModel.put("subjects", subjects);
                                else dataModel.put("searchMessage", "brak wyników wyszukiwania do zadancyh parametrów");
                            });
                    break;
                }
                case "description": {
                    if (StringUtils.isEmpty(input) || input.length() < 3) {
                        dataModel.put("message", "wprowadź co najmniej 3 znaki");
                        break;
                    }
                    searchService.findBySubjectDescription(input)
                            .ifPresent(subjects -> {
                                if (subjects.size() > 0) dataModel.put("subjects", subjects);
                                else dataModel.put("searchMessage", "brak wyników wyszukiwania do zadancyh parametrów");
                            });
                    break;
                }
                case "user": {
                    userService.findByNickname(input).ifPresentOrElse(user -> dataModel.put("subjects", user.getSubjects()),
                            () -> dataModel.put("searchMessage", "brak wyników wyszukiwania do zadancyh parametrów"));
                    break;
                }
                case "all": {
                    List<Subject> subjects = subjectService.findAll();
                    if (subjects != null && subjects.size() > 0) dataModel.put("subjects", subjects);
                    else dataModel.put("searchMessage", "brak przedmiotów");
                }
            }
        }

        try {
            template.process(dataModel, printWriter);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            LOGGER.info(e.getLocalizedMessage());
        }
    }


}
