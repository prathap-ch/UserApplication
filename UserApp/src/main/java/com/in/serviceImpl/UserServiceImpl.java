package com.in.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.in.dao.UsersDao;
import com.in.service.UsersService;
import com.in.user.Users;

@Service
/*@Configuration
@ComponentScan("com.in.dao")*/
public class UserServiceImpl implements UsersService{
	
	@Autowired
	UsersDao userDao;

	public boolean saveOrUpdate(Users users) {
        return userDao.saveOrUpdate(users);
    }
 
    public List<Users> list() {
    	List l = userDao.list();
    	System.out.println(l);
        return l;
    }
 
    public boolean delete(Users users) {
        // TODO Auto-generated method stub
        return userDao.delete(users);
    }
}
