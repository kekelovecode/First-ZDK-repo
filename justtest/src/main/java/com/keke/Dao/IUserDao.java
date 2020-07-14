package com.keke.Dao;

import com.keke.Entity.User;

import java.util.List;

public interface IUserDao {
     List<User> findAll();
}
