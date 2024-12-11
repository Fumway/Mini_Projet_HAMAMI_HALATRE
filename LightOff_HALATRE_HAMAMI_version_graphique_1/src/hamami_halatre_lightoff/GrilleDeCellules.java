/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hamami_halatre_lightoff;
import java.util.Random;

/**
 *
 * @author enniohalatre
 */
public class GrilleDeCellules {
    private int p_nbLignes; // Nombre de lignes de la grille
    private int p_nbColonnes; // Nombre de colonnes de la grille
    private CelluleLumineuse[][] matriceCellules; // La grille contenant les cellules lumineuses
 
public GrilleDeCellules(int p_nbLignes, int p_nbColonnes) {
    this.p_nbLignes = p_nbLignes;
    this.p_nbColonnes = p_nbColonnes;
    this.matriceCellules = new CelluleLumineuse[p_nbLignes][p_nbColonnes];

    // Création de chaque CelluleLumineuse dans la grille
    for (int i = 0; i < p_nbLignes; i++) {
        for (int j = 0; j < p_nbColonnes; j++) {
            this.matriceCellules[i][j] = new CelluleLumineuse(false); // Par défaut, cellule éteinte
        }
    }
}
@Override
public String toString() {
    StringBuilder builder = new StringBuilder();

    // Afficher les indices de colonnes
    builder.append("   ");
    for (int j = 0; j < p_nbColonnes; j++) {
        builder.append(j).append(" "); // Ajout des indices de colonnes
    }
    builder.append("\n");

    // Afficher chaque ligne de la grille avec l'indice de ligne
    for (int i = 0; i < p_nbLignes; i++) {
        builder.append(i).append("  "); // Afficher l'indice de la ligne

        for (int j = 0; j < p_nbColonnes; j++) {
            builder.append(matriceCellules[i][j].toString()).append(" "); // Ajouter l'état de la cellule (O ou X)
        }
        builder.append("\n"); // Saut de ligne après chaque ligne
    }

    return builder.toString();
}
public boolean getCelluleEtat(int ligne, int colonne) {
        if (ligne >= 0 && ligne < p_nbLignes && colonne >= 0 && colonne < p_nbColonnes) {
            return !matriceCellules[ligne][colonne].est_eteint();
        }
        return false;
    }


 // Méthode pour activer une ligne ou une colonne ou une diagonale aléatoire
public void activerLigneColonneOuDiagonaleAleatoire() {
        Random rand = new Random();

        // Générer un nombre aléatoire pour choisir entre ligne, colonne ou diagonale
        int choix = rand.nextInt(5); // Choix entre 0-4 (5 possibilités)
        
        if (choix < 2) {
            // Activer une ligne (0 ou 1)
            int idLigne = rand.nextInt(p_nbLignes); // Choisir une ligne aléatoire
            activerLigneDeCellules(idLigne);
            //System.out.println("Ligne " + idLigne + " activée.");
        } else if (choix < 4) {
            // Activer une colonne (2 ou 3)
            int idColonne = rand.nextInt(p_nbColonnes); // Choisir une colonne aléatoire
            activerColonneDeCellules(idColonne);
            //System.out.println("Colonne " + idColonne + " activée.");
        } else {
            // Activer une diagonale aléatoire (4)
            int diagonale = rand.nextInt(2); // 0 pour diagonale descendante, 1 pour montante
            if (diagonale == 0) {
                activerDiagonaleDescendante();
               // System.out.println("Diagonale descendante activée.");
            } else {
                activerDiagonaleMontante();
               // System.out.println("Diagonale montante activée.");
            }
        }
    }

// Méthode pour mélanger la grille aléatoirement pendant un nombre spécifié de tours
public void melangerMatriceAleatoirement(int nbTours) {
        Random rand = new Random();

        // 1. Éteindre toutes les cellules avant de commencer
        for (int i = 0; i < p_nbLignes; i++) {
            for (int j = 0; j < p_nbColonnes; j++) {
                matriceCellules[i][j].eteindreCellule(); // Éteindre chaque cellule
            }
        }
// 2. Effectuer les tours
        for (int tour = 0; tour < nbTours; tour++) {
            int choix = rand.nextInt(5); // Choix entre 0-4 (ligne, colonne ou diagonale)

            if (choix < 2) {
                // Activer une ligne (0 ou 1)
                int idLigne = rand.nextInt(p_nbLignes); // Choisir une ligne aléatoire
                activerLigneDeCellules(idLigne);
                System.out.println("Tour " + (tour + 1) + ": Ligne " + idLigne + " activée.");
            } else if (choix < 4) {
                // Activer une colonne (2 ou 3)
                int idColonne = rand.nextInt(p_nbColonnes); // Choisir une colonne aléatoire
                activerColonneDeCellules(idColonne);
                System.out.println("Tour " + (tour + 1) + ": Colonne " + idColonne + " activée.");
            } else {
                // Activer une diagonale aléatoire (4)
                int diagonale = rand.nextInt(2); // 0 pour diagonale descendante, 1 pour montante
                if (diagonale == 0) {
                    activerDiagonaleDescendante();
                    System.out.println("Tour " + (tour + 1) + ": Diagonale descendante activée.");
                } else {
                    activerDiagonaleMontante();
                    System.out.println("Tour " + (tour + 1) + ": Diagonale montante activée.");
                }
            }
        }
    }


public void activerLigneDeCellules(int idLigne) {
    // Vérifier si l'indice de ligne est valide
    if (idLigne >= 0 && idLigne < p_nbLignes) {
        for (int j = 0; j < p_nbColonnes; j++) {
            matriceCellules[idLigne][j].allumerCellule(); // Active la cellule
        }
    } else {
        System.out.println("L'indice de la ligne est invalide.");
    }
}

public void activerColonneDeCellules(int idColonne) {
    // Vérifier si l'indice de colonne est valide
    if (idColonne >= 0 && idColonne < p_nbColonnes) {
        for (int i = 0; i < p_nbLignes; i++) {
            matriceCellules[i][idColonne].allumerCellule(); // Active la cellule
        }
    } else {
        System.out.println("L'indice de la colonne est invalide.");
    }
}

public void activerDiagonaleDescendante() {
    for (int i = 0; i < Math.min(p_nbLignes, p_nbColonnes); i++) {
        matriceCellules[i][i].allumerCellule(); // Active la cellule sur la diagonale descendante
    }
}

public void activerDiagonaleMontante() {
    for (int i = 0; i < Math.min(p_nbLignes, p_nbColonnes); i++) {
        matriceCellules[i][p_nbColonnes - 1 - i].allumerCellule(); // Active la cellule sur la diagonale montante
    }
}

public boolean cellulesToutesEteintes() {                       //si les cllules sont éteintes 
    for (int i = 0; i < p_nbLignes; i++) {
        for (int j = 0; j < p_nbColonnes; j++) {
            if (!matriceCellules[i][j].est_eteint()) {
                return false;                                   // Si une cellule est allumée, retournez false
            }
        }
    }
    return true;                                                // Toutes les cellules sont éteintes
    }
}

