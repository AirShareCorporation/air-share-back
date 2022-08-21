package dev.airshareback.services;

import dev.airshareback.entities.Departement;
import dev.airshareback.repositories.DepartementRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementService {
    private DepartementRepository departementRepository;

    public DepartementService(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    public List<Departement> getDepartments() {
        return this.departementRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
