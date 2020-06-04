package org.fjnu.dao;

import org.fjnu.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wb_Lin
 * @create 2020-05-31 15:05
 */
@Repository
public interface TagRespository extends JpaRepository<Tag, Long> {
    Tag getByName(String name);
}
