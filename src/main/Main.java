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
		SDifficulty.Init("D�butant", "Interm�diaire", "Confirm�", "Exp�riment�");
		SGameType.Init("Hors Ligne", "En Ligne");
		SLifeTime.Init("Courte", "Moyenne", "Longue", "Infinie");
		SGameStyle.Init(
			new Couple<String, String>("Fiction Int�ractive", "Aventure, Sous-Aventure"),
			new Couple<String, String>("Visual Novel", "Aventure, Sous-Aventure"),
			new Couple<String, String>("Infiltration", "Action Aventure, Sous-Action, Sous-Aventure"),				new Couple<String, String>("Survival Horror", "Action Aventure, Sous-Action, Sous-Aventure"),
			new Couple<String, String>("A-RPG", "Jeu de role, Sous-Action"),
			new Couple<String, String>("MMORPG", "Jeu de role")
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
				new DDescription("Meilleur jeu de l'ann�e"), 
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
		
		c.getListeSupply();
		c.afficherScore();
		cal1.set(2015, 5, 19, 0, 0, 0);
		
		s1 = new TreeMap<>();
		s1.put("type", "PC");s1.put("nomEditeur", "Microsoft"); s1.put("nomSupport", "fixe");
		s2 = new TreeMap<>();
		s2.put("type", "PC");s2.put("nomEditeur", "Microsoft"); s2.put("nomSupport", "Portable");
		s3 = new TreeMap<>();
		s3.put("type", "ConsoleSalon");s3.put("nomEditeur", "Sony"); s3.put("nomSupport", "PlayStation4");
		TreeMap<String, String>s4 = new TreeMap<>();
		s4.put("type", "ConsoleSalon");s4.put("nomEditeur", "Sony"); s4.put("nomSupport", "PlayStation3");
		TreeMap<String, String>s5 = new TreeMap<>();
		s5.put("type", "PC");s5.put("nomEditeur", "Apple"); s5.put("nomSupport", "MAC");
		TreeMap<String, String>s6 = new TreeMap<>();
		s6.put("type", "ConsoleSalon");s6.put("nomEditeur", "Microsoft"); s6.put("nomSupport", "Xbox360");
		TreeMap<String, String>s7 = new TreeMap<>();
		s7.put("type", "ConsoleSalon");s7.put("nomEditeur", "Microsoft"); s7.put("nomSupport", "XboxOne");
		supports.add(s1);supports.add(s2);supports.add(s3);supports.add(s4);supports.add(s5);supports.add(s6);supports.add(s7);
		
		a2 = new TreeMap<>();
		a2.put("type", "Manette");a2.put("nomEditeur", "Microsoft"); a2.put("nomAccessoire", "XboxOne");
		a3 = new TreeMap<>();
		a3.put("type", "Manette");a3.put("nomEditeur", "Microsoft"); a3.put("nomAccessoire", "Xbox360");
		accessories.add(a2); accessories.add(a3);
		
		Supply nouv = new Supply(
				-1,
				"http://image.jeuxvideo.com/medias-sm/142247/1422469608-7141-jaquette-avant.jpg",
				new STitle("The Witcher 3 :Wild Hunt"),
				new SDescription("The Witcher 3 : Wild Hunt est un Action-RPG se d�roulant dans un monde ouvert. Troisi�me �pisode de la s�rie du m�me nom, inspir�e des livres du polonais Andrzej Sapkowski, cet opus relate la fin de l histoire de Geralt de Riv."),
				new SEditor("CD Projekt"),
				new SMark((float)18.6),
				new SReleaseDate(cal1),
				new SGameType("Hors-Ligne"),
				new SBuyMethod(new SPrice((float) 45.5),"Licence"),
				new SDifficulty("Interm�diaire"),
				new SLifeTime("Infinie"),
				new SGameStyle("A-RPG"),
				new SStoryType("Fantastique", "Aventure"),
				new SGameSupport(supports),
				new SAccessory(accessories)
				);
		//connexion.insertSupply(nouv,10);
		connexion.deleteSupplyById(3);
		connexion.close();
	}
}
