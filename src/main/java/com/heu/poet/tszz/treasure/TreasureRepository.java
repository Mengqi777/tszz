package com.heu.poet.tszz.treasure;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author MengQi
 * @create 2018-01-08 15:58
 */
@SuppressWarnings(value = "unused")
public interface TreasureRepository extends MongoRepository<Treasure, String> {
    Treasure findTreasureById(String id);

}
