package org.fjnu.dao;

import org.fjnu.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wb_Lin
 * @create 2020-05-31 16:28
 */
@Repository
public interface BlogRespository extends JpaRepository<Blog,Long> , JpaSpecificationExecutor<Blog> {

    List<Blog> findAllByTitleContains(String query);
}
