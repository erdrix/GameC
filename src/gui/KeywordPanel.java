package gui;

import java.util.TreeMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class KeywordPanel extends JPanel {
	private JLabel jl;
	private String classe;
	private JTextField jtf;
	
	public KeywordPanel(TreeMap<String,String> t){
		
		jl = new JLabel(t.get("label")); add(jl);
		classe = t.get("classe");
		
		UserPanel.custom_demand.setField(classe, "");
		jtf = new JTextField(12);
		jtf.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void changedUpdate(DocumentEvent e) {}

			@Override
			public void insertUpdate(DocumentEvent e) {
				String s = new String(jtf.getText());
				UserPanel.custom_demand.setField(classe, s);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String s = new String(jtf.getText());
				UserPanel.custom_demand.setField(classe, s);
			}
			
		});
		add(jtf);
	}
}
