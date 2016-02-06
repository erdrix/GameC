package gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class UserPanel extends JPanel {
	private ButtonPanel bp;
	public UserPanel(){
		setLayout(new BorderLayout());
		bp = new ButtonPanel();
		add(bp,BorderLayout.SOUTH);
	}
	
	@SuppressWarnings("unused")
	public ButtonPanel getBP(){
		return bp;
	}
}
