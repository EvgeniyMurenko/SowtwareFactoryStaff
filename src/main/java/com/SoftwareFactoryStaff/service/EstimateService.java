package com.SoftwareFactoryStaff.service;

import com.SoftwareFactoryStaff.model.Estimate;

import java.util.List;


public interface EstimateService {

    void addNewEstimate(Estimate estimate);

    void updateEstimate(Estimate estimate);

    void deleteEstimate(Estimate estimate);

    List<Estimate> getAllEstimates();

    Estimate getEstimateById(long estimateId);

    Estimate findEstimateByCustomerInfoId(Long id);

}
