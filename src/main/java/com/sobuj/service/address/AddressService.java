package com.sobuj.service.address;



import com.sobuj.dto.AddressDto;
import com.sobuj.models.Address;

import java.util.Optional;

public interface AddressService {
    Optional<Address> findById(Long id);
    public Address create(AddressDto addressDto);
}
