package com.infoshareacademy.servlet.servletDao;

import com.infoshareacademy.entity.Subject;
import com.infoshareacademy.entity.User;
import com.infoshareacademy.service.servisDao.GradeService;
import com.infoshareacademy.service.servisDao.SubjectService;
import com.infoshareacademy.service.servisDao.UserService;
import org.apache.commons.lang.StringUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/teacher/grades")
public class GradesServlet extends HttpServlet {

    @Inject
    UserService userService;

    @Inject
    GradeService gradeService;

    @Inject
    SubjectService subjectService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String grade = req.getParameter("grade");
        String comment = req.getParameter("comment");
  /*      String subjectId = req.getParameter("subjectId");*/

       /* HttpSession session = req.getSession();
        String anAuthorizedAccess = (String) session.getAttribute("login");

        if (StringUtils.isEmpty(anAuthorizedAccess)) {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }*/
        Subject subject = subjectService.findById(1).get();
        userService.findByNickname("kamila")
                .ifPresent(user->gradeService.saveGrade(comment,Byte.parseByte(grade),user,subject));

    }
}
