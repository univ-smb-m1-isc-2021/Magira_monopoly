
public class EtatLibre implements Etat{

	private Rue ctx;

	public EtatLibre(Rue ctx) {
		this.ctx = ctx;
	}

	@Override
	public void joueurArrive(Joueur j) {
		if(j.proposerAchat(ctx.nom, ctx.prixAchat)) {
			Etat nouvelEtat = new EtatAchete(ctx);
			ctx.setProprietaire(j);
			ctx.setEtat(nouvelEtat);
			ctx.verifierMonopoleQuartier(j);
		} 
	}

	@Override
	public void verifierMonopoleQuartier(Joueur j) {
		//Throw !
	}
	
	@Override
	public String toString() {
		return "La case est actuellement libre";
	}


}
