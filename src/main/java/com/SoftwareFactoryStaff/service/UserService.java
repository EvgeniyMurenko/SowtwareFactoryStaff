package com.SoftwareFactoryStaff.service;

import com.SoftwareFactoryStaff.model.User;

import java.util.List;

public interface UserService {

	User findById(Long id);

	User findBySSO(String sso);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserBySSO(String sso);

	void deleteUserById(Long id);

	List<User> findAllUsers();

	boolean isUserSSOUnique(Long id, String sso);

	User createCustomerUser(String phone);

	User createStaffUser(String password);

}