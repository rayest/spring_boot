package com.rayeston.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Rayest on 2016/11/13 0013.
 */
@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(value = "/customer/save", method = RequestMethod.GET)
    public Customer save(String name, String address, Integer age) {
        return customerRepository.save(new Customer(null, name, age, address));
    }

    @RequestMapping(value = "/customer/address", method = RequestMethod.GET)
    public List<Customer> findByAddress(String address) {
        return customerRepository.findByAddress(address);
    }

    @RequestMapping(value = "/customer/find/address/name", method = RequestMethod.GET)
    public Customer findByNameAndAddress(String name, String address) {
        return customerRepository.findByNameAndAddress(name, address);
    }

    @RequestMapping(value = "/customer/query/address/name", method = RequestMethod.GET)
    public Customer queryWithNameAndAddress(String name, String address) {
        return customerRepository.queryWithNameAndAddress(name, address);
    }

    @RequestMapping(value = "/customer/addressNamed/address/name", method = RequestMethod.GET)
    public Customer queryWithNameAndAddressNamed(String name, String address) {
        return customerRepository.queryWithNameAndAddressNamed(name, address);
    }

    // 测试排序
    @RequestMapping(value = "/customer/sort", method = RequestMethod.GET)
    private List<Customer> sort() {
        return customerRepository.findAll(new Sort(Sort.Direction.ASC, "age"));
    }

    // 测试分页
    @RequestMapping(value = "/customer/page", method = RequestMethod.GET)
    public Page<Customer> page() {
        return customerRepository.findAll(new PageRequest(1, 2));
    }
}
