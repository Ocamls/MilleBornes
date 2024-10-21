package cartes;

public interface Cartes {
	Botte PRIORITAIRE = new Botte(Type.FEU); 
	Attaque FEU_ROUGE = new Attaque(Type.FEU); 
	Parade FEU_VERT = new Parade(Type.FEU); 
	
	Botte AS_DU_VOLANT = new Botte(Type.ACCIDENT); 
	Attaque ACCIDENT = new Attaque(Type.ACCIDENT); 
	Parade REPARATION = new Parade(Type.ACCIDENT); 
	
	Botte INCREVABLE = new Botte(Type.CREVAISON); 
	Attaque CREVAISON = new Attaque(Type.CREVAISON); 
	Parade ROUE_DE_SECOURS = new Parade(Type.CREVAISON); 
	
	Botte CITERNE = new Botte(Type.ESSENCE); 
	Attaque PANNE_D_ESSENCE = new Attaque(Type.ESSENCE); 
	Parade ESSENCE = new Parade(Type.ESSENCE); 

	FinLimite FIN_LIMITE =  new FinLimite(); 
	DebutLimite DEBUT_LIMITE = new DebutLimite();
	
	Borne BORNE_25 = new Borne(25); 
	Borne BORNE_50 = new Borne(50); 
	Borne BORNE_75 = new Borne(75); 
	Borne BORNE_100 = new Borne(100); 
	Borne BORNE_200 = new Borne(200); 

	
	
}
