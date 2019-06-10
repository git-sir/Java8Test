package com.kailin.jdk8.optional;

import java.util.Optional;

public class TestOptionalMap {
    /**
     * 熟悉Optional的map方法的使用，对比传统代码和Optional代码的区别
     * @param args
     */
    public static void main(String[] args) {

        User user1 = new User();
        user1.setName("Tom");
        User user2 = null;
        //传统方式
        String str1 = getName(user1);
        System.out.println("传统方式："+str1);

        //Optional的map方式
        String str2 = getNameByOptional(user2);
        System.out.println("Optional的map方式："+str2);
    }

    public static String getName(User user){
        if(user != null){
            if(user.getName() != null){
                return user.getName();
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    public static String getNameByOptional(User user){
        /**
         * 1. Optional.ofNullable(user) ： 利用user对象构造Optional
         * 2. optional.map(u -> u.getName()) ： 若user不为空，则执行函数体u -> u.getName()，map内部会利用函数体的返回值构造一个新的Optional对象并返回
         * 3. opt.orElse(null) ： opt是步骤2中构造的新的Optional对象，调用其orElse方法表示若有值不为null则返回，若为null则返回null
         *
         * 总结：以下较为简洁的几行代码，实现了上述getName方法里的较为繁琐的多级if..else..的null判断
         */
        Optional<User> optional = Optional.ofNullable(user);
        //optional是利用user构造的，map方法会判断如果user != null，则将user传入某个匿名内部类对象，我们可以通过lambda表达式对user进行操作
        Optional<String> opt = optional.map(u -> u.getName());//map内部会利用u.getName()返回值构造一个新的Optional对象并返回
        return opt.orElse(null);

        //map是可能无限级联的, 比如上述代码再深一层, 获得用户名的大写形式，则可以如下实现
//        return optional.map(u -> u.getName()).map(name -> name.toUpperCase()).orElse(null);
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
