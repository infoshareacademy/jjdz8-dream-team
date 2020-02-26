package com.infoshareacademy.users;

import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;
import com.infoshareacademy.menu.MenuService;
import com.infoshareacademy.subjects.SubjectAccountCreator;
import com.infoshareacademy.userInput.UserInput;

import java.util.UUID;

public class TeacherAccountCreator {

    public void createTeacherAccount() {
        Teacher teacher = createTeacher();
        savingTeacher(teacher);
        decideToEnterSubject(teacher.getId());
    }

    private void savingTeacher(Teacher teacher) {
        Teachers teachers = JsonReader.create(new Teachers(), "users.json");
        teachers.addTeacher(teacher);
        JsonSaver.createJson(teachers, "users.json");
    }

    private Teacher createTeacher() {
        String nickName = "";
        System.out.println("Enter Nickname");
        do {
            nickName = UserInput.uploadString();
        } while (Teachers.teacherAlreadyExist(nickName));

        TeacherFactory teacherFactory = new TeacherFactory();

        return teacherFactory.make(nickName);
    }


    private void decideToEnterSubject(UUID teacherId) {
        System.out.println("***********************************");
        System.out.println("Do you want enter subject? Yes/No");
        System.out.println("***********************************");

        String choice = UserInput.uploadString();
        while (!choice.equalsIgnoreCase("yes") || !choice.equalsIgnoreCase("no")) {
            if (choice.equalsIgnoreCase("yes")) {
                addSubjectForTeacher(teacherId);

                return;
            }
            if (choice.equalsIgnoreCase("No")) {
                returnToMainMenu();

                return;
            }

            System.out.println("please enter yes/no");
            choice = UserInput.uploadString();
        }
    }

    public void addSubjectForTeacher(UUID teacherId) {
        SubjectAccountCreator accountCreator = new SubjectAccountCreator();
        accountCreator.createSubjectsAccount(teacherId);
        decideToEnterSubject(teacherId);
    }

    private void returnToMainMenu() {
        System.out.println("Your account was safely saved!!");
        MenuService service = new MenuService();
        service.returnToMainMenu();
    }
}
