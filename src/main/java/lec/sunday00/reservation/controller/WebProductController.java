package lec.sunday00.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product/show")
public class WebProductController {

    @GetMapping("/{product}")
    public String index (@PathVariable(name = "product") int product) {

        return "detail";
    }


}
