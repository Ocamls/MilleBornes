package jeu;

import java.util.ArrayList;
import cartes.Cartes;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cartes.*;

public class ZoneDeJeu {
	private List<Limite> limites;
	private List<Bataille> batailles;
	private Set<Borne> bornes;
	private Set<Botte> bottes;
	

	public ZoneDeJeu() {
		limites = new ArrayList<Limite>();
		batailles = new ArrayList<Bataille>();
		bornes = new HashSet<Borne>();
		bottes = new HashSet<Botte>(); 
	}

	public List<Limite> getLimites() {
		return limites;
	}

	public List<Bataille> getBatailles() {
		return batailles;
	}

	public Set<Borne> getBornes() {
		return bornes;
	}

	public int donnerLimitationVitesse() { // test main ok
		if (limites.size() != 0) {
			if (limites.get(limites.size() - 1).equals(Cartes.DEBUT_LIMITE)) {
				return 50;
			}
		}
		return 200;
	}

	public int donnerKmParcourus() { //test main ok
		int total = 0;
		for (Borne borne : bornes) {
			total = total + borne.getKm();
		}
		return total;
	}

	public void deposer(Carte carte) {
		if (carte instanceof Borne) {
			bornes.add((Borne) carte);
		} else if (carte instanceof Limite) {
			limites.add((Limite) carte);
		} else if (carte instanceof Bataille) {
			batailles.add((Bataille) carte);
		}
	}
	public boolean peutAvancer() { // test main ok
		if (batailles.size() > 0 && batailles.get(batailles.size() - 1).equals(Cartes.FEU_VERT)) {
			return true;
		}
		return false;
	}

	private boolean estDepotFeuVertAutorise() { // test main ok
		if(batailles.size()==0) {
			return true;
		}
		Bataille bataille = batailles.get(batailles.size() - 1); 
		if (bataille.equals(new Attaque(Type.FEU)) || (bataille instanceof Parade && (!(bataille).equals(new Parade(Type.FEU))))) {
			return true;

		}
		return false;
	}

	private boolean estDepotBorneAutorise(Borne borne) {
		if (!peutAvancer() || borne.getKm() > donnerLimitationVitesse() || donnerKmParcourus() + borne.getKm() > 1000) {
			return false;
		}
		return true;
	}

	public boolean estDepotLimiteAutorise(Limite limite) {
		if (limite instanceof DebutLimite) {
			return (limites.size() == 0 || limites.get(limites.size() - 1).equals(Cartes.FIN_LIMITE));

		} else if (limite instanceof FinLimite) {
			return (limites.get(limites.size()-1).equals(Cartes.DEBUT_LIMITE)); 
		}
		return false; 
	}
	
	private boolean estDepotBatailleAutorise(Bataille bataille) { // ne fonctionne pas pour le moment je dois tester les autres méthodes.
		if(bataille instanceof Attaque) {
			return peutAvancer(); 
		}else {
			if(bataille.equals(Cartes.FEU_VERT)) {
				return estDepotFeuVertAutorise(); 
			}
			if(batailles.size()>0) {
				Type type = bataille.getType(); 
				return (batailles.get(batailles.size()-1).equals(new Attaque(type)));
				
			}
		}
		return false;
	}
	
	public boolean estDepotAutorise(Carte carte) {
			if(carte instanceof Borne) {
				return estDepotBorneAutorise((Borne)carte); 
			}else if (carte instanceof Bataille) {
				return estDepotBatailleAutorise((Bataille)carte);
			}else if (carte instanceof Limite) {
				return estDepotLimiteAutorise((Limite)carte);
			}
		
		return false; 
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		ZoneDeJeu zdj = new ZoneDeJeu(); 
		zdj.batailles.add(Cartes.FEU_VERT);
		System.out.println(zdj.peutAvancer()); 
		
		zdj.limites.add(Cartes.DEBUT_LIMITE); 
		System.out.println(zdj.donnerLimitationVitesse());
	}

}
