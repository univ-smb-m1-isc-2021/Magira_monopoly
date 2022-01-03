package main.java;
import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
	
	private String nom;
	private int argent;
	private Case position;
	private ArrayList<CasePropriete> proprietes; //Utile si le joueur veut hypothéquer ses prop ?
	
	public Joueur(String nom) {
		this.nom = nom;
		this.position = null;
		this.argent = 1500;
		this.proprietes = new ArrayList<CasePropriete>();
	}
	
	public void auDepart(Case depart){
		this.position = depart;
	}
	
	public boolean paye(int montant) {
		if(argent < montant) {
			return false;
		} else {
			argent -= montant;
			return true;
		}
	}
	
	public void recois(int montant) {
		argent += montant;
	}

	public void lanceDe() {
		int resultatDes = De.lancer() + De.lancer();
		System.out.println(toString() + " lance les dés et obtient : " + resultatDes);
		position.joueurPart(this);
		position = position.avance(resultatDes);
		position.joueurArrive(this);
	}
	
	@Override
	public String toString() {
		return nom;
	}
	
	 @Override
	 public boolean equals(Object o) {
		 if(o instanceof Joueur) {
			 Joueur j = (Joueur) o;
			 if(this.nom == j.nom) {
				 return true;
			 }
		 }
		 return false;
	 }

	public boolean proposerAchat(String nom, int prix) {
		if(prix <= argent) {
			System.out.println("Voulez-vous achetez \"" + nom + "\" pour " + prix + "€ ? (O/N)");
			
			Scanner scan = new Scanner(System.in);
		    String res = scan.next();
		    
		    System.out.println(res);
		    if(res.contains("O")) {
		    	argent -= prix;
		    	System.out.println("Vous venez d'acheter la propriété ! Votre solde actuel : " + prix);
		    	return true;
		    } else {
		    	System.out.println("Vous n'avez pas acheté la propriété ... Noob");
		    }
		} else {
			System.out.println("Vous n'avez pas assez d'argent pour acheter la propriété, repassez plus tard");
		}
		return false;
	}
}
