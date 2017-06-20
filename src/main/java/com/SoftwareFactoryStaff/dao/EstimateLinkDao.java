package com.SoftwareFactoryStaff.dao;


import com.SoftwareFactoryStaff.model.EstimateLink;

import java.util.List;

public interface EstimateLinkDao {

    Long create(EstimateLink estimateLink);

    EstimateLink read(Long id);

    void update(EstimateLink estimateLink);

    void delete(EstimateLink estimateLink);

    List<EstimateLink> findAll();

}
