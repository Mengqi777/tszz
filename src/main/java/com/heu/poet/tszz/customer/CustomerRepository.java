package com.heu.poet.tszz.customer;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author MengQi
 * @create 2018-01-08 15:58
 */
@SuppressWarnings(value = "unused")
public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findCustomerByOpenId(String openId);

    Customer findCustomerById(String id);
}
