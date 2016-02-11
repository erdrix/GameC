package ihmComparatorold;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SubmitPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton submit;
	
	public SubmitPanel(){
		submit = new JButton("Rechercher !");
		add(submit);
	}

}
