package com.infoshareacademy.servlet.servletDao;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.entity.User;
import com.infoshareacademy.freemarker.TemplateCreator;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.servisDao.UserService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.infoshareacademy.resolver.InputResolver.inputStreamToString;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private static Logger LOGGER = LogManager.getLogger(AccountInfoServlet.class.getName());

    @Inject
    UserService service;

    @Inject
    TemplateProvider provider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        Map<String, Object> dataModel = new HashMap<>();

        HttpSession session = req.getSession();
        String loginUser =(String) session.getAttribute("login");

        if (!StringUtils.isEmpty(loginUser)) {
            Optional<User> user = service.findByNickname(loginUser);
            user.ifPresent(u->dataModel.put("user", u));
            TemplateCreator.createTemplate(dataModel,"user-account-data-form-before-edit.ftlh",resp,provider,getServletContext());
        } else {
            LOGGER.info("forbidden, user not login");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            dataModel.put("message","unauthorised");
            TemplateCreator.createTemplate(dataModel,"home-page.ftlh",resp,provider,getServletContext());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String body = inputStreamToString(req.getInputStream());
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(body, User.class);
        if (user != null) {
            if (!StringUtils.isEmpty(user.getEmail()) && !StringUtils.isEmpty(user.getNickName())) {
            }
        }
    }

    /*    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute(SESSION_MARK) == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        String id = req.getParameter("id");
        if (StringUtils.isEmpty(id)) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Optional<User> user = service.findById(UUID.fromString(id));
        if (user.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        service.delete(user.get());
        req.getSession(false).invalidate();
    }*/
}
