package com.kailin.jdk8.optional;

import java.util.Optional;

public class TestOptional {
    /**
     * 熟悉Optional的构造方法
     * 熟悉Optional的orElse方法的使用，对比传统代码和Optional代码的区别
     * 熟悉Optional的orElseGet方法的使用
     * @param args
     */
    public static void main(String[] args) {
        /**
         *  Optional 的三种构造方式:
         *  Optional.empty() : 构造一个空的 Optional 实例。
         *  Optional.of(obj) : 它要求传入的 obj 不能是 null 值的, 否则抛出异常 NullPointerException.
         *  Optional.ofNullable(obj) : 它以一种智能的、宽容的方式来构造一个 Optional 实例. 来者不拒, 传 null 进去就调用 Optional.empty(), 非 null 就调用 Optional.of(obj).
         *  1. 当我们非常非常的明确将要传给 Optional.of(obj) 的 obj 参数不可能为 null 时, 比如它是一个刚 new 出来的对象(Optional.of(new User(...))), 或者是一个非 null 常量时;
         *  2. 当想为 obj 断言不为 null 时, 即我们想在万一 obj 为 null 立即报告 NullPointException 异常, 立即修改, 而不是隐藏空指针异常时, 我们就应该果断的用 Optional.of(obj) 来构造 Optional 实例, 而不让任何不可预计的 null 值有可乘之机隐身于 Optional 中
         *  3. 其余场景可用 Optional.ofNullable(obj) 或者 Optional.empty()
         */
        User user = new User();
        user.setName("Tom");
        //传统方式
        User u1 = getUser(user);
        System.out.println("传统方式："+u1.getName());
        //Optional方式
        User u2 = getUserByOptional(user);
        System.out.println("Optional方式："+u2.getName());

        user = null;    //重新初始化为null
        //Optional方式
        User u3 = getUserByOptional2(user);
        System.out.println("Optional方式："+u3.getName());
    }

    public static User getUser(User user){
        /**
         * 传统的进行null检测的代码，比较繁琐
         */
        if(user != null){
            return user;
        }else{
            return null;
        }
    }

    public static User getUserByOptional(User user){
        /**
         * Optional可以避免较为繁琐的if...else...形式的空值null检测
         * orElse：存在即返回, 不存在则提供默认值
         */
        Optional<User> optional = Optional.ofNullable(user);//注意声明Optional<T>时要传入泛型类型
        return optional.orElse(null);//orElse：表示若user不为null则直接返回user；若为null则直接返回null（也可以直接new User()表示若user为空就创建一个User对象）
    }

    public static User getUserByOptional2(User user){
        /**
         * Optional可以避免较为繁琐的if...else...形式的空值null检测
         * orElseGet：存在即返回, 不存在则由函数来产生
         */
        Optional<User> optional = Optional.ofNullable(user);//注意声明Optional<T>时要传入泛型类型
        return optional.orElseGet(() -> createUser());//orElseGet：表示若user不为null则直接返回user；若为null则调用当前类中的函数
    }

    public static User createUser(){
        User user = new User();
        user.setName("Lucy");
        user.setAge(5);
        return user;
    }
    static class User{
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
