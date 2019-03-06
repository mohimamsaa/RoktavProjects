package com.sisi.reimbursement.repository;

import com.sisi.reimbursement.model.UserRoleModel;
import org.apache.tomcat.jni.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleDB extends JpaRepository<UserRoleModel, Long> {
	UserRoleModel findByUsername(String username);
	UserRoleModel findById(long id);
	Optional<User> findByAcc(String acc);
}
