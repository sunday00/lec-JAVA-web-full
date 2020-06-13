package lec.spring.layered.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import resolver.Apple;
import resolver.MapArgumentResolver;

@Controller
@RequestMapping("/test")
public class LookHeaderController {

    @GetMapping("/arg")
    public String index (ModelMap modelMap, MapArgumentResolver mapArgumentResolver) {
        modelMap.addAttribute("mapArgs", mapArgumentResolver.getMap());
        System.out.println(mapArgumentResolver.getMap().toString());
        return "test/arg-rslv";
    }

    @GetMapping("/arg2")
    public String index2 (ModelMap modelMap, Apple apple){
        System.out.println(apple.getName());
        return "test/arg-rslv";
    }
}
