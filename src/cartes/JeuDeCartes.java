package cartes;

public class JeuDeCartes {
	private Configuration[] typeDeCartes = { new Configuration(10, new Borne(25)), new Configuration(10, new Borne(50)),
			new Configuration(10, new Borne(75)), new Configuration(12, new Borne(100)),
			new Configuration(4, new Borne(200)), new Configuration(14, new Parade(Type.FEU)),
			new Configuration(6, new Parade(Type.ACCIDENT)), new Configuration(6, new Parade(Type.CREVAISON)),
			new Configuration(6, new Parade(Type.ESSENCE)), new Configuration(5, new Attaque(Type.FEU)),
			new Configuration(3, new Attaque(Type.ACCIDENT)), new Configuration(3, new Attaque(Type.CREVAISON)),
			new Configuration(3, new Attaque(Type.ESSENCE)), new Configuration(1, new Botte(Type.FEU)),
			new Configuration(1, new Botte(Type.ACCIDENT)), new Configuration(1, new Botte(Type.CREVAISON)),
			new Configuration(1, new Botte(Type.ESSENCE)), new Configuration(6, new FinLimite()),
			new Configuration(4, new DebutLimite()) };

	public String affichageJeuDeCartes() {
		StringBuilder builder = new StringBuilder();
		builder.append("JEU : \n");
		for (Configuration config : typeDeCartes) {
			builder.append(config.getNbExemplaires() + " " + config.getCarte() + "\n");

		}
		return builder.toString();
	}

	public Carte[] donnerCartes() {
		Carte[] cartes = new Carte[106];
		int nbCartes = 0;
		for (Configuration config : typeDeCartes) {
			int n = config.getNbExemplaires();
			for (int i = 0; i < n; i++) {
				cartes[nbCartes] = config.getCarte();
				nbCartes++;
			}
		}
		return cartes;	
	}
	
//	public boolean checkCount() {
//		
//	}
	
	

	
	public void afficherCartes(Carte[] cartes) { // Cette fonction n'était pas demandé mais utile
		for (Carte carte : cartes) {
			if (carte != null) {
				System.out.println(carte);
			}
		}
	}

	private static class Configuration extends Carte {
		private int nbExemplaires;
		private Carte carte;

		private Configuration(int nbExemplaires, Carte carte) {
			this.nbExemplaires = nbExemplaires;
			this.carte = carte;
		}

		public Carte getCarte() {
			return carte;

		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}

	}

	public static void main(String[] args) {
		JeuDeCartes jdc = new JeuDeCartes();
		Carte[] cartes = jdc.donnerCartes();
		jdc.afficherCartes(cartes);
	}

}
