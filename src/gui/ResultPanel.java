package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import supply.Supply;


@SuppressWarnings("serial")
public class ResultPanel extends JPanel {
	public ResultPanel(HomeFrame frame, Dimension d, ArrayList<Supply> supplies)
	{
		HeadPanel head = new HeadPanel(d, "Résultat de la recherche",new Color(181,94,94), frame ); 
		setLayout(new BorderLayout());
		add(head, BorderLayout.NORTH);
		
		JPanel body = new JPanel();
		for(Supply s : supplies){
			ComparatorPanel offre = new ComparatorPanel(s, d);
			body.add(offre);
		}
		//add(body, BorderLayout.CENTER);
	}
}
