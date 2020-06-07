package com.infoshareacademy.servlet.users;

import com.infoshareacademy.service.EditService;
import com.infoshareacademy.service.Service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/edit-teacher-account")
public class TeacherAccountEditorServlet extends UserEditServlet {

    @Inject
    private EditService userEditService;

    @Inject
    private Service userService;

    private static final String SESSION_ATTRIBUTE ="teacherID";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setSessionAttribute(SESSION_ATTRIBUTE);
        setTemplateFile("teacher-account-data-after-edit-new.ftlh");
        doGetMethod(req, resp, userService);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setSessionAttribute(SESSION_ATTRIBUTE);
        setRedirectAfterCorrectForm("/teacher-account-information");
        setRedirectAfterInCorrectForm("/edit-teacher-account");
        doPostMethod(req, resp, userService, userEditService);
    }
}
