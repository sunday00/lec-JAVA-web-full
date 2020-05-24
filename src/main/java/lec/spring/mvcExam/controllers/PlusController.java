package lec.spring.mvcExam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlusController {
    @GetMapping("/plus")
    public static String index () {
        return "plusForm";
    }

    @PostMapping("/plus")
    public static String store (@RequestParam(name = "num1", required = true) int num1,
                                @RequestParam(name = "num2", required = true) int num2,
                                ModelMap modelMap) {
        int result = num1 + num2;
        modelMap.addAttribute("num1", num1);
        modelMap.addAttribute("num2", num2);
        modelMap.addAttribute("result", result);

        return "plusResult";
    }
}
