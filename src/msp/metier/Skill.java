/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msp.metier;

/**
 *Classe permettant la gestion des skill
 * @author Chloé
 * @version 1.0
 */
public class Skill {
    private String Name;
    private String Level;
    
    /**
     * Constructeur d'un skills
     * @param name correspond au nom du skill
     * @param level correspond au niveau du skill
     */
    
    public Skill(String name, String level){
        this.Name = name;
        this.Level = level;
    }
    
    /**
     * Fonction permettant de récupérer le nom du skill
     * @return String correspondant au nom du skill
     */
    
    public String getName(){
        return this.Name;
    }
    /**
     * Fonction permettant de donner un nom à un skill
     * @param n correspond au nom du skill voulu
     */
    
    public void setName(String n){
        this.Name = n;
    }
    
    /**
     * Fonction permettant de récupérer le niveau d'un skill
     * @return String correspondant au niveau du skill
     */
    public String getLevel(){
        return this.Level;
    }
    
    /**
     * Fonction permettant de donner un niveau à un skill
     * @param l correspondant au level du skill voulu
     */
    
    public void setLevel(String l){
        this.Level = l;
    }
}
