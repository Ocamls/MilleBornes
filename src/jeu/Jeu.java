package jeu;

import utils.GestionCartes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;

public class Jeu {

    private Sabot sabot;

    public Jeu() {
    	JeuDeCartes jeuDeCartes = new JeuDeCartes();
        Carte[] tableauDeCartes = jeuDeCartes.donnerCartes();

        List<Carte> listeCartes = Arrays.asList(tableauDeCartes);

        List<Carte> cartesMelangees = GestionCartes.melanger(new ArrayList<>(listeCartes));

        Carte[] tableauMelange = cartesMelangees.toArray(new Carte[0]);

        this.sabot = new Sabot();
        sabot.setCartes(tableauMelange);
        // Faut-il modifier la classse Sabot() pour Sabot(Carte[] cartes)
    }

    public Sabot getSabot() {
        return sabot;
    }
}
