package com.bankonet.model;

public class TestCompteCourant {
	
	public static void main (String args[]) {
	
		CompteCourant  compteCourant1 = new CompteCourant(1, "compte n°1", 10F, -50F);
		System.out.println(compteCourant1.getIdentifiant());
		System.out.println(compteCourant1.getSolde());
		System.out.println(CompteCourant.getNbComptesCourants());
		
		CompteCourant  compteCourant2 = new CompteCourant(2, "compte n°2", 100F, 500F);
		System.out.println(compteCourant2.getIdentifiant());
		System.out.println(compteCourant2.getSolde());
		System.out.println(CompteCourant.getNbComptesCourants());
		
		CompteCourant  compteCourant3 = new CompteCourant(3, "compte n°3", 1000F, -5000F);
		System.out.println(compteCourant3.getIdentifiant());
		System.out.println(compteCourant3.getSolde());
		System.out.println(CompteCourant.getNbComptesCourants());
	}
	
}
