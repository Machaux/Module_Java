package com.bankonet.model;

import com.bankonet.model.Compte;
import com.bankonet.model.DebitException;

public final class CompteCourant extends Compte {
	
	private Float decouvertAutorise;
	//private static int nbComptesCourants=0;
	
	public CompteCourant(){
		super();
	}
	
	public CompteCourant(int identifiant, String libelle, Float solde, Float decouvertAutorise) {
		
		super(identifiant,libelle,solde);
		this.decouvertAutorise = decouvertAutorise;
		this.setTypeCompte(TypeCompte.COURANT);
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

	
	
	public boolean isdebitAutorise(Float montant) throws DebitException{
		if ( this.getSolde()-montant>this.getDecouvertAutorise()){
			return  true;
		} else {
			throw new DebitException ("d�bit non autoris�");
		}
	}

	public void debiter(Float montant) {
			super.debiter(montant);
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