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
			new Configuration(6, new DebutLimite()) };

	public String affichageJeuDeCartes() {
		StringBuilder builder = new StringBuilder();
		builder.append("JEU : \n");
		for (Configuration config : typeDeCartes) {
			builder.append(config.getNbExemplaires() + " " + config.getCarte() + "\n");

		}
		return builder.toString();
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

}
