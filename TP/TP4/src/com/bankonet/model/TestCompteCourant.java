package com.bankonet.model;

public class TestCompteCourant {
	
	public static void main (String args[]) {
	
		CompteCourant  compteCourant1 = new CompteCourant(1, "compte n°1", 10F, -50F);
		//System.out.println(compteCourant1.getIdentifiant());
		//System.out.println(compteCourant1.getSolde());
		//System.out.println(CompteCourant.getNbComptesCourants());
		
		CompteCourant  compteCourant2 = new CompteCourant(2, "compte n°2", 100F, -500F);
		//System.out.println(compteCourant2.getIdentifiant());
		//System.out.println(compteCourant2.getSolde());
		//System.out.println(CompteCourant.getNbComptesCourants());
		
		CompteCourant  compteCourant3 = new CompteCourant(3, "compte n°3", 1000F, -5000F);
		
		CompteCourant  compteCourant4 = new CompteCourant(4, "compte n°4", -200F, -5000F);
//		System.out.println(compteCourant4.getIdentifiant());
//		System.out.println(compteCourant4.getSolde());
	//  System.out.println(CompteCourant.getNbComptesCourants());
	
//		System.out.println(CompteCourant.toString(compteCourant1));
//		System.out.println(compteCourant1.isdebitAutorise(100F));
//		System.out.println(compteCourant1.isdebitAutorise(100F));
//		
//		System.out.println(CompteCourant.toString(compteCourant2));
//		System.out.println(compteCourant2.isdebitAutorise(100F));
//		System.out.println(compteCourant2.isdebitAutorise(100F));
//		
//		System.out.println(CompteCourant.toString(compteCourant3));
//		System.out.println(compteCourant3.isdebitAutorise(100F));
//		System.out.println(compteCourant3.isdebitAutorise(100F));
		
		CompteCourant[] compteCourantTab = new CompteCourant[3];
			compteCourantTab[0] = new CompteCourant(5, "compte n°5", 100000F, -50000F);
			compteCourantTab[1] = new CompteCourant(6, "compte n°6", -2F, -5000000F);
			compteCourantTab[2] = new CompteCourant(7, "compte n°7", 0F, -500F);
		
//		int solde = 10000;
//			switch (solde) {
//				case 0:
//					System.out.println("solde nul");
//					break;
//				case 10000:
//					System.out.println("solde créditeur");
//					break;
//				default:
//					System.out.println("ras");
//					break;
//			}

//			for (CompteCourant i : compteCourantTab) {
//				System.out.println(CompteCourant.toString(i));
//			}
			
			int i = 0;
			while ( i<compteCourantTab.length) {
				System.out.println(CompteCourant.toString(compteCourantTab[i]));
				i++;
			}
			
			
	}
	
	
	
}
