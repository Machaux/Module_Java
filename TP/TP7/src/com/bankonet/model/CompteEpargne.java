package com.bankonet.model;

import com.bankonet.model.Compte;

public class CompteEpargne extends Compte {

	private double tauxInteret;
	
	
	
	public CompteEpargne(int numero, String intitule, Float solde, double tauxInteret) {
		super(numero, intitule, solde);
		this.tauxInteret = tauxInteret;
	}
	
	public double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	public String toString(){
		return super.toString() + "taux d'intérêt : " + this.getTauxInteret();
	}
	
	public boolean isdebitAutorise(Float montant) {
		boolean autorise =false;
		if ( this.getSolde()-montant>0){
			autorise = true;
		}
		else{
			autorise = false;
		}
		return autorise;
	}
	
	public void debiter(Float montant) {
		if ((this.getSolde()-montant)>0) {
			super.debiter(montant);
		} else {
			System.err.print("débit non autorisé");
		}
	}
}
