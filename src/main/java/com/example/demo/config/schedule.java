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