package com.SoftwareFactoryStaff.dao;

import com.SoftwareFactoryStaff.model.Estimate;

import java.util.List;

public interface  EstimateDao {

    Long create(Estimate estimate);

    Estimate read(Long id);

    void update(Estimate estimate);

    void delete(Estimate estimate);

    List<Estimate> findAll();

    Estimate findEstimateByCustomerInfoId(Long id);

}
