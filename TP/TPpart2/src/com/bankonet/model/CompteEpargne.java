package com.bankonet.model;



public class CompteEpargne extends Compte {

	
	private double tauxInteret;
	
	public CompteEpargne() {
		super();
	}
	
	public CompteEpargne(int numero, String intitule, Float solde, double tauxInteret) {
		super(numero, intitule, solde);
		this.tauxInteret = tauxInteret;
		this.setTypeCompte(TypeCompte.EPARGNE);
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
	
	public boolean isdebitAutorise(Float montant) throws DebitException{
		
		if ( this.getSolde()-montant>0){
			return true;
		}
		else{
			throw new DebitException ("débit non autorisé");
		}
	}
	
	public void debiter(Float montant) {
		super.debiter(montant);
	
	}
}
