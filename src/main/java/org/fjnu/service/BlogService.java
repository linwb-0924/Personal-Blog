package org.fjnu.service;

import org.fjnu.Exception.NotfoundException;
import org.fjnu.bean.BlogQuery;
import org.fjnu.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author wb_Lin
 * @create 2020-05-31 16:26
 */
public interface BlogService {

    Blog gethtmlBlog(Long id);
    Blog getBlog(Long id);
    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);
    Page<Blog> listBlog(Pageable pageable);
    Page<Blog> searchtag(Pageable pageable,String name);
    Page<Blog> searchBlog(Pageable pageable,String query);
    Blog saveBlog(Blog blog);
    Blog updateBlog(Long id,Blog blog) throws NotfoundException;
    void deleteBlog(Long id);
}
