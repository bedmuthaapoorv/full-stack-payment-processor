package com.apoorv.paymentprocessorserverside.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apoorv.paymentprocessorserverside.model.BankLogin;

public interface LoginRepository extends JpaRepository<BankLogin,String>{
	
}
