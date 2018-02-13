package com.heu.poet.tszz.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * @author MengQi
 * @create 2018-01-08 15:58
 */
@RestController
@RequestMapping("customer")
@SuppressWarnings(value = "unused")
public class CustomerController {

    private CustomerRepository customerRepository;
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerRepository customerRepository,
                              CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Map<String, Object> login(@RequestParam("code") String code,
                                     @RequestParam("userInfo") String userInfo, HttpServletRequest request) throws IOException {
        return customerService.login(code, userInfo, request);
    }


    @RequestMapping(value = "register", method = RequestMethod.POST)
    public Customer register(@RequestBody Customer customer, HttpServletRequest request) {
        return customerService.register(customer, request);
    }


    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Customer update(@RequestBody Customer customer, HttpServletRequest request) {
        return customerRepository.save(customer);
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Customer get(@RequestParam("id") String id) {
        return customerRepository.findCustomerById(id);
    }

}
