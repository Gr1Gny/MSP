/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msp.ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import msp.database.UserDao;
import msp.metier.User;
import msp.metier.Utils;

/**
 * permet d'éditer le profil d'un utilisateur
 * @author Tanguy
 * @version 1.0
 */
public class ProfileWindow {
    private User user;
    private JPanel panel;
    private JPasswordField textFieldPassword;
    private JPasswordField textFieldNewPassword;
    private JPasswordField textFieldConfirmPassword;
    
    /**
     * permet de récupérer la page
     * @return un JPanel
     */
    public JPanel getPanel(){
        return this.panel;
    }
    
    /**
     * constructeur de la classe ProfileWindow
     * @param Us correspond à l'utilisateur actuellement connecté
     */
    public ProfileWindow(User Us) {
        
        panel = new JPanel();
        panel.setBackground(new Color(10, 10, 10));
        panel.setBounds(181, 0, 715, 574);
        panel.setLayout(null);

        JButton btnCancel = new JButton("");
        btnCancel.setIcon(new ImageIcon("images\\cancel.png"));
        btnCancel.setContentAreaFilled(false);
        btnCancel.setFocusPainted(false);
        btnCancel.setBorderPainted(false);
        btnCancel.setBounds(433, 414, 167, 86);
        panel.add(btnCancel);
        btnCancel.addActionListener((ActionEvent e) -> {
            Cancel();
        });

        JButton btnEditProfil = new JButton("");
        btnEditProfil.setIcon(new ImageIcon("images\\editprofile.jpg"));
        btnEditProfil.setContentAreaFilled(false);
        btnEditProfil.setFocusPainted(false);
        btnEditProfil.setBorderPainted(false);
        btnEditProfil.setBounds(124, 42, 476, 55);
        panel.add(btnEditProfil);

        JPanel panelTraitBleu = new JPanel();
        panelTraitBleu.setBounds(124, 171, 476, 2);
        panelTraitBleu.setBackground(new Color(20, 158, 240));
        panel.add(panelTraitBleu);

        JTextField txtName = new JTextField();
        txtName.setText("Name");
        txtName.setBounds(124, 188, 86, 20);
        panel.add(txtName);
        txtName.setForeground(new Color(255 ,255 ,255));
        txtName.setEditable(false);
        txtName.setBackground(new Color(10, 10, 10));
        txtName.setBorder(BorderFactory.createLineBorder(new Color(10, 10, 10)));

        JTextField testFieldName = new JTextField();
        testFieldName.setText(Us.getLastName());
        testFieldName.setEditable(false);
        testFieldName.setBounds(124, 218, 131, 20);
        testFieldName.setForeground(new Color(255 ,255 ,255));
        panel.add(testFieldName);
        testFieldName.setBackground(new Color(10, 10, 10));
        testFieldName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(128, 128, 128)));

        JTextField txtLogin = new JTextField();
        txtLogin.setText("Login");
        txtLogin.setBounds(124, 248, 86, 20);
        panel.add(txtLogin);
        txtLogin.setForeground(new Color(255 ,255 ,255));
        txtLogin.setEditable(false);
        txtLogin.setBackground(new Color(10, 10, 10));
       txtLogin.setBorder(BorderFactory.createLineBorder(new Color(10, 10, 10)));

        JTextField textFieldLogin = new JTextField();
        textFieldLogin.setText(Us.getLogin());
        textFieldLogin.setEditable(false);
        textFieldLogin.setBounds(124, 278, 131, 20);
        textFieldLogin.setForeground(new Color(255 ,255 ,255));
        panel.add(textFieldLogin);
        textFieldLogin.setBackground(new Color(10, 10, 10));
        textFieldLogin.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(128, 128, 128)));

        JTextField txtPassword = new JTextField();
        txtPassword.setText("Old password");
        txtPassword.setBounds(124, 308, 86, 20);
        panel.add(txtPassword);
        txtPassword.setForeground(new Color(255 ,255 ,255));
        txtPassword.setEditable(false);
        txtPassword.setBackground(new Color(10, 10, 10));
        txtPassword.setBorder(BorderFactory.createLineBorder(new Color(10, 10, 10)));

        textFieldPassword = new JPasswordField();
        textFieldPassword.setBounds(124, 338, 131, 20);
        textFieldPassword.setForeground(new Color(255 ,255 ,255));
        panel.add(textFieldPassword);
        textFieldPassword.setBackground(new Color(10, 10, 10));
        textFieldPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(128, 128, 128)));

        JTextField NewPsw = new JTextField();
        NewPsw.setText("New password");
        NewPsw.setBounds(424, 188, 86, 20);
        panel.add(NewPsw);
        NewPsw.setForeground(new Color(255 ,255 ,255));
        NewPsw.setEditable(false);
        NewPsw.setBackground(new Color(10, 10, 10));
        NewPsw.setBorder(BorderFactory.createLineBorder(new Color(10, 10, 10)));
        
        textFieldNewPassword = new JPasswordField();
        textFieldNewPassword.setBounds(424, 218, 131, 20);
        textFieldNewPassword.setForeground(new Color(255 ,255 ,255));
        panel.add(textFieldNewPassword);
        textFieldNewPassword.setBackground(new Color(10, 10, 10));
        textFieldNewPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(128, 128, 128)));
        
        JTextField txtConfirmPassword = new JTextField();
        txtConfirmPassword.setText("Confirm password");
        txtConfirmPassword.setBounds(424, 248, 150, 20);
        panel.add(txtConfirmPassword);
        txtConfirmPassword.setForeground(new Color(255 ,255 ,255));
        txtConfirmPassword.setEditable(false);
        txtConfirmPassword.setBackground(new Color(10, 10, 10));
        txtConfirmPassword.setBorder(BorderFactory.createLineBorder(new Color(10, 10, 10)));
        
        textFieldConfirmPassword = new JPasswordField();
        textFieldConfirmPassword.setBounds(424, 278, 131, 20);
        textFieldConfirmPassword.setForeground(new Color(255 ,255 ,255));
        panel.add(textFieldConfirmPassword);
        textFieldConfirmPassword.setBackground(new Color(10, 10, 10));
        textFieldConfirmPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(128, 128, 128)));
        
        JButton btnSaveChanges = new JButton("");
        btnSaveChanges.setIcon(new ImageIcon("images\\saves_changes.png"));
        btnSaveChanges.setContentAreaFilled(false);
        btnSaveChanges.setFocusPainted(false);
        btnSaveChanges.setBorderPainted(false);
        btnSaveChanges.setBounds(124, 414, 167, 86);
        
        JTextField msgBon = new JTextField();
        msgBon.setText("");
        msgBon.setBounds(124, 390, 200, 20);
        msgBon.setEditable(false);
        panel.add(msgBon);
        msgBon.setBackground(new Color(10, 10, 10));
        msgBon.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(128, 128, 128)));
        
        panel.add(btnSaveChanges);
        btnSaveChanges.addActionListener((ActionEvent e) -> {
            if(textFieldPassword.getText().equals(textFieldNewPassword.getText()) && textFieldPassword.getText().equals(textFieldConfirmPassword.getText()) && !textFieldPassword.getText().equals("")){
                msgBon.setText("Password modified successfully");
                msgBon.setForeground(new Color(84, 249, 141));
                try {
                    this.user.setLastName(testFieldName.getText());
                    this.user.setLogin(textFieldLogin.getText());
                    Utils u = new Utils();
                    String mdp = u.HashPassword(textFieldNewPassword.getText());
                    this.user.setPasswordHash(mdp);
                    Validate();
                    Cancel();
                } catch (SQLException ex) {
                    Logger.getLogger(ProfileWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                msgBon.setText("Write the same password");
                msgBon.setForeground(new Color(158, 14, 64));
            }
        });

        JPanel panelTraitBas = new JPanel();
        panelTraitBas.setBounds(124, 378, 476, 2);
        panelTraitBas.setBackground(new Color(60, 158, 240));
        panel.add(panelTraitBas);

        this.user = new User(0);
        Us.Copy(this.user);
        System.out.println(this.user.toString());
    }

    /**
     * permet de valider la modification de mot de passe
     * @throws SQLException 
     */
    public void Validate() throws SQLException {
        UserDao db = new UserDao();
        db.Update(this.user);
    }

    /**
    * permet de vider les champs
    */
    public void Cancel() {
	textFieldPassword.setText("");
        textFieldNewPassword.setText("");
        textFieldConfirmPassword.setText("");
    }
}
