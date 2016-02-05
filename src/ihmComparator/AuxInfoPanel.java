package ihmComparator;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JSeparator;

public class AuxInfoPanel extends InfoPanel{

	private static final long serialVersionUID = 1L;
	public AuxInfoPanel(String[] criterions){
		super(criterions);
		setLayout(new BorderLayout());
		add(new JLabel("Informations compl�mentaires : "),BorderLayout.NORTH);
		add(new JSeparator(JSeparator.HORIZONTAL),BorderLayout.CENTER);	
		add(new CritInfoPanel(criterions), BorderLayout.SOUTH);
				
	}

}
