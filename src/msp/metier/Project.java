/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msp.metier;

/**
 * Classe permettant de gérer un projet 
 * @author Chloé, Océane
 * @Version 1.0
 */
public class Project {
    private String name;
    private int finalDuration;
    private ProjectStatus Status;
    private int ID;
    private int estimatedDurationMinutes;
    private float estimatedDurationHours;
    private float estimatedDurationDays;
    
    /**
     * Méthode permettant de mettre le statut du projet à "WORKING"
     */
    public void Start(){
        this.Status = ProjectStatus.WORKING;
    }
    
    /**
     * Méthode permettant de mettre le statut du projet à "CANCELED"
     */
    public void Cancel(){
        this.Status = ProjectStatus.CANCELED;
    }
    
    /**
     * Méthode permettant de changer le nom du projet
     * @param Name : nouveau nom du projet
     */
    public void setName(String Name) {
		this.name = Name;
    }

    /**
     * Méthode permettant de récupérer le nom du projet
     * @return retourne la valeur de l'attribut name
     */
    public String getName() {
	return this.name;
    }

    /**
     * Méthode qui permet de modifier le temps de durée du projet
     * @param FinalDuration : nouvelle valeur de la durée final du projet
     */
    public void setFinalDuration(int FinalDuration) {
	this.finalDuration = FinalDuration;
    }

    /**
     * Méthode qui permet de récupérer la durée finale du projet
     * @return la vleur de l'attribut finalDuration
     */
    public int getFinalDuration() {
	return this.finalDuration;
    }

    /**
     * Méthode qui permet de modifier le status du projet
     * @param Status : nouvelle valeur du status du projet
     */
    public void setStatus(ProjectStatus Status) throws BadProjectStatus {
        boolean bool = false;
        for (ProjectStatus s : ProjectStatus.values()){
            if(Status == s){
                bool = true;
            }
        }
        if(!bool){
            throw new BadProjectStatus("Wrong Status");
        }
	this.Status = Status;
    }

    /**
     * Méthode qui permet de récupérer la valeur du status du projet
     * @return la valeur de l'attribut status
     */
    public ProjectStatus getStatus() {
	return this.Status;
    }

    /**
     * Méthode qui permet de modifier l'ID du projet
     * @param ID : nouvel ID du projet
     */
    public void setID(int ID) {
	this.ID = ID;
    }

    /**
     * Méthode qui permet de récupérer l'ID du projet
     * @return la valeur de l'attribut ID
     */
    public int getID() {
	return this.ID;
    }

    /**
     * Méthode qui permet de modifier des minutes de l'estimation de durée du projet
     * @param EstimatedDurationMinutes : nouvelle valeur des minutes l'estimation de durée du projet
     */
    public void setEstimatedDurationMinutes(int EstimatedDurationMinutes) {
	this.estimatedDurationMinutes = EstimatedDurationMinutes;
    }

    /**
     * Méthode qui permet de récupérer la valeur des minutes de l'estimation de durée du projet
     * @return la valeur de l'attribut EstimatedDurationMinutes
     */
    public int getEstimatedDurationMinutes() {
	return this.estimatedDurationMinutes;
    }

    /**
     * Méthode qui permet de modifier des heures de l'estimation de durée du projet
     * @param EstimatedDurationHours : nouvelle valeur des heures l'estimation de durée du projet
     */
    public void setEstimatedDurationHours(float EstimatedDurationHours) {
	this.estimatedDurationHours = EstimatedDurationHours;
    }

    /**
     * Méthode qui permet de récupérer la valeur des heures de l'estimation de durée du projet
     * @return la valeur de l'attribut EstimatedDurationHours
     */
    public float getEstimatedDurationHours() {
	return this.estimatedDurationHours;
    }
        
    /**
     * Méthode qui permet de récupérer la valeur des jours de l'estimation de durée du projet
     * @return la valeur de l'attribut EstimatedDurationDays
     */
    public float getEstimatedDurationDays(){
        return this.estimatedDurationDays;
    }
    
    /**
     * Méthode qui permet de modifier des jours de l'estimation de durée du projet
     * @param EstimatedDurationDays : nouvelle valeur des jours l'estimation de durée du projet
     */
    public void setEstimatedDurationDays(float EstimatedDurationDays){
        this.estimatedDurationDays = EstimatedDurationDays;
    }
    
}
