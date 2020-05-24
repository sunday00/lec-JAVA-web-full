package lec.spring.mvcExam.controllers;

import lec.spring.mvcExam.models.Good;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Controller
public class GoodsController {

    private static List<String> nameData = new ArrayList<String>(asList("shoes","clothes"));
    private static List<Integer> costData = new ArrayList<Integer>(asList(1000, 2000));

    @GetMapping("/goods")
    public static String index(){
        return "/path-vari-exam";
    }

    @PostMapping("/goods/result")
    public static String redi (@RequestParam(name = "id") int id) {
        return "redirect:/goods/result/" + id;
    }

    @GetMapping("/goods/result/{id}")
    public static String store(@PathVariable(name = "id") int id,
                               @RequestHeader(value = "User-Agent", defaultValue = "chrome") String agent,
                               HttpServletRequest request,
                               ModelMap modelMap) {
        Good good = new Good();
        good.setId(id);
        good.setName(nameData.get(id - 1));
        good.setCost(costData.get(id - 1));



        modelMap.addAttribute("good", good);
        modelMap.addAttribute("userAgent", agent);
        modelMap.addAttribute("path", request.getServletPath());

        return "/path-vari-result";
    }
}
