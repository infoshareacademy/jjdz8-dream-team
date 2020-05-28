package com.infoshareacademy.servlet;

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
    @Named("TeacherEditService")
    private EditService userEditService;

    @Inject
    @Named("TeacherService")
    private Service userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setTemplateFile("teacher-account-data-after-edit.ftlh");
        doGetMethod(req, resp, userService);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setRedirectAfterCorrectForm("/teacher-account-information");
        setRedirectAfterInCorrectForm("/edit-teacher-account");
        doPostMethod(req, resp, userService, userEditService);
    }
}
