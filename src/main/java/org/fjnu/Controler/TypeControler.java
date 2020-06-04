package org.fjnu.Controler;

import org.fjnu.Exception.NotfoundException;
import org.fjnu.entity.Type;
import org.fjnu.service.TypeService;
import org.fjnu.service.impl.TypeServiceimpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author wb_Lin
 * @create 2020-05-30 21:07
 */
@Controller
public class TypeControler {

    @Resource
    TypeServiceimpl typeServiceimpl;

    @GetMapping("/admin/types")
    public String type(@PageableDefault(size = 10,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable, Model model){

        Page<Type> types = typeServiceimpl.listType(pageable);
        model.addAttribute("page",types);
        return "admin/type";
    }
    @GetMapping("/admin/types/input")
    public String add(Model model){
        model.addAttribute("type",new Type());
        return "admin/type-input";
    }

    @PostMapping("/admin/types")
    public String post(Type type, RedirectAttributes redirectAttributes){
        Type t1 = typeServiceimpl.getByName(type.getName());
        if (t1 != null){
            redirectAttributes.addFlashAttribute("message","已存在改分类");
            return "redirect:/admin/types";
        }
        Type t = typeServiceimpl.saveType(type);
        if(t == null){
            redirectAttributes.addFlashAttribute("message","新增失败");
        }else {
            redirectAttributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/types";

    }

    @GetMapping("/admin/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("type",typeServiceimpl.getType(id));
        return "admin/type-input";
    }
    @PostMapping("/admin/types/{id}")
    public String editpost(Type type, RedirectAttributes redirectAttributes,@PathVariable Long id) throws NotfoundException {
        Type t1 = typeServiceimpl.getByName(type.getName());
        if (t1 != null){
            redirectAttributes.addFlashAttribute("message","已存在改分类");
            return "redirect:/admin/types";
        }
        Type t = typeServiceimpl.updateType(id,type);
        if(t == null){
            redirectAttributes.addFlashAttribute("message","更新失败");
        }else {
            redirectAttributes.addFlashAttribute("message","更新成功");
        }
        return "redirect:/admin/types";
    }
    @GetMapping("/admin/types/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
        Type type = typeServiceimpl.getType(id);
        if(type == null){
            redirectAttributes.addFlashAttribute("message","删除失败");
        }
        typeServiceimpl.deleteType(id);
        redirectAttributes.addFlashAttribute("message","删除成功");

        return "redirect:/admin/types";
    }





}
