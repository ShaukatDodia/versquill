package com.app.versequill.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "T_VSQ_REGISTRATION", uniqueConstraints=@UniqueConstraint(columnNames = {"user_name", "email"}))

public class Registration {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY )
    @Column
    private int id;

    @Column(name = "user_name")
    private String userName;
    
    @Column
    private String email;

    @Column
    private String password;

    public String getUser_name() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public void setUser_name(String user_name) {
        this.userName = user_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

	@Override
	public String toString() {
		return "Registration [id=" + id + ", user_name=" + userName + ", email=" + email + ", password=" + password
				+ "]";
	}


}
