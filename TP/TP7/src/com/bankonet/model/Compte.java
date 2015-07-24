package com.bankonet.model;



public abstract class Compte implements ICompteStat{
	private int numCompte;
	private String libelle;
	private Float solde; 

	public enum TypeCompte {COURANT, EPARGNE} 
	
	
	public Compte() {}
	
	public Compte(int numCompte, String libelle, Float solde) {
		
		if (solde <0) {
			System.out.println("le compte courant ne peut être créé avec un découvert. Gros boulet!!");
		} else {
		
		this.numCompte = numCompte;
		this.libelle = libelle;
		this.solde = solde;
				
		}
	}
	
	public int getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
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

	private void setSolde(Float solde) {
		this.solde = solde;
	}



	public String toString(){
		return 	"n° compte : " + this.numCompte + 
				" libellé : " + this.libelle + 
				" solde : "+ this.solde +"\n";

	}
	
	
	public void debiter(Float montant) {
		this.setSolde(this.getSolde()-montant);
	}

	public void crediter(Float montant){
		this.setSolde(montant);
	}
	
	public abstract boolean isdebitAutorise(Float montant);
}
