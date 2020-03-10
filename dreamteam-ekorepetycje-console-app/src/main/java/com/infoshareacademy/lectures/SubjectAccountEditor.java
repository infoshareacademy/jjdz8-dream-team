package com.infoshareacademy.lectures;

import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;
import com.infoshareacademy.menu.MenuAppearance;
import com.infoshareacademy.menu.MenuOption;
import com.infoshareacademy.menu.MenuService;
import com.infoshareacademy.userInput.UserInput;
import com.infoshareacademy.userOutput.CommandPrinter;
import com.infoshareacademy.users.TeacherAccount;
import com.infoshareacademy.users.TeacherAccountCreator;

import java.util.List;
import java.util.UUID;

import static com.infoshareacademy.fileOperations.FileNames.SUBJECTS_JSON;

public class SubjectAccountEditor {

    public void editSubjects(TeacherAccount account) {
        List<Subject> subjectList = findAllTeacherSubjects(account);
        showSubjects(subjectList);

        Subject editedSubject = returnSubjectToEdit(subjectList, account);
        MenuAppearance.showSubjectDataToEdit();
        MenuOption.changeInSubcject(editedSubject);

        MenuService.returnToDataEditMenu(account);
    }

    public List<Subject> findAllTeacherSubjects(TeacherAccount account) {
        UUID teacherId = account.getTeacher().getId();
        Subjects subjects = new Subjects();

        return subjects.findSubjectsForOneTeacher(teacherId);
    }

    public void showSubjects(List<Subject> subjectList) {
        CommandPrinter.showSubjectsHeader();
        int i = 1;
        for (Subject subject : subjectList) {
            System.out.println(i + ". " + subject);
            i++;
        }
    }

    public Subject returnSubjectToEdit(List<Subject> subjectList, TeacherAccount account) {
        if (subjectList.size() == 0) {
            System.out.println("You have any subjects entered yet.");
            TeacherAccountCreator creator = new TeacherAccountCreator();
            creator.decideToEnterSubject(account.getTeacher());
        }
        System.out.println("Which subject do you want edit");
        Subject editedSubject = uploadCorrectSubject(subjectList);
        System.out.println(editedSubject);
        System.out.println("what want you edit");

        return editedSubject;
    }

    public Subject uploadCorrectSubject(List<Subject> subjects){
        Subject subject = new Subject();
        int num = MenuOption.uploadCorrectUserInput(subjects.size());
        int choice = num - 1;
        for (int j = 0; j < subjects.size(); j++) {
            if (j == choice) {
                subject = subjects.get(j);
            }
        }
        return subject;
    }

    public void editSubjectName(Subject editedSubject) {
        System.out.println("Please enter new name for your subject");
        String newNAme = UserInput.uploadString();
        Subjects subjects = JsonReader.create(new Subjects(), SUBJECTS_JSON);
        subjects.findById(editedSubject).setName(newNAme);
        JsonSaver.createJson(subjects, SUBJECTS_JSON);
    }

    public void editSubjectTopic(Subject editedSubject) {
        System.out.println("Please enter new Topic for your subject");
        String newTopic = UserInput.uploadString();
        Subjects subjects = JsonReader.create(new Subjects(), SUBJECTS_JSON);
        subjects.findById(editedSubject).setTopic(newTopic);
        JsonSaver.createJson(subjects, "subjects.json");
    }

    public void editSubjectRange(Subject editedSubject) {
        System.out.println("Please enter new range, every phrase divide by /");
        String[] newRange = UserInput.uploadString().split("/");
        Subjects subjects = JsonReader.create(new Subjects(), SUBJECTS_JSON);
        subjects.findById(editedSubject).setRange(newRange);
        JsonSaver.createJson(subjects, "subjects.json");
    }

    public void editVideoLessonsPossibility(Subject editedSubject) {
        System.out.println();
        SubjectFactory factory = new SubjectFactory();
        factory.setSubject(editedSubject);
        System.out.println("Do you have video materials for this subject? enter yes/no");
        factory.setIsVideo();
        boolean isVideo = factory.getSubject().isVideo();

        Subjects subjects = JsonReader.create(new Subjects(), SUBJECTS_JSON);
        subjects.findById(editedSubject).setVideo(isVideo);
        JsonSaver.createJson(subjects, "subjects.json");
    }
}
