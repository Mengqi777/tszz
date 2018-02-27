package com.heu.poet.tszz.sleepstory;


import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author MengQi
 * @create 2018-01-08 15:58
 */
@RestController
@RequestMapping("sleepstory")
@SuppressWarnings(value = "unused")
public class SleepStoryController {

    private final SleepStoryRepository sleepStoryRepository;
    private final SleepStoryService sleepStoryService;

    public SleepStoryController(SleepStoryRepository sleepStoryRepository, SleepStoryService sleepStoryService) {
        this.sleepStoryRepository = sleepStoryRepository;
        this.sleepStoryService = sleepStoryService;
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public SleepStory add(@RequestBody SleepStory sleepStory) {
        return sleepStoryRepository.insert(sleepStory);
    }


    @RequestMapping(value = "getbydatetime", method = RequestMethod.GET)
    public SleepStory getByDateContains(@RequestParam("dateTime") String dateTime) {
        return sleepStoryService.getByDateContains(dateTime);
    }

    @RequestMapping(value = "getall", method = RequestMethod.GET)
    public List<SleepStory> getAll(@RequestParam("pageNumber") int pageNumber) {
        return sleepStoryService.getAll(pageNumber);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public SleepStory update(@RequestBody SleepStory sleepStory, HttpServletRequest request) {
        return sleepStoryRepository.save(sleepStory);
    }


    @RequestMapping(value = "getbytimestamp", method = RequestMethod.GET)
    public List<SleepStory> getByTimestampLess(@RequestParam("timestamp") long timestamp,
                                               @RequestParam("toWho") String  toWho) {
        return sleepStoryService.getByTimestampLess(timestamp,toWho);
    }


    @RequestMapping(value = "getbyauthorid", method = RequestMethod.GET)
    public List<SleepStory> getByAuthorId(@RequestParam("authorId") String  authorId,
                                          @RequestParam("pageNumber") int  pageNumber) {
        return sleepStoryService.getByAuthorId(authorId,pageNumber);
    }



    @RequestMapping(value = "delbyid", method = RequestMethod.GET)
    public void delById(@RequestParam("id") String id) {
        sleepStoryService.delById(id);
    }
}
