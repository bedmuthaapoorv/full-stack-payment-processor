package com.apoorv.paymentprocessorserverside.service;

import java.util.HashMap;
import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.apoorv.paymentprocessorserverside.model.BankLogin;

@Service
public class CacheService {
	HashMap<String,BankLogin> logins=new HashMap<>();
	
	public void addLogin(BankLogin login) {
		logins.put(login.getUsername(),login);
		System.out.println(logins);
	}

	@Override
	public String toString() {
		return "CacheService [logins=" + logins + "]";
	}

	public boolean hasLogin(BankLogin login) {
		if(logins.get(login.getUsername())==null) {
			return false;
		}else {
			if(logins.get(login.getUsername()).equals(login)) {
				return true;
			}
		}
		return false;
	}
	
	
}
