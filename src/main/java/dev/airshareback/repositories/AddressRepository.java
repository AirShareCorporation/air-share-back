package dev.airshareback.repositories;

import dev.airshareback.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository  extends JpaRepository<Address, Integer> {
    public Optional<Address> findById(Long id);
}
