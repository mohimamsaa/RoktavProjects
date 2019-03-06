package com.sisi.reimbursement.service;

import com.sisi.reimbursement.model.UserRoleModel;
import org.apache.tomcat.jni.User;

import java.util.List;
import java.util.Optional;

public interface UserRoleService {
	UserRoleModel addUser(UserRoleModel user);
	public String encrypt(String password);
	UserRoleModel getUserByUsername(String username);
	UserRoleModel getUserById(long id);
	List<UserRoleModel> getUserRoleList();
	Optional<User> findUserByAcc(String acc);
}
