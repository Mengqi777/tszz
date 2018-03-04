package com.heu.poet.tszz.sleepstory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author MengQi
 * @create 2018-01-08 15:58
 */
@SuppressWarnings(value = "unused")
public interface SleepStoryRepository extends MongoRepository<SleepStory, String> {
    SleepStory findSleepStoryById(String id);

    Page<SleepStory> findSleepStoriesByAuthorIdAndStatus(String authorId, String status, Pageable pageable);

    List<SleepStory> findSleepStoryByDateTimeContainsAndStatus(String dateTime, String status);

    Page<SleepStory> findSleepStoryByTimestampLessThanAndToWhoAndStatus(long timestamp, String toWho, String status, Pageable pageable);

    @Override
    Page<SleepStory> findAll(Pageable pageable);
}
