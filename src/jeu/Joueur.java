package jeu;

import cartes.Carte;

public class Joueur {
	private String nom; 
	private ZoneDeJeu zoneDeJeu;
	private MainJoueur mainJoueur;
	
	public Joueur(String nom, ZoneDeJeu zoneDeJeu) {
		this.nom = nom;
		this.zoneDeJeu = zoneDeJeu;
		this.mainJoueur = new MainJoueur(); 
		
	} 
	
	public String getNom() {
		return nom;
	}
	
	public ZoneDeJeu getZoneDeJeu() {
		return zoneDeJeu;
	}
	
	public MainJoueur getMainJoueur() {
		return mainJoueur;
	}
	
	public void donner (Carte carte) {
		mainJoueur.prendre(carte); 
	}
	
	public Carte prendreCarte(Sabot sabot) {
		Carte carte = sabot.piocher(); 
		if (carte != null) {
			return carte; 
		}
		return null; 
	}
	
	public int donnerKmParcourus() {
		return zoneDeJeu.donnerKmParcourus();
	}
	

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Joueur) {
			Joueur joueur = (Joueur)obj; 
			return nom.equals(joueur.getNom()); 
		}
		return false; 
	}	
	
	
	public void afficherMain() {
		System.out.println(mainJoueur); 
	}
	
	public boolean estDepotAutorise(Carte carte) {
		return zoneDeJeu.estDepotAutorise(carte);
	}
	
	
	@Override
	public String toString() {
		return nom;
	}
}
