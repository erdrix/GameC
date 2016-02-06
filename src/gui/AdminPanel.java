package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AdminPanel extends JPanel {
	private JLabel admintext;
	public AdminPanel(){
		admintext = new JLabel("ADMINISTRATION");
		add(admintext);
		JPanel jp = new JPanel();
		JButton ad = new JButton("admin");
		jp.add(ad);
		add(jp);
	}
}
