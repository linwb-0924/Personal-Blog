package org.fjnu.Controler;

import org.fjnu.bean.BlogQuery;
import org.fjnu.entity.Tag;
import org.fjnu.entity.Type;
import org.fjnu.service.impl.BlogServiceimpl;
import org.fjnu.service.impl.TagServiceimpl;
import org.fjnu.service.impl.TypeServiceimpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.management.Query;
import java.util.List;

/**
 * @author wb_Lin
 * @create 2020-04-03 14:04
 */
@Controller
public class Mycontroler {

    @Resource
    BlogServiceimpl blogServiceimpl;

    @Resource
    TypeServiceimpl typeServiceimpl;

    @Resource
    TagServiceimpl tagServiceimpl;
        @GetMapping("/")
        public String index(@PageableDefault(size = 5,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable, Model model){
            model.addAttribute("page",blogServiceimpl.listBlog(pageable));
            model.addAttribute("types",typeServiceimpl.listType());
            model.addAttribute("tags",tagServiceimpl.listTag());
            model.addAttribute("recommendblog",blogServiceimpl.listBlog(pageable));
            return "index";
        }
        @RequestMapping("/blog")
        public String blog(){
            return "blog";
        }
        @GetMapping("/type")
        public String types(@PageableDefault(size = 5,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable, Model model){
            model.addAttribute("page",blogServiceimpl.listBlog(pageable));
            model.addAttribute("types",typeServiceimpl.listType());
            return "type";
    }
        @GetMapping("/type/one")
        public String typeone(@PageableDefault(size = 20,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,@RequestParam String name, Model model){
            model.addAttribute("page",typeServiceimpl.getByName(name).getBlogs());
            model.addAttribute("types",typeServiceimpl.listType());
            model.addAttribute("title",name);
            return "type-one";
        }


        @GetMapping("/tags")
        public String tags(@PageableDefault(size = 5,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable, Model model){
            model.addAttribute("page",blogServiceimpl.listBlog(pageable));
            model.addAttribute("tags",tagServiceimpl.listTag());
            return "tags";
        }
        @GetMapping("/tags/tag")
        public String tagsname(@PageableDefault(size = 20,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable, @RequestParam String name,Model model){
            model.addAttribute("page",tagServiceimpl.getByName(name).getBlogs());
            model.addAttribute("tags",tagServiceimpl.listTag());
            model.addAttribute("title",name);
            return "tags-one";
        }

        @RequestMapping("/archives")
    public String archives(){
        return "archives";
    }
        @RequestMapping("/about")
    public String about(){
        return "about";
    }


    @RequestMapping("/adminlogin")
    public String adminlogin(){
        return "admin/blog-login";
    }
    @RequestMapping("/adminindex")
    public String adminindex(){
        return "admin/index";
    }

    @RequestMapping("/blog/{id}")
    public String blogid(@PathVariable Long id,Model model){
           model.addAttribute("blog",blogServiceimpl.gethtmlBlog(id));
        return "blog";
    }
    @PostMapping("/search")
    public String search(@PageableDefault(size = 5,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,@RequestParam  String query, Model model){
            model.addAttribute("page",blogServiceimpl.searchBlog(pageable,query));
            model.addAttribute("query",query);
            return "search";
    }
    @GetMapping("/search")
    public String searcha(@PageableDefault(size = 5,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable, @RequestParam String query, Model model){
        model.addAttribute("page",blogServiceimpl.searchBlog(pageable,query));
        model.addAttribute("query",query);
        return "search";
    }

}
