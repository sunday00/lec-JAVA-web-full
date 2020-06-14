package lec.bootexample.sunday00.roleapp.services;

import lec.bootexample.sunday00.roleapp.dao.RoleRepository;
import lec.bootexample.sunday00.roleapp.dto.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Role> selectAll() {
        return roleRepository.selectAll();
    }
}
