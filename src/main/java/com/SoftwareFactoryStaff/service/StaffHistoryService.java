package com.SoftwareFactoryStaff.service;


import com.SoftwareFactoryStaff.model.StaffHistory;

import java.util.List;

public interface StaffHistoryService {

    void addNewStaffHistory(StaffHistory staffHistory);

    void updateStaffHistory(StaffHistory staffHistory);

    void deleteStaffInfo(StaffHistory staffHistory);

    List<StaffHistory> getAllStaffHistorys();

    StaffHistory getStaffHistoryById(Long id);

}
