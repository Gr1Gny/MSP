/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msp.database;

/**
 * permet de gérer les exceptions dans la base de donnée
 * @author Océane
 */
public class DaoError extends Exception {
    private String message;
    private String nom;
    
    /**
     * Constructeur
     * @param nom nom de l'exception
     * @param message message à afficher
     */
    public DaoError(String nom,String message) {
        this.message = message;
        this.nom = nom;
    }
    
    /**
     * Renvoie le nom de l'exception
     * @return le nom de l'exception
     */
    public String getNom() {
        return this.nom;
    }
    
    /**
     * permte de récupérer le message de l'exception
     * @return le message de l'exception
     */
    @Override
    public String getMessage() {
        return this.message;
    }
}
