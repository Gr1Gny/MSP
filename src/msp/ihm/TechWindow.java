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
import msp.metier.Skill;
import msp.metier.Tech;
import msp.metier.User;


/**
 * Classe de la page d'un technicien
 * @author Chloé
 * @version 1.0
 */

public class TechWindow {
    private User tech;
    private JPanel Tech;
    private JTextField[] nummerTextField;

    public JPanel getPanel(){
        return Tech;
    }
        
    /**
    * constructeur de la page
    * @param tech correspond au technicien que nous voulons regarder
    */
        
public TechWindow(Tech tech,JPanel p) {
            this.tech = tech; 
            Tech = new JPanel();
            Tech.setBounds(181, 0, 715, 574);
            Tech.setBackground(new Color(10, 10, 10));
                
            JButton btnNewButton = new JButton("");
            btnNewButton.setBounds(218, 52, 299, 63);
            btnNewButton.setIcon(new ImageIcon("images\\Skills.jpg"));
                
            btnNewButton.setContentAreaFilled(false);
            btnNewButton.setFocusPainted(false);
            btnNewButton.setBorderPainted(false);
                
            JTextField txtTechnicians = new JTextField();
            txtTechnicians.setBounds(156, 125, 200, 20);
            txtTechnicians.setText("Technician : " + this.tech.getFirstName() + " " + this.tech.getLastName());
            txtTechnicians.setForeground(new Color(255 ,255 ,255));
            txtTechnicians.setEditable(false);
            txtTechnicians.setBackground(new Color(10, 10, 10));
            txtTechnicians.setBorder(BorderFactory.createLineBorder(new Color(10, 10, 10)));
            
            JTextField txtSkills = new JTextField();
            txtSkills.setBounds(156, 150, 200, 20);
            txtSkills.setText("Skills : ");
            txtSkills.setForeground(new Color(255 ,255 ,255));
            txtSkills.setEditable(false);
            txtSkills.setBackground(new Color(10, 10, 10));
            txtSkills.setBorder(BorderFactory.createLineBorder(new Color(10, 10, 10)));

            JButton btnNewButton_1 = new JButton("");
            btnNewButton_1.setIcon(new ImageIcon("images\\back.jpg"));
            btnNewButton_1.setContentAreaFilled(false);
            btnNewButton_1.setFocusPainted(false);
            btnNewButton_1.setBorderPainted(false);
            btnNewButton_1.setBounds(272, 451, 134, 46);
            btnNewButton_1.addActionListener((ActionEvent e) -> {
                Tech.setVisible(false);
                p.setVisible(true);
            });
            
            Tech.add(btnNewButton_1);
            Tech.setLayout(null);
            Tech.add(btnNewButton);
            Tech.add(txtTechnicians);
            Tech.add(txtSkills);
            
            nummerTextField = new JTextField[tech.GetSkills().size()];
            ArrayList<Skill> skillTable = tech.GetSkills();
            
            int y = 190;
            for (int i=0 ; i<tech.GetSkills().size() ; i++) {
                nummerTextField[i] = new JTextField();
                nummerTextField[i].setBounds(146, y, 439, 34);
                nummerTextField[i].setText("   name : " + skillTable.get(i).getName() + ",    level : " + skillTable.get(i).getLevel());
                nummerTextField[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(20, 158, 240)));
                nummerTextField[i].setForeground(new Color(255 ,255 ,255));
                nummerTextField[i].setEditable(false);
                nummerTextField[i].setBackground(new Color(10, 10, 10));
                Tech.add(nummerTextField[i]);
                y+=34;
            }
	}
}
