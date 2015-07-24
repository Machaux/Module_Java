package com.bankonet.model;

public class CompteCourant {
	
	private int identifiant;
	private String libelle;
	private Float solde;
	private Float decouvertAutorise;
	private static int nbComptesCourants=0;
	
	public CompteCourant(){
		nbComptesCourants++;
	}
	
	public CompteCourant(int identifiant, String libelle, Float solde, Float decouvertAutorise) {
		this();
		
		if (solde <0) {
			System.out.println("le compte courant ne peut être créé avec un découvert. Gros boulet!!");
			nbComptesCourants --;
		} else {
		
		this.identifiant = identifiant;
		this.libelle = libelle;
		this.solde = solde;
		this.decouvertAutorise = decouvertAutorise;
		
		}
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Float getSolde() {
		return solde;
	}

	public void setSolde(Float solde) {
		this.solde = solde;
	}

	public Float getDecouvertAutorise() {
		return decouvertAutorise;
	}

	public void setDecouvertAutorise(Float decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}

	public static int getNbComptesCourants() {
		return nbComptesCourants;
	}

	public static void setNbComptesCourants(int nbComptesCourants) {
		CompteCourant.nbComptesCourants = nbComptesCourants;
	}
		
	
	/** 
	 * Vérification de la validité du débit : le solde - le montant > découvert autorisé.
	 * */

	public boolean iscreditAutorise(Float montant) {
		return true;
	}
	
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
	
	
	/** 
	 * Surcharge de la méthode toString pour qu'elle renvoie les détails du compte mis en forme et non un objet compte courant.	 * 
	 * */
	
	public static String toString (CompteCourant compte) {
		String details = 	"n° compte : " + compte.identifiant + 
							" libellé : " + compte.libelle + 
							" solde : "+compte.solde +
							"Découvert autorisé : " + compte.getDecouvertAutorise()+"\n";
		return	details;
	}

	/**
	 * Le credit d'un compte courant est toujours autorisé
	*/
	

	
}