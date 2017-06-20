package com.SoftwareFactoryStaff.dao;


import com.SoftwareFactoryStaff.model.ManagerInfoPermission;

import java.util.List;

public interface ManagerInfoPermissionDao {

    List<ManagerInfoPermission> findAll();

    ManagerInfoPermission findByPermission(String permission);

    ManagerInfoPermission findById(Long id);

}
