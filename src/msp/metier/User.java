/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msp.metier;

/**
 *Classe User permettant la création d'un utilisateur
 * @author Océane
 * @Version 1.0
 */
public class User {
    private int ID;
    private String Login;
    private String PasswordHash;
    private String LastName;
    private String FirstName;
    private boolean isConnected = false;
    private boolean isChief = false;
    
    /**
     * Constructeur d'utilisateur
     * @param id correspond à l'id de l'utilisateur
     */
    public User(int id){
        this.ID = id;
    }
    /**
     * fonction permettant la copie d'un utilisateur
     * @param user correspondant à l'utilisateur que l'on veut copier
     */
    public void Copy(User user){
        user.setID(this.ID);
        user.FirstName = this.FirstName;
        user.LastName = this.LastName;
        user.Login = this.Login;
        user.PasswordHash = this.PasswordHash;
        user.isChief = this.isChief;
        user.isConnected = this.isConnected;
                
    }
    /**
     * fonction permettant la deconnexion d'un utilisateur
     */
    public void Disconect(){
        this.isConnected = false;
    }
    /**
     * fonction permettant 
     * @return int correspondant à l'id
     */
    public int getID(){
        return this.ID;
    }
    /**
     * fonction permettant la création d'une id
     * @param ID correspondant à l'id que l'on veut créer
     */
    public void setID(int ID){
        this.ID = ID;
    }
    /**
     * fonction permettant la récupération du login
     * @return String permettant de récupérer le login 
     */
     public String getLogin(){
        return this.Login;
    }
    /**
     * Fonction permettant la création d'un login
     * @param login correspondant au login qu'on veut créer
     */
    public void setLogin(String login){
        this.Login = login;
    }
    /**
     * fonction permettant de récupérer le mot de passe
     * @return String correspondant au mot de passe à récupérer 
     */
    
     public String getPasswordHash(){
        return this.PasswordHash;
    }
     
     /**
      * fonction permettant la création d'un mot de passe
      * @param ph correspondant au mot de passe qu'on veut créer
      */
    public void setPasswordHash(String ph){
        this.PasswordHash = ph;
    }
    
    /**
     * Fonction permettant de récupérer le last name
     * @return String correspondant au last Name qu'on veut récupérer
     */
    
     public String getLastName(){
        return this.LastName;
    }
     
     /**
      * Fonction permettant la création d'un last Name
      * @param LN correspondant au last Name qu'on veut créer
      */
    public void setLastName(String LN){
        this.LastName = LN;
    }
    /**
     * Fonction permettant de récupérer le First name
     * @return String correspondant au first name qu'on veut récupérer
     */
    
     public String getFirstName(){
        return this.FirstName;
    }
     /**
      * Fonction permettant la création d'un first name
      * @param FN correspond au first name que l'on veut créer
      */
    public void setFirstName(String FN){
        this.FirstName = FN;
    }
    
    /**
     * fonction permettant de set une connexion
     * @param IsConnected correspond à si la personne est connecté ou non
     */
    
    public void setIsConnected(boolean IsConnected) {
		this.isConnected = IsConnected;
	}
    
    /**
     * Fonction permettant de savoir si il y a connexion
     * @return boolean permettant de savoir si il y a connexion
     */

    public boolean isConnected() {
        return this.isConnected;
    }
    
    /**
     * fonction permettant de savoir si un terchnicien est chef de projet
     * @param IsChief correspond à si l'utilisateur veut passer un techs en chef ou non
     */

    public void setIsChief(boolean IsChief) {
        this.isChief = IsChief;
    }
    
    /**
     * Fonction permettant de savoir si le technicien est un chef ou non 
     * @return boolean pour savoir si le technicien est un chef ou non
     */

    public boolean isIsChief() {
        return this.isChief;
    }
     /**
      * fonction permettant de retourner les informations d'un utilisateur
      * @return String correspondant à l'ensemble des informations d'un utilisateur
      */
    @Override
    public String toString(){
        return ID + "  " + Login + "  " + PasswordHash + " " + LastName + " " + FirstName + " " + isConnected + " " + isChief;
    }
}
