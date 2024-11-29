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
    private int nombreLignes; // Nombre de lignes de la grille
    private int nombreColonnes; // Nombre de colonnes de la grille
    private CelluleLumineuse[][] matriceCellules; // La grille contenant les cellules lumineuses
 
public GrilleDeCellules(int lignes, int colonnes) {
    this.nombreLignes = lignes;
    this.nombreColonnes = colonnes;
    this.matriceCellules = new CelluleLumineuse[lignes][colonnes];

    // Création de chaque CelluleLumineuse dans la grille
    for (int i = 0; i < lignes; i++) {
        for (int j = 0; j < colonnes; j++) {
            this.matriceCellules[i][j] = new CelluleLumineuse(); // Par défaut, cellule éteinte
        }
    }
}
@Override
public String toString() {
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < nombreLignes; i++) {
        for (int j = 0; j < nombreColonnes; j++) {
            builder.append(matriceCellules[i][j].etat() ? "O" : ".");
        }
        builder.append("\n"); // Saut de ligne après chaque ligne de la grille
    }

    return builder.toString();
}
    
}
