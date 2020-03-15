package com.infoshareacademy.dataSorter;


import com.infoshareacademy.fileOperations.FileNames;
import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.users.Teacher;
import com.infoshareacademy.users.Teachers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class  TeachersSorter {
    Teachers teachers = JsonReader.create(new Teachers(), FileNames.TEACHERS_JSON);
        private void sortTeachersByAverageRating(){
        Collections.sort(teachers.getTeachers());

        }
}
