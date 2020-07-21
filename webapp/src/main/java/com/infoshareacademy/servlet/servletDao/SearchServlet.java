package com.infoshareacademy.servlet.servletDao;

import com.infoshareacademy.entity.Subject;
import com.infoshareacademy.entity.User;
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
import java.util.*;
import java.util.stream.Collectors;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    private static Logger LOGGER = LogManager.getLogger(SearchServlet.class.getName());

    @Inject
    private TemplateProvider provider;

    @Inject
    private SearchService searchService;

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
        Integer page = (Integer) req.getAttribute("page");
        Integer subjectsLimit = 10;

        if (!StringUtils.isEmpty(filter)) {
            if (!StringUtils.isEmpty(input) && input.length()>=3){
                Optional<List<Subject>> subjects = searchService.returnSuitableSubjectList(filter, input,subjectsLimit,page);
                subjects.ifPresent(s -> {
                    if (s.size() > 0) {
                        dataModel.put("subjects", s);
                        dataModel.put("totalPages", returnPageList(calculateTotalPages(s.size())) );
                        dataModel.put("filter",filter);
                        dataModel.put("input",input);
                    } else dataModel.put("searchMessage", "brak wyników wyszukiwania do zadancyh parametrów");
                });
            } else dataModel.put("searchMessage","wprowadź co najmniej 3 znaki");

        }
        try {
            template.process(dataModel, printWriter);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (
                TemplateException e) {
            LOGGER.info(e.getLocalizedMessage());
        }
    }

    public int calculateTotalPages(int subjectsListSize) {
        if (subjectsListSize % 10 != 0 ) return (subjectsListSize/10) +1;
        else return subjectsListSize/10;
    }
    private List<Integer> returnPageList(int totalPages) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= totalPages; i++) {
            result.add(i);
        }

        return result;
    }


}
