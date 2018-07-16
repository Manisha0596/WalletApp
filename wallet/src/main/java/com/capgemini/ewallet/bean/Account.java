package com.capgemini.ewallet.bean;

import java.util.ArrayList;

public class Account {
	private String customerName;
	private int customerAccNumber;
	private String customerPhoneNo;
	private int customerAge;
	private double customerBalance;
	private String customerPwd;
		public void setCustomerPwd(String customerPwd) {
		this.customerPwd = customerPwd;
	}
	String tDetails = new String();
	public String gettDetails() {
		return tDetails;
	}
	public void settDetails(String getDetails) {
		this.tDetails=(getDetails);
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerAccNumber() {
		return customerAccNumber;
	}
	public void setCustomerAccNumber(int customerAccNumber) {
		this.customerAccNumber = customerAccNumber;
	}
	public String getCustomerPhoneNo() {
		return customerPhoneNo;
	}
	public void setCustomerPhoneNo(String customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}
	public int getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}
	public double getCustomerBalance() {
		return customerBalance;
	}
	public void setCustomerBalance(double customerBalance) {
		this.customerBalance = customerBalance;
	}
	public void setAccNum() {
		// TODO Auto-generated method stub
		
	}
	public Integer getAccNum() {
		// TODO Auto-generated method stub
		return null;
	}
	public double getCustBal() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setCustBal(double d) {
		// TODO Auto-generated method stub
		
	}
	public String getCustomerPwd() {
		return customerPwd;

	}
}
