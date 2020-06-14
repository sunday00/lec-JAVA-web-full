package lec.bootexample.sunday00.roleapp.services;

import lec.bootexample.sunday00.roleapp.dto.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleServiceImplTest {
    @Autowired
    RoleServiceImpl roleService;

    @Test
    public void selectAllTest(){
        List<Role> roles = roleService.selectAll();
        Assert.notNull(roles, "empty");
        System.out.println(roles);
    }
}