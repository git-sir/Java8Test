package com.kailin.jdk8.lambda;

public class TestOtherLambda {
    /**
     * 列举lambda表达式的几个不同示例
     * @param args
     */
    public static void main(String[] args) {
        WithoutPara withoutPara = () -> System.out.println("这是一个不带入参的函数式接口");
        withoutPara.print();
        WithPara withPara = para -> System.out.println("这是一个不带入参的函数式接口:"+para);
        withPara.print("aabbcc");
        WithReturn withReturn = (a,b) -> a+b;
        int result = withReturn.print(1,2);
        System.out.println("这是一个带返回值的函数式接口："+result);
        MathOperation mathOperation = (i,j) -> {
            int x = i * i;
            int y = j * j;
            return x+y;
        };  //代码段此处需要分号结尾
        int c = mathOperation.operation(1,2);
        System.out.println("运算结果："+c);
        //Runnable接口也是一个函数式接口，因此也可以用lambda表达式来创建Runnable
        startThread(() -> {
            System.out.println("(lambda表达式方式)我是一个线程，线程id="+Thread.currentThread().getId());
        });
        //用传统的匿名内部类方式创建Runnable对象
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println("(匿名内部类方式)我是一个线程，线程id="+Thread.currentThread().getId());
            }
        });
    }

    /**
     * 定义一个不带入参的函数式接口。
     */
    interface WithoutPara{
        void print();
    }
    /**
     * 定义一个带入参的函数式接口。
     */
    interface WithPara{
        void print(String para);
    }
    /**
     * 定义一个带入参的函数式接口。
     */
    interface WithReturn{
        int print(int a, int b);
    }

    interface MathOperation {
        int operation(int i, int j);
    }

    public static void startThread(Runnable runnable){
        System.out.println("启动一个线程");
        new Thread(runnable).start();
    }
}
