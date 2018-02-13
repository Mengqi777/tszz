package com.heu.poet.tszz.travel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author MengQi
 * @create 2018-01-08 15:58
 */
@RestController
@RequestMapping("travel")
@SuppressWarnings(value = "unused")
public class TravelController {

    private TravelRepository travelRepository;
    private TravelService travelService;

    @Autowired
    public TravelController(TravelRepository travelRepository,
                            TravelService travelService) {
        this.travelRepository = travelRepository;
        this.travelService = travelService;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Travel add(@RequestBody Travel travel) throws InterruptedException {
        return travelService.add(travel);
    }


    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Travel get(@RequestParam("id") String id) {
        return travelRepository.findTravelById(id);
    }


    @RequestMapping(value = "getbyusrid", method = RequestMethod.GET)
    public List<Travel> getByUserId(@RequestParam("userId") String userId,
                                    @RequestParam("pageNum") int pageNum) {
        return travelService.findTravelsByUserId(userId, pageNum);
    }


    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Travel update(@RequestBody Travel travel, HttpServletRequest request) {
        return travelRepository.save(travel);
    }


}
