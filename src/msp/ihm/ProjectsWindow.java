/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msp.ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import msp.database.ProjectDao;
import msp.metier.BadProjectStatus;
import msp.metier.Project;

/**
 *
 * @author Noham
 */
public class ProjectsWindow {
    
    private ArrayList<Project> Project = new ArrayList<>();
    private JPanel Projects;
    private JButton[] nummerButton;
    private JPanel Project_Details;
    
    public JPanel getProjects(){
        return this.Projects;
        }

    public JPanel getProject_Details() {
        return Project_Details;
    }
    
    public ProjectsWindow(MainWindow menu) throws BadProjectStatus {
        Projects = new JPanel();
        Projects.setBounds(181, 0, 715, 574);
        Projects.setBackground(new Color(10, 10, 10));
                
        JButton btnNewButton = new JButton("");
        btnNewButton.setBounds(218, 52, 299, 63);
        btnNewButton.setIcon(new ImageIcon("images\\Projects.png"));
                
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setFocusPainted(false);
        btnNewButton.setBorderPainted(false);
                
        JTextField txtTechnicians = new JTextField();
        txtTechnicians.setBounds(156, 125, 86, 20);
        txtTechnicians.setText("Projets :");
        txtTechnicians.setForeground(new Color(255 ,255 ,255));
        txtTechnicians.setEditable(false);
        txtTechnicians.setBackground(new Color(10, 10, 10));
        txtTechnicians.setBorder(BorderFactory.createLineBorder(new Color(10, 10, 10)));

        Projects.setLayout(null);
        Projects.add(btnNewButton);
        Projects.add(txtTechnicians);
        
        ProjectDao db = new ProjectDao();    
        Project = db.ListAll();
        System.out.println(Project.size());
        nummerButton = new JButton [Project.size()+1];
        int y = 152;
        for (int i=0 ; i<Project.size() ; i++) {
            final int nb = i;
            nummerButton[i]= new JButton(Project.get(i).getName());
            nummerButton[i].setBounds(146, y, 439, 28);
            nummerButton[i].setBorder(new LineBorder(new Color(20, 158, 240)));
            nummerButton[i].setContentAreaFilled(false);
            nummerButton[i].setFocusPainted(false);
            nummerButton[i].setForeground(Color.WHITE);
            nummerButton[i].addActionListener((ActionEvent e) -> {
                System.out.println(nummerButton[nb].getText());
                ProjectWindow p = new ProjectWindow(Project.get(nb), Projects);
                Project_Details = p.getpanel();
                Projects.setVisible(false);
                menu.add(Project_Details);
                Project_Details.setVisible(true);
            });
        Projects.add(nummerButton[i]);
        y+=28; 
        }        
    }
}
