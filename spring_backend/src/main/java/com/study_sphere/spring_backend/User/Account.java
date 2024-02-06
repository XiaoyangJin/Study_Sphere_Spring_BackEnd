package com.study_sphere.spring_backend.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int account_id;
	private String username;
	private String password;
	public Account(int user_id, String username, String password) {
		super();
		this.account_id = user_id;
		this.username = username;
		this.password = password;
	}
	// No-argument constructor
    public Account() {
    }
	public int getUser_id() {
		return account_id;
	}
	public void setUser_id(int user_id) {
		this.account_id = user_id;
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
	@Override
	public String toString() {
		return "User [user_id=" + account_id + ", username=" + username + ", password=" + password + "]";
	}
	
}
