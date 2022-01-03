package main.java;
import java.util.ArrayList;
import java.util.Iterator;

public class Monopoly {
	private ArrayList<Joueur> joueurs;
	private int joueurCourant;
	
	private Plateau plateau;
	
	public Monopoly(ArrayList<Joueur> joueurs) {
		this.joueurs = joueurs;
		this.plateau = new Plateau();
		
		//On place les joueurs sur la cas "départ"
		for (int i = 0; i < joueurs.size(); i++) {
			joueurs.get(i).auDepart(plateau.getDepart());
			plateau.getDepart().joueurArrive(joueurs.get(i));
		}
		
		//On tire au sort le premier joueurs à jouer
		joueurCourant = (int) (Math.random() * (joueurs.size() - 1));
		
	}
	
	
	public Joueur getJoueurCourant() {
		return joueurs.get(joueurCourant);
	}
	
	public Joueur joueurSuivant() {
		joueurCourant = (joueurCourant + 1) % joueurs.size();
		return joueurs.get(joueurCourant);
	}
	
	public void jouer() {
		Joueur joueur = joueurs.get(joueurCourant);
		System.out.println("C'est au tour de " + joueur.toString() + " de jouer !");
		joueur.lanceDe();
	}
	
	@Override
	public String toString() {
		return plateau.toString();
	}
}
