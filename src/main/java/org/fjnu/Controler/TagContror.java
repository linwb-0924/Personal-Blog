package org.fjnu.Controler;

import org.fjnu.Exception.NotfoundException;
import org.fjnu.entity.Tag;
import org.fjnu.entity.Type;
import org.fjnu.service.impl.TagServiceimpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

/**
 * @author wb_Lin
 * @create 2020-05-31 15:04
 */
@Controller
public class TagContror {

    @Resource
    TagServiceimpl tagServiceimpl;

    @GetMapping("/admin/tag")
    public String tag(@PageableDefault(size = 10,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable, Model model){
        Page<Tag> tag = tagServiceimpl.listTag(pageable);
        model.addAttribute("page",tag);
        return "admin/tag";
    }

    @GetMapping("/admin/tag/input")
    public String add(Model model){
        model.addAttribute("tag",new Tag());
        return "admin/tag-input";
    }

    @PostMapping("/admin/tag")
    public String post(Tag tag, RedirectAttributes redirectAttributes){
        Tag tag1 = tagServiceimpl.getByName(tag.getName());
        if (tag1 !=null){
            redirectAttributes.addFlashAttribute("message","已存在该分类!");
            return "redirect:/admin/tag";
        }
        Tag tag2 = tagServiceimpl.saveTag(tag);
        if(tag2 == null){
            redirectAttributes.addFlashAttribute("message","新增失败！");
        }else{
            redirectAttributes.addFlashAttribute("message","新增成功！");
        }
        return "redirect:/admin/tag";
    }

    @GetMapping("/admin/tag/{id}/input")
    public String edit(@PathVariable Long id,Model model){
        model.addAttribute("tag",tagServiceimpl.getTag(id));
        return "admin/tag-input";
    }
    @PostMapping("/admin/tag/{id}")
    public String editpost(Tag tag,RedirectAttributes redirectAttributes,@PathVariable Long id) throws NotfoundException {
        Tag t1 = tagServiceimpl.getByName(tag.getName());
        if (t1 != null){
            redirectAttributes.addFlashAttribute("message","已存在改分类");
            return "redirect:/admin/tag";
        }
        Tag t = tagServiceimpl.updateTag(id,tag);
        if(t == null){
            redirectAttributes.addFlashAttribute("message","更新失败");
        }else {
            redirectAttributes.addFlashAttribute("message","更新成功");
        }
        return "redirect:/admin/tag";
    }
    @GetMapping("/admin/tag/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
        Tag tag = tagServiceimpl.getTag(id);
        if(tag == null){
            redirectAttributes.addFlashAttribute("message","删除失败");
        }
        tagServiceimpl.deleteTag(id);
        redirectAttributes.addFlashAttribute("message","删除成功");

        return "redirect:/admin/tag";
    }
}
