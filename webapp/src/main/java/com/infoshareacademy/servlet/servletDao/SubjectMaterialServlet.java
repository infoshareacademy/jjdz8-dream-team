package com.infoshareacademy.servlet.servletDao;

import com.infoshareacademy.entity.User;
import com.infoshareacademy.freemarker.TemplateCreator;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.servisDao.SubjectService;
import com.infoshareacademy.service.servisDao.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/subject/material")
public class SubjectMaterialServlet extends HttpServlet {

    private static Logger LOGGER = LogManager.getLogger(SubjectMaterialServlet.class.getName());

    @Inject
    private TemplateProvider provider;

    @Inject
    SubjectService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String id = req.getParameter("id");

        Map<String, Object> dataModel = new HashMap<>();
        System.out.println(id);

        HttpSession session = req.getSession();
        String loginUser = (String) session.getAttribute("login");

        if (StringUtils.isEmpty(id)) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        if (StringUtils.isEmpty(loginUser)) {
            LOGGER.info("forbidden, user not login");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            dataModel.put("message", "unauthorised");
            TemplateCreator.createTemplate
                    (dataModel, "home-page.ftlh", resp, provider, getServletContext());
            return;
        }
        service.findById(Long.valueOf(id)).ifPresent(subject -> {
            dataModel.put("subject", subject);
            dataModel.put("material", "material");
            try {
                TemplateCreator.createTemplate
                        (dataModel, "material-details.ftlh", resp, provider, getServletContext());
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


    }
}
