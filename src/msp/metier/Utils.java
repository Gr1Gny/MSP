/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msp.metier;

/**
 * @author Chloé
 */
public class Utils {
    
    /**
     * Méthode qui permet de crypter le mot de passe
     * @param pass : le mot de passe
     * @return chaine de caractère qui est le mot de passe crypté
     */
    public String HashPassword(String pass){
        char ch[] = pass.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ch.length; i++){
            String hexString = Integer.toHexString(ch[i]);
            sb.append(hexString);
            pass = sb.toString();
        }
        return pass;
    }
    
    /**
     * Méthode qui permet de savoir combien il y a de lettre en majuscule dans le mot de passe
     * @param pass : le mot de passe à tester
     * @return le nombre de lettre majuscule que le mot de passe contient
     */
    private int nb_maj(String pass){
        int compteur = 0;
        for(int i = 0; i<pass.length(); i++){
            char ch = pass.charAt(i);
            if(Character.isUpperCase(ch)){
                compteur ++;
            }
        }
        return compteur;
    }
    
    /**
     * Méthode qui permet de savoir si le mot de passe contient des chiffres
     * @param pass : le mot de passe à tester
     * @return true si le mot de passe contient des chiffres, false sinon
     */
    private boolean nb_chiffre(String pass){
        boolean b = false;
        if(pass.contains("1") || pass.contains("2") || pass.contains("3") ||
           pass.contains("4") || pass.contains("5") || pass.contains("6") || pass.contains("7") || pass.contains("8") || pass.contains("9") || pass.contains("0")){
           b = true;
        }
        return b;
    }
    
    /**
     * Méthode qui permet de de savoir si le mot de passe contient des lettres
     * @param pass : le mot de passe à tester
     * @return true si le mot de passe contient des lettres, false sinon
     */
    private boolean nb_lettre(String pass){
        boolean b = false;
        String s = pass.toLowerCase();
        if(s.contains("a") || s.contains("b") || s.contains("c") || s.contains("d") || s.contains("e") || s.contains("f") || s.contains("g") || s.contains("h")
            || s.contains("i") || s.contains("j") || s.contains("k") || s.contains("l") || s.contains("m") || s.contains("n") || s.contains("o") || s.contains("p")
            || s.contains("q") || s.contains("r") || s.contains("s") || s.contains("t") || s.contains("u") || s.contains("v") || s.contains("w") || s.contains("x")
            || s.contains("y") || s.contains("z")){
                b = true;
            
        }
        return b;
    }
    
    /**
     * Méthode qui permet de savoir si le password est valide ou non
     * @param pass : le mot de passe à vérifier
     * @return true si le password est valide, false sinon
     */
    public boolean IsPasswordSafe(String pass){
        //8 charactères / Au moins 1 maj, au moins 1 chiffre ou 1 lettre
        boolean b = false;
        if(pass.length() >= 8 && nb_maj(pass)>= 1 && nb_chiffre(pass) == true && nb_lettre(pass) == true ){
            b = true;
        }
        return b;
    }
    
}
