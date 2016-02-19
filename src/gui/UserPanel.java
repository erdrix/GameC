package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import bd.Connexion;
import demand.Demand;
import supply.Supply;

@SuppressWarnings("serial")
public class UserPanel extends JPanel {
	private InformationsPanel cp;
	public ButtonPanel bp;
	public static Demand custom_demand;
	public static ArrayList<Supply> result;
	
	@SuppressWarnings("unchecked")
	public UserPanel(HomeFrame frame, Dimension d, Connexion connexion){
		HeadPanel head = new HeadPanel(d, "Comparateur de jeux vidéos",new Color(181,94,94), frame ); 

		setLayout(new BorderLayout());
		custom_demand = new Demand();
		result = new ArrayList<Supply>();
		bp = new ButtonPanel(d);
		bp.applybutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
			
		});
		String[] main_infos;
		String[] aux_infos;
		
		JSONParser parser = new JSONParser();
		try{
			Object obj = parser.parse(new FileReader("./src/config.json"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONObject interf= (JSONObject) jsonObject.get("Interface");
			JSONArray objP = (JSONArray) interf.get("Principal"); 
			main_infos = new String[objP.size()]; objP.toArray(main_infos);
			objP = (JSONArray) interf.get("Secondaire"); 
			aux_infos = new String[objP.size()]; objP.toArray(aux_infos);
			cp = new InformationsPanel(main_infos,aux_infos);		
			add(head, BorderLayout.NORTH);
			add(cp,BorderLayout.CENTER);
		}catch(Exception e){e.printStackTrace();}		
		
		
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
