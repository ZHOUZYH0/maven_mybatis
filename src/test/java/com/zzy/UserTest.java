package com.zzy;

import com.zzy.mapper.UserMapper;
import com.zzy.model.Role;
import com.zzy.model.User;
import com.zzy.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserTest {

    SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
    SqlSession sqlSession = sqlSessionFactory.openSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    @Test
    public void findAllUser(){

        List<User> users = mapper.selectAll();
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void findAllUserLaz(){

        List<User> users = mapper.selectAllLaz();
        for (User user : users) {
            System.out.println(user);
//            System.out.println(user.getRole());
        }
        sqlSession.close();

    }

    @Test
    public void findUserByAll(){
        //模拟登陆测试
        User user = new User("root","root");
        User user1 = mapper.selectUserByAll(user);
        System.out.println(user1);

        sqlSession.close();

    }

    @Test
    public void findUserById(){
        //通过id查找User
        User user = new User();
        user.setId(1);
        User user1 = mapper.selectUserByAll(user);
        System.out.println(user1);
        sqlSession.close();
    }

    @Test
    public void findUserByName(){
        //通过姓名查找User
        User user = new User();
        user.setUsername("root");
        User user1 = mapper.selectUserByAll(user);
        System.out.println(user1);
        sqlSession.close();
    }

    @Test
    public void addUserList(){

        Role role1 = new Role(1);
        Role role2 = new Role(2);
        Role role3 = new Role(3);

        User u1 = new User("aaa","aaa",role1);
        User u2 = new User("bbb","bbb",role2);
        User u3 = new User("ccc","ccc",role3);

        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);

        Integer i = mapper.addUserList(list);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }

}
