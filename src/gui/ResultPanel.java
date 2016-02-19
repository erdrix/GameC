package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import bd.Connexion;
import comparator.Comparator;
import demand.Demand;
import supply.Supply;


@SuppressWarnings("serial")
public class ResultPanel extends JPanel {
	public ResultPanel(){
		
	}
	public ResultPanel(HomeFrame frame, Dimension d, Demand demand)
	{
		ArrayList<Supply> result = new ArrayList<Supply>();
		Connexion connexion = new Connexion();
		connexion.connect();
		ArrayList<Supply> supplies = connexion.getSupply();
		connexion.close();
		System.out.println(supplies);
		Comparator comparator = new Comparator(supplies,UserPanel.custom_demand);
		result = comparator.getListeSupply();
		comparator.afficherScore();
		HeadResultPanel head = new HeadResultPanel(d,"Résultat de la recherche",new Color(181,94,94), frame ); 
		setLayout(new BorderLayout());
		add(head, BorderLayout.NORTH);
		
		JPanel body = new JPanel(); 
		body.setPreferredSize(new Dimension((int) d.getWidth()-25, supplies.size()*270));
	    body.setLayout(new GridLayout(supplies.size(),1));
		int i = 1;
		for(Supply s : result){
			ComparatorPanel offre = new ComparatorPanel(s, d, i, frame);
			body.add(offre);
			i++;
		}
		JScrollPane jsp = new JScrollPane(body);
		jsp.getVerticalScrollBar().setUnitIncrement(16);
		add(jsp, BorderLayout.CENTER);
	}
}
