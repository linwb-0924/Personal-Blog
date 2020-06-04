package org.fjnu.Controler;

import org.fjnu.entity.User;
import org.fjnu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author wb_Lin
 * @create 2020-05-30 16:56
 */
@Controller
public class LoginControler {

    @Resource
    UserService userService;


    @PostMapping("/admin/login")
    public String logincheck(@RequestParam String username, @RequestParam String password, HttpSession session, RedirectAttributes redirectAttributes){
        User user = userService.checkUser(username, password);
        if(user != null){
            user.setPassword(null);
            session.setAttribute("user",user);
            return "admin/index";
        }else{
            redirectAttributes.addFlashAttribute("message","用户名或密码错误");
            return "redirect:/adminlogin";
        }

    }
    @GetMapping("/admin/login")
    public String logincheck(){
        return "redirect:/adminlogin";
    }

    @GetMapping("/admin/loginout")
    public String loginout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/adminlogin";

    }
}
