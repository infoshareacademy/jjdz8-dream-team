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
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class SearchService {

    @Inject
    private Dao<Subject> subjectDao;

    @Inject
    private Dao<User> userDao;

    @Transactional
    public Optional<List<Subject>> findBySubjectName(String fraze) {
        return subjectDao
                .createNamedQueryForList
                        (SubjectQuery.FIND_BY_NAME_WHERE_NAME_IS_LIKE, SubjectColumn.NAME,fraze);
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


}
