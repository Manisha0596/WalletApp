package com.capgemini.ewallet.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;

import com.capgemini.ewallet.bean.Account;
import com.capgemini.ewallet.dao.EwalletDAO;
import com.capgemini.ewallet.dao.IEwalletDAO;
import com.capgemini.ewallet.exception.EwalletException;


public class EwalletService implements IEwalletService {
	Account temp = new Account();
	IEwalletDAO dao;
	 public EwalletService() {
		 dao = new EwalletDAO();
		 
	}
	 LocalDate tDate = LocalDate.now();
	 static String namePattern = "[A-Z]{1}[a-z]{2,}";
	 static String numberPattern = "(\\d){10}";
	 static String passwordPattern = "[A-Z]{1}[a-z]{2,6}(\\d){1,4}(\\W){1}";
	 public  boolean validateCustName(String name)
	 {	if(name.matches(namePattern))
	 		return true;
	 	else
	 		return false;
	 }
	 
	 
	 public  boolean validateCustPhoneNumber(String number) {
			if(number.matches(numberPattern))
				return true;
			else
				return false;
		}
	 
	 
public boolean validateCustAge(int age) {
	if(age<=110&&age>=1)
		return true;
	else
		return false;
	
}

public  boolean validateCustPwd(String pwd) {
	if(pwd.matches(passwordPattern))
		return true;
	else
		return false;
}

public  boolean validateAmt(double amt) {
if(amt>0.00)
	return true;
else
	return false;
}
	

	@Override
	public int addAccntDao(Account ac) {
		// TODO Auto-generated method stub
		return dao.accountCreation(ac);
	}

	@Override
	public double depositDao(double money) throws EwalletException   {
		// TODO Auto-generated method stub
		temp.setCustBal(temp.getCustBal()+money);
		try {
			temp.settDetails("Date :"+tDate+" Depsoited Amount :"+money+" Total Balance :"+temp.getCustBal());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao.updatedetails(temp.getAccNum(),temp);
		return temp.getCustBal();
		
	}

	@Override
	public double withdrawlDao(double money) throws EwalletException {
		// TODO Auto-generated method stub
		if(money<temp.getCustBal()) {
			temp.setCustBal(temp.getCustBal()-money);
			try {
				temp.settDetails("Date :"+tDate+" Amount Withdrawn :"+money+" Total Balance :"+temp.getCustBal());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dao.updatedetails(temp.getAccNum(),temp);
			}
			else
				System.out.println(" Low Balance :( ");
			return temp.getCustBal();
	}
	
	

	@Override
	public double showbalanceDao() {
		// TODO Auto-generated method stub
		
		return temp.getCustBal();
	}

	@Override
	public boolean checkLogin(int accNo) throws EwalletException {
		// TODO Auto-generated method stub
		temp =dao.loginuser(accNo);
		if(temp!=null)
		return true;
		else 
			return false;
	}

	@Override
	public boolean checkPassword(String pwd) {
		// TODO Auto-generated method stub
		if(temp.getCustomerPwd().matches(pwd))
			return true;
		else
			return false;
	}

	@Override
	public String currentUser() {
		// TODO Auto-generated method stub
		return  temp.getCustomerName();
	}

	@Override
	public boolean transferAmnt(int toAccNo, double money)
			throws EwalletException {
		// TODO Auto-generated method stub
		Account ftTemp =new Account();
		if(temp.getCustBal()>=money) {
		ftTemp = dao.loginuser(toAccNo);
		if(ftTemp!=null)
		{
			ftTemp.setCustBal(ftTemp.getCustBal()+money);
			temp.setCustBal(temp.getCustBal()-money);
			temp.settDetails("Date :"+tDate+" Amount Transfered :"+money+" To Acc No: "+ftTemp.getAccNum()+" Total Balance :"+temp.getCustBal());
			ftTemp.settDetails("Date :"+tDate+" Depsoited Amount :"+money+" From Acc No: "+temp.getAccNum()+" Total Balance :"+ftTemp.getCustBal());
			dao.updatedetails(temp.getAccNum(), temp);
			dao.updatedetails(ftTemp.getAccNum(), ftTemp);
			return true;
		}
		
		
	}
		else if(temp.getCustBal()<money)
		{
			System.out.println("Low Balance to transfer");
		}
		
		else
			System.out.println("No such user account");
		return false;
	}


	@Override
	public void printTransdetails() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int generateAccountId() {
		// TODO Auto-generated method stub
		int AccountId = (int) (Math.random()*10000);
		return 0;
	}
	

	/*@Override
	public void printTransdetails() {
		// TODO Auto-generated method stub
		String tempDetails = new ArrayList<String>();
		tempDetails = temp.gettDetails();
		Stream printList = tempDetails.stream();
		printList.forEach(System.out::println);
		
	}*/
	

}
