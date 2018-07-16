package com.capgemini.ewallet.service;

import com.capgemini.ewallet.bean.Account;
import com.capgemini.ewallet.exception.EwalletException;




public interface IEwalletService {
	int addAccntDao(Account ac);
	double depositDao(double money) throws EwalletException;
	double withdrawlDao(double money) throws EwalletException ;
	double showbalanceDao();
	boolean checkLogin(int accNo) throws EwalletException;
	boolean checkPassword(String pwd);
	String currentUser();
	boolean transferAmnt(int toAccNo, double money) throws EwalletException;
	void printTransdetails();
	int generateAccountId();

}

