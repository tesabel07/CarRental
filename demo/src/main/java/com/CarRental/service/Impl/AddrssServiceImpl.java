package com.CarRental.service.Impl;

import com.CarRental.model.Address;
import com.CarRental.repository.AddressRepository;
import com.CarRental.service.AddrssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddrssServiceImpl implements AddrssService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
       return addressRepository.save(address);
    }

    @Override
    public Address getAddress(String string) {
        return  null;  //addressRepository.findOne(string);  //how to fix get one address
    }

    @Override
    public void delete(long id) {
        addressRepository.deleteById(id);
    }

    public List<Address> getAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Address getSpecifyAddress(long id) {
        return addressRepository.getOne(id);
    }
}
