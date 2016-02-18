package gui;

import java.util.TreeMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MultipleComplexePanel extends JPanel {
	private String classe;
	private JLabel jl;
	
	public MultipleComplexePanel(TreeMap<String,String> type){
		classe = type.get("classe");
		jl = new JLabel(type.get("label"));
		add(jl);
	}

}
