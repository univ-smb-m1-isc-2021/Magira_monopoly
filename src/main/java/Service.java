package main.java;

public class Service extends CasePropriete{
	
	private boolean libre;

	public Service(String nom, int prixAchat) {
		super(nom, prixAchat);
		this.libre = true;
	}
	
	@Override
	public void joueurArrive(Joueur joueur) {
		joueurs.add(joueur);
		if(libre) {
			if(joueur.proposerAchat(nom, prixAchat)) {
				setProprietaire(joueur);
				libre = !libre;
			} else {
				//S'il refuse d'acheter il peut vouloir faire une autre action
			}
		} else {
			if(!estProprietaire(joueur)) {
				boolean monopole = quartier.verifierMonopole(getProprietaire());
				int loyer = De.lancer() + De.lancer();
				if(monopole) {
					loyer = loyer*10;
				} else {
					loyer = loyer*4;
				}
				
				if(joueur.paye(loyer)) {
					getProprietaire().recois(loyer);
				} else {
					//Le joueur dois hypothequer sa maison				
					getProprietaire().recois(loyer);
				}
			} else {
				//il peut vouloir faire une autre action
			}
			
		}
	}

}
