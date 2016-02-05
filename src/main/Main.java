package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeMap;
import bd.Connexion;
import comparator.Comparator;
import supply.*;
import demand.*;
public class Main {

	public static void main(String[] args) {
		Connexion connexion = new Connexion();
		connexion.connect();
		
		// Initialisation des champs choix possibles.
		SBuyMethod.Init("Abonnement", "Licence", "Gratuit");
		SDifficulty.Init("Débutant", "Intermédiaire", "Confirmé", "Expérimenté");
		SGameType.Init("Hors Ligne", "En Ligne");
		SLifeTime.Init("Courte", "Moyenne", "Longue", "Infinie");
		SGameStyle.Init(
				new Couple<String, String>("Fiction Intéractive", "Aventure, Sous-Aventure"),
				new Couple<String, String>("Visual Novel", "Aventure, Sous-Aventure"),
				new Couple<String, String>("Infiltration", "Action Aventure, Sous-Action, Sous-Aventure"),
				new Couple<String, String>("Survival Horror", "Action Aventure, Sous-Action, Sous-Aventure")
				);
		SAccessory.Init(connexion.getAccessoriesById(-1));
		SGameSupport.Init(connexion.getSupportsById(-1));
		
		SStoryType.Init(connexion.getTypeStoriesById(-1));		
		
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		cal1.set(Calendar.YEAR,2008 );
		cal2.set(Calendar.YEAR,2013 );
		
		TreeMap<String, String> s1 = new TreeMap<>();
		s1.put("type", "0");s1.put("nomEditeur", "Nintendo"); s1.put("nomSupport", "WiiU");
		TreeMap<String, String> s2 = new TreeMap<>();
		s2.put("type", "0");s2.put("nomEditeur", "Nintendo"); s2.put("nomSupport", "Wii");
		TreeMap<String, String> s3 = new TreeMap<>();
		s3.put("type", "0");s3.put("nomEditeur", "Microsoft"); s3.put("nomSupport", "Xbox360");
		
		
		TreeMap<String, String> a1 = new TreeMap<>();
		a1.put("type", "2"); a1.put("nomEditeur", "Nintendo"); a1.put("nomAccessoire", "WiiMote");
		TreeMap<String, String> a2 = new TreeMap<>();
		a2.put("type", "2");a2.put("nomEditeur", "Nintendo"); a2.put("nomAccessoire", "GamePad");
		TreeMap<String, String> a3 = new TreeMap<>();
		a3.put("type", "2");a3.put("nomEditeur", "Microsoft"); a3.put("nomAccessoire", "Xbox360");
		
		ArrayList<TreeMap<String, String>>supports = new ArrayList<>();
		supports.add(s1); supports.add(s2); supports.add(s3);
		
		ArrayList<TreeMap<String, String>> accessories = new ArrayList<>();
		accessories.add(a1); accessories.add(a2); accessories.add(a3);
		
	
		Demand d = new Demand(
				new DTitle("Guild Guild Wars 2"), 
				new DDescription("Meilleur jeu de l'année"), 
				new DEditor("AreaNet"), 
				new DMark(17, 18), 
				new DReleaseDate(cal1, cal2), 
				new DGameType(0), 
				new DBuyMethod(new DPrice(30, 70), 2), 
				new DDifficulty(2), 
				new DLifeTime(2), 
				new DGameStyle("A-RPG"), 
				new DStoryType(0,2), 
				new DGameSupport(supports), 
				new DAccessory(accessories),
				null ,0);
		
		
		ArrayList<Supply> test = connexion.getSupply();
		Comparator c = new Comparator(test, d);
		System.out.println(SBuyMethod.getOptions().get(2));
		System.out.println(test.get(1).getBuyMethod());
		c.getListeSupply();
		c.afficherScore();

		connexion.close();
	}
}
