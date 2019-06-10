package com.kailin.jdk8.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestLambda {
    public static void main(String[] args) {
        /**
         * 以swing中为按钮JButton添加监听器的代码为例子，比较传统的写法和Lambda表达式写法
         */
        JButton button = new JButton();
        //传统写法
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按钮被点击了");
            }
        });
        //Lambda表达式写法
        button.addActionListener(e -> System.out.println("按钮被点击了"));
        System.out.println("代码运行结束");
        /**
         * 总结：传统写法 -- 必须声明匿名内部类，代码多写四行；Lambda表达式写法：无需匿名内部类对象，直接传递参数和函数内容，代码只需一行
         */
    }
}
