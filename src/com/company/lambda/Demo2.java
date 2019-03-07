package com.company.lambda;

/**
 * create by wangyu
 * 2018/10/13 0013 17:43
 * 此类主要是针对lambad的测试
 */
public class Demo2 {

    public static void main(String[] args) {

        /**
         * 传统的匿名内部类的实现方式
         */
        new Action() {
            @Override
            public void execute(String content) {
                System.out.println(content);
            }
        }.execute("jdk1.8之前的匿名内部类的实现方式");



//        lambda表达式的实现匿名内容类的方式
        Action login = (String content) -> {//此方法里传递的是参数
            System.out.println(content);
        };
        login.execute("这是jdk1.8之后的lambda表达式实现的");
    }


    static interface Action {
        void execute(String content);
    }
}
