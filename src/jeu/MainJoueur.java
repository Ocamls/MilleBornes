package jeu;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import cartes.Carte;

public class MainJoueur {
	List<Carte> cartesEnMain; 
	
	
	public MainJoueur() {
		cartesEnMain = new ArrayList<Carte>(); 
	}
	
	public void prendre(Carte carte) {
		cartesEnMain.add(carte);
	}
	
	public void jouer (Carte carte) {
		if(cartesEnMain.contains(carte)) {
			cartesEnMain.remove(carte); 
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(); 
		ListIterator<Carte> it =cartesEnMain.listIterator();
		for(int i=0; i<cartesEnMain.size(); i++) {
			Carte carte = it.next(); 
			builder.append(carte + " "); 
		}
		return builder.toString(); 
	}

}
