package com.capgemini.ewallet.test;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.ewallet.dao.EwalletDAO;
import com.capgemini.ewallet.exception.EwalletException;
import com.capgemini.ewallet.service.EwalletService;
import com.project.wallet.bean.Account;
import com.project.wallet.dao.WalletAccess;
import com.project.wallet.exception.WalletException;
import com.project.wallet.service.WalletBasicService;

import static org.junit.Assert.*;
public class Test1 {
EwalletService obj=new EwalletService();



@Test
public void testValidatePhoneNo() {
	EwalletService check = new EwalletService();

assertEquals(true, check.validateCustPhoneNumber("9878012345"));
	
}



@Test
public void testValidateName() {
	EwalletService check = new EwalletService();

Assert.assertEquals(true, check.validateCustName("Manisha"));
	
}
@Test
public void testValidatePwd() {
	EwalletService check = new EwalletService();

Assert.assertEquals(true, check.validateCustPwd("Man@123"));
	
}
@Test
public void testValidateAge()
{
	EwalletService check = new EwalletService();
	Assert.assertEquals(true, check.validateCustAge(22));
}
@Test
public void testValidateAmt()
{
	EwalletService check = new EwalletService();
	Assert.assertEquals(true, check.validateAmt(2000.00));
}

@Test
public void testValidatePhoneNoFail() {
	EwalletService check = new EwalletService();

assertEquals(false, check.validateCustPhoneNumber("8745621212121"));
	
}

@Test
public void testValidateNameFail() {
	EwalletService check = new EwalletService();

Assert.assertEquals(false, check.validateCustName("Manisha12"));
	
}

@Test
public void testValidatePwdFail() {
	EwalletService check = new EwalletService();

Assert.assertEquals(false, check.validateCustPwd("12 mAm.IY"));
	
}

@Test
public void testValidateAgeFail()
{
	EwalletService check = new EwalletService();
	Assert.assertEquals(false, check.validateCustAge(152));
}

@Test
public void testValidateAmtFail()
{
	EwalletService check = new EwalletService();
	Assert.assertEquals(false, check.validateAmt(0.00));
}
@SuppressWarnings("deprecation")
@Test
public void testAccCreation()
{
	EwalletDAO w = new EwalletDAO();
	Account a = new Account();
	Assert.assertEquals(10100,w.accCreation(a));
	Account a1 = new Account();
	Assert.assertEquals(10101,w.accCreation(a1));
	Account a2 = new Account();
	Assert.assertEquals(10102,w.accCreation(a2));
	
}

@SuppressWarnings("deprecation")
@Test
public void testDepositAmt() throws EwalletException
{
	EwalletService w = new EwalletService();
	Account a = new Account();
	Assert.assertEquals(2000.00, w.depositDao(0, 2000.00));
	Assert.assertEquals(4000.00, w.depositDao(0, 2000.00));
	
}
@SuppressWarnings("deprecation")
@Test
public void testWithdrawAmt() throws Exception
{
	EwalletService wal = new EwalletService();
	Account a = new Account();
	
	Assert.assertEquals(4000.00, wal.depositDao(0, 4000.00));
	Assert.assertEquals(2000.00, wal.withdrawDao(0, 2000.00));
	Assert.assertEquals(00.00, wal.withdrawDao(0, 2000.00));
	
}

@Test
public void testDispBal()
{
	EwalletService w = new EwalletService();
	Account a = new Account();
	Assert.assertEquals(0.00,w.showBalDao(a.getAccNum()));
	
	
}

@Test
public void testLogin() throws EwalletException
{
	EwalletDAO w = new EwalletDAO();
	Account a = new Account();
	w.accCreation(a);
	Account a1 = new Account();
	w.accCreation(a1);
	Account a2 = new Account();
	w.accCreation(a2);
	Account a3 = new Account();
	w.accCreation(a3);
	System.out.println(a3.getAccNum());
	Assert.assertEquals(a1, w.loginuser(10104));
}
}

}


