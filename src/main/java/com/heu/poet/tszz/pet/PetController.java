package com.heu.poet.tszz.pet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author MengQi
 * @create 2018-01-08 15:58
 */
@RestController
@RequestMapping("pet")
@SuppressWarnings(value = "unused")
public class PetController {

    private PetRepository petRepository;
    private PetService petService;

    @Autowired
    public PetController(PetRepository petRepository,
                         PetService petService) {
        this.petRepository = petRepository;
        this.petService = petService;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Pet add(@RequestBody Pet pet) {
        return petService.add(pet);
    }


    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Pet get(@RequestParam("id") String id) {
        return petRepository.findPetById(id);
    }


    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Pet update(@RequestBody Pet pet, HttpServletRequest request) {
        return petRepository.save(pet);
    }


}
