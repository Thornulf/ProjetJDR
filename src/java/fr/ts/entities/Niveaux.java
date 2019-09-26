/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ts.entities;

/**
 *
 * @author Thomas
 */
public class Niveaux {
    
    private int niveau;
    private int nivSup;

    public Niveaux(int niveau, int nivSup) {
        this.niveau = niveau;
        this.nivSup = nivSup;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getNivSup() {
        return nivSup;
    }

    public void setNivSup(int nivSup) {
        this.nivSup = nivSup;
    }    
    
}
