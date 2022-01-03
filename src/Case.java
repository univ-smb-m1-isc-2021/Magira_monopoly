import java.util.ArrayList;

public class Case {
	private Case caseSuivante;
	protected ArrayList<Joueur> joueurs;
	protected String nom; 
	
	public Case(String nom) {
		this.caseSuivante = null;
		this.joueurs = new ArrayList<Joueur>();
		this.nom = nom;
	}
	
	public void setSuivante(Case suivante) {
		this.caseSuivante = suivante;
	}
	
	public Case getSuivante() {
		return caseSuivante;
	}
	
	@Override
	public String toString() {
		String space = "";
		for (int i = 0; i < (30 - nom.length()); i++) {
			space += " ";
		}
		String res = nom + space + "<-----------     ";
		for (int i = 0; i < joueurs.size(); i++) {
			res += joueurs.get(i).toString() + "  ";
		}
		return res;
	}

	public Case avance(int resultatDes) {
		Case atterissage = caseSuivante;
		for (int i = 0; i < resultatDes; i++) {
			atterissage = atterissage.getSuivante();
		}
		
		return atterissage;
	}

	public void joueurArrive(Joueur joueur) {
		joueurs.add(joueur);
		System.out.println("Le joueur arrive sur la case : \""+ nom +"\"");	
	}
	
	
	public void joueurPart(Joueur joueur) {
		joueurs.remove(joueur);
	}
	
}
