package com.apoorv.paymentprocessorserverside.controller;

import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apoorv.paymentprocessorserverside.model.BankLogin;
import com.apoorv.paymentprocessorserverside.service.CacheService;
import com.apoorv.paymentprocessorserverside.service.LoginService;



@RestController
public class PaymentController {
	
	/*	
	 Response Codes

	1: login success
	2: login unsuccessful
	3: login success from cache
	
	*/
	
	@Autowired
	LoginService loginService;
	@Autowired
	CacheService cacheService;
	
	@CrossOrigin("http://localhost:3000")
	@PostMapping("/login")
	public int login(@RequestBody BankLogin login) {
		if(cacheService.hasLogin(login)) {
			return 3;
		}
		if(loginService.hasUsername(login.getUsername())) {
			BankLogin realCred=loginService.getLogin(login.username);
			if(realCred.getPassword().equals(login.password)) {
				loginService.saveLogin(login);
				cacheService.addLogin(login);
				return 1;
			}
		}
		return 2;
	}
	
	@CrossOrigin("http://localhost:3000")
	@PostMapping("/createAccount")
	public int createAccount(@RequestBody BankLogin login) {
		/*
		Response Codes

		1: Account created successfully
		2: username already exists
		
		*/
		if(!loginService.hasUsername(login.getUsername())) {
			loginService.saveLogin(login);
			return 1;
		}
		return 2;
	}
	
	@GetMapping("/getAllTransactions")
	public String getAllTransactions() {
		return "getAllTransactions";
	}
	
	@GetMapping("/AcceptTransaction")
	public String AcceptTransaction() {
		return "AcceptTransaction";
	}
	
	@GetMapping("/RejectTransaction")
	public String rejecTransaction() {
		return "rejectTransaction";
	}
	
}
