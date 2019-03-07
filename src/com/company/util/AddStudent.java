package com.company.util;

import com.company.domain.Sex;
import com.company.domain.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * create by wangyu
 * 2018/10/13 0013 15:21
 */
public class AddStudent {

    public static List<Student> add() {
        List<Student> studentList = new ArrayList<>();

        Student s2 = new Student("小红", 18, Sex.WOMAN);
        Student s3 = new Student("大白", 20, Sex.WOMAN);
        Student s4 = new Student("大灰", 21, Sex.WOMAN);
        Student s5 = new Student("呓语", 21, Sex.WOMAN);

        Student s1 = new Student("小黑", 19, Sex.MAN);
        int i = s1.getName().indexOf("黑");
        System.out.println("i=" + i);

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
        return studentList;
    }

}
