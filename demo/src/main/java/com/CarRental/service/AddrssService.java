package com.CarRental.service;


import com.CarRental.model.Address;

import java.util.List;

public interface AddrssService {
    Address save(Address address);
    Address getAddress(String string);
    void delete(long id);
    List<Address> getAddress();
    Address getSpecifyAddress(long id);
}
