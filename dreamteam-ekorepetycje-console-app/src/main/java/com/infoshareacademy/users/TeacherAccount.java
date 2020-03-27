package com.infoshareacademy.users;

import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.security.PasswordCoding;
import com.infoshareacademy.menu.MenuService;
import com.infoshareacademy.userInput.UserInput;
import com.infoshareacademy.userOutput.CommandPrinter;

import static com.infoshareacademy.fileOperations.FileNames.TEACHERS_JSON;

public class TeacherAccount {

    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public boolean logIn() {
        CommandPrinter.enterNicknameHeader();
        String username = uploadCorrectNickname();
        CommandPrinter.enterYourPasswordHeader();
        acceptCorrectPassword(username);
        Teachers teachers = JsonReader.create(new Teachers(), TEACHERS_JSON);
        if (teachers.findByNickname(username).isPresent()) {
            setTeacher(teachers.findByNickname(username).get());
            CommandPrinter.accessGrantedHeader();

            return true;
        }
        return false;
    }

    public String uploadCorrectNickname() {
        String nickName = UserInput.uploadString();
        int badNicknameCounter = 0;
        while (!Teachers.teacherAlreadyExist(nickName)) {
            if (badNicknameCounter == 5) {
                System.out.println("You have entered 5 times incorrect nickname");
                MenuService.returnToMainMenu();
                break;
            }
            System.out.println("Incorrect nickName. Please try again ");
            nickName = UserInput.uploadString();
            badNicknameCounter++;
        }

        return nickName;
    }

    public void acceptCorrectPassword(String username) {
        String password = UserInput.uploadString();
        String hashPassword = PasswordCoding.passwordHashing(password);
        int badPasswordCount = 0;
        while (!isPasswordCorrect(username, hashPassword)) {
            if (badPasswordCount == 5) {
                System.out.println("You have entered 5 times incorrect password");
                MenuService.returnToMainMenu();
                break;
            }
            System.out.println("Incorrect password, please try again");
            hashPassword = PasswordCoding.passwordHashing(UserInput.uploadString());
            badPasswordCount++;
        }
    }

    public boolean isPasswordCorrect(String userNAme, String password) {
        Teachers teachers = JsonReader.create(new Teachers(), TEACHERS_JSON);
        for (Teacher teacher : teachers.getTeachers()) {
            if (teacher.getPassword().equals(password) && teacher.getNickName().equals(userNAme)) {

                return true;
            }
        }

        return false;
    }
}
