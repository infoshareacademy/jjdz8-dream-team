package com.infoshareacademy.service.servisDao;

import com.infoshareacademy.entity.Subject;
import com.infoshareacademy.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class SearchService {

    @Inject
    SearchHelperService helperService;

    @Inject
    private UserService userService;

    @Inject
    private SubjectService subjectService;


    public Optional<List<Subject>> returnSuitableSubjectList(String filter, String input, int limit, int offset) {
        Optional<List<Subject>> subjects = Optional.empty();
        switch (filter) {
            case "name": {
                subjects = helperService.findBySubjectName(input, limit, offset);
                break;
            }
            case "topic": {
                subjects = helperService.findBySubjectTopic(input, limit, offset);
                break;
            }
            case "rangeDescription": {
                subjects = helperService.findBySubjectDescription(input, limit, offset);
                break;
            }
            case "user": {
                Optional<User> user = userService.findByNickname(input, limit, offset);
                if (user.isPresent()) {
                    subjects = Optional.of(new ArrayList<>(user.get().getSubjects()));
                }
                break;
            }
            case "all": {
                subjects = Optional.of(subjectService.findAll(offset, limit));

            }
        }
        return subjects;
    }

}
