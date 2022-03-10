/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msp.database;

/**
 * permet de gérer le cas où il y a une exception dans la base de donnée
 * @author Océane
 */
public class DatabaseError extends DaoError {
    
    /**
     * constructeur de la classe DatabaseError
     * @param message le message à envoyer quand l'exception est levée
     */
    public DatabaseError(String message) {
        super("SQL error", message);
    }
    
}
