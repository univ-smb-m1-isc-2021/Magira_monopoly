package main.java;

public class CasePropriete extends Case{
	public final int prixAchat;
	protected Quartier quartier;
	private Joueur proprietaire;
	
	public CasePropriete(String nom, int prixAchat) {
		super(nom);
		this.prixAchat = prixAchat;
	}
	
	public void attribuerQuartier(Quartier quartier) {
		this.quartier = quartier;
	}
	
	public Joueur getProprietaire() {
		return proprietaire;
	}
	
	public boolean estProprietaire(Joueur j) {
		return proprietaire.equals(j);
	}
	
	public void setProprietaire(Joueur j) {
		this.proprietaire = j;
	}
	
}
