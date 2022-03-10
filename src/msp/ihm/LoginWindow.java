/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msp.ihm;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import msp.database.BadPasswordError;
import msp.database.BadUserError;
import msp.database.UserDao;
import msp.metier.BadProjectStatus;
import msp.metier.User;
import msp.metier.Utils;
/**
 * @author Tanguy et Noham
 * Page permettant la connexion
 */
public class LoginWindow {

    /**
    * utilisateur à remplir lors de la connexion
*/
private User user;
        
    private JPanel contentPane;
    private JTextField txtLogin;
    private JTextField txtLogin2;
    private JTextField textField;
    private JPasswordField textField2;

    /**
    * Initialise la fenêtre. Transmet un utilisateur à modifier (lors de la connexion)
    * @param USER l'utilisateur à utiliser (modifié par la connexion). Si la connexion échoue, l'utilisateur ne contient rien
    */
    public LoginWindow(User USER) {
        
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setIconImage(Toolkit.getDefaultToolkit().getImage("images\\logobleu.png"));
        f.setBounds(100, 100, 902, 603);
        contentPane = new JPanel();
        f.setContentPane(contentPane);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        f.setContentPane(contentPane);
        contentPane.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(10, 10, 10));
        panel.setBounds(0, 0, 896, 574);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton buttonCancel = new JButton("");
        buttonCancel.setIcon(new ImageIcon("images\\cancel.png"));
        buttonCancel.setContentAreaFilled(false);
        buttonCancel.setFocusPainted(false);
        buttonCancel.setBorderPainted(false);
        buttonCancel.setBounds(519, 414, 167, 86);
        panel.add(buttonCancel);
        buttonCancel.addActionListener((ActionEvent e) -> {
            Cancel();
        });


        JButton btnTitle = new JButton("");
        btnTitle.setIcon(new ImageIcon("images\\titre.jpg"));
        btnTitle.setContentAreaFilled(false);
        btnTitle.setFocusPainted(false);
        btnTitle.setBorderPainted(false);
        btnTitle.setBounds(210, 40, 476, 55);
        panel.add(btnTitle);

        JButton btnLogin = new JButton("");
        btnLogin.setIcon(new ImageIcon("images\\login.jpg"));
        btnLogin.setContentAreaFilled(false);
        btnLogin.setFocusPainted(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setBounds(210, 414, 167, 86);
        panel.add(btnLogin);
        btnLogin.addActionListener((ActionEvent e) -> {
            try {
                Connect();
            } catch (BadUserError ex) {
                System.err.println("wrong user");;
            } catch (BadPasswordError ex) {
                System.err.println("Wrong password");;
            }
            if(user.getID() != 0){
                f.dispose();
                MainWindow main = new MainWindow();
                main.setCurrentUser(this.user);
                try {
                    main.menu();
                } catch (BadProjectStatus ex) {
                    Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            JTextField msgFaux = new JTextField();
            msgFaux.setBounds(210, 320, 476, 20);
            msgFaux.setEditable(false);
            panel.add(msgFaux);
            msgFaux.setBackground(new Color(10, 10, 10));
            msgFaux.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(128, 128, 128)));
            msgFaux.setText("Incorrect Login or Password");
            msgFaux.setForeground(new Color(158, 14, 64));
        });

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(210, 171, 476, 2);
        panel_1.setBackground(new Color(20, 158, 240));
        panel.add(panel_1);

        txtLogin = new JTextField();
        txtLogin.setText("Login");
        txtLogin.setBounds(210, 184, 86, 20);
        panel.add(txtLogin);
        txtLogin.setForeground(new Color(255 ,255 ,255));
        txtLogin.setEditable(false);
        txtLogin.setBackground(new Color(10, 10, 10));
        txtLogin.setBorder(BorderFactory.createLineBorder(new Color(10, 10, 10)));

        textField = new JTextField();
        textField.setBounds(210, 206, 131, 20);
        textField.setForeground(new Color(255 ,255 ,255));
        panel.add(textField);
        textField.setBackground(new Color(10, 10, 10));
        textField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(128, 128, 128)));

        txtLogin2 = new JTextField();
        txtLogin2.setText("Password");
        txtLogin2.setBounds(210, 237, 86, 20);
        panel.add(txtLogin2);
        txtLogin2.setForeground(new Color(255 ,255 ,255));
        txtLogin2.setEditable(false);
        txtLogin2.setBackground(new Color(10, 10, 10));
        txtLogin2.setBorder(BorderFactory.createLineBorder(new Color(10, 10, 10)));

        textField2 = new JPasswordField();
        textField2.setBounds(210, 261, 131, 20);
        textField2.setForeground(new Color(255 ,255 ,255));
        panel.add(textField2);
        textField2.setBackground(new Color(10, 10, 10));
        textField2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(128, 128, 128)));		
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(210, 300, 476, 2);
        panel_2.setBackground(new Color(60, 158, 240));
        panel.add(panel_2);
        f.setVisible(true);
    }
    /**
    * l'utilisateur valide la saisie du login/du mot de passe
    */
    public void Connect() throws BadUserError, BadPasswordError {
        String login = textField.getText();
        String password = textField2.getText();
        System.out.println(login);
        System.out.println(password);
        Utils u = new Utils();
        String hash = u.HashPassword(password);
        UserDao db = new UserDao();
        user = db.Read(login, hash); 
    }

    /**
    * permet de vider les champs
    */
    public void Cancel() {
        textField.setText("");
        textField2.setText("");
    }

}
