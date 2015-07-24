package com.bankonet.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bankonet.model.Client;
//import com.bankonet.model.Compte;
//import com.bankonet.model.Compte.TypeCompte;
//import com.bankonet.model.DebitException;

public class TestClient {

	public static void main(String[] args) { 
		
		List<Client> clientTab = new ArrayList<Client>(3);
			clientTab.add( new Client("465797", "Machaux", "Frédéric")); 
			//	clientTab[0].creerCompte(new CompteCourant(123, "mon compte à moi", 0F, -500F));
			//	clientTab[0].creerCompte(new CompteEpargne(456, "mes comptes à moi", 154F, 0.025D));
				
			clientTab.add( new Client("46579", "Machaux", "Justine")); 
			//	clientTab[1].creerCompte(new CompteCourant(12, "ton compte à toi", 0F, -500F));
			//	clientTab[1].creerCompte(new CompteEpargne(457, "mes comptes à moi", 155F, 0.025D));
			
			
			clientTab.add( new Client("4657", "Machaux", "Nicolas")); 
				//clientTab[2].creerCompte(new CompteCourant(1, "son compte à lui", 0F, -500F));
	
			
			System.out.println(clientTab.toString());
			System.out.println("Liste triée");
			Collections.sort(clientTab);
			System.out.println(clientTab.toString());
////			System.out.println(client.toString());
////			//System.out.println("avoir global: "+client.calculerAvoirGlobal()+ "\n");
////		}
//
////		Compte monCompte =  clientTab[1].getCompteCourant();
////		System.out.println(monCompte.toString());
//
//			clientTab[1].getCompteCourant().crediter(5000F);
//			clientTab[1].getCompteCourant().effectuerVirement(4000F, clientTab[1].getCompteCourant(), clientTab[1].getCompteCourant());
//			System.out.println("compte epargne : "+clientTab[1].getCompteCourant().getSolde());
//			System.out.println("compte courant : "+clientTab[1].getCompteCourant().getSolde());

	}
}
