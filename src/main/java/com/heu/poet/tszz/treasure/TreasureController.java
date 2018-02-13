package com.heu.poet.tszz.treasure;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author MengQi
 * @create 2018-01-08 15:58
 */
@RestController
@RequestMapping("treasure")
@SuppressWarnings(value = "unused")
public class TreasureController {

    private TreasureRepository treasureRepository;
    private TreasureService treasureService;

    @Autowired
    public TreasureController(TreasureRepository treasureRepository,
                              TreasureService treasureService) {
        this.treasureRepository = treasureRepository;
        this.treasureService = treasureService;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Treasure add(@RequestBody Treasure treasure) {
        return treasureRepository.insert(treasure);
    }


    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Treasure get(@RequestParam("id") String id) {
        return treasureRepository.findTreasureById(id);
    }


    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Treasure update(@RequestBody Treasure treasure, HttpServletRequest request) {
        return treasureRepository.save(treasure);
    }


}
