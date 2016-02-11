package ihmComparatorold;


import javax.swing.JPanel;
import javax.swing.JTextField;

public class KeywordPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTextField jtf;
	
	public KeywordPanel(String classname){
		if(classname.equals("DTitle")){
			jtf = new JTextField(16);
			add(jtf);
		}		
		if(classname.equals("DEditor")){
			jtf = new JTextField(16);
			add(jtf);
		}		
		if(classname.equals("DDescription")){
			jtf = new JTextField(16);
			add(jtf);
		}
	}

}
