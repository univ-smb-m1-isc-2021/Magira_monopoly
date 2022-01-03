package main.java;
import java.util.ArrayList;
import java.util.Iterator;

public class Plateau {
	private ArrayList<Case> listeCase;
	
	public Plateau() {
		listeCase = new ArrayList<Case>();
		genererPlateau();
	}
	
	private void genererPlateau(){
		listeCase.add(new CaseFixe("Départ", 0));
		
		//Quartier marron
		Case c1 = new Rue("Boulevard de belleville", 60, 50, 5); listeCase.add(c1);
		Case c2 = new CaseFixe("Caisse de la communauté", 0); listeCase.add(c2);
		Case c3 = new Rue("Rue lecourbe", 60, 50, 6); listeCase.add(c3);
		Case c4 = new CaseFixe("Impôts du le revenu", 200); listeCase.add(c4);
		Quartier marron = new Quartier(c1, c3);
		
		Case g1 = new Gare("Gare montparnasse", 200); listeCase.add(g1);
		
		//Quartier bleu ciel
		Case c5 = new Rue("Rue vaugirard", 100, 50, 7); listeCase.add(c5);
		Case c6 = new CaseFixe("Carte chance", 0); listeCase.add(c6);
		Case c7 = new Rue("Rue de courcelles", 100, 50, 8); listeCase.add(c7);
		Case c8 = new Rue("Avenue de la république", 120, 50, 9); listeCase.add(c8);
		Quartier bleu_ciel = new Quartier(c5, c7, c8);
		
		listeCase.add(new CaseFixe("Prison", 0));
		
		//Quartier rose
		Case c9 = new Rue("Boulevard de la vilette", 140, 100, 10); listeCase.add(c9);
		Case c10 = new Service("Compagnie d'éléctricité", 150); listeCase.add(c10);
		Case c11 = new Rue("Avenue de neuilly", 140, 100, 11); listeCase.add(c11);
		Case c12 = new Rue("Rue de paradis", 160, 100, 12); listeCase.add(c12);
		Quartier rose = new Quartier(c9, c11, c12);

		Case g2 = new Gare("Gare de lyon", 200); listeCase.add(g2);
	
		//Quartier orange
		Case c13 = new Rue("Avenue mozart", 180, 100, 13); listeCase.add(c13);
		Case c14 = new CaseFixe("Caisse de la communauté", 0); listeCase.add(c14);
		Case c15 = new Rue("Boulevard saint-michel", 180, 100, 14); listeCase.add(c15);
		Case c16 = new Rue("Place pigalle", 200, 100, 15); listeCase.add(c16);
		Quartier orange = new Quartier(c13, c15, c16);
		
		listeCase.add(new CaseFixe("Parc gratuit", 0));
		
		//Quartier rouge
		Case c17 = new Rue("Avenue matignon", 220, 150, 16); listeCase.add(c17);
		Case c18 = new CaseFixe("Carte chance", 0); listeCase.add(c18);
		Case c19 = new Rue("Boulevard malesherbes", 220, 150, 17); listeCase.add(c19);
		Case c20 = new Rue("Avenue henri-martin", 240, 150, 18); listeCase.add(c20);
		Quartier rouge = new Quartier(c17, c19, c20);
				
		Case g3 = new Gare("Gare du nord", 200); listeCase.add(g3);
		
		//Quartier jaune
		Case c21 = new Rue("Faubourg saint honoré", 260, 150, 19); listeCase.add(c21);
		Case c22 = new Rue("Place de la bourse", 260, 150, 20); listeCase.add(c21);
		Case c23 = new Service("Compagnie des eaux", 150); listeCase.add(c23);
		Case c24 = new Rue("Rue la fayette", 280, 150, 21); listeCase.add(c24);
		Quartier jaune = new Quartier(c21, c22, c24);
		
		listeCase.add(new CaseFixe("Allez en prison", 0));
		
		//Quartier vert
		Case c25 = new Rue("Avenue de breteuil", 300, 200, 22); listeCase.add(c25);
		Case c26 = new Rue("Avenue foch", 300, 200, 23); listeCase.add(c26);
		Case c27 = new CaseFixe("Caisse de la communauté", 0); listeCase.add(c27);
		Case c28 = new Rue("Boulevard des capucines", 320, 200, 24); listeCase.add(c28);
		Quartier vert = new Quartier(c21, c22, c24);
		
		Case g4 = new Gare("Gare saint lazare", 200); listeCase.add(g4);
		
		Quartier gares = new Quartier(g1,g2,g3,g4);
		Quartier services = new Quartier(c10, c23);
		
		//Quartier bleu
		Case c29 = new CaseFixe("Carte chance", 0); listeCase.add(c29);
		Case c30 = new Rue("Avenue des champs élysées", 350, 200, 25); listeCase.add(c30);
		Case c31 = new CaseFixe("Taxe de luxe", 100); listeCase.add(c31);
		Case c32 = new Rue("Rue de la paix", 400, 200, 26); listeCase.add(c32);
		Quartier bleu = new Quartier(c30, c32);
		
		for (int i = 0; i < listeCase.size() - 1 ; i++) {
			listeCase.get(i).setSuivante(listeCase.get(i+1));
		}
		listeCase.get(listeCase.size()-1).setSuivante(listeCase.get(0));

	}
	
	public Case getDepart() {
		return listeCase.get(0);
	}
	
	@Override
	public String toString() {
		String res = "";
		for (int i = 0; i < listeCase.size(); i++) {
			res += listeCase.get(i).toString() + '\n';
		}
		return res;
	}
}
