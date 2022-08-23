package dev.airshareback.controllers;

import dev.airshareback.entities.Role;
import dev.airshareback.services.RoleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200/")
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("role")
    public List<Role> listRole() {
        return this.roleService.list();
    }

    @GetMapping("role/{id}")
    public Optional<Role> getRole(@PathVariable Long id) {
        return this.roleService.getRoleById(id);
    }
}
