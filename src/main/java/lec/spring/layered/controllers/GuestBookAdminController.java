package lec.spring.layered.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes()
@RequestMapping("/auth/admin")
public class GuestBookAdminController {

    @GetMapping("/login")
    public String index () {
        return "login-form";
    }

    @PostMapping("/login")
    public String logged (@RequestParam(name = "password") String password,
                          HttpSession session, RedirectAttributes redirectAttributes) {

        if( password.equals("1111") ){
            session.setAttribute("passed", true);
        } else {
            redirectAttributes.addFlashAttribute("error", "pw wrong");
            return "redirect:/auth/admin/login";
        }

        return "redirect:/list";
    }

    @PostMapping("/logout")
    public String logout (@SessionAttribute("passed") boolean passed, HttpSession session) {

        if(passed == true){
            session.removeAttribute("passed");
        }

        return "redirect:/list";
    }

}
