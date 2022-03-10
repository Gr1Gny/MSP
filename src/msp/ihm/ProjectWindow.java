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
import javax.swing.JTextField;
import msp.database.ProjectDao;
import msp.metier.BadProjectStatus;
import msp.metier.Project;
import msp.metier.ProjectStatus;
import static msp.metier.ProjectStatus.ENDED;

/**
 *
 * @author Noham
 */
public class ProjectWindow {

        private JPanel panel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtEstimatedDuration;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
        private JTextField durationvar;

    public JPanel getpanel() {
        return panel;
    }
        
    ProjectWindow(Project p, JPanel Projects) {
                Project modif = p;
                panel = new JPanel();
		panel.setBackground(new Color(10, 10, 10));
		panel.setBounds(181, 0, 796, 660);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("images\\Project_details.png"));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(131, 37, 476, 55);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(20, 158, 240));
		panel_1.setBounds(131, 125, 476, 2);
		panel.add(panel_1);
		
		textField = new JTextField();
		textField.setText("Name");
		textField.setForeground(Color.WHITE);
		textField.setEditable(false);
		textField.setBorder(BorderFactory.createLineBorder(new Color(10, 10, 10)));
		textField.setBackground(new Color(10, 10, 10));
		textField.setBounds(131, 137, 86, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
                textField_1.setText(p.getName());
                textField_1.setEditable(false);
		textField_1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(128, 128, 128)));
		textField_1.setBackground(new Color(10, 10, 10));
		textField_1.setBounds(131, 167, 131, 20);
		panel.add(textField_1);
		
		txtEstimatedDuration = new JTextField();
		txtEstimatedDuration.setText("Estimated Duration");
		txtEstimatedDuration.setForeground(Color.WHITE);
		txtEstimatedDuration.setEditable(false);
		txtEstimatedDuration.setBorder(BorderFactory.createLineBorder(new Color(10, 10, 10)));
		txtEstimatedDuration.setBackground(new Color(10, 10, 10));
		txtEstimatedDuration.setBounds(131, 197, 109, 20);
		panel.add(txtEstimatedDuration);
		
		textField_2 = new JTextField();
                textField_2.setText(String.valueOf(p.getEstimatedDurationHours()));
                textField_2.setEditable(false);
                if(p.getStatus() != ENDED){
                    textField_2.setEditable(true);
                }
		textField_2.setForeground(Color.WHITE);
		textField_2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(128, 128, 128)));
		textField_2.setBackground(new Color(10, 10, 10));
		textField_2.setBounds(131, 233, 131, 20);
		panel.add(textField_2);
		
		durationvar = new JTextField();
		durationvar.setText("hours");
		durationvar.setForeground(Color.WHITE);
		durationvar.setEditable(false);
		durationvar.setBorder(BorderFactory.createLineBorder(new Color(10, 10, 10)));
		durationvar.setBackground(new Color(10, 10, 10));
		durationvar.setBounds(272, 225, 97, 28);
		panel.add(durationvar);
		
                
		textField_3 = new JTextField();
                String temps = String.valueOf(p.getFinalDuration());
                if(p.getFinalDuration() == 0){
                    temps = "not ended";
                }
                textField_3.setText(temps);
                if(p.getStatus() == ENDED){
                    textField_3.setEditable(false);
                }
		textField_3.setForeground(Color.WHITE);
		textField_3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(128, 128, 128)));
		textField_3.setBackground(new Color(10, 10, 10));
		textField_3.setBounds(131, 313, 131, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("Final Duration");
		textField_4.setForeground(Color.WHITE);
		textField_4.setEditable(false);
		textField_4.setBorder(BorderFactory.createLineBorder(new Color(10, 10, 10)));
		textField_4.setBackground(new Color(10, 10, 10));
		textField_4.setBounds(131, 273, 109, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("Status");
		textField_5.setForeground(Color.WHITE);
		textField_5.setEditable(false);
		textField_5.setBorder(BorderFactory.createLineBorder(new Color(10, 10, 10)));
		textField_5.setBackground(new Color(10, 10, 10));
		textField_5.setBounds(131, 353, 109, 20);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
                textField_6.setText(String.valueOf(p.getStatus()));
                textField_6.setEditable(false);
                textField_6.setForeground(Color.WHITE);
		textField_6.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(128, 128, 128)));
		textField_6.setBackground(new Color(10, 10, 10));
		textField_6.setBounds(131, 383, 131, 20);
		panel.add(textField_6);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(20, 158, 240));
		panel_1_1.setBounds(131, 482, 476, 2);
		panel.add(panel_1_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("images\\saves_changes.png"));
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBounds(109, 485, 167, 86);
                btnNewButton_2.addActionListener((ActionEvent e) -> {
                    try {
                        modif.setEstimatedDurationHours(Float.valueOf(textField_2.getText()));
                        switch(textField_6.getText()){
                            case "CANCELED" : modif.setStatus(ProjectStatus.CANCELED); break;
                            case "WORKING" : modif.setStatus(ProjectStatus.WORKING); break;
                            case "WAITING" : modif.setStatus(ProjectStatus.WAITING); break;
                        }
                        if(!"not ended".equals(textField_3.getText())){
                            try {
                                modif.setFinalDuration(Integer.valueOf(textField_3.getText()));
                                modif.setStatus(ENDED);
                            } catch (BadProjectStatus ex) {
                                Logger.getLogger(ProjectWindow.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        ProjectDao projectDao = new ProjectDao();
                        try {
                            projectDao.update(modif);
                        } catch (SQLException ex) {
                            Logger.getLogger(ProjectWindow.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (BadProjectStatus ex) {
                        Logger.getLogger(ProjectWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    });
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("images\\discard.png"));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(465, 485, 167, 86);
                btnNewButton_1.addActionListener((ActionEvent e) -> {
                    panel.setVisible(false);
                    Projects.setVisible(true);
                    });
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.setIcon(new ImageIcon("images\\Start.png"));
		btnNewButton_2_1.setFocusPainted(false);
		btnNewButton_2_1.setContentAreaFilled(false);
		btnNewButton_2_1.setBorderPainted(false);
		btnNewButton_2_1.setBounds(189, 413, 141, 61);
                btnNewButton_2_1.addActionListener((ActionEvent e) -> {
                    if(String.valueOf(p.getStatus()) == "WAITING"){
                        textField_6.setText("WORKING");
                    }
                    });
		panel.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("");
		btnNewButton_2_1_1.setIcon(new ImageIcon("images\\cancel.png"));
		btnNewButton_2_1_1.setFocusPainted(false);
		btnNewButton_2_1_1.setContentAreaFilled(false);
		btnNewButton_2_1_1.setBorderPainted(false);
		btnNewButton_2_1_1.setBounds(395, 413, 141, 61);
                btnNewButton_2_1_1.addActionListener((ActionEvent e) -> {
                    if(!(String.valueOf(p.getStatus()) == "ENDED")){
                        textField_6.setText("CANCELED");
                    }
                    });
		panel.add(btnNewButton_2_1_1);
    }

    
}
