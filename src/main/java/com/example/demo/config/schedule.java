package com.example.demo.config;

import javax.annotation.PostConstruct;

import com.example.demo.util.MyTest;
import com.example.demo.util.Recyle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class schedule {
    Logger logger = LoggerFactory.getLogger(schedule.class);

    @PostConstruct
    public void testAll() {
        logger.info("start");
        /*
         * 冒泡排序测试
         */
        int arr[] = { 8, 62, 6, 7, 15, 12, 56, 8 };
        int arrs[] = MyTest.sortByLargeToSmall(arr);
        logger.info("冒泡排序后的内容为:[{}]", arrs);
        /**
         * 单例测试
         */
        Recyle recyle = Recyle.getInstan();
        recyle.delete("视频文件删除-----------");
        /**
         * java中==和equals和hashCode的区别
         */
        String aaa = "sss";
        String bbb = "sss";
        Boolean b = aaa.equals(bbb);
        Boolean a = (aaa == bbb);
        logger.info("java中==和equals和hashCode的区别1：[{}],[{}]", a, b);
        Person p1 = new Person("EEE", 10);
        Person p2 = new Person("EEE", 10);
        logger.info("java中==和equals和hashCode的区别2：[{}],[{}]", (p1 == p2), p1.equals(p2));
        //hashCode() 的作用是获取哈希码，也称为散列码；它实际上是返回一个int整数。这个哈希码的作用是确定该对象在哈希表中的索引位置。

        //接口与抽象类的区别：
        //相似点：1.抽象类和接口都是不能含有方法体的；2.都是被继承，在继承类里面实现方法(除非继承类也是抽象类)；3.接口声明的方法和抽象类声明的抽象方法都必须在继承类里面一一实现(实现的方法不一样，抽象方法可以只是再次声明);4.两者都是抽象类，不能实例化
        //不同点：1.interface实现的时候用implements，而abstract class需要继承，用extends。
        //2.一个类可以实现多个接口interface，但是一个类只能继承一个抽象类abstract class
        //3.interface强调的是特定功能的实现，而abstract class强调的是所属关系
        //4.尽管interface实现类和abstract class的子类都必须实现相应的抽象方法，但实现的形式不同.interface中的每一个方法都是抽象方法，都只是声明没有方法体，实现类必须要实现。而abstract class的子类可以有选择的实现抽象方法。
        //5.抽象类里面不是所有的方法都是抽象方法，但接口里面的都是抽象方法。
    }

    private static class Person {
        int age;
        String name;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return name + " - " + age;
        }
    }
}