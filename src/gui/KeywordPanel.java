package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class KeywordPanel extends JPanel {
	private JLabel jl;
	private JTextField jtf;
	
	public KeywordPanel(String name){
		jl = new JLabel(name);
		add(jl);
		jtf = new JTextField(12);
		add(jtf);
	}
}
