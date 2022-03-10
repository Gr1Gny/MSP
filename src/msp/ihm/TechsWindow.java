/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package msp.ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import msp.database.UserDao;
import msp.metier.Tech;

/**
 * classe permettant de montrer les techniciens
 * @author Anthony
 */
public class TechsWindow {

    private ArrayList<Tech> Tech = new ArrayList<>();
    private JPanel Techs;
    private JPanel Skills;
    private JButton[] nummerButton;
    
    public JPanel getTechs(){
        return this.Techs;
        }
    
    public JPanel getSkills(){
        return this.Skills;
    }
    
    public TechsWindow(MainWindow menu) {
        Techs = new JPanel();
        Techs.setBounds(181, 0, 715, 574);
        Techs.setBackground(new Color(10, 10, 10));
        Skills = new JPanel();
                
                JButton btnNewButton = new JButton("");
                btnNewButton.setBounds(218, 52, 299, 63);
                btnNewButton.setIcon(new ImageIcon("images\\Technicians.jpg"));
                
                btnNewButton.setContentAreaFilled(false);
                btnNewButton.setFocusPainted(false);
                btnNewButton.setBorderPainted(false);
                
                JTextField txtTechnicians = new JTextField();
                txtTechnicians.setBounds(156, 125, 86, 20);
                txtTechnicians.setText("Technicians :");
                txtTechnicians.setForeground(new Color(255 ,255 ,255));
                txtTechnicians.setEditable(false);
                txtTechnicians.setBackground(new Color(10, 10, 10));
                txtTechnicians.setBorder(BorderFactory.createLineBorder(new Color(10, 10, 10)));

                Techs.setLayout(null);
                Techs.add(btnNewButton);
                Techs.add(txtTechnicians);
                
                UserDao db = new UserDao();    
            try {
                Tech = db.ListTechs();
                System.out.println(Tech.size());
            } catch (SQLException ex) {
                Logger.getLogger(ProjectsWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            nummerButton = new JButton [Tech.size()+1];
            int y = 152;
            for (int i=0 ; i<Tech.size() ; i++) {
                final int nb = i;
                nummerButton[i]= new JButton(Tech.get(i).getFirstName() + " " + Tech.get(i).getLastName());
                nummerButton[i].setBounds(146, y, 439, 34);
                nummerButton[i].setBorder(new LineBorder(new Color(20, 158, 240)));
                nummerButton[i].setContentAreaFilled(false);
                nummerButton[i].setFocusPainted(false);
                nummerButton[i].setForeground(Color.WHITE);
                nummerButton[i].addActionListener((ActionEvent e) -> {
                    System.out.println(nummerButton[nb].getText());
                    TechWindow t = new TechWindow(Tech.get(nb), Techs);
                    Skills = t.getPanel();
                    Techs.setVisible(false);
                    menu.add(Skills);
                    Skills.setVisible(true);
                });
                Techs.add(nummerButton[i]);
                y+=34; 
            }
	}

}
