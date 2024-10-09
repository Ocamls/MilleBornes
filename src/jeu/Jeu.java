package jeu;

import utils.GestionCartes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;

// Classe Jeu qui contient un attribut de type Sabot
public class Jeu {

    private Sabot sabot;

    // Constructeur
    public Jeu() {
    	JeuDeCartes jeuDeCartes = new JeuDeCartes();
        Carte[] tableauDeCartes = jeuDeCartes.donnerCartes();

        // Transformation en liste
        List<Carte> listeCartes = Arrays.asList(tableauDeCartes);

        // Mélange des cartes à l'aide de la méthode mélanger de GestionCartes
        List<Carte> cartesMelangees = GestionCartes.melanger(new ArrayList<>(listeCartes));

        // Transformation de la liste mélangée en tableau
        Carte[] tableauMelange = cartesMelangees.toArray(new Carte[0]);

        // Création du Sabot avec le tableau de cartes mélangé
        this.sabot = new Sabot();
        sabot.setCartes(tableauMelange);
    }

    // Méthode pour récupérer le Sabot
    public Sabot getSabot() {
        return sabot;
    }
}
