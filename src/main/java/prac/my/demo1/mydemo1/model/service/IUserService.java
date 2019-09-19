package prac.my.demo1.mydemo1.model.service;

import prac.my.demo1.mydemo1.model.dao.UserDO;;

public interface IUserService {

    boolean add(UserDO user);
    boolean update(Integer idx, UserDO user);
    boolean delete(Integer idx);

    UserDO search(Integer idx);

}