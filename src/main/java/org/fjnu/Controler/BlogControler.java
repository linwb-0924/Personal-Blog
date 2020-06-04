package org.fjnu.Controler;

import org.fjnu.Exception.NotfoundException;
import org.fjnu.bean.BlogQuery;
import org.fjnu.entity.Blog;
import org.fjnu.entity.User;
import org.fjnu.service.impl.BlogServiceimpl;
import org.fjnu.service.impl.TagServiceimpl;
import org.fjnu.service.impl.TypeServiceimpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.print.DocFlavor;
import javax.servlet.http.HttpSession;

/**
 * @author wb_Lin
 * @create 2020-05-31 16:45
 */
@Controller
public class BlogControler {
    @Resource
    BlogServiceimpl blogServiceimpl;

    private static final String INPUT = "admin/imput";
    private static final String LIST = "admin/blog";
    private static final String REDIRECT_LIST = "redirect:/admin/blog";

    @Resource
    TypeServiceimpl typeServiceimpl;

    @Resource
    TagServiceimpl tagServiceimpl;

    @GetMapping("/admin/blog")
    public String admin(@PageableDefault(size = 3,sort = {"updateTime"},direction = Sort.Direction.DESC)Pageable pageable, BlogQuery blog, Model model){

        model.addAttribute("types",typeServiceimpl.listType());
        model.addAttribute("page",blogServiceimpl.listBlog(pageable,blog));
        return LIST;
    }

    @PostMapping("/admin/blog/search")
    public String search(@PageableDefault(size = 3,sort = {"updateTime"},direction = Sort.Direction.DESC)Pageable pageable, BlogQuery blog, Model model){
            model.addAttribute("page",blogServiceimpl.listBlog(pageable,blog));
        return "admin/blog :: blogList";
    }



    @RequestMapping("/admininput")
    public String admininput(Model model){
        model.addAttribute("types",typeServiceimpl.listType());
        model.addAttribute("tags",tagServiceimpl.listTag());
        model.addAttribute("blog",new Blog());
        return "admin/imput";
    }


    @PostMapping("/admin/blogs")
    public String post(Blog blog, RedirectAttributes redirectAttributes, HttpSession session) throws NotfoundException {
        blog.setUser((User) session.getAttribute("user"));
        blog.setType(typeServiceimpl.getType(blog.getType().getId()));
        blog.setTags(tagServiceimpl.listTag(blog.getTagIds()));

        System.out.println("-------------------------------");

        Blog b;
        System.out.println("id:"+blog.getId());
        if (blog.getId() == null) {
             b = blogServiceimpl.saveBlog(blog);
        }else{
             b = blogServiceimpl.updateBlog(blog.getId(),blog);
        }

        if(b == null){
            redirectAttributes.addFlashAttribute("message","操作失败");
        }else{
            redirectAttributes.addFlashAttribute("message","操作成功");
        }
        return REDIRECT_LIST;
    }

    @GetMapping("/admin/{id}")
    public String get(@PathVariable Long id ,RedirectAttributes redirectAttributes) throws NotfoundException {
        redirectAttributes.addAttribute("types",typeServiceimpl.listType());
        redirectAttributes.addAttribute("tags",tagServiceimpl.listTag());
        Blog b = new Blog();
        b.setId(id);
        redirectAttributes.addAttribute("id",id);
        redirectAttributes.addAttribute("blog",b);
        return "redirect:/admininput";
    }
    @GetMapping("/admin/blog/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes redirectAttributes){
        blogServiceimpl.deleteBlog(id);
        redirectAttributes.addFlashAttribute("message","操作成功");
        return REDIRECT_LIST;
    }



}
