package com.zzy;

import com.zzy.mapper.UserMapper;
import com.zzy.model.User;
import com.zzy.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

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
    public void selectUserByAll(){

        User user = new User("root","root");
        User user1 = mapper.selectUserByAll(user);
        System.out.println(user1);

        sqlSession.close();

    }

}
