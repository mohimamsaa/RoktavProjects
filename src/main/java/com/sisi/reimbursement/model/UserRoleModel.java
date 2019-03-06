package com.sisi.reimbursement.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="user_role")
public class UserRoleModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(max = 50)
	@Column(name = "username", nullable = false)
	private String username;

	@NotNull
	@Lob
	@Column(name = "password", nullable = false)
	private String password;

	@NotNull
	@Size(max = 50)
	@Column(name = "role", nullable = false)
	private String role;

	@NotNull
	@Size(max = 255)
	@Column(name = "contacts", nullable = false)
	private String contacts;

	@NotNull
	@Size(max = 255)
	@Column(name = "division", nullable = false)
	private String division;

	@NotNull
	@Size(max = 255)
	@Column(name = "bank", nullable = false)
	private String bank;

	@NotNull
	@Size(max = 255)
	@Column(name = "acc", nullable = false)
	private String acc;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}
}
