package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;
import cartes.Parade;
import cartes.Type;

public class Sabot implements Iterable<Carte> {
	private Carte[] cartes;
	private int nbCartes = 0; // 106
	private int capacite = 106;

	private int nombreOperations = 0;

	public Sabot() {
		cartes = new Carte[capacite];
	}
	
	public void setCartes(Carte[] cartes) {
		this.cartes = cartes;
	}

	public boolean estVide() {
		return nbCartes == 0;
	}
	
	public Carte[] getCartes() {
		return cartes;
	}

	
	
	public void ajouterCarte(Carte carte) {
		if (nbCartes < capacite) {
			cartes[nbCartes] = carte;
			nbCartes++;
			nombreOperations++;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	public void afficherCartes() { // Cette fonction n'était pas demandé mais utile pour les tests 
		for (Carte carte : cartes) {
			if (carte != null) {
				System.out.println(carte);
			}
		}
	}

	public Carte piocher() {
		Iterator<Carte> iter = iterator();
		Carte cartePioche = iter.next();
		iter.remove();
		nombreOperations++;
		return cartePioche;
	}

	public Iterator<Carte> iterator() {
		return new Iterateur();
	}

	private class Iterateur implements Iterator<Carte> {
		private int indiceIterateur = 0;
		private boolean nextEffectue = false;

		private int nombreOperationsReference = nombreOperations;

		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}

		public Carte next() {
			verificationConcurrence();
			if (hasNext()) {
				Carte carte = cartes[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return carte;
			} else {
				throw new NoSuchElementException();
			}
		}

		public void remove() {
			verificationConcurrence();
			if (nbCartes < 1 && !nextEffectue) {
				throw new IllegalStateException();
			}
			for (int i = indiceIterateur - 1; i < nbCartes; i++) {
				cartes[i] = cartes[i + 1];
			}
			nextEffectue = false;
			indiceIterateur--;
			nbCartes--;
			nombreOperations++;
			nombreOperationsReference++;
		}

		private void verificationConcurrence() {
			if (nombreOperations != nombreOperationsReference) {
				throw new ConcurrentModificationException();
			}
		}

	}

	

}
