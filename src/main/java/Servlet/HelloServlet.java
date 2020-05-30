package Servlet;

import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet( name = "UserServlet", urlPatterns = {"/users2"})
public class HelloServlet extends HttpServlet {

        private static final long serialVersionUID = 1L;

        private static List<User> userList = new ArrayList<User>();


        static {
            userList.add(new User("Kasia", 5));
            userList.add(new User("Ola", 6));
            userList.add(new User("Wiktor", 4.5));
            userList.add(new User("Adam", 2));
            userList.add(new User("Beata", 2.4));

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Template template = new TemplateProvider().getTemplate(getServletContext(), "template.ftlh");

            Map<String, Object> model = new HashMap<>();
        try {
            template.process(model, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        //request.setAttribute("users2", userList);

        // request.getRequestDispatcher("/template.ftlh").forward(request, response);

    }
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            String firstname = request.getParameter("name");
          Integer lastname = Integer.parseInt(request.getParameter("grade"));

            if(null != firstname && null != lastname
                    && !firstname.isEmpty() ){

                synchronized (userList) {
                    userList.add(new User(firstname, lastname));
                }

            }

            doGet(request, response);
        }
}
