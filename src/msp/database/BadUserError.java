/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msp.database;

/**
 * permet de lever une exception quand l'utilisateur n'existe pas
 * @author Océane
 */
public class BadUserError extends DaoError{
    
    /**
     * constructeur de la classe BadUserError
     * @param message le message à envoyer quand l'exception est levée
     */
    public BadUserError(String message) {
        super("Wrong user", message);
    }
    
}
