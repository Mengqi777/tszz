package com.heu.poet.tszz.sleepstory;


import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author MengQi
 * @create 2018-01-08 15:58
 */
@Service
public class SleepStoryService {


    private final SleepStoryRepository sleepStoryRepository;

    private final MongoTemplate mongoTemplate;

    @Autowired
    public SleepStoryService(SleepStoryRepository sleepStoryRepository, MongoTemplate mongoTemplate) {
        this.sleepStoryRepository = sleepStoryRepository;
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * * 创建分页请求.
     */
    private PageRequest buildPageRequest(int pageNumber, int pageSize, String sortType) {
        Sort sort = new Sort(Sort.Direction.DESC, sortType);
        //参数1表示当前第几页,参数2表示每页的大小,参数3表示排序
        return PageRequest.of(pageNumber, pageSize, sort);
    }


    public List<SleepStory> getAll(int pageNumber){
        PageRequest pageRequest=buildPageRequest(pageNumber,10,"id");
        Page<SleepStory> pages = sleepStoryRepository.findAll(pageRequest);
        List<SleepStory> list = new ArrayList<>();
        pages.forEach(list::add);
        return list;
    }

    public SleepStory getByDateContains(String dateTime){
        List<SleepStory> res = sleepStoryRepository.findSleepStoryByDateTimeContainsAndStatus(dateTime,"1");
        return res.size()==0?null:res.get(res.size()-1);
    }


    public List<SleepStory> getByAuthorId(String authorId,int pageNumber){
        PageRequest pageRequest=buildPageRequest(pageNumber,10,"timestamp");
        Page<SleepStory> pages = sleepStoryRepository.findSleepStoriesByAuthorIdAndStatus(authorId,"1",pageRequest);
        List<SleepStory> list = new ArrayList<>();
        pages.forEach(list::add);
        return list;
    }


    public void delById(String id){
        Query query = new Query();
        query.addCriteria(new Criteria("_id").is(id));
        Update update = new Update();
        update.set("status", "-1");
        mongoTemplate.updateFirst(query,update,SleepStory.class);
    }


    public void like(Map<String,String > map){
        SleepStory sleepStory=sleepStoryRepository.findSleepStoryById(map.get("id"));
        List<String> likeList = sleepStory.getLikeList()==null?new ArrayList<>():sleepStory.getLikeList();
        likeList.add(map.get("nickName")+"-commit-"+map.get("userId"));
        Query query = new Query();
        query.addCriteria(new Criteria("_id").is(map.get("id")));
        Update update = new Update();
        update.set("like", likeList.size());
        update.set("likeList", likeList);
        mongoTemplate.updateFirst(query,update,SleepStory.class);
    }
    public void dislike(Map<String,String > map){
        SleepStory sleepStory=sleepStoryRepository.findSleepStoryById(map.get("id"));
        List<String> dislikeList = sleepStory.getDislikeList()!=null?sleepStory.getDislikeList():new ArrayList<>();
        dislikeList.add(map.get("nickName")+"-commit-"+map.get("userId"));
        Query query = new Query();
        query.addCriteria(new Criteria("_id").is(map.get("id")));
        Update update = new Update();
        update.set("dislike", dislikeList.size());
        update.set("dislikeList", dislikeList);
        mongoTemplate.updateFirst(query,update,SleepStory.class);
    }

    public List<SleepStory> getByTimestampLess(long timestamp,String toWho){
        List<SleepStory> list = new ArrayList<>();

        PageRequest pageRequest_1=buildPageRequest(0,2,"timestamp");
        Page<SleepStory> pages_1 = sleepStoryRepository.findSleepStoryByTimestampLessThanAndToWhoAndStatus(timestamp,toWho,"1",pageRequest_1);
        pages_1.forEach(list::add);

        PageRequest pageRequest=buildPageRequest(0,10,"timestamp");
        Page<SleepStory> pages = sleepStoryRepository.findSleepStoryByTimestampLessThanAndToWhoAndStatus(timestamp,"everyone","1",pageRequest);
        pages.forEach(list::add);

        return list;
    }


}
