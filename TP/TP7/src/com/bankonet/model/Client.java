package com.bankonet.model;

public class Client {

	private String identifiant;
	private String nom;
	private String prenom;
	private CompteCourant compteCourant;
	private CompteEpargne compteEpargne;
	
	public Client(String identifiant, String nom, String prenom,CompteCourant compteCourant, CompteEpargne compteEpargne) {
		
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.compteCourant = compteCourant;
		this.compteEpargne = compteEpargne;
				
	}

 
	
	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String toString (){
		
		String details = 	"Mon beau client, roi des clients \n" +
							"Nom" + this.getNom() +  " " + "Prénom "+ this.getPrenom() + "\n"+
							"identifiant "+ this.getIdentifiant()+"\n";
		
		if (this.getCompteCourant() != null) {
			details = details + this.getCompteCourant().toString();
		} else {
			details = details+ "ce client n'a pas de compte courant \n";
		}
		
		if (this.getCompteEpargne() != null) {
			details = details + this.getCompteEpargne().toString();
		}	else{
			details = details+ "ce client n'a pas de compte épargne \n";
		}
				
		details += "\n Avoirs :" +this.calculerAvoirGlobal()+"\n"; 
		return details;
	}
	
	public double calculerAvoirGlobal(){
		double sum = 0;
		if (this.getCompteCourant() != null) {
			sum += this.getCompteCourant().getSolde();
		}
		if (this.getCompteEpargne() != null) {
			sum += this.getCompteEpargne().getSolde();
		}
		return sum;
	}
		
}
