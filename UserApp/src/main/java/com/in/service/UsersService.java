package com.in.service;

import java.util.List;

import com.in.user.Users;

public interface UsersService {
	public List<Users> list();
	
	public boolean saveOrUpdate(Users users);
	 
    public boolean delete(Users users);
}
