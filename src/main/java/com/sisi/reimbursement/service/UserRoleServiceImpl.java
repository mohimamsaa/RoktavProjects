package com.sisi.reimbursement.service;

import com.sisi.reimbursement.model.UserRoleModel;
import com.sisi.reimbursement.repository.UserRoleDB;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	private UserRoleDB userDb;

	@Override
	public UserRoleModel addUser(UserRoleModel user) {
		String pass = encrypt(user.getPassword());
		user.setPassword(pass);
		return userDb.save(user);
	}

	@Override
	public String encrypt(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		return hashedPassword;
	}

	@Override
	public UserRoleModel getUserByUsername(String username) {
		return userDb.findByUsername(username);
	}

	@Override
	public UserRoleModel getUserById(long id) {
		return userDb.findById(id);
	}

	@Override
	public List<UserRoleModel> getUserRoleList() {
		return userDb.findAll();
	}

	@Override
	public Optional<User> findUserByAcc(String acc) {
		return userDb.findByAcc(acc);
	}
}
