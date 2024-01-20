package com.externship.appointment.Person_storage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="person")
public class Person {
	@Id
	private String email;
	private String password;
	 @Column(name = "reset_token")
	    private String resetToken;
	public String getResetToken() {
		return resetToken;
	}
	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*
	 * public String getResetToken() { return resetToken; } public void
	 * setResetToken(String resetToken) { this.resetToken = resetToken; }
	 */


}
