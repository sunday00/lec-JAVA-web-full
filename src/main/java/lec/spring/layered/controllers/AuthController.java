package lec.spring.layered.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Controller
public class AuthController {

    @GetMapping("/auth")
    public String index (
            HttpServletRequest req,
            @CookieValue(name = "count", defaultValue = "0") int springCookie,
            HttpServletResponse res,
            ModelMap modelMap) {

        /*
        Cookie [] cookies = req.getCookies();
        HashMap <String, String> OCookie = new HashMap<>();
        for( Cookie cookie: cookies){
            OCookie.put(cookie.getName(), cookie.getValue());
        }

        System.out.println(OCookie);
        System.out.println(OCookie.get("count"));

        int count = OCookie.get("count") != null ? Integer.parseInt(OCookie.get("count")) : 0;
        */

        int count = springCookie;

        modelMap.addAttribute("count", count);


        Cookie cookie = new Cookie("count", String.valueOf(count + 1));
        cookie.setHttpOnly(true);
        cookie.setMaxAge(10);
        cookie.setPath("/");
        res.addCookie(cookie);
        return "auth";
    }
}
