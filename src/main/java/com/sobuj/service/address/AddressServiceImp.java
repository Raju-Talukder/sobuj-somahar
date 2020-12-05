package com.sobuj.service.address;


import com.sobuj.dto.AddressDto;
import com.sobuj.models.Address;
import com.sobuj.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImp implements AddressService{
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public Address create(AddressDto addressDto) {
        Address add = new Address();
        return addressRepository.save(add);
    }
}
