package com.bankonet.model;

public class CompteEpargne {

	private String numero;
	private String intitule;
	private double solde;
	private double tauxInteret;
	
	public CompteEpargne(String numero, String intitule, double solde, double tauxInteret) {
		
		if (solde <0) {
			System.out.println("le compte épargne ne peut être créé avec un découvert. Gros boulet!!");
		} else {
			this.numero = numero;
			this.intitule = intitule;
			this.solde = solde;
			this.tauxInteret = tauxInteret;
		}
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public double getSolde() {
		return solde;
	}

	public double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	
}
