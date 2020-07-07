package com.infoshareacademy.servlet.servletDao;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.Dto.UserDto;
import com.infoshareacademy.entity.User;
import com.infoshareacademy.freemarker.TemplateCreator;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.servisDao.UserService;
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
import java.util.Map;
import java.util.Optional;

import static com.infoshareacademy.resolver.InputResolver.inputStreamToString;

@WebServlet({"/user","/edit-user"})
public class UserServlet extends HttpServlet {

    private static Logger LOGGER = LogManager.getLogger(AccountInfoServlet.class.getName());

    @Inject
    UserService service;

    @Inject
    TemplateProvider provider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String requestURI = req.getRequestURI();

        Map<String, Object> dataModel = new HashMap<>();

        HttpSession session = req.getSession();
        String loginUser = (String) session.getAttribute("login");
        String incorrectParameters = (String) session.getAttribute("exist");
        String emptyParameters = (String) session.getAttribute("empty");
        String incorrectPassword = (String) session.getAttribute("incorrectPassword");

        if (!StringUtils.isEmpty(loginUser)) {
            Optional<User> user = service.findByNickname(loginUser);
            user.ifPresent(u -> dataModel.put("user", u));

            if (!StringUtils.isEmpty(incorrectParameters) ) {
                dataModel.put("incorrectParameters", "true");
            }
            if (!StringUtils.isEmpty(emptyParameters)) {
                dataModel.put("emptyParameters", "true");
            }
            if(!StringUtils.isEmpty(incorrectPassword)) {
                dataModel.put("incorrectPassword", "true");
            }
            if (requestURI.equals("/user")){
                TemplateCreator.createTemplate(dataModel, "user-account-data-form-before-edit.ftlh", resp, provider, getServletContext());
                return;
            }
            if (requestURI.equals("/edit-user")){
                TemplateCreator.createTemplate(dataModel,"edit-password-page.ftlh",resp,provider,getServletContext());
                return;
            }
        }

        LOGGER.info("forbidden, user not login");
        resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        dataModel.put("message", "unauthorised");
        TemplateCreator.createTemplate(dataModel, "home-page.ftlh", resp, provider, getServletContext());
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String body = inputStreamToString(req.getInputStream());
        ObjectMapper mapper = new ObjectMapper();
        UserDto user = mapper.readValue(body, UserDto.class);


        if (user != null) {
            String email = user.getEmail();
            String nickName = user.getNickName();
            String password = user.getPassword();
            String newPassword = user.getNewPassword();
            String repeatedPassword = user.getRepeatedPassword();
            Long id = user.getId();

            if (!StringUtils.isEmpty(email) && !StringUtils.isEmpty(nickName)) {
                if (!service.emailAlreadyExist(email,id) && !service.nickNameAlreadyExist(nickName, id)) {
                    service.editUserNickNameAndEmail(id, nickName, email);
                } else {
                    req.getSession().setAttribute("exist", "true");
                }
            }
            if (!StringUtils.isEmpty(password) && !StringUtils.isEmpty(newPassword) && !StringUtils.isEmpty(repeatedPassword)){
                System.out.println(service.isCorrectPassword(password,id));
                if(service.isCorrectPassword(password,id) && newPassword.equals(repeatedPassword)){
                    service.editUserPassword(id,password);
                }else {
                    req.getSession().setAttribute("incorrectPassword", "true");
                }
            }
            else {
                req.getSession().setAttribute("empty", "true");
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
