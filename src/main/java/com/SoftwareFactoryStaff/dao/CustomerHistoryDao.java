package com.SoftwareFactoryStaff.dao;


import com.SoftwareFactoryStaff.model.CustomerHistory;

import java.util.List;

public interface CustomerHistoryDao {

    Long create(CustomerHistory customerHistory);

    CustomerHistory read(Long id);

    void update(CustomerHistory customerHistory);

    void delete(CustomerHistory customerHistory);

    List<CustomerHistory> findAll();

}
