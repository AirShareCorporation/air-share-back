package dev.airshareback.repositories;

import dev.airshareback.entities.Address;
import dev.airshareback.entities.AirData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository  extends JpaRepository<Address, Integer> {
}
