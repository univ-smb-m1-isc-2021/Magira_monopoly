
public class EtatConstructible implements Etat{

	private Rue ctx;

	public EtatConstructible(Rue ctx) {
		this.ctx = ctx;
	}

	@Override
	public void joueurArrive(Joueur j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verifierMonopoleQuartier(Joueur j) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return "La case appartient à " + ctx.getProprietaire().toString() + " et est constructible !";
	}

}
