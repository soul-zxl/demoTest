package com.example.demotest;

import com.google.common.collect.Lists;
import org.assertj.core.internal.Objects;
import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestString {
    @Test
    public void test1(){
        String str="hello world";
        //取出索引值
        str.charAt(2);
        //将一个字符串改成数组
        char[] array = str.toCharArray();
    //    将数组改成大写
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i]-=32;

        }
         new String(chars);




        String str1 = "123321";
        if(isNumber(str1)){
            System.out.println("字符串由数组组成");
        }else{
            System.out.println("字符串不是由数组组成");
        }
    }
    // 判断字符串是否为数组组成，是返回true,否返回false
    public static boolean isNumber(String temp){
        char [] data = temp.toCharArray();
        for(int x = 0; x <data.length;x++){
            if(data[x] > '9' || data[x] < '0'){
                return false;
            }
        }
        return true;

    }


    @Test
    public void test(){
        //字符串转字节数组
        String str="hello world";
        byte[] bytes = str.getBytes();
        //字节转字符串
        byte[] a={1,2,4,6};
        ArrayList<byte[]> bytes1 = Lists.newArrayList(Arrays.asList(a));

        String s = new String(a);

        String str1="Hello world";
        String str2="hello World";
        //区分大小写
        str1.equals(str2);
        //不区分大小写
        str1.equalsIgnoreCase(str2);


        int i = str1.compareTo(str2);
        System.out.println(i);
        String str3="a";
        String str4="a";
        int i1 = str3.compareTo(str4);
        System.out.println(i1);


    }

@Test
    public void test2(){
        String str="hello world";
        boolean s = str.contains("s");
        System.out.println(s);


    int i = str.indexOf("1");
    System.out.println(i);

    int i1 = str.lastIndexOf(3);
    System.out.println(i1);

    boolean h = str.startsWith("h");
    System.out.println(h);

    boolean h1 = str.startsWith("h", 2);
    System.out.println(h1);


    boolean d = str.endsWith("d");
    System.out.println(d);
}


    @Test
    public void test3() {
        //字符串转字节数组
        String str = "hello world hello";
        String str1 = "CBA";
        String hello = str.replaceAll("hello", str1);
        System.out.println(hello);

        String hello1 = str.replaceFirst("hello", str1);
        System.out.println(hello1);

    }
    @Test
    public void test4() {
        //字符串转字节数组
        String str = "hello world hello";
        String s1 = str.toUpperCase();
        System.out.println(s1);


        String substring = str.substring(4);
        System.out.println(substring);


        String substring1 = str.substring(4, 8);
        System.out.println(substring1);


        String[] os = str.split("o");

        String str1 = "Hello world hello";



        String concat = str.concat(str1);
        System.out.println(concat);

        String str2 = "Hello World hello";
        String s = str2.toLowerCase();
        System.out.println(s);


        String trim = str2.trim();
        str2.length();
        str2.isEmpty();

    }
    @Test
    public void test5() {
        ArrayList<Object> objects = Lists.newArrayList();
        objects.add("a");
        objects.add("b");
        objects.add("c");


        Object o = objects.get(1);
        System.out.println(o);


        objects.set(2,"ddd");
        Object o1 = objects.get(2);
        System.out.println(o1);


        objects.add(2,"ccc");
        Object o2 = objects.get(2);
        System.out.println(o2);

        objects.remove(2);
        objects.toArray(new String[objects.size()]);

        List<Object> objects1 = objects.subList(1, 2);



    }

}
