package com.bankonet.model;


public abstract class Compte implements ICompteStat{
	private int numCompte;
	private String libelle;
	private Float solde; 
	
	public enum TypeCompte {COURANT, EPARGNE} 
	private TypeCompte typeCompte;
	
	
	
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
	
	public TypeCompte getTypeCompte() {
		return typeCompte;
	}
	

	public void setTypeCompte(TypeCompte typecompte) {
		this.typeCompte = typecompte;
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
	
	public void setSolde(Float solde) {
		this.solde = solde;
	}

	public String toString(){
		return 	"n° compte : " + this.numCompte + 
				" libellé : " + this.libelle + 
				" solde : "+ this.solde +"\n";

	}
	
	public void debiter(Float montant) {
		try {
			this.isdebitAutorise(montant);
			this.setSolde(this.getSolde()-montant);
		} catch (DebitException debitException){
			System.err.println(debitException.getMessage());
		}
		
	}

	public void crediter(Float montant){
		this.setSolde(this.getSolde()+montant);
	}
	
	public abstract boolean isdebitAutorise(Float montant) throws DebitException;
	
	public void effectuerVirement (Float montant, Compte compteDepart, Compte compteArrive){
		try {
			isdebitAutorise(montant);
			compteDepart.debiter(montant);
			compteArrive.crediter(montant);
		} catch (DebitException debitException){
			System.err.println(debitException.getMessage());
		}
	}
}
