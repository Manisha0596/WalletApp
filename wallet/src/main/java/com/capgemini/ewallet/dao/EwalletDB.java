package com.capgemini.ewallet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Stack;

import com.capgemini.ewallet.bean.Account;
import com.capgemini.ewallet.exception.EwalletException;
import com.capgemini.ewallet.util.DBUtil;
import com.project.wallet.exception.WalletException;

public class EwalletDB implements IEwalletDAO {
	Connection con = DBUtil.getConnect();
	@Override
	public int accountCreation(Account ac) {
		// TODO Auto-generated method stub
		ac.setAccNum();
		ac.settDetails("Initial Balance : "+ac.getCustBal());
String sql1 = "INSERT INTO ACCOUNT VALUES(?,?,?,?,?,?)";
String sql2 = "INSERT INTO TDETAILS VALUES(?,?)";
PreparedStatement pstmt;
try {
	pstmt = con.prepareStatement(sql1);
	pstmt.setInt(1, ac.getAccNum());
	pstmt.setString(2, ac.getCustomerName());
	pstmt.setString(3, ac.getCustomerPhoneNo());
	pstmt.setInt(4, ac.getCustomerAge());
	pstmt.setDouble(5, ac.getCustBal());
	pstmt.setString(6, ac.getCustomerPwd());


	int row1 = pstmt.executeUpdate();
	if(row1>0)
	{
		System.out.println("1 row has been inserted successfully");
	}
} catch (SQLException e) {
	
	e.printStackTrace();
}

		return ac.getAccNum();
	}
		
	

	@Override
	public Account loginuser(int accntNum) throws EwalletException {
		// TODO Auto-generated method stub
		String sql1 = "SELECT * FROM ACCOUNT WHERE CUSTID =?";
		try {
			
			
			PreparedStatement pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, accntNum);
			
			ResultSet rslt = pstmt.executeQuery();
			if(rslt.next()) {
				
				Account tempLogin = new Account();
				tempLogin.setCustomerName(rslt.getString(2));
				tempLogin.setCustomerAge(rslt.getInt(4));
				tempLogin.setCustBal(rslt.getDouble(5));
				tempLogin.setCustomerPhoneNo(rslt.getString(3));
				tempLogin.setCustomerPwd(rslt.getString(6));
				
				
				
				return tempLogin;
				
				
			}
			
			
			
		} catch (SQLException e) {
			throw new EwalletException("DB fetch error");
		}
			return null;
			}
		

	@Override
	public void updatedetails(int accntNum, Account ac)  {
		// TODO Auto-generated method stub
		String sql1 = "UPDATE ACCOUNT SET CUSTBAL=? WHERE CUSTID =?";
		String sql2 = "INSERT INTO TDETAILS VALUES(?,?)";
		PreparedStatement pstmt;
		try {
			 pstmt = con.prepareStatement(sql1);
			pstmt.setDouble(1, ac.getCustBal());
		
			pstmt.setInt(2, accntNum);
			int row = pstmt.executeUpdate();
			if(row>0)
			{
				System.out.println("*********************");
			}
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, accntNum);
			pstmt.setString(2, ac.gettDetails());
			int row1 = pstmt.executeUpdate();
			if(row1>0) {
				
				System.out.println("updated successfully");
			}
			
		} catch (SQLException e) {
			try {
				throw new EwalletException("Update Details Failed");
			} catch (EwalletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
	}



	@Override
	public Stack<String> getTransactionDetails(Object custId) throws EwalletException {
		// TODO Auto-generated method stub
		{
			String sql2 = "SELECT DETAILS FROM TDETAILS WHERE CUSTID=?";
			Stack<String> resultList = new Stack<String>();
		
			try {
				PreparedStatement pstmt = con.prepareStatement(sql2);
				int accntNum = 0;
				pstmt.setInt(1, accntNum);
				ResultSet result = pstmt.executeQuery();
				
				
				while(result.next()) {
				
					
			resultList.push(result.getString(1));
					
				
				}
				
			} catch (SQLException e) {
				throw new EwalletException("Transaction Details Error");
			}
			
			
			return resultList;
		}
		
	}
	
	
	}


