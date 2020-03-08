package com.infoshareacademy.ratings;

import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;
import com.infoshareacademy.subjects.Subject;
import com.infoshareacademy.subjects.SubjectFactory;
import com.infoshareacademy.subjects.Subjects;

import java.util.UUID;

public class Rates {
    public void createSubjectsAccount(UUID teacherID) {
        RankingFactory rankingFactory = new RankingFactory();
        rankingFactory.createRanking();
        rankingFactory.getRanking().setTeacherId(teacherID);
        savingRanking(rankingFactory.getRanking());
    }


    private void savingRanking(Subject subject) {
        Ranking ranking = JsonReader.create(new Ranking(), "ranking.json");
        ranking.addRanking(ranking);
        JsonSaver.createJson(ranking, "raiting.json");
    }

}
