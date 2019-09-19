package prac.my.demo1.mydemo1.model.dao;

import prac.my.demo1.mydemo1.model.dao.UserDO;

public interface IUserDao {
 
    /**
     * Add new user
     * @param user
     * @return
     */
    Boolean add(UserDO user);

    /**
     * Update a user
     * @param user
     * @return
     */
    Boolean update(Integer idx, UserDO user);

    /**
     * Delete a user
     * @param Integer
     * @return
     */
    Boolean delete(Integer idx);

    /**
     * Search a user
     * @param Integer
     * @return
     */
    UserDO search(Integer idx);
}