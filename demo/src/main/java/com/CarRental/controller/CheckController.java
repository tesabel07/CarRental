package com.CarRental.controller;

import com.CarRental.model.Car;
import com.CarRental.service.AddrssService;
import com.CarRental.model.Address;
import com.CarRental.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CheckController {

    @Autowired
    private AddrssService addrssService;


    @CrossOrigin
    @RequestMapping(value="/address" ,method = RequestMethod.POST)
    public Address create(@RequestBody Address address){
        return addrssService.save(address);
    }

    @RequestMapping(value = "/address",method =RequestMethod.GET)
    public List<Address> getAll(){
        List<Address> list = addrssService.getAddress();
        return list;

    }

    @CrossOrigin
    @RequestMapping(value = "/address",method =RequestMethod.DELETE)
    public void removeAll(@RequestParam("id") long id){
        addrssService.delete(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/address/{id}",method =RequestMethod.GET)
    public Address getOneAddress(@PathVariable long id){
        Address address = addrssService.getSpecifyAddress(id);
        System.out.println(address);
        return address;
    }

}
