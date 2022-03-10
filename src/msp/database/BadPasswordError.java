/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msp.database;

/**
 * permet de lever une exception quand le mot de passe est mauvais
 * @author Océane
 */
public class BadPasswordError extends DaoError{
    
    /**
     * constructeur de la classe BadPasswordError
     * @param message le message à envoyer quand l'exception est levée
     */
    public BadPasswordError(String message) {
        super("Bad Password", message);
    }
    
}
