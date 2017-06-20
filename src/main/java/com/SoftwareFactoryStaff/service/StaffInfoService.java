package com.SoftwareFactoryStaff.service;


import com.SoftwareFactoryStaff.model.ManagerInfo;
import com.SoftwareFactoryStaff.model.StaffInfo;
import com.SoftwareFactoryStaff.model.User;


import java.util.List;


public interface StaffInfoService {

    void addNewStaffInfo(StaffInfo staffInfo);

    void updateStaffInfo(StaffInfo staffInfo);

    void deleteStaffInfo(StaffInfo staffInfo);

    List<StaffInfo> getAllStaffInfos();

    StaffInfo getStaffInfoById(Long id);

    void updateStaffInfoWithParameters(Long id, User user, ManagerInfo managerInfo ,String password,String name, String phone, String email, String birthDate, int android, int iOs, int iot, int java, int php, int javascript, int cSharp, int cPlusPlus, int frontend, int design);

}
