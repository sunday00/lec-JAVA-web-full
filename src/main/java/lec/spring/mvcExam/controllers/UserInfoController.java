package lec.spring.mvcExam.controllers;

import lec.spring.mvcExam.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserInfoController {
    @GetMapping("/user/info")
    public static String index(){

        return "user-info";
    }

    @PostMapping("/user/register")
    public static String store (@ModelAttribute User user, ModelMap model){
        System.out.println(user);
        model.addAttribute("user", user);
        return "/user-info-result";
    }
}
