package com.SoftwareFactoryStaff.dao;

import com.SoftwareFactoryStaff.model.CustomerInfo;

import java.util.List;


public interface CustomerInfoDao {

    Long create(CustomerInfo customerInfo);

    CustomerInfo read(Long id);

    void update(CustomerInfo customerInfo);

    void delete(CustomerInfo customerInfo);

    List<CustomerInfo> findAll();

}
