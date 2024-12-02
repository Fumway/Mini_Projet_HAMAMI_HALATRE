/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hamami_halatre_lightoff;

/**
 *
 * @author enniohalatre
 */
public class HAMAMI_HALATRE_Lightoff {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
Partie partie = new Partie(5, 5);

        // Initialise la partie avec 10 mélanges
        partie.InitialiserPartie(10);

        // Lance la partie
        partie.LancerPartie();
    }
    
}
