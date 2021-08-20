package com.example.demotest;

import com.example.demotest.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SpringBootTest
class DemoTestApplicationTests {
    //Class Clazz = Class.forName("com.example.demotest.entity.User");
    //
    //DemoTestApplicationTests() throws ClassNotFoundException {
    //}

    @Test
    void contextLoads() throws ClassNotFoundException {

        DataSource dataSource;



//     获取Class对象的三种方式
// * 1 Object ——> getClass();
// * 2 任何数据类型（包括基本数据类型）都有一个“静态”的class属性
// * 3 通过Class类的静态方法：forName（String  className）(常用)

//        第一个种 获取Class对象
//        User user=new User();
//        String name = user.getClass().getName();
////        com.example.demotest.entity.User
//        System.out.println(name);

////        第二个种 获取Class对象
//        Class userClass = User.class;
////        class com.example.demotest.entity.User
//        System.out.println(userClass);
//
////        第三个种 获取Class对象      类的路径
//        Class<?> aClass = Class.forName("com.example.demotest.entity.User");
////        class com.example.demotest.entity.User
//        System.out.println(aClass);
//    }
//
//    @Test
//    public void Test1() throws Exception {
//        User user = new User();
//        System.out.println("**********************所有公有构造方法*********************************");
////        Class Clazz = Class.forName("com.example.demotest.entity.User");
//        Constructor[] constructor = Clazz.getConstructors();
//        for (Constructor c : constructor) {
//            System.out.println(c);
//        }
//
//        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
//        Constructor[] declaredConstructors = Clazz.getDeclaredConstructors();
//        for (Constructor cc : declaredConstructors) {
//            System.out.println(cc);
//        }
//        System.out.println("*****************获取公有、无参的构造方法*******************************");
//        //返回的是描述这个无参构造函数的类对象。
//        Constructor con = Clazz.getConstructor();
//        System.out.println("这是一个无参构造" + con);
//        User newInstance = (User) con.newInstance();
//        System.out.println(newInstance);
//
//        System.out.println("获取单个公有的构造方法###############################################################");
//        Constructor constructor1 = Clazz.getConstructor(String.class);
//        System.out.println(constructor1);
//
//        System.out.println("获取单个私有的构造方法###############################################################");
//        Field age = Clazz.getDeclaredField("age");
//        System.out.println(age);
////        暴力反射
//        age.setAccessible(true);
//        user.setAge(2);
//        System.out.println(user);
//        ;
//
//    }
//
//    @Test
//    public void test2() throws Exception {
//        System.out.println("获取所有共有字段*****************************************");
//        Field[] fields = Clazz.getFields();
//        for (Field s : fields) {
//            System.out.println(s);
//        }
//
//        System.out.println("获取所有字段，包括：私有、受保护、默认、公有；########################################");
//        Field[] declaredFields = Clazz.getDeclaredFields();
//        for (Field a : declaredFields) {
//            System.out.println(a);
//        }
//
//
//        System.out.println("获取单个公有字段*****************************************");
//        Field num = Clazz.getField("num");
//        System.out.println(num);
//
//        System.out.println("获取单个私有字段*****************************************");
//        Field name = Clazz.getDeclaredField("name");
//        System.out.println(name);
//    }
//
//    @Test
//    public void test3() throws Exception {
//        Class<?> aClass = Class.forName("com.example.demotest.service.Student");
//        Method[] methods = aClass.getMethods();
//        for (Method m:methods) {
//            System.out.println(m);
//        }
//
//    }

    }
}
