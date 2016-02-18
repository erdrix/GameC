package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import bd.Connexion;
import supply.Couple;
import supply.SBuyMethod;
import supply.SDifficulty;
import supply.SGameStyle;
import supply.SGameType;
import supply.SLifeTime;
import supply.Supply;

public class FrameSupply extends JFrame{
	
	private Connexion connexion;
	private HomeFrame frame;
	private JButton save;
	private SupplyInfo nouv;
	private Supply supply;
	private FrameSupply me;
	@SuppressWarnings("unchecked")
	public FrameSupply(Connexion c, HomeFrame f, Supply s){
		me = this;
		supply = s;
		frame = f;
		connexion=c;
		// Style de la fen�tre
		setLayout(new BorderLayout());
		this.setBounds(10, 10, 500, 500);
		this.setResizable(false);
		
		// El�ments de la fen�tre
		save = new JButton("Enregistrer"); add(save, BorderLayout.SOUTH);
		//save.setEnabled(false);
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
			nouv = new SupplyInfo(save, supply,  main_infos, aux_infos);add(nouv, BorderLayout.CENTER);
		}catch(Exception e){e.printStackTrace();}
		
		
		save.addActionListener(new ActionListener(){
			public void actionPerformed( ActionEvent e)
			{
				me.dispose();	
			}
		});
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosed(WindowEvent arg0) {
				connexion.connect();
				System.out.println(supply.getTitle());
				if(supply.getIdOffre() !=-1)
					connexion.updateSupply(supply);
				else
					connexion.insertSupply(supply);
				connexion.close();
				frame.reloadAdminPanel();
				
			}
			
		});
	}
}
