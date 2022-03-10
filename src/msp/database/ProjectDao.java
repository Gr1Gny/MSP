/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import msp.metier.BadProjectStatus;
import msp.metier.Project;
import msp.metier.ProjectStatus;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Class permettant la gestion de la base de donnée côté projet
 * @author Anthony Mouchot
 * @version 1.0
 */
public class ProjectDao{   
    
    private Connection con = null;

    /**
     * constructeur de la classe ProjectDao
     * permet de se connecter à la base de donnée
     */
    public ProjectDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb","root","");
            System.out.println("connected");
        }
        catch (ClassNotFoundException | SQLException e) {
            System.out.println("error : " +e);
        }
    }
    
    /**
     * permet de lister tous les projets
     * @return un tableau de projets
     */
    public ArrayList<Project> ListAll() throws BadProjectStatus{
        ArrayList<Project> Projects = new ArrayList<>();
        
        try {
            //on récupère ici toutes les infos de la bdd
            Statement stm = con.createStatement();
            PreparedStatement rechercheprojet = con.prepareStatement("SELECT * FROM projet"); 
            ResultSet res = rechercheprojet.executeQuery();
            
            //tant que la requête renvoie quelque chose
            while(res.next()){
                //on crée un objet de type project
                Project p = new Project();
                p.setName(res.getString("nom"));
                p.setFinalDuration(res.getInt("dureeFinale"));
                p.setID(res.getInt("ID"));
                switch(res.getString("statut")){
                    case "fini": p.setStatus(ProjectStatus.ENDED);
                        break;
                    case "en attente": p.setStatus(ProjectStatus.WAITING);
                        break;
                    case "en cours": p.setStatus(ProjectStatus.WORKING);
                        break;
                    case "annule": p.setStatus(ProjectStatus.CANCELED);
                        break;
                }
                p.setEstimatedDurationDays(res.getInt("dureeEstimee")/7);
                p.setEstimatedDurationHours(res.getInt("dureeEstimee"));
                p.setEstimatedDurationMinutes(res.getInt("dureeEstimee")*60);
                //on ajoute maintenant le projet qu'on vient de créer au tableau à retourner 
                Projects.add(p);
            }
        }
        catch (SQLException e) {
            System.out.println("error : " +e);
            }
        
        return Projects;                
    }
    
    /**
     * permet de modifier un projet
     * @param p le projet à modifier
     * @throws SQLException 
     */
    public void update(Project p) throws SQLException{
        String statutstr = null;
        switch(p.getStatus()){
            case ENDED : statutstr = "fini"; break;
            case CANCELED : statutstr = "annule"; break;
            case WORKING : statutstr = "en cours"; break;
            case WAITING : statutstr = "en attente"; break;
        }
        //on va ici modifier un projet de la bdd
        Statement st = con.createStatement();
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE projet ");
        //la durée estimée
        sb.append("SET dureeEstimee='").append(p.getEstimatedDurationHours()).append("'");
        sb.append(", dureeFinale='").append(p.getFinalDuration()).append("'");
        //le statut
        sb.append(", statut='").append(statutstr).append("'");
        sb.append(" WHERE ID=").append(p.getID());
        //on execute maintenant la requête
        st.execute(sb.toString());
    }

}
