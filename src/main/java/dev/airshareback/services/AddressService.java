package dev.airshareback.services;

import dev.airshareback.entities.Address;
import dev.airshareback.repositories.AddressRepository;

import java.util.List;
import java.util.Optional;

public class AddressService {

    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> list() {
        return addressRepository.findAll();
    }

    public Optional<Address> get(Long id) {
        return addressRepository.findById(id);
    }
}
