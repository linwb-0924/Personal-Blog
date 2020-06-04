package org.fjnu.service;

import org.fjnu.entity.User;

/**
 * @author wb_Lin
 * @create 2020-05-30 16:46
 */
public interface UserService {

    User checkUser(String username,String password);
}
