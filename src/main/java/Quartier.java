package main.java;
import java.util.ArrayList;
import java.util.Iterator;

public class Quartier {
	
	private ArrayList<CasePropriete> quartier;
	
	public Quartier(Case... caseProprietes) {
		quartier = new ArrayList<CasePropriete>();
		CasePropriete cp;
		for (int i = 0; i < caseProprietes.length; i++) {
			cp = (CasePropriete) caseProprietes[i];
			quartier.add(cp);
			cp.attribuerQuartier(this);
		}
	}

	public boolean verifierMonopole(Joueur j) {
		boolean monopole = true;
		for (int i = 0; i < quartier.size(); i++) {
			if(quartier.get(i).getProprietaire() == null) {
				monopole = false;
			} else {
				if(!quartier.get(i).getProprietaire().equals(j)) {
					monopole = false; 
				}
			}
		}	
		return monopole;
	}
	
	public int getNombreProprietes(Joueur j) {
		int cpt = 0;
		for (int i = 0; i < quartier.size(); i++) {
			if(quartier.get(i).estProprietaire(j)) {
				cpt++;
			}
		}
		return cpt;
	}

	public void passerConstructible() {
		boolean quartierRue = true;
		for (int i = 0; i < quartier.size(); i++) {
			if(!(quartier.get(i) instanceof Rue)) {
				quartierRue = false;
			}
		}
		
		if(quartierRue) {
			for (int i = 0; i < quartier.size(); i++) {
				Rue rue = (Rue) quartier.get(i);
				rue.setEtat(new EtatConstructible(rue));
			}
		}
	}
	
	
}
