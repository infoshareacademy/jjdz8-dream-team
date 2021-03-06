package com.infoshareacademy.service.servisDao;

import com.infoshareacademy.dao.Dao;
import com.infoshareacademy.entity.Subject;
import com.infoshareacademy.entity.SubjectColumn;
import com.infoshareacademy.entity.SubjectQuery;
import com.infoshareacademy.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class SearchHelperService {

    @Inject
    private Dao<Subject> subjectDao;

    @Inject
    private Dao<User> userDao;

    @Transactional
    public Optional<List<Subject>> findBySubjectName(String fraze, int limit, int offset) {
        return subjectDao
                .createNamedQueryForOffSetAndLimit
                        (SubjectQuery.FIND_BY_NAME_WHERE_NAME_IS_LIKE, SubjectColumn.NAME,fraze,offset, limit);
    }

    public Optional<List<Subject>> findBySubjectTopic(String fraze, int limit, int offset) {
        return subjectDao
                .createNamedQueryForOffSetAndLimit
                        (SubjectQuery.FIND_BY_TOPIC_WHERE_TOPIC_IS_LIKE, SubjectColumn.TOPIC,fraze,offset,limit);
    }

    public Optional<List<Subject>> findBySubjectDescription(String fraze,int limit, int offset) {
        return subjectDao
                .createNamedQueryForOffSetAndLimit
                        (SubjectQuery.FIND_BY_DESCRIPTION_WHERE_DESCRIPTION_IS_LIKE, SubjectColumn.DESCRIPTION,fraze,offset,limit);
    }
}
