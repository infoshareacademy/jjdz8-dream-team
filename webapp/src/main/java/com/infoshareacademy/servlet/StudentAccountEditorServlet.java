package com.infoshareacademy.servlet;

import com.infoshareacademy.service.EditService;
import com.infoshareacademy.service.Service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-student-account")
public class StudentAccountEditorServlet extends UserEditServlet {

    @Inject
    @Named("StudentEditService")
    private EditService userEditService;

    @Inject
    @Named("StudentService")
    private Service userService;

    private static final String SESSION_ATTRIBUTE ="studentID";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setSessionAttribute(SESSION_ATTRIBUTE);
        setTemplateFile("student-account-data-after-edit-new.ftlh");
        doGetMethod(req, resp, userService);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setSessionAttribute(SESSION_ATTRIBUTE);
        setRedirectAfterCorrectForm("/student");
        setRedirectAfterInCorrectForm("/edit-student-account");
        doPostMethod(req, resp, userService, userEditService);
    }
}
