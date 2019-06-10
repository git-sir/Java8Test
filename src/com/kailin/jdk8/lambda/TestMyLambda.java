package com.kailin.jdk8.lambda;

public class TestMyLambda {
    /**
     * 自定义一个函数式接口，采用传统匿名内部类方式和lambda表达式的方式，分别创建接口对象
     * @param args
     */
    public static void main(String[] args) {

        /**
         * 如果用传统的匿名内部类的方式声明一个MyPrinter对象，有以下代码
         */
        MyPrinter myPrinter1 = new MyPrinter() {
            @Override
            public void print(String string) {
                System.out.println("The string is : "+string);
            }
        };
        myPrinter1.print("传统的匿名内部类的方式");
        /**
         * 如果用lambda表达式的方式声明一个MyPrinter对象，有以下代码
         */
        MyPrinter myPrinter2 = string -> System.out.println("The string is : "+string);
        myPrinter2.print("lambda表达式的方式");
        /**
         * 代码解析：
         * string 接口函数的入参，
         * -> 将参数和接口函数的内容体分开
         * System.out.println("The string is : "+string); 接口函数的内容
         */
        /**
         * 总结：使用lambda表达式代替传统的匿名内部类方式，可以大大简化代码，但只支持函数式接口
         */
    }

    /**
     * 定义一个函数式接口。
     * 函数式接口是指只有一个抽象方法的接口。
     * lambda表达式主要用于简化函数式接口的使用。
     */
    interface MyPrinter{
        void print(String string);
    }
}
