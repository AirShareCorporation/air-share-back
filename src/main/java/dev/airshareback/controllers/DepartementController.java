package dev.airshareback.controllers;

import dev.airshareback.entities.Departement;
import dev.airshareback.services.DepartementService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200/")
public class DepartementController {
    private DepartementService departementService;

    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping("departments")
    public List<Departement> getDepartments() {
        return departementService.getDepartments();
    }
}
