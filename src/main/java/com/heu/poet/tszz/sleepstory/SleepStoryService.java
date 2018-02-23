package com.heu.poet.tszz.sleepstory;


import com.heu.poet.tszz.customer.Customer;
import com.heu.poet.tszz.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MengQi
 * @create 2018-01-08 15:58
 */
@Service
public class SleepStoryService {


    private SleepStoryRepository sleepStoryRepository;

    private CustomerRepository customerRepository;

    @Autowired
    public SleepStoryService(SleepStoryRepository sleepStoryRepository, CustomerRepository customerRepository) {
        this.sleepStoryRepository = sleepStoryRepository;
        this.customerRepository = customerRepository;
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


    public List<SleepStory> getByAuthor(String author,int pageNumber){
        PageRequest pageRequest=buildPageRequest(pageNumber,10,"id");
        Page<SleepStory> pages = sleepStoryRepository.findSleepStoriesByAuthor(author,pageRequest);
        List<SleepStory> list = new ArrayList<>();
        pages.forEach(list::add);
        return list;
    }
}
