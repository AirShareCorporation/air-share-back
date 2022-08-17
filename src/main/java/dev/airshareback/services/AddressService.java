package dev.airshareback.services;

import dev.airshareback.entities.Address;
import dev.airshareback.entities.AirData;
import dev.airshareback.repositories.AddressRepository;
import dev.airshareback.repositories.AirDataRepository;

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

    public Optional<Address> get(int id) {
        return addressRepository.findById(id);
    }

}
