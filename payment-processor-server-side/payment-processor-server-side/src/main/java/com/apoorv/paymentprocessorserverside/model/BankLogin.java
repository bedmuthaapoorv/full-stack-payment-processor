package com.apoorv.paymentprocessorserverside.model;

import java.sql.Time;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BankLogin {
	@Id
	public String username;
	public String password;
	//Time time;
	public int hours;
	public int minutes;
	public String ip;
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

	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@Override
	public String toString() {
		return "BankLogin [username=" + username + ", password=" + password + ", hours=" + hours + ", minutes="
				+ minutes + ", ip=" + ip + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(ip, password, username);
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof BankLogin) {
			BankLogin temp=(BankLogin)o;
			return this.getUsername().equals(temp.getUsername()) && this.password.equals(temp.getPassword()) && this.ip.equals(temp.getIp());
		}
		return false;
	}


		
	
	
}
