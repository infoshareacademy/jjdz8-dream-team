package com.infoshareacademy.service.servisDao;

import com.infoshareacademy.dao.Dao;
import com.infoshareacademy.entity.Subject;
import com.infoshareacademy.entity.SubjectColumn;
import com.infoshareacademy.entity.SubjectQuery;
import com.infoshareacademy.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class SearchService {

    @Inject
    private Dao<Subject> subjectDao;

    @Inject
    private Dao<User> userDao;

    @Inject
    private SearchService searchService;

    @Inject
    private UserService userService;

    @Inject
    private SubjectService subjectService;


    @Transactional
    public Optional<List<Subject>> findBySubjectName(String fraze, int limit, int page) {
        int offset;
        if (page <= 0 || page == 1 ) offset = 0;
        else offset = page * limit;
        return subjectDao
                .createNamedQueryForOffSetAndLimit
                        (SubjectQuery.FIND_BY_NAME_WHERE_NAME_IS_LIKE, SubjectColumn.NAME,fraze,offset, limit);
    }

    public Optional<List<Subject>> findBySubjectTopic(String fraze) {
        return subjectDao
                .createNamedQueryForList
                        (SubjectQuery.FIND_BY_TOPIC_WHERE_TOPIC_IS_LIKE, SubjectColumn.TOPIC,fraze);
    }

    public Optional<List<Subject>> findBySubjectDescription(String fraze) {
        return subjectDao
                .createNamedQueryForList
                        (SubjectQuery.FIND_BY_DESCRIPTION_WHERE_DESCRIPTION_IS_LIKE, SubjectColumn.DESCRIPTION,fraze);
    }


    public Optional<List<Subject>> returnSuitableSubjectList(String filter, String input, int limit, int page) {
        Optional<List<Subject>> subjects = Optional.empty();
        switch (filter) {
            case "name": {
                subjects = searchService.findBySubjectName(input,limit,page);
                break;
            }
            case "topic": {
                subjects = searchService.findBySubjectTopic(input);
                break;
            }
            case "rangeDescription": {
                subjects = searchService.findBySubjectDescription(input);
                break;
            }
            case "user": {
                Optional<User> user = userService.findByNickname(input);
                if (user.isPresent()) {
                    subjects = Optional.of(new ArrayList<>(user.get().getSubjects()));
                }
                break;
            }
            case "all": {
                subjects = Optional.of(subjectService.findAll());

            }
        }
        return subjects;
    }

}
