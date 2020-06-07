package com.infoshareacademy.service;

import com.infoshareacademy.domain.Subject;
/*import com.infoshareacademy.domain.Teacher;*/
import com.infoshareacademy.domain.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class SearchService {

  /*  @Inject
    private SubjectService subjectService;

    @Inject
    @Named("TeacherService")
    private Service service;


    public List<Subject> findCorrectSubjects(String filter, String value) {
        List<Subject> subjects = new ArrayList<>();
        if (filter.equals("name")) {
            subjects = subjectService.searchByName(value);
        }
        if (filter.equals("topic")) {
            subjects = subjectService.searchByTopic(value);
        }
        if (filter.equals("rangeDescription")) {
            subjects = subjectService.searchByDescription(value);
        }
        if (filter.equals("all")) {
            subjects = subjectService.findAll();
        }

        return subjects;
    }

    public void sendCorrectRedirectDependsOnFilterAndUserInput(String filter, String input, HttpServletResponse resp) throws IOException {
        switch (filter) {
            case "name": {
                resp.sendRedirect("/filter-subjects?filter=name&value=" + input);
                break;
            }
            case "topic": {
                resp.sendRedirect("/filter-subjects?filter=topic&value=" + input);
                break;
            }
            case "rangeDescription": {
                resp.sendRedirect("/filter-subjects?filter=rangeDescription&value=" + input);
                break;
            }
            case "nickName": {
                resp.sendRedirect("/filter-subjects?filter=teacherNickname&value=" + input);
                break;
            }
            case "ranking": {
                resp.sendRedirect("/filter-subjects?filter=ranking");
                break;
            }
            case "all": {
                resp.sendRedirect("/filter-subjects?filter=all");
                break;
            }
        }
    }

    public List<User> findSuitableTeachers (String partOfNickname) {
        return service.findUserByPartOfNickname(partOfNickname);
    }*/
}
