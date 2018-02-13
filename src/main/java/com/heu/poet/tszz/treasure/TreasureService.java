package com.heu.poet.tszz.treasure;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MengQi
 * @create 2018-01-08 15:58
 */
@Service
public class TreasureService {


    private TreasureRepository treasureRepository;

    private String rootPath = System.getProperty("user.dir");

    @Autowired
    public TreasureService(TreasureRepository treasureRepository) {
        this.treasureRepository = treasureRepository;
    }


}
