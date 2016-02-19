package main;

import bd.Connexion;
import supply.*;
import gui.HomeFrame;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Connexion connexion = new Connexion();
		connexion.connect();
		
		JSONParser parser = new JSONParser();
		try{
			Object obj = parser.parse(new FileReader("./src/config.json"));
			JSONObject jsonObject = (JSONObject) obj;
			
			// Initialisation Paiement
			JSONArray bm = (JSONArray) jsonObject.get("BuyMethod");
			String[] m = new String[bm.size()]; bm.toArray(m);
			SBuyMethod.Init(m);
			
			// Initialisation Difficulté
			JSONArray diff = (JSONArray) jsonObject.get("Difficulty");
			m = new String[diff.size()];diff.toArray(m);
			SDifficulty.Init(m);
			
			// Initialisation GameType
			JSONArray gt = (JSONArray) jsonObject.get("GameType");
			m = new String[gt.size()]; gt.toArray(m);
			SGameType.Init(m);
			
			// Initialisation LifeTime
			JSONArray lt = (JSONArray) jsonObject.get("LifeTime");
			m = new String[lt.size()]; lt.toArray(m);
			SLifeTime.Init(m);
			
			// Initialisation GameStyle
			JSONArray gameStyle = (JSONArray)jsonObject.get("GameStyle");
			Iterator<JSONArray> it = gameStyle.iterator();
			ArrayList<Couple<String, String>> res = new ArrayList<>();
			while(it.hasNext())
			{
				JSONArray style = (JSONArray) it.next();
				res.add(new Couple<String, String>((String) style.get(0), (String)style.get(1)));
			}
			SGameStyle.Init(res);	
		}catch(Exception e){e.printStackTrace();}
		
		// Initialisation des champs choix possibles.
		
		SAccessory.Init(connexion.getAccessoriesById(-1));
		SGameSupport.Init(connexion.getSupportsById(-1));
		
		SStoryType.Init(connexion.getTypeStoriesById(-1));		
		connexion.close();
		new HomeFrame(connexion);
	}
}
