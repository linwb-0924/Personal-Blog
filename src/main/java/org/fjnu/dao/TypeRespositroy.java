package org.fjnu.dao;

import org.fjnu.entity.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wb_Lin
 * @create 2020-05-30 20:54
 */
@Repository
public interface TypeRespositroy extends JpaRepository<Type,Long> {

    Type findByName(String name);

}
