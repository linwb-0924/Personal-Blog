package org.fjnu.service.impl;

import org.fjnu.dao.UserRespository;
import org.fjnu.entity.User;
import org.fjnu.service.UserService;
import org.fjnu.util.MD5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wb_Lin
 * @create 2020-05-30 16:50
 */
@Service
public class UserServiceimpl implements UserService {

    @Resource
    UserRespository userRespository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRespository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
