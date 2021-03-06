package com.bankonet.model;

public class CompteCourant {
	
	private int identifiant;
	private String libelle;
	private Float solde;
	private Float decouvertAutorise;
	//private static int nbComptesCourants=0;
	
	public CompteCourant(){
		//nbComptesCourants++;
	}
	
	public CompteCourant(int identifiant, String libelle, Float solde, Float decouvertAutorise) {
		this();
		
		if (solde <0) {
			System.out.println("le compte courant ne peut �tre cr�� avec un d�couvert. Gros boulet!!");
			//nbComptesCourants --;
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

	/** 
	 * Le setteur de Solde n'est pas judicieux car le solde est modifi� par d'autres m�thode et non fix� arbitrairement
	 * 
	public void setSolde(Float solde) {
		this.solde = solde;
	}
	*/

	public Float getDecouvertAutorise() {
		return decouvertAutorise;
	}

	public void setDecouvertAutorise(Float decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}

//	public static int getNbComptesCourants() {
//		return nbComptesCourants;
//	}

	
	/** 
	 * le nombre de compte courant ne peut �tre impl�ment� que par le constructeur!!
	 * 
	public static void setNbComptesCourants(int nbComptesCourants) {
		CompteCourant.nbComptesCourants = nbComptesCourants;
	}
	*/
	
	/** 
	 * V�rification de la validit� du d�bit : le solde - le montant > d�couvert autoris�.
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
	 * Surcharge de la m�thode toString pour qu'elle renvoie les d�tails du compte mis en forme et non un objet compte courant.	 * 
	 * */
	
	public String toString () {
		String details = 	"n� compte : " + this.identifiant + 
							" libell� : " + this.libelle + 
							" solde : "+ this.solde +
							"D�couvert autoris� : " + this.getDecouvertAutorise()+"\n";
		return	details;
	}

	/**
	 * Le credit d'un compte courant est toujours autoris�
	*/
	

	
}