package com.SoftwareFactoryStaff.dao;


import com.SoftwareFactoryStaff.model.StaffHistory;


import java.util.List;

public interface StaffHistoryDao {

    Long create(StaffHistory staffHistory);

    StaffHistory read(Long id);

    void update(StaffHistory staffHistory);

    void delete(StaffHistory staffHistory);

    List<StaffHistory> findAll();

}
