package com.SoftwareFactoryStaff.service;


import com.SoftwareFactoryStaff.model.EstimateLink;

import java.util.List;

public interface EstimateLinkService {

    void addNewEstimateLink(EstimateLink estimateLink);

    void updateEstimateLink(EstimateLink estimateLink);

    void deleteEstimateLink(EstimateLink estimateLink);

    List<EstimateLink> getAllEstimateLinks();

    EstimateLink getEstimateLinkById(Long Id);

}
