
package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Set;

public class GestionCartes {

	public static <Carte> Carte extraire(List<Carte> liste) {
		if (liste.isEmpty()) {
			throw new IllegalArgumentException("La liste ne doit pas être vide");
		}
		Random random = new Random();
		int index = random.nextInt(liste.size());
		return liste.remove(index);
	}

	public static <Carte> Carte extraireAvecIterateur(List<Carte> liste) {
		if (liste.isEmpty()) {
			throw new IllegalArgumentException("La liste ne doit pas être vide");
		}
		Random random = new Random();
		int index = random.nextInt(liste.size());
		ListIterator<Carte> it = liste.listIterator();
		Carte element = null;
		for (int i = 0; i <= index; i++) {
			element = it.next();
		}
		it.remove();
		return element;
	}

	public static <Carte> List<Carte> melanger(List<Carte> liste) {
		List<Carte> listeMelangee = new ArrayList<>();
		while (!liste.isEmpty()) {
			listeMelangee.add(extraire(liste)); // Extraire tous les éléments un par un
		}
		return listeMelangee;
	}

	public static <Carte> boolean verifierMelange(List<Carte> liste1, List<Carte> liste2) {
		if (liste1.size() != liste2.size()) {
			return false;
		}
		for (Carte element : liste1) {
			if (Collections.frequency(liste1, element) != Collections.frequency(liste2, element)) {
				return false;
			}
		}
		return true;
	}

	public static <Carte> List<Carte> rassembler(List<Carte> liste) {
		List<Carte> listeRassemblee = new ArrayList<>();

		Set<Carte> dejaTraites = new HashSet<>();

		for (Carte carte : liste) {
			if (!dejaTraites.contains(carte)) {

				for (Carte c : liste) { // ce for permet d'ajouter les autres occurences
					if (c.equals(carte)) {
						listeRassemblee.add(c);
					}
				}
				dejaTraites.add(carte);
			}
		}
		return listeRassemblee;
	}

	public static <Carte> boolean verifierRassemblement(List<Carte> liste) {
		if (liste.isEmpty()) {
			return true; // Si la liste est vide, elle est considérée comme bien "rassemblée"
		}
		ListIterator<Carte> it1 = liste.listIterator();
		Carte elementCourant = it1.next();

		while (it1.hasNext()) {
			Carte elementSuivant = it1.next();
			if (!elementCourant.equals(elementSuivant)) {
				ListIterator<Carte> it2 = liste.listIterator(it1.nextIndex());
				while (it2.hasNext()) {
					if (it2.next().equals(elementCourant)) {
						return false; 
					}
				}
				elementCourant = elementSuivant; 
			}
		}
		return true;
	}

}
