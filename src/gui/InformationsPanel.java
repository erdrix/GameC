package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class InformationsPanel extends JPanel {
	private CriterionPanel main_panel;
	private CriterionPanel aux_panel;
	
	public InformationsPanel(String[] m, String[] a){
		setLayout(new GridLayout(2,1));
		
		
		main_panel = new CriterionPanel("Informations principales",m,a);
		add(main_panel);
		aux_panel = new CriterionPanel("Informations complémentaires",m,a);
		add(aux_panel);
		
		
	}
}
