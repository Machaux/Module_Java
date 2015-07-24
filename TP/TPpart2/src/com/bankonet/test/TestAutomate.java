package com.bankonet.test;

import com.bankonet.model.ICompteStat;

public class TestAutomate {

	public static void main(String[] args) {
		
		ICompteStat[] nouveauxTabComptes = new ICompteStat[5];
				
		nouveauxTabComptes = DonneesTest.construitEchantillonComptes();
		
		Float nouvelleMoyenne = 0F ;
		
		for (ICompteStat compte : nouveauxTabComptes) {
			nouvelleMoyenne += compte.getSolde(); 
		}
		nouvelleMoyenne = nouvelleMoyenne/nouveauxTabComptes.length;
		
		System.out.println(nouvelleMoyenne);
	}
}