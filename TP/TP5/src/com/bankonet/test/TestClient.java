package com.bankonet.test;

import com.bankonet.model.Client;
import com.bankonet.model.CompteCourant;
import com.bankonet.model.CompteEpargne;

public class TestClient {

	public static void main(String[] args) { 
		
		Client[] clientTab = new Client[3];
			clientTab[0] = new Client("465797", "Machaux", "Frédéric", new CompteCourant(123, "mon compte à moi", 0F, -500F), new CompteEpargne("456", "mes comptes à moi", 154D, 0.025D));
			clientTab[1] = new Client("46579", "Machaux", "Justine", new CompteCourant(12, "mon compte à moi", 0F, -500F), new CompteEpargne("456", "mes comptes à moi", 154D, 0.025D));
			clientTab[2] = new Client("4657", "Machaux", "Nicolas", new CompteCourant(1, "mon compte à moi", 0F, -500F), null);
	}
	

}
