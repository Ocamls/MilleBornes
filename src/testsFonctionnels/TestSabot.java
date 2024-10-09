package testsFonctionnels;

import java.util.Iterator;

import cartes.Botte;
import cartes.Carte;
import cartes.Parade;
import cartes.Type;
import jeu.Sabot;

public class TestSabot {
	
	public static void main(String[] args) {
		
				// INIT // 
		Sabot sabot = new Sabot(); 
		Carte c1 = new Parade(Type.FEU);
		Carte c2 = new Parade(Type.ESSENCE);
		Carte c3 = new Parade(Type.ACCIDENT);
		Carte c4 = new Parade(Type.CREVAISON);
		sabot.ajouterCarte(c1);
		sabot.ajouterCarte(c2);
		sabot.ajouterCarte(c3);
		sabot.ajouterCarte(c4);
		Carte As = new Botte(Type.ACCIDENT); 
		/*Ici, il y a 4 cartes dans le sabot*/
		
				// PIOCHE //
		for (int i =0; i<4; i++) { // comment faire pour ne pas mettre 
			System.out.println("je pioche " +sabot.piocher());
		}
		
				// ITER + REMOVE //
//		Iterator<Carte> iter=  sabot.iterator();
//		for(int i =0; i<4; i++) {
//			System.out.println("je pioche " + iter.next());
//			iter.remove();
//		}
		
		/*
		Iterator<Carte> iter = sabot.iterator();
//		sabot.piocher(); 
		for(int i =0; i<4; i++) {
			if (i==1) {
				sabot.ajouterCarte(As);
			}
			System.out.println("je pioche " + iter.next());
			iter.remove();
		}*/
		/*Ici quand je mets piocher au milieu de la boucle il y a bien la concurrence qui lève une exception 
		 * Par contre quand je mets piocher avant la boucle et avant la création de iter alors il n'y a pas 
		 * la bonne exception (NoSuchElementException) à la place de (ConcurrentModificationException)
		 * Mais quand je le mets après la création de iter c'est bon 
		 * Dans le cas ou j'ajoute l'as du volant au milieu de la boucle, il y a bien l'exception.*/
	}
	
	
	// voir comment remplacer le for envoyer un mail à la prof 

}
