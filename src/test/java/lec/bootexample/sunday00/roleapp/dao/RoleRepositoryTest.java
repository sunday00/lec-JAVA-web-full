package lec.bootexample.sunday00.roleapp.dao;

import lec.bootexample.sunday00.roleapp.dto.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleRepositoryTest {

    @Autowired
    RoleRepository roleRepository;

    @Test
    public void selectAllTest () {
        List<Role> list = roleRepository.selectAll();
        Assert.notNull(list, "not data");
        if ( list.size() > 0 ){
            Role firstRow = (Role)list.toArray()[0];
            Assert.isInstanceOf(Role.class, firstRow);
            Assert.isInstanceOf(Integer.class, firstRow.getRole_id());
            Assert.isInstanceOf(String.class, firstRow.getDescription());
        }
        System.out.println(list);
    }
}