/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msp.metier;

/**
 * permet de gérer l'erreur dans le cas où il y a un status non présent dans ProjectStatus
 * @author Chloé
 */
public class BadProjectStatus extends LogicError {
    
    /**
     * constructeur de la classe LogicError
     * @param message le message à envoyer quand l'exception est levée
     */
    public BadProjectStatus(String message) {
        super("Wrong Status", message);
    }
}
