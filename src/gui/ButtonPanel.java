package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ButtonPanel extends JPanel {
	public JButton logoutbutton;
	public JButton applybutton;
	
	public ButtonPanel(Dimension d){
		applybutton = new JButton("RECHERCHER");
	    applybutton.setPreferredSize(new Dimension((int) (d.getWidth()-2),28));
	    applybutton.setHorizontalAlignment(JLabel.CENTER);
	    applybutton.setVerticalAlignment(JLabel.CENTER);
	    applybutton.setBackground(new Color(128,214, 160)); applybutton.setForeground(Color.WHITE);
	    applybutton.setFont(new Font("Segoe UI", Font.BOLD, 14));applybutton.setFocusPainted(false);
	    add(applybutton);
	}
}
