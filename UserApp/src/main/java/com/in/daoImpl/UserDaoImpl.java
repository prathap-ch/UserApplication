package com.in.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in.controller.UserController;
import com.in.dao.UsersDao;
import com.in.user.Users;

@Repository
@Transactional
public class UserDaoImpl implements UsersDao{
	private static final Logger log = Logger.getLogger(UserDaoImpl.class);
	@Autowired
    SessionFactory session;
 
    public boolean saveOrUpdate(Users users) {
        session.getCurrentSession().saveOrUpdate(users);
        /*session.getCurrentSession().flush();
        session.getCurrentSession().clear();
        session.getCurrentSession().getTransaction().commit();
        session.getCurrentSession().close();*/
        return true;
    }
 
    public List<Users> list() {
    	System.out.println("inside UserDAO impl list()");
    	//HQL work with entity  class name not Table name
    	List<Users> list = session.getCurrentSession().createQuery("from Users").list();
    	log.info("DAO : "+list);
    	for(Users u : list){
			log.info("User List:: "+u.getEmail()+" | "+u.getUserId()+" | "+u.getUserName());
		}
        return list;
    }
 
    public boolean delete(Users users) {
        try {
            session.getCurrentSession().delete(users);
        } catch (Exception ex) {
            return false;
        }
 
        return true;
    }
}
