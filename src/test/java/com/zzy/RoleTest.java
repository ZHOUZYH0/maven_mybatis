package com.zzy;

import com.zzy.mapper.RoleMapper;
import com.zzy.model.Role;
import com.zzy.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class RoleTest {

    SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
    SqlSession sqlSession = sqlSessionFactory.openSession();
    RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);

    @Test
    public void findRoleById(){
        int id = 1;
        Role role = mapper.selectRoleById(id);
        System.out.println(role);
        sqlSession.close();

    }


}
