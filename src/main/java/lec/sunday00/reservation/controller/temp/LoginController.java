package lec.sunday00.reservation.controller.temp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @GetMapping("/booking-login")
    public String login(HttpServletResponse response){
        Cookie cookie = new Cookie( "logged", "true" );
        response.addCookie(cookie);
        return "redirect:/";
    }
}
