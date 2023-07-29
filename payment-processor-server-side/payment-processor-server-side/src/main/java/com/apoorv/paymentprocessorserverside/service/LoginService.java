package com.apoorv.paymentprocessorserverside.service;

import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.apoorv.paymentprocessorserverside.model.BankLogin;

@Service
public class LoginService{
	
	@Autowired
	LoginRepository loginRepo;
	
	public boolean saveLogin(BankLogin login) {
		loginRepo.save(login);
		return true;
	}

	public boolean hasUsername(String username) {
		return loginRepo.existsById(username);
	}

	public BankLogin getLogin(String username) {
		return loginRepo.findById(username).get();
	}


	
}
