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
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import msp.metier.BadProjectStatus;
import msp.metier.User;

/**
 * classe qui permet de gérer la page principale
 * @author Océane, Tanguy et Noham
 */
public class MainWindow {
    
    /**
    * Utilisateur courante (vide avant la connexion, vide après la connexion)
    */
    private User currentUser;
    private JFrame f;
    private JFrame menu;
    private JPanel skills;
    private JPanel profil;
    private JPanel techs;
    private JPanel projects;
            
    public MainWindow(){
        
        f = new JFrame();
        f.setIconImage(Toolkit.getDefaultToolkit().getImage("images\\logobleu.png"));
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setBounds(100, 100, 902, 603);
	JPanel contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	f.setContentPane(contentPane);
	contentPane.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
		
	JPanel panelHaut = new JPanel();
	panelHaut.setBackground(new Color(10, 10, 10));
	panelHaut.setForeground(Color.WHITE);
	panelHaut.setBounds(0, 0, 898, 179);
	contentPane.add(panelHaut);
	panelHaut.setLayout(null);
		
	JPanel trait_bleu = new JPanel();
	trait_bleu.setBackground(new Color(0, 158, 240));
	trait_bleu.setBounds(145, 165, 572, 4);
	panelHaut.add(trait_bleu);
		
	JPanel panelTitre = new JPanel();
	panelTitre.setBackground(new Color(10, 10, 10));
	panelTitre.setBounds(145, 39, 572, 116);
	panelHaut.add(panelTitre);
	panelTitre.setLayout(null);
		
	JButton btnTitre = new JButton("");
	btnTitre.setIcon(new ImageIcon("images\\Titre_page_accueil.jpg"));
	btnTitre.setBounds(26, 0, 510, 116);
	panelTitre.add(btnTitre);
	btnTitre.setContentAreaFilled(false);
	btnTitre.setFocusPainted(false);
	btnTitre.setBorderPainted(false);
		
	JPanel panelBas = new JPanel();
	panelBas.setBackground(new Color(10, 10, 10));
	panelBas.setBounds(0, 177, 898, 399);
	contentPane.add(panelBas);
	panelBas.setLayout(null);
		
			
	JButton btnQuit = new JButton("");
	btnQuit.addActionListener((ActionEvent e) -> {
            f.dispose();
        });
	btnQuit.setBounds(157, 195, 146, 47);
	panelBas.add(btnQuit);
	btnQuit.setIcon(new ImageIcon("images\\quit.jpg"));
	btnQuit.setContentAreaFilled(false);
	btnQuit.setFocusPainted(false);
	btnQuit.setBorderPainted(false);
			
	JButton btnConnetion = new JButton("");
	btnConnetion.setBounds(607, 187, 146, 62);
	panelBas.add(btnConnetion);
	btnConnetion.setIcon(new ImageIcon("images\\connect.jpg"));
	btnConnetion.setContentAreaFilled(false);
	btnConnetion.setFocusPainted(false);
	btnConnetion.setBorderPainted(false);
	btnConnetion.addActionListener((ActionEvent e) -> {
            f.dispose();
            Connect();
        });
		
	JButton btnLogoSinge = new JButton("");
	btnLogoSinge.setBounds(361, 90, 183, 256);
	panelBas.add(btnLogoSinge);
	btnLogoSinge.setIcon(new ImageIcon("images\\logobleu.png"));
	btnLogoSinge.setContentAreaFilled(false);
	btnLogoSinge.setFocusPainted(false);
	btnLogoSinge.setBorderPainted(false);
        f.setVisible(true);

    }
    
    public void menu() throws BadProjectStatus{
        f.dispose();
        System.out.println(currentUser.toString());
        menu = new JFrame();
        menu.setIconImage(Toolkit.getDefaultToolkit().getImage("images\\logobleu.png"));
	menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	menu.setBounds(100, 100, 902, 603);
	JPanel contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	menu.setContentPane(contentPane);
	contentPane.setLayout(null);
        menu.setLocationRelativeTo(null);
        menu.setResizable(false);
		
	JPanel panel = new JPanel();
	panel.setBackground(new Color(10, 10, 10));
	panel.setBounds(0, 0, 171, 574);
	contentPane.add(panel);
	panel.setLayout(null);
		
	JButton btnProfile = new JButton("");
	btnProfile.setIcon(new ImageIcon("images\\profile.jpg"));
	btnProfile.setContentAreaFilled(false);
	btnProfile.setFocusPainted(false);
	btnProfile.setBorderPainted(false);
	btnProfile.setBounds(0, 175, 171, 48);
	panel.add(btnProfile);
        btnProfile.addActionListener((ActionEvent e) -> {
            this.EditProfile();
        });
		
	JButton btnViewProjects = new JButton("");
	btnViewProjects.setIcon(new ImageIcon("images\\view_projects.jpg"));
	btnViewProjects.setContentAreaFilled(false);
	btnViewProjects.setFocusPainted(false);
	btnViewProjects.setBorderPainted(false);
	btnViewProjects.setBounds(10, 234, 151, 48);
        btnViewProjects.addActionListener((ActionEvent e) -> {
            this.Projects();
        });
	panel.add(btnViewProjects);
		
	JButton btnViewTechs = new JButton("");
	btnViewTechs.setIcon(new ImageIcon("images\\view_techs.jpg"));
	btnViewTechs.setContentAreaFilled(false);
	btnViewTechs.setFocusPainted(false);
	btnViewTechs.setBorderPainted(false);
	btnViewTechs.setBounds(10, 293, 151, 48);
	panel.add(btnViewTechs);
	btnViewTechs.addActionListener((ActionEvent e) -> {
            this.ViewTechs();
        });
        
	JButton btnDisconnect = new JButton("");
	btnDisconnect.setIcon(new ImageIcon("images\\disconnect.jpg"));
	btnDisconnect.setContentAreaFilled(false);
	btnDisconnect.setFocusPainted(false);
	btnDisconnect.setBorderPainted(false);
	btnDisconnect.setBounds(10, 24, 151, 48);
	panel.add(btnDisconnect);
	btnDisconnect.addActionListener((ActionEvent e) -> {
            menu.dispose();
            Disconnect();
        });
	
	JButton btnLogo = new JButton("");
	btnLogo.setIcon(new ImageIcon("images\\logobleu.png"));
	btnLogo.setBounds(10, 380, 151, 183);
	btnLogo.setContentAreaFilled(false);
	btnLogo.setFocusPainted(false);
	btnLogo.setBorderPainted(false);
	panel.add(btnLogo);
        
	JPanel panel_2 = new JPanel();
	panel_2.setBackground(new Color(20, 158, 240));
	panel_2.setBounds(171, 0, 10, 574);
	contentPane.add(panel_2);
        
        menu.setVisible(true);
        
        ProfileWindow profile = new ProfileWindow(currentUser);
        profil = profile.getPanel();
        menu.add(profil);
        profil.setVisible(true);
        
        TechsWindow techsw = new TechsWindow(this);
        techs = techsw.getTechs();
        menu.add(techs);
        techs.setVisible(false);
        
        ProjectsWindow projectw = new ProjectsWindow(this);
        projects = projectw.getProjects();
        menu.add(projects);
        projects.setVisible(false);
    }
    
    public void Connect() {
	LoginWindow login = new LoginWindow(currentUser);
    }

    /**
    * l'utilisateur demande à se déconnecter
    */
    public void Disconnect() {
	MainWindow main = new MainWindow();
    }

    /**
    * L'utilisateur demande à modifier son profil
    */
    public void EditProfile() {
	profil.setVisible(true);
        techs.setVisible(false);
        projects.setVisible(false);
        if (skills != null) {
            skills.setVisible(false);
        }
    }

    /**
    * L'utilisateur demande à lister les projets
    */
    public void Projects() {
	projects.setVisible(true);
	profil.setVisible(false);
        techs.setVisible(false);
        if (skills != null) {
            skills.setVisible(false);
        }
    }

    /**
    * L'utilisateur demande à lister les techniciens
    */
    public void ViewTechs() {
        projects.setVisible(false);
	profil.setVisible(false);
        techs.setVisible(true);
        if (skills != null) {
            skills.setVisible(false);
        }
    }
    
    /**
     * permet d'ajouter le panel skill au menu
     * @param user 
     */
    public void setCurrentUser(User user){
        this.currentUser = user;
    }

    
    public void add(JPanel Skills) {
        menu.add(Skills);
        this.skills = Skills;
    }
}
