/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hamami_halatre_lightoff;

/**
 *
 * @author enniohalatre
 */
public class CelluleLumineuse {
    private boolean etat; // la cellule est alumée ou éteinte 

    public CelluleLumineuse(boolean etat) { //constructeur qui initialise la celulle dans l'état false
        this.etat = false;
    }
    public void alumer_la_cellule() { //la cellule s'allume 
        this.etat = !this.etat;
    }
    public void eteindre_cellule(){ //cellule eteinte 
        this.etat = false;
    }
    public boolean est_eteint(){
        return !etat;
    }

    @Override
    public String toString() {
        return etat ? "X" : "O"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
        
        

    
}

