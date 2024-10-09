package cartes;

public enum Type {
	FEU("Feu rouge","feu vert","VÉHICULE PRIORITAIRE"),
	ESSENCE("panne d'essence","essence","CITERNE"), 
	CREVAISON("crevaison","roue de secours","INCREVABLE"), 
	ACCIDENT("accident","reparation","AS DU VOLANT");
	
	private final String attaque; 
	private final String parade;
	private final String botte; 
	
	private Type(String attaque, String parade, String botte) {
		this.attaque = attaque;
		this.parade = parade; 
		this.botte = botte; 
	}
	
	public String getAttaque() {
		return attaque;
	}
	public String getParade() {
		return parade;
	}
	public String getBotte() {
		return botte;
	}
	
	
	
}
