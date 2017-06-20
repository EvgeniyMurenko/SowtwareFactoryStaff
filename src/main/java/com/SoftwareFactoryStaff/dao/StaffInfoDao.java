package com.SoftwareFactoryStaff.dao;


import com.SoftwareFactoryStaff.model.StaffInfo;

import java.util.List;

public interface StaffInfoDao {

    Long create(StaffInfo staffInfo);

    StaffInfo read(Long id);

    void update(StaffInfo staffInfo);

    void delete(StaffInfo staffInfo);

    List<StaffInfo> findAll();

}
