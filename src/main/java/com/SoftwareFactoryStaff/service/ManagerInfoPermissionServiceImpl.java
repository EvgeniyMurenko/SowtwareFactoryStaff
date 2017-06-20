package com.SoftwareFactoryStaff.service;


import com.SoftwareFactoryStaff.dao.ManagerInfoPermissionDao;
import com.SoftwareFactoryStaff.model.ManagerInfoPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Transactional
@Service("managerInfoPermissionService")
public class ManagerInfoPermissionServiceImpl implements ManagerInfoPermissionService {

    @Autowired
    ManagerInfoPermissionDao managerInfoPermissionDao;

    public ManagerInfoPermission findById(Long id) {
        return managerInfoPermissionDao.findById(id);
    }

    public ManagerInfoPermission findByPermission(String permission) {
        return managerInfoPermissionDao.findByPermission(permission);
    }

    public List<ManagerInfoPermission> findAll() {
        return managerInfoPermissionDao.findAll();
    }

}
