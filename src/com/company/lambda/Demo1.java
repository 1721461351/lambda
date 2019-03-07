package com.company.lambda;

import com.company.domain.Student;
import com.company.util.AddStudent;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * create by wangyu
 * 2018/10/13 0013 15:21
 * <p>
 * 此类主要是介绍了stream和filter的用法（包含了lambda的用法）
 */
public class Demo1 {


    public static void main(String[] args) {

        /**
             * 使用过滤器和lambda表达式输出年龄是18的学生信息，为什么找不到
         */
        //        添加学生
        List<Student> studentList = AddStudent.add();
        studentList.stream()
                .filter(student -> student.getAge() == 18)//过滤器，过滤出年龄等于18岁的学生信息。
                .forEach(student -> System.out.println(String.format("年龄为18岁的学生信息为:%s", student.toString())));//遍历信息并打印

        studentList.stream()
                .filter(student -> student.getAge() > 18)//过滤器，过滤出年龄等于18岁的学生信息。
                .forEach(student -> System.out.println(String.format("年龄大于18岁的学生信息为:%s", student.toString())));//遍历信息并打印
    }

    /**
     * 统计Student中名字中包含"大"字的学生信息
     */
    @Test
    public void test1() {
//        添加几个学生
        List<Student> studentList = AddStudent.add();
        studentList.stream()
                .filter(student -> student.getName().indexOf("大") >= 0)//过滤器的条件
                .forEach(student -> System.out.println("学生中包含'大'字的学生信息：" + student.toString()));//遍历结合

    }

    /**
     * 统计student中名字包含"小"字的并计算他们的平均年龄
     */
    @Test
    public void test2() {
        List<Student> students = AddStudent.add();
        double average = students.stream()
                .filter(student -> student.getName().indexOf("小") >= 0)//过滤器，选择了名字带有"小"字的
                .mapToDouble(student -> student.getAge())//获取了过滤器中学生的年龄
                .average()//计算了他们的平均值
                .getAsDouble();//把结果转换成了double类型的

        System.out.println("包含小字的学生的平均年龄为" + average);
    }

    /**
     * 统计student中名字包含"小"字或"白"字的并计算他们的平均年龄
     */
    @Test
    public void test3() {
        List<Student> students = AddStudent.add();
        double average = students.stream()
                .filter(student -> student.getName().indexOf("小") >= 0 || student.getName().indexOf("白") >= 0)
                .mapToDouble(student -> student.getAge())
                .average()
                .getAsDouble();
        System.out.println(average);

    }
}
