package main.java;

public class Gare extends CasePropriete{
	
	private boolean libre;

	public Gare(String nom, int prixAchat) {
		super(nom, prixAchat);
		this.libre = true;
	}

	@Override
	public void joueurArrive(Joueur joueur) {
		joueurs.add(joueur);
		System.out.println("Le joueur arrive sur la case : \""+ nom +"\"");
		System.out.println("       -> " + "La case est actuellement " + (libre ? "libre" : "occupée") + " !");
		if(libre) {
			if(joueur.proposerAchat(nom, prixAchat)) {
				setProprietaire(joueur);
				libre = !libre;
			} else {
				//S'il refuse d'acheter il peut vouloir faire une autre action
			}
		} else {
			if(!estProprietaire(joueur)) {
				int nombreGare = quartier.getNombreProprietes(getProprietaire());
				int loyer = De.lancer() + De.lancer();
				for (int i = 0; i < nombreGare; i++) {
					loyer = loyer*2;
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
