package com.example.demotest;

import com.example.demotest.entity.Student;
import com.example.demotest.entity.User;
import com.example.demotest.mapper.StudentMapper;
import com.example.demotest.mapper.UserMapper;
import com.example.demotest.vo.VO;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class Test {
    @Autowired
    DataSource dataSource;

    @SneakyThrows
    @org.junit.jupiter.api.Test
    public void test() {
        dataSource.getClass();
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        System.out.println(dataSource.getClass());
    }
    @Autowired
    UserMapper userMapper;


    @org.junit.jupiter.api.Test
    public  void select() {
        List<User> select = userMapper.select();
        for (User a: select) {
            System.out.println(a);
        }

        User user = userMapper.selectById(1);
        System.out.println(user);
        User user1=new User(1,"美美","123456");
        int insert = userMapper.insert(user1);
        System.out.println(insert);

        int update = userMapper.update(user);
        System.out.println(update);

    }
    @org.junit.jupiter.api.Test
    public  void delete() {
        int delete = userMapper.delete(1);
        System.out.println(delete);
    }
    @org.junit.jupiter.api.Test
    public  void update() {
        User user=new User(3,"美美","12346");
        int update = userMapper.update(user);
        System.out.println(update);
    }
@org.junit.jupiter.api.Test
    public void insert2(){
        User user=new User();
        user.setName("sssd");
        user.setPass("456789");
    int i = userMapper.insert2(user);
    System.out.println(i);
}

@org.junit.jupiter.api.Test
     public void update2(){
         HashMap<String, Object> map = new HashMap<>();
         map.put("username","zxl");
         map.put("passworld","44444444");
         map.put("userid",99);
         int i = userMapper.update2(map);
         System.out.println(i);


     }



    @org.junit.jupiter.api.Test
    public void select2() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username","zxl");
        map.put("passworld","44444444");
        User user = userMapper.select3(map);
        System.out.println(user);
    }


    @org.junit.jupiter.api.Test
    public void selectLike() {
        List<User> selectLike = userMapper.selectLike("李");
        for (User a:selectLike) {
            System.out.println(a);
        }

    }
     @Resource
    StudentMapper studentMapper;
    @org.junit.jupiter.api.Test
public void selectstudent(){
        studentMapper.select().forEach(System.out::println);
}

@org.junit.jupiter.api.Test
public void selectif(){
    Map map = new HashMap();
    List<Student> selectif = studentMapper.selectif(map);
    for (Student a:selectif) {
        System.out.println(a);
    }


}

@org.junit.jupiter.api.Test
public void test11(){
    Map map = new HashMap();
    List<VO> selectif = studentMapper.list111111();
    for (VO s:selectif) {
        System.out.println(s);
    }

}


}


