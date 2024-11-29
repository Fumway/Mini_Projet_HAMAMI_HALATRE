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
    private int nbLignes; // Nombre de lignes de la grille
    private int nbColonnes; // Nombre de colonnes de la grille
    private CelluleLumineuse[][] matriceCellules; // La grille contenant les cellules lumineuses
 
public GrilleDeCellules(int p_nbLignes, int p_nbColonnes) {
    this.nbLignes = p_nbLignes;
    this.nbColonnes = p_nbColonnes;
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

    for (int i = 0; i < nbLignes; i++) {
        for (int j = 0; j < nbColonnes; j++) {
            builder.append(matriceCellules[i][j].toString());

        }
        builder.append("\n"); // Saut de ligne après chaque ligne de la grille
    }

    return builder.toString();
}

 // Méthode pour activer une ligne ou une colonne ou une diagonale aléatoire
public void activerLigneColonneOuDiagonaleAleatoire() {
        Random rand = new Random();

        // Générer un nombre aléatoire pour choisir entre ligne, colonne ou diagonale
        int choix = rand.nextInt(5); // Choix entre 0-4 (5 possibilités)
        
        if (choix < 2) {
            // Activer une ligne (0 ou 1)
            int idLigne = rand.nextInt(nbLignes); // Choisir une ligne aléatoire
            activerLigneDeCellules(idLigne);
            //System.out.println("Ligne " + idLigne + " activée.");
        } else if (choix < 4) {
            // Activer une colonne (2 ou 3)
            int idColonne = rand.nextInt(nbColonnes); // Choisir une colonne aléatoire
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
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j].eteindre_cellule(); // Éteindre chaque cellule
            }
        }
// 2. Effectuer les tours
        for (int tour = 0; tour < nbTours; tour++) {
            int choix = rand.nextInt(5); // Choix entre 0-4 (ligne, colonne ou diagonale)

            if (choix < 2) {
                // Activer une ligne (0 ou 1)
                int idLigne = rand.nextInt(nbLignes); // Choisir une ligne aléatoire
                activerLigneDeCellules(idLigne);
                System.out.println("Tour " + (tour + 1) + ": Ligne " + idLigne + " activée.");
            } else if (choix < 4) {
                // Activer une colonne (2 ou 3)
                int idColonne = rand.nextInt(nbColonnes); // Choisir une colonne aléatoire
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
    if (idLigne >= 0 && idLigne < nbLignes) {
        for (int j = 0; j < nbColonnes; j++) {
            matriceCellules[idLigne][j].alumer_la_cellule(); // Active la cellule
        }
    } else {
        System.out.println("L'indice de la ligne est invalide.");
    }
}

public void activerColonneDeCellules(int idColonne) {
    // Vérifier si l'indice de colonne est valide
    if (idColonne >= 0 && idColonne < nbColonnes) {
        for (int i = 0; i < nbLignes; i++) {
            matriceCellules[i][idColonne].alumer_la_cellule(); // Active la cellule
        }
    } else {
        System.out.println("L'indice de la colonne est invalide.");
    }
}

public void activerDiagonaleDescendante() {
    for (int i = 0; i < Math.min(nbLignes, nbColonnes); i++) {
        matriceCellules[i][i].alumer_la_cellule(); // Active la cellule sur la diagonale descendante
    }
}

public void activerDiagonaleMontante() {
    for (int i = 0; i < Math.min(nbLignes, nbColonnes); i++) {
        matriceCellules[i][nbColonnes - 1 - i].alumer_la_cellule(); // Active la cellule sur la diagonale montante
    }
}



}
