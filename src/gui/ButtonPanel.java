package gui;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ButtonPanel extends JPanel {
	public JButton logoutbutton;
	public JButton applybutton;
	
	public ButtonPanel(){
		logoutbutton = new JButton("D�connexion");
		applybutton = new JButton("Rechercher !");
		add(logoutbutton);
		add(applybutton);
	}
}
