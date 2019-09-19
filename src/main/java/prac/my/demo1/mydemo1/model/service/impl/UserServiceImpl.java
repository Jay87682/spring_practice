package prac.my.demo1.mydemo1.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prac.my.demo1.mydemo1.model.dao.IUserDao;
import prac.my.demo1.mydemo1.model.dao.UserDO;
import prac.my.demo1.mydemo1.model.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserDao userDao;

    @Autowired
    public UserServiceImpl(IUserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public boolean add(UserDO user) {
        // TODO Auto-generated method stub
        if (userDao.add(user)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Integer idx, UserDO user) {
        // TODO Auto-generated method stub
        if(userDao.update(idx, user)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer idx) {
        // TODO Auto-generated method stub
        if(userDao.delete(idx)) {
            return true;
        }
        return false;
    }

    @Override
    public UserDO search(Integer idx) {
        // TODO Auto-generated method stub
        UserDO user = userDao.search(idx);
        if(user != null) {
            return user;
        }
        return null;
    }
    
}