package com.bankonet.model;

import com.bankonet.model.Compte;

public final class CompteCourant extends Compte {
	
	private Float decouvertAutorise;
	//private static int nbComptesCourants=0;
		
	public CompteCourant(int identifiant, String libelle, Float solde, Float decouvertAutorise) {
		
		super(identifiant,libelle,solde);
		this.decouvertAutorise = decouvertAutorise;
	}
	
	public Float getDecouvertAutorise() {
		return decouvertAutorise;
	}

	public void setDecouvertAutorise(Float decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}
	
	/** 
	 * V�rification de la validit� du d�bit : le solde - le montant > d�couvert autoris�.
	 * */

	
	
	public boolean isdebitAutorise(Float montant) {
		boolean autorise =false;
		if ( this.getSolde()-montant>this.getDecouvertAutorise()){
			autorise = true;
		}
		else{
			autorise = false;
		}
		return autorise;
	}

	public void debiter(Float montant) 
	{
		if (this.isdebitAutorise(montant) == true) {
			super.debiter(montant);
		} else {
			System.err.print("d�bit non autoris�");
		}
		
	}
	
	
	/**
	 * Le credit d'un compte courant est toujours autoris�
	*/
	
	public boolean iscreditAutorise(Float montant) {
		return true;
	}
	
	
	/** 
	 * Surcharge de la m�thode toString pour qu'elle renvoie les d�tails du compte mis en forme et non un objet compte courant.	 * 
	 * */
	

		
}