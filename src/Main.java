import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
		
		System.out.println("Voulez vous commencer une nouvelle partie ? (O/N)");
		Scanner scan = new Scanner(System.in);
	    String res = scan.next();
	    if(res.contains("O")) {
	    	System.out.println("A combien de joueurs voulez vous jouer ? (1,2,3 ... )");
	    	int nbJoueur = scan.nextInt();
	    	scan.nextLine();
	    	for (int i = 1; i <= nbJoueur; i++) {
				System.out.println("Quel est le nom du joueur " + i + " ?");
				res = scan.nextLine();
				joueurs.add(new Joueur(res));
			}
	    	System.out.println("Tout est prêt, le jeu peut commencer !");
	    	lancerJeu(joueurs);
	    } else {
	    	System.out.println("D'accord, à bientôt ..");
	    }
	}
		


	
	private static void lancerJeu(ArrayList<Joueur> joueurs) {
		Monopoly monop = new Monopoly(joueurs);
		System.out.println(monop.toString());

		monop.jouer();
		System.out.println(monop.toString());
		
		/*
		monop.joueurSuivant();
		monop.jouer();
		System.out.println(monop.toString());
		*/

		System.out.println(monop.toString());

	}

}
