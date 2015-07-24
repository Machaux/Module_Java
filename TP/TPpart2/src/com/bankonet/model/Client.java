package com.bankonet.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.*;

import com.bankonet.test.TestClient;

public class Client implements Comparable{

	Log loggerClient = LogFactory.getLog(Client.class);
	
	private String identifiant;
	private String nom;
	private String prenom;
		
	private List<Compte> comptes; 
	
	public Client(String identifiant, String nom, String prenom) {
		
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.comptes = new ArrayList<Compte>();
		
		loggerClient.debug(this);
						
	}
 	
	public int compareTo(Object aClient) throws ClassCastException {
		if (aClient instanceof Client){
			return Integer.valueOf(this.getIdentifiant()) - Integer.valueOf(((Client) aClient).getIdentifiant());
		} else {
			throw new ClassCastException("erreur de classe");
		}
				
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
		
		if (this.getComptes() != null) {
			details = details + this.getComptes().toString();
		} else {
			details = details+ "ce client n'a pas de compte courant \n";
		}
		
		if (this.getComptes() != null) {
			details = details + this.getComptes().toString();
		}	else{
			details = details+ "ce client n'a pas de compte épargne \n";
		}
				
		details += "\n Avoirs :" +this.calculerAvoirGlobal()+"\n"; 
		return details;
	}
	
	public double calculerAvoirGlobal(){
		
		double sum = 0;
	
		if (this.getComptes() != null) {
			for(Compte compte : this.comptes){
				sum += compte.getSolde();
			}
		}
				
		return sum;
	}
	
	public List<Compte> getComptes() {
		return Collections.unmodifiableList(comptes);
	}
	
	public void creerCompte (Compte compte){
		this.comptes.add(compte);
	}
	
	public Compte retournerCompte(String numero) throws CompteNonTrouveException{
		Compte compteRecherche = null;
		for (Compte compte : this.comptes){
			if (compte.getNumCompte() == Integer.valueOf(numero)){
				compteRecherche = compte;
			} 
		}
		if (compteRecherche != null){
			return compteRecherche;
		} else {
			throw new CompteNonTrouveException("ce client n'a pas de compte n°"+numero);
		}
		
	}
	
	public void supprimerCompte(String numero){
		Compte compteSuppr = null;
		
		try{
			this.retournerCompte(numero);
		}
		catch (CompteNonTrouveException compteNonTrouveException){
			System.err.println(compteNonTrouveException.getMessage());
		}
		finally {
			for (Compte compte : this.comptes){
				if (compte.getNumCompte() == Integer.valueOf(numero)){
					compteSuppr = compte;
				}
			}
		}
		this.comptes.remove(compteSuppr);
	}
}
