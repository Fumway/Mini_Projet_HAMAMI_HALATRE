/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hamami_halatre_lightoff;

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
