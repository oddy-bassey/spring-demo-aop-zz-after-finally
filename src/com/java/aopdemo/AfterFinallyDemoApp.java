package com.java.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.java.aopdemo.dao.Account;
import com.java.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {
	public static void main(String[] args) {
		
		//read spring java config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the AccountDAO bean from spring container
		AccountDAO accDao = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> accounts = null;
		try {
			
			//add a boolean flag to simulate an exception
			boolean tripWire = false;
			
			//call the method to find the Accounts
			accounts = accDao.findAccounts(tripWire);
			
		}catch (Exception e) {
			System.out.println("\n\nMain Program ... caught exception: "+e);
		}
		
		//display the Accunts
		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("----------");
		System.out.println(accounts+"\n");
		
		//close the
		context.close();
	}
}
