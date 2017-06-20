package com.SoftwareFactoryStaff.service;

import org.springframework.transaction.annotation.Transactional;
import com.SoftwareFactoryStaff.dao.ManagerInfoDao;
import com.SoftwareFactoryStaff.model.ManagerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("managerInfoService")
public class ManagerInfoServiceImpl implements ManagerInfoService {


    private ManagerInfoDao managerInfoDao;

    @Autowired(required = true)
    public void setManagerInfoDao(ManagerInfoDao managerInfoDao) {
        this.managerInfoDao = managerInfoDao;
    }

    @Override
    @Transactional
    public void addNewManagerInfo(ManagerInfo managerInfo) {
        managerInfoDao.create(managerInfo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ManagerInfo> getAllManagerInfos() {
        return managerInfoDao.findAll();
    }

    @Override
    @Transactional
    public ManagerInfo getManagerInfoById(Long id) {
        ManagerInfo managerInfo = managerInfoDao.read(id);
        return managerInfo;
    }

    @Override
    @Transactional
    public void updateManagerInfo(ManagerInfo managerInfo) {
        managerInfoDao.update(managerInfo);
    }

    @Override
    @Transactional
    public void deleteManagerInfo(ManagerInfo managerInfo) {
        managerInfoDao.delete(managerInfo);
    }


}
