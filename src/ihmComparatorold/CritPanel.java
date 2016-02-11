package ihmComparatorold;

import java.awt.GridLayout;

import javax.swing.JPanel;


public class CritPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CritPanel(){
		setLayout(new GridLayout(2,1) );
		String[] main_crit = {"DTitle","DEditor","DPrice","DReleaseDate","DMark","DBuyMethod"};
		String[] aux_crit = {"DDescription","DEditor"};
		add(new MainInfoPanel(main_crit));
		add(new AuxInfoPanel(aux_crit));
		validate();
	}
	
}
