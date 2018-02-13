package com.heu.poet.tszz.travel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author MengQi
 * @create 2018-01-08 15:58
 */
@SuppressWarnings(value = "unused")
public interface TravelRepository extends MongoRepository<Travel, String> {
    Travel findTravelById(String id);

    Page<Travel> findTravelsByUserId(String userId, Pageable pageable);
}
