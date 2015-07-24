package com.bankonet.thread;

import com.bankonet.model.*;

import java.util.*;

import thread.AlimenteurCompte;

public class TestThreads {

	public static void main(String[] args) {
		Client client = new Client("1","TITI","TATA");
		client.creerCompte(new CompteCourant(1, "compte courant 1", 0F, 1000F));
		
		Runnable firstRun = new Thread(new AlimenteurCompte(client.getComptes().get(0), 500F, 2000));
		
		Runnable secRun = new Thread(new AlimenteurCompte(client.getComptes().get(0), -200F, 1000));

		((Thread) firstRun).start();
		((Thread) secRun).start();
		
		
	}

}
