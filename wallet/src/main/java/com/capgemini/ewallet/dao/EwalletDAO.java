package com.capgemini.ewallet.dao;

import java.util.Stack;
import java.util.TreeMap;

import com.capgemini.ewallet.bean.Account;
import com.capgemini.ewallet.exception.EwalletException;


public class EwalletDAO implements IEwalletDAO {

	TreeMap<Integer, Account> treemap = new TreeMap<Integer, Account>();
	
	public int accCreation(Account ac) {
		ac.setAccNum();
		treemap.put(ac.getAccNum(), ac);
		return ac.getAccNum();
	}

	

	@Override
	public Account loginuser(int accntNum) throws EwalletException {
		// TODO Auto-generated method stub
		Account temp = new Account();
		try {
			temp = treemap.get(accntNum);
			return temp;
				
		}
		catch(NullPointerException e) {
			if(temp==null)
			throw new EwalletException("Account does not exist");
		}
		return null;
		
	}

	@Override
	public void updatedetails(int accntNum, Account ac) {
		// TODO Auto-generated method stub
		treemap.replace(accntNum, ac);
		
		
	}



	@Override
	public int accountCreation(Account ac) {
		// TODO Auto-generated method stub
		ac.setAccNum();
		treemap.put(ac.getAccNum(), ac);
		return ac.getAccNum();
		
	}



	@Override
	public Stack<String> getTransactionDetails(Object custId) throws EwalletException {
		// TODO Auto-generated method stub
		return null;
	}




}
