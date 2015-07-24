package com.bankonet.test;

import com.bankonet.jdbc.ClientDao;
import com.bankonet.model.Client;

public class TestCompteDAO {

	public static void main(String[] args) {
		ClientDao newTest = new ClientDao();
		Client testClient = new Client("3","titi","tata");
		
		System.out.println(newTest.lireComptesEpargne(testClient));
		newTest.closeConnection();

	}

}
