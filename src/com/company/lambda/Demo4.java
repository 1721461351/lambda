package com.company.lambda;

import com.company.domain.Sex;
import com.company.domain.Student;
import com.company.util.AddStudent;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * create by wangyu
 * 2018/10/14 0014 10:11
 * 利用lambda表达式实现集合
 * 利用了Stream.of();的方法
 */
public class Demo4 {

//    利用stream创建一个string类型的集合，并遍历
    @Test
    public void createList(){
//        创建一个string类型的list集合
        List<String> stringList = Stream.of("you", "are", "the", "best").collect(Collectors.toList());
//        遍历list集合
        stringList.forEach(P -> System.out.println(P));
    }

//    创建一个自定义对象的集合，并遍历

    @Test
    public void list(){
//        由于AddStudent.add()的返回对象是一个list，再打成list就变成了两个list集合嵌套
        List<List<Student>> listList = Stream.of(AddStudent.add())//把对象加入到stream中去
                .collect(Collectors.toList());//把stream打成list集合
    }

//    遍历原始的集合，并把这个集合转化为另一个集合。
    @Test
    public void conver(){
        Student student = new Student("王宇",22, Sex.MAN);
//        利用stream.of把此流转化为list集合
        List<Student> studentList = Stream
                .of(student)
                .collect(Collectors.toList());
//        把上一个list集合打成了另一个list集合，遍历并输出
        studentList
                .stream()
                .map(Student::getAge)
                .collect(Collectors.toList())
                .forEach(s -> System.out.println(s));
    }

    /**
     * 得到学生对象中年龄的总和
     */
    @Test
    public void listOragin(){
        Student student = new Student("hello",22, Sex.MAN);
        Student student1 = new Student("word",28, Sex.MAN);
//        利用stream.of把此流转化为list集合
        List<Student> studentList = Stream
                .of(student,student1)
                .collect(Collectors.toList());
        Double average = studentList.stream().mapToDouble(Student::getAge).average().getAsDouble();
        System.out.println(average);

//把stream打成list集合
    }

    @Test
    public void test(){
        Student student = new Student("hello",22, Sex.MAN);
        Student student1 = new Student("word",28, Sex.MAN);
//        利用stream.of把此流转化为list集合
        List<Student> studentList = Stream
                .of(student,student1)
                .collect(Collectors.toList());
        studentList.stream()
                .forEach(student2 -> System.out.println(student2));
        double sum = studentList.stream().mapToDouble((Student::getAge)).sum();
        System.out.println(sum);
//把stream打成list集合
    }


    @Test
    public void reductionStream() {
        Stream<String> wordList = Stream.of("bj","tj","sh","yy","yq").distinct();
        Optional<String> firstWord = wordList.filter(word -> word.startsWith("a")).findFirst();
//        此输出说明如果firstWord如果为空就输出unknown
        System.out.println(firstWord.orElse("unknown"));
    }


}
