/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msp.metier;

import java.util.ArrayList;

/**
 *Fonction permettant la gestion des techniciens 
 * @author Anthony
 * @version 1.0
 */
public class Tech extends User{
    
    private ArrayList<Skill> skillTable = new ArrayList<>();
    
    /**
     * Constructeur d'un technicien
     * @param ID correspond à l'ID du technicien
     */
    
    public Tech(int ID){
        super(ID);
    }
    
    /**
     * Fonction permettant de récupérer le tableau des skills du technicien
     * @return ArrayList correspondant au tableau des skills
     */
    
    public ArrayList<Skill> GetSkills(){
        
        return skillTable; 
    }
    
    /**
     * Fonction permettant d'ajouter un skill
     * @param s correspondant au skill à ajouter
     */
    
    public void addSkill(Skill s){
        skillTable.add(s);
    } 
     
    
}
