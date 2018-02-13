package com.heu.poet.tszz.pet;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author MengQi
 * @create 2018-01-08 15:58
 */
@SuppressWarnings(value = "unused")
public interface PetRepository extends MongoRepository<Pet, String> {
    Pet findPetById(String id);
}
