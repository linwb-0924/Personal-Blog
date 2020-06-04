package org.fjnu.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.fjnu.Exception.NotfoundException;
import org.fjnu.bean.BlogQuery;
import org.fjnu.dao.BlogRespository;
import org.fjnu.entity.Blog;
import org.fjnu.entity.Tag;
import org.fjnu.entity.Type;
import org.fjnu.service.BlogService;
import org.fjnu.util.MarkdownUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wb_Lin
 * @create 2020-05-31 16:28
 */
@Service
public class BlogServiceimpl implements BlogService {

    @Resource
    BlogRespository blogRespository;

    @Override
    public Blog gethtmlBlog(Long id) {
        Blog b = new Blog();
        Blog one = blogRespository.getOne(id);
        BeanUtils.copyProperties(one,b);
        String content = b.getContent();
        String marktohtml = MarkdownUtils.marktohtml(content);
        b.setContent(marktohtml);
        return b;
    }

    @Override
    public Blog getBlog(Long id) {
        Blog one = blogRespository.getOne(id);
        return one;
    }


    @Override
    public Page<Blog> listBlog(Pageable pageable, BlogQuery blog) {

        return blogRespository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if(!"".equals(blog.getTitle()) && blog.getTitle() != null){
                    predicates.add(cb.like(root.<String>get("title"),"%"+blog.getTitle()+"%"));
                }
                if(blog.getTypeId() !=null){
                    predicates.add(cb.equal(root.<Type>get("type").get("id"),blog.getTypeId()));
                }
                if(blog.isRecommend()){
                    predicates.add(cb.equal(root.<Boolean>get("recommend"),blog.isRecommend()));
                }
                cq.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        },pageable);
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable) {
        return blogRespository.findAll(pageable);
    }

    @Override
    public Page<Blog> searchtag(Pageable pageable,String name) {
        return blogRespository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if(!"".equals(name) && name!= null){
                    predicates.add(cb.equal(root.<Type>get("tags").get("name"),name));
                }
                cq.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        },pageable);
    }

    @Override
    public Page<Blog> searchBlog(Pageable pageable, String query) {
        return blogRespository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if(!"".equals(query) && query != null){
                    predicates.add(cb.like(root.<String>get("title"),"%"+query+"%"));
                }
                cq.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        },pageable);
    }


    @Transactional
    @Override
    public Blog saveBlog(Blog blog) {
        if (blog.getId() == null){
            blog.setCreateTime(new Date());
            blog.setUpdateTime(new Date());
            blog.setViews(0);
        }else{
            blog.setUpdateTime(new Date());
        }
        return blogRespository.save(blog);
    }
    @Transactional
    @Override
    public Blog updateBlog(Long id, Blog blog) throws NotfoundException {
        Blog one = blogRespository.getOne(id);
        if(one == null){
            throw new NotfoundException("博客未找到");
        }
        BeanUtils.copyProperties(blog,one);
        one.setUpdateTime(new Date());
        return blogRespository.save(one);
    }
    @Transactional
    @Override
    public void deleteBlog(Long id) {
        blogRespository.deleteById(id);
    }
}
