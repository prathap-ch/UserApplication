package com.in.dao;

import java.util.List;

import com.in.user.Users;
 
public interface UsersDao {
	
    public boolean saveOrUpdate(Users users);
 
    public List<Users> list();
 
    public boolean delete(Users users);
}