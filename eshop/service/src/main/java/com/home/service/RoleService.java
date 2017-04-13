package com.home.service;

import com.home.repository.RoleRepository;
import com.home.repository.entity.Role;
import com.home.service.impl.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void createRoles() {
        roleRepository.save(createRole("user"));
        roleRepository.save(createRole("admin"));
    }

    @Override
    public boolean checkRoles() {
        return roleRepository.count() > 0;
    }

    private Role createRole(String name) {
        Role role = new Role();
        role.setName(name);

        return role;
    }
}
