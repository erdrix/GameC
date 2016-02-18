package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import bd.Connexion;
import comparator.Comparator;
import demand.Demand;
import supply.Supply;

@SuppressWarnings("serial")
public class UserPanel extends JPanel {
	private InformationsPanel cp;
	public ButtonPanel bp;
	public static Demand custom_demand;
	private static ArrayList<Supply> result;
	
	public UserPanel(HomeFrame frame, Dimension d, Connexion connexion){
		HeadPanel head = new HeadPanel(d, "Comparateur de jeux vidéos",new Color(181,94,94), frame ); 

		setLayout(new BorderLayout());
		custom_demand = new Demand();
		bp = new ButtonPanel(d);
		bp.applybutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
			
		});
		String[] main_infos = { "DTitle","DEditor",
								"DPrice","DReleaseDate",
								"DGameStyle","DStoryType",
								"DGameType","DMark"};
		
		String[] aux_infos = {	"DDescription","DAccessory",
								"DDifficulty","DBuyMethod",
								"DLifeTime","DGameSupport"};
		cp = new InformationsPanel(main_infos,aux_infos);		
		add(head, BorderLayout.NORTH);
		add(cp,BorderLayout.CENTER);
		bp.applybutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				result = new ArrayList<>();
				connexion.connect();
				ArrayList<Supply> supplies = connexion.getSupply();
				Comparator comparator = new Comparator(supplies,custom_demand);
				result = comparator.getListeSupply();
				comparator.afficherScore();
			}
			
		});
		add(bp,BorderLayout.SOUTH);
	}
	
	public ButtonPanel getBP(){
		return bp;
	}
	
	public void setResult(ArrayList<Supply> supplies){
		result = supplies;
	}
	
	public ArrayList<Supply> getResult(){
		return result;
	}
}
