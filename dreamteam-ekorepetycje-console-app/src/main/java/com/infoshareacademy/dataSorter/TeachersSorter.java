package com.infoshareacademy.dataSorter;

import com.infoshareacademy.fileOperations.FileNames;
import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.users.Teacher;
import com.infoshareacademy.users.TeacherService;
import com.infoshareacademy.users.Teachers;

import java.util.HashMap;
import java.util.Map;

public class  TeachersSorter {
    Teacher teacher = new Teacher();
    Teachers teachers = JsonReader.create(new Teachers(), FileNames.TEACHERS_JSON);
    private Map<Teacher,t> rankingTeacher = new HashMap();
    /*rozumiem że tutaj do mapy powinienem zaimplementować nauczyciela i pobrać dane z nauczyciela o
    rankingu ale za nic nie moge tego tam wstawić nie wiem czy utworzenie obietku jest konieczne. czy powinieniem najpierw
    do listy która zawiera wszystkie obiekty dodać geter??
     */

}

