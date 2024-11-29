/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hamami_halatre_lightoff;

/**
 *
 * @author enniohalatre
 */
public class Partie {                                                       //creation de la classe partie 
    private GrilleDeJeu grille;                                             // attribut de la calsse partie 
    private int nbcoups; 

    public Partie(int nbLignes, int nbColonnes) {                           // Constructeur de la classe partie qui initialise le nb de colones et de lignes
    this.grille = new GrilleDeJeu(nbLignes, nbColonnes);
    this.nbcoups = 0;                                                       // initialisation du nb de coups du joueur a 0 
    }
    
public void InitialiserPartie() {
    grille.eteindreToutesLesCellules();                                     // étein toutes les cellules pour démarer la partie 
    grille.melangerMatriceAleatoirement(nbToursMelange);                    // Mélange la grille
}  
      
public void LancerPartie static {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Bienvenue dans le jeu lightsoff ! ");
    System.out.println("Bienvenue dans le jeu lightsoff ! ");
    
    while (!grille.cellulesToutesEteintes()) {                                              // Tant qu'il reste des cellules allumées
        System.out.println(grille);                                                         // Affiche l'état actuel de la grille
        System.out.println("choissis une action (ligne, colonne ou diagonale) :");
        System.out.println("1 - Activer une ligne");
        System.out.println("2 - Activer une colonne");
        System.out.println("3 - Activer la diagonale gauche");
        System.out.println("4 - Activer la diagonale droite");
        
        int choix = scanner.nextInt();                                                      // Récupère l'action du joueur
        
        switch (choix) {
            case 1 -> {
                System.out.print("numéro de la ligne à switcher : ");
                int ligne = scanner.nextInt();
                grille.activerLigneDeCellules(ligne);                                       // Active la ligne choissis 
            }
            case 2 -> {
                System.out.print("numéro de la colonne à switcher : ");
                int colonne = scanner.nextInt();
                grille.activerColonneDeCellules(colonne);                                   // Active la colonne choissis 
            }
            case 3 -> grille.activerDiagonaleGauche(); // Active la diagonale descendante
            case 4 -> grille.activerDiagonaleDroite(); // Active la diagonale montante
            default -> System.out.println("Choix invalide, réessayez.");
        }
        
        nbCoups++;                                                                          // Incrémente le compteur de coups
    }
    
    System.out.println("Bravo ! Vous avez gagné en " + nbCoups + " coups.");
}
   
}
