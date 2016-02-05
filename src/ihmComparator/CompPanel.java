package ihmComparator;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class CompPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CritPanel crp;
	private SubmitPanel sp;
	
	public CompPanel(){
		crp = new CritPanel();
		sp = new SubmitPanel();
		setLayout(new BorderLayout());
		add(crp,BorderLayout.CENTER);
		add(sp,BorderLayout.SOUTH);
	}
}
