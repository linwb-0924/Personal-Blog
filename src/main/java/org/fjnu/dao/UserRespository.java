package org.fjnu.dao;

import org.fjnu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wb_Lin
 * @create 2020-05-30 16:52
 */
@Repository
public interface UserRespository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username,String password);
}
