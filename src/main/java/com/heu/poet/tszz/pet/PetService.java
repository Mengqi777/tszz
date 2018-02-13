package com.heu.poet.tszz.pet;


import com.heu.poet.tszz.customer.Customer;
import com.heu.poet.tszz.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MengQi
 * @create 2018-01-08 15:58
 */
@Service
public class PetService {


    private PetRepository petRepository;

    private String rootPath = System.getProperty("user.dir");

    private CustomerRepository customerRepository;

    @Autowired
    public PetService(PetRepository petRepository, CustomerRepository customerRepository) {
        this.petRepository = petRepository;
        this.customerRepository = customerRepository;
    }


    public Pet add(Pet pet) {
        pet = petRepository.insert(pet);
        System.out.println(pet.getUserId() + "  d");
        Customer customer = customerRepository.findCustomerById(pet.getUserId());
        List<Pet> pets = customer.getPets();
        if (pets == null) pets = new ArrayList<>();
        pets.add(pet);
        customer.setPets(pets);
        customerRepository.save(customer);
        return pet;
    }
}
