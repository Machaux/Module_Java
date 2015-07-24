package com.bankonet.test;

import com.bankonet.model.CompteCourant;
import com.bankonet.model.CompteEpargne;
import com.bankonet.model.ICompteStat;

public class DonneesTest {

	public static ICompteStat[] construitEchantillonComptes() {
		ICompteStat[] tabComptes = new ICompteStat[5];
		tabComptes[0] = new CompteCourant(1, "compte courant 1", 0F, 1000F);
		tabComptes[1] = new CompteCourant(2, "compte courant 2", 500F, 200F);
		tabComptes[2] = new CompteCourant(3, "compte courant 3", 20F, 0F);
		tabComptes[3] = new CompteEpargne(4, "compte épargne 4", 1F, 2.54D);
		tabComptes[4] = new CompteEpargne(5, "compte épargne 5", 1000000F,13.42D);

		return tabComptes;

	}

}