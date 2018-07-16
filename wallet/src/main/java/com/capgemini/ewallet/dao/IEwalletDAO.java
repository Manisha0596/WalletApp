
package com.capgemini.ewallet.dao;

import java.util.Stack;

import com.capgemini.ewallet.bean.Account;
import com.capgemini.ewallet.exception.EwalletException;

public interface IEwalletDAO {
	int accountCreation(Account ac);
	Account loginuser(int accntNum) throws EwalletException;
	void updatedetails(int accntNum, Account ac) throws EwalletException;
	Stack<String> getTransactionDetails(Object custId) throws EwalletException;
	

}

