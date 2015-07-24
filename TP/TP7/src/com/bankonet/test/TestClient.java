package com.bankonet.test;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.CompteCourant;
import com.bankonet.model.CompteEpargne;

public class TestClient {

	public static void main(String[] args) { 
		
		Client[] clientTab = new Client[3];
			clientTab[0] = new Client("465797", "Machaux", "Fr�d�ric", new CompteCourant(123, "mon compte � moi", 0F, -500F), new CompteEpargne(456, "mes comptes � moi", 154F, 0.025D));
			clientTab[1] = new Client("46579", "Machaux", "Justine", new CompteCourant(12, "ton compte � toi", 0F, -500F), new CompteEpargne(456, "mes comptes � moi", 155F, 0.025D));
			clientTab[2] = new Client("4657", "Machaux", "Nicolas", new CompteCourant(1, "son compte � lui", 0F, -500F), null);

	
		for (Client client : clientTab) {
			System.out.println(client.toString());
			//System.out.println("avoir global: "+client.calculerAvoirGlobal()+ "\n");
		}

		Compte monCompte =  clientTab[1].getCompteCourant();
		System.out.println(monCompte.toString());
	}

}
