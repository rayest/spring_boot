package com.rayeston.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Rayest on 2016/11/13 0013.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByAddress(String address);

    Customer findByNameAndAddress(String name, String address);

    // 使用 @Query 查询，参数按照名称绑定
    @Query("select c from Customer c where c.name= :name and c.address= :address")
    Customer queryWithNameAndAddress(@Param("name") String name, @Param("address") String address);

    // 使用 @NamedQuery 查询，在实体类中有该注解
    Customer queryWithNameAndAddressNamed(String name, String address);

}
