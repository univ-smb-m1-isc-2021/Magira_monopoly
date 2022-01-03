
public class Rue extends CasePropriete{
	
	private int nbMaison;
	private final int prixMaison;
	private Etat etat;
	public final int loyer;
	
	public Rue(String nom, int prixAchat, int prixMaison, int loyer) {
		super(nom, prixAchat);
		this.prixMaison = prixMaison;
		this.nbMaison = 0;
		this.etat = new EtatLibre(this);
		this.loyer = loyer;
	}
	
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	
	public void verifierMonopoleQuartier(Joueur j) {
		etat.verifierMonopoleQuartier(j);
	}
	
	public void passerQuartierConstructible() {
		quartier.passerConstructible();
	}

	
	@Override
	public void joueurArrive(Joueur joueur) {
		System.out.println("Le joueur arrive sur la case : \""+ nom +"\"");
		System.out.println("       -> " + etat.toString());
		joueurs.add(joueur);
		etat.joueurArrive(joueur);
	}

	public Quartier getQuartier() {
		return quartier;
	}

}
