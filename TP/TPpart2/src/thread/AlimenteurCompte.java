package thread;

import com.bankonet.model.*;

public class AlimenteurCompte implements Runnable{

	private Compte compte;
	private Float somme;
	private Integer timer;
	
	public AlimenteurCompte (Compte compte, Float somme, Integer timer){
		this.compte = compte;
		this.somme = somme;
		this.timer = timer;
	}
	
	public void run() {
		Float solde = compte.getSolde();
		
		System.out.println("solde du compte : "+solde);
		
		try {
			Thread.sleep(timer.intValue());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		compte.setSolde(compte.getSolde()+somme);
		
		System.out.println("Ajout de : "+somme);
		
		System.out.println("Thread : "+this.toString() +" solde du compte : "+solde);
	}

}
