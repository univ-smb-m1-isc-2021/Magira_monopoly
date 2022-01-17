package main.java;

public class EtatAchete implements Etat{
	
	private Rue ctx;

	public EtatAchete(Rue ctx) {
		this.ctx = ctx;
	}

	@Override
	public void joueurArrive(Joueur j) {
		if(!ctx.estProprietaire(j) && j.paye(ctx.loyer)) {
			ctx.getProprietaire().recois(ctx.loyer);
		}else if(!j.paye(ctx.loyer)) {
			//Le joueur dois hypothequer sa maison				
			ctx.getProprietaire().recois(ctx.loyer);
		}
	}

	@Override
	public void verifierMonopoleQuartier(Joueur j) {
		if(ctx.getQuartier().verifierMonopole(j)) {
			ctx.passerQuartierConstructible();
		}		
	}
	
	@Override
	public String toString() {
		return "La case appartient à " + ctx.getProprietaire().toString() + " mais n'est pas constructible :/";
	}
}
