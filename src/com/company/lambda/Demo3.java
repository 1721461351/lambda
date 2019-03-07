package com.company.lambda;

import com.company.domain.Student;
import com.company.util.AddStudent;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * create by wangyu
 * 2018/10/14 0014 9:24
 * limbda表达式的一些基础的方法
 */
public class Demo3 {

//    使用lambda表达式，查询年龄大于19岁的学生信息
    @Test
    public void findLambda(){

        List<Student> studentList = AddStudent.add();
        studentList.stream()
                .filter(student -> student.getAge()>19)
                .forEach(student -> System.out.println(student));
    }

    /**
     * 利用lambda进行自定义对象的排序
     * 按照学生的年龄进行升序
     */
    @Test
    public void sortLambda(){
        List<Student> studentList = AddStudent.add();
        List<Student> students = studentList.stream()
                .sorted((Student s1, Student s2) -> s1.getAge() - s2.getAge())
                .collect(Collectors.toList());
        students.stream().forEach(student -> System.out.println(student));
    }

    /**
     * 利用传统的匿名内部类的方式进行自定义排序
     */
    @Test
    public void sort(){
        List<Student> studentList = AddStudent.add();
       studentList
               .stream()
               .sorted(new Comparator<Student>() {
           @Override
           public int compare(Student o1, Student o2) {
               return o1.getAge() - o2.getAge();
           }
       }).collect(Collectors.toList())
               .forEach(student -> System.out.println(student));
    }

    /**
     * 需求：找出名字中第一个字为"小"的学生信息
     */
    @Test
    public void findName(){
        List<Student> studentList = AddStudent.add();
        studentList.stream().filter(word -> word.getName().startsWith("小")).forEach(student -> System.out.println(student));
    }
}
