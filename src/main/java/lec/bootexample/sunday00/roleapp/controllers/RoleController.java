package lec.bootexample.sunday00.roleapp.controllers;

import lec.bootexample.sunday00.roleapp.dto.Role;
import lec.bootexample.sunday00.roleapp.services.RoleService;
import lec.bootexample.sunday00.roleapp.services.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class RoleController {

    @Autowired
    RoleService roleService;

    @ResponseBody
    @GetMapping(path={"/api/", "/api"})
    public List<Role> selectAllApi() {
        return roleService.selectAll();
    }

    @GetMapping(path={"/", ""})
    public String selectAll(ModelMap modelMap) {
        modelMap.addAttribute("list", roleService.selectAll());
        return "role";
    }
}
