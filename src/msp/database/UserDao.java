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
import msp.metier.Skill;
import msp.metier.Tech;
import msp.metier.User;

/**
 * Gère l'accès des utilisateurs aux données
 * @author Noham Martin
 * @version 1.0
 */

/**
 * permet la connexion à la base de donnée
 */
public class UserDao {
    
    private Connection con = null;
    
    /**
     * constructeur de la classe UserDao
     * permet de se connecter à la base de donnée
     */
    public UserDao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://mysql-noham.alwaysdata.net/noham_test","noham","H7ASFa2dv423zez");
            System.out.println("connected");
        }
        catch (ClassNotFoundException | SQLException e) {
            System.out.println("error : " +e);
        }
    }

    /**
    * Lit un utilisateur depuis la BD. En cas d'erreur, lève une exception.
    * @param Login login de l'utilisateur cherché
    * @param PassHash valeur de hachage du mot de passe de l'utilisateur cherché
    * @return L'utilisateur chargé depuis la BD.
    */
    public User Read(String Login, String PassHash) throws BadUserError, BadPasswordError {
        String nom = "";
        String prenom = "";
        boolean chief = false;
        String Type_user = "";
        int id = 0;
        
        
        try {
            //on prépare ici notre requête
            Statement stm = con.createStatement();
            PreparedStatement rechercheID = con.prepareStatement("SELECT * FROM utilisateur WHERE LOGIN = ? AND PASSWORD = ?");
            //on remplace ? par le Login et le Password crypté
            rechercheID.setString(1, Login);
            rechercheID.setString(2, PassHash);
            
            //on exécute la requête
            ResultSet res = rechercheID.executeQuery();
            
            //si la requête revoie quelque chose
            if (res.next()) {
                //on récupère l'id et le type de l'utilisateur
                id = res.getInt("ID");
                Type_user = res.getString("TYPE_UTILISATEUR");
            }
            if (Type_user.equals("chef")){
                //ischief passe à true si l'utilisateur est un chef
                chief = true;
            }
            
            //on effectue la même chose que précedement mais pour récupérer le nom et le prénom de l'utilisateur
            PreparedStatement rechercheNP = con.prepareStatement("SELECT * FROM " + Type_user + " WHERE UTILISATEUR_ID = ?");
            rechercheNP.setInt(1, id);
            ResultSet res2 = rechercheNP.executeQuery();
            
            //seulement si la requête renvoie quelque chose
            if (res2.next()) {
                nom = res2.getString("nom");
                prenom = res2.getString("prenom");
            }
        }
        catch (SQLException e) {
            System.out.println("error : " + e);
        }
        User u = new User(id);
        u.setLogin(Login);
        u.setPasswordHash(PassHash);
        if(PassHash == null){
            throw new BadPasswordError("Wrong Password");
        }
        u.setIsChief(chief);
        u.setIsConnected(true);
        u.setFirstName(prenom);
        u.setLastName(nom);
        
        return u;
    }
	

	/**
	 * Met à jour l'utilisateur dans la BD
	 * @param User L'utilisateur à mettre à jour
         * @throws java.sql.SQLException
	 */
	public void Update(User User) throws SQLException {
            
            //on crée ici une requête qui permet de modifier un utilisateur dans la base de donnée 
            Statement st = con.createStatement();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE utilisateur ");
            //on modifie ici le login et le password
            sb.append("SET LOGIN='").append(User.getLogin()).append("'");
            sb.append(", PASSWORD='").append(User.getPasswordHash()).append("'");
            sb.append(" WHERE ID=").append(User.getID());
            //on execute ici la requête qui permet la midification
            st.execute(sb.toString());
            
            String type_utilisateur = null;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT TYPE_UTILISATEUR FROM utilisateur WHERE ID =" + User.getID());
            //on cherche ici à récupérer me type de l'utilisateur qu'on modifie actuellement
            if (rs.next()){
                type_utilisateur = rs.getString("TYPE_UTILISATEUR");
            }
            //on update donc maintenant le nom de l'utilisateur
            Statement st2 = con.createStatement();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("UPDATE ").append(type_utilisateur);
            sb2.append(" SET nom='").append(User.getLastName()).append("'");
            sb2.append(" WHERE UTILISATEUR_ID=").append(User.getID());
            System.out.println(sb2.toString());
            st2.execute(sb2.toString());
            
            
	}

	/**
	 * Liste les techniciens
	 * @return un ensemble d'utilisateurs qui sont des techniciens
	 */
	public ArrayList<Tech> ListTechs() throws SQLException {
            ArrayList<Tech> Tech = new ArrayList<>();
            Statement stm = con.createStatement();
            //on récupère toutes les informations concernant les techniciens de la bdd
            PreparedStatement techrequest = con.prepareStatement("SELECT * FROM utilisateur INNER JOIN technicien ON utilisateur.ID = technicien.UTILISATEUR_ID WHERE TYPE_UTILISATEUR = 'technicien'");
            ResultSet res = techrequest.executeQuery();
            //tant qu'il y a des techniciens
            while(res.next())
            {
                //on crée un objet de type Tech grace aux infos de la bdd
                Tech p = new Tech(res.getInt("ID"));
                p.setLogin(res.getString("LOGIN"));
                p.setPasswordHash(res.getString("PASSWORD"));
                p.setIsChief(false);
                p.setFirstName(res.getString("prenom"));
                p.setLastName(res.getString("nom"));
               
                //on récupère maintenant leurs compétences
                Statement st = con.createStatement();
                PreparedStatement skillrequest = con.prepareStatement("SELECT * FROM possede INNER JOIN competence ON possede.competenceID = competence.ID WHERE technicienID = ?");
                skillrequest.setInt(1, res.getInt("ID"));
                ResultSet res2 = skillrequest.executeQuery();
                while(res2.next()){
                   Skill s = new Skill(res2.getString("nom"),res2.getString("niveau"));
                   p.addSkill(s);
                }
                Tech.add(p);
            }
            return Tech;
	}
}
