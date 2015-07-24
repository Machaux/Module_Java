package com.bankonet.test;

import com.bankonet.jdbc.ClientDao;

public class TestClientDAO {

	public static void main(String[] args) {
		ClientDao newTest = new ClientDao();

		System.out.println(newTest.lireCLient(2));
		newTest.closeConnection();
	}

	
	
}
