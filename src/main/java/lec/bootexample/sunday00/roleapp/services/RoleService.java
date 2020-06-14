package lec.bootexample.sunday00.roleapp.services;

import lec.bootexample.sunday00.roleapp.dao.RoleRepository;
import lec.bootexample.sunday00.roleapp.dto.Role;

import java.util.List;

public interface RoleService {
    public List<Role> selectAll();
}
