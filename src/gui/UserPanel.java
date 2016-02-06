package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class UserPanel extends JPanel {
	private JLabel usertext;
	public UserPanel(){
		usertext = new JLabel("ADMINISTRATION");
		add(usertext);
	}
}
