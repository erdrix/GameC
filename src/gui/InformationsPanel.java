package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

import demand.*;

@SuppressWarnings("serial")
public class InformationsPanel extends JPanel {
	private CriterionPanel main_panel;
	private CriterionPanel aux_panel;
	
	public InformationsPanel(String[] m, String[] a){
		setLayout(new GridLayout(2,1));
		CriterionPanel.init_arrays();
		main_panel = new CriterionPanel("Informations principales",m);
		add(main_panel);
		aux_panel = new CriterionPanel("Informations complémentaires",a);
		add(aux_panel);
	}

	public Demand getValues(){
		Demand d = new Demand();
		d = main_panel.addValues();
		d = aux_panel.addValues();
		return d;
	}
}
