package com.zzy.mapper;

import com.zzy.model.User;

import java.util.List;

public interface UserMapper {

    public List<User> selectAllLaz();

    public List<User> selectAll();

    public User selectUserByAll(User user);

}
