package dev.airshareback.services;

import dev.airshareback.entities.Role;
import dev.airshareback.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> list() {
        return roleRepository.findAll();
    }

    public Optional<Role> get(int id) {
        return roleRepository.findById(id);
    }

    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }
}
