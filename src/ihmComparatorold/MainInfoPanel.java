package ihmComparatorold;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class MainInfoPanel extends InfoPanel{

	private static final long serialVersionUID = 1L;
	public MainInfoPanel(String[] criterions){
		super(criterions);
		setLayout(new BorderLayout());
		add(new JLabel("Informations principales : "),BorderLayout.NORTH);
		add(new JSeparator(JSeparator.HORIZONTAL),BorderLayout.CENTER);
		add(new CritInfoPanel(criterions), BorderLayout.SOUTH);
		
		
	}

}
