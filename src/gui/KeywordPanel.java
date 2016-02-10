package gui;

import java.util.TreeMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class KeywordPanel extends JPanel {
	private JLabel jl;
	private JTextField jtf;
	
	public KeywordPanel(TreeMap<String,String> t){
		jl = new JLabel(t.get("label"));
		add(jl);
		jtf = new JTextField(12);
		add(jtf);
	}
}
