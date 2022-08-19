package dev.airshareback.repositories;

import dev.airshareback.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {
    public Optional<Departement> findByCode(String code);
}
