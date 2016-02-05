package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeMap;

import supply.*;


public class Connexion {
	
	private String DBPath= ".\\src\\bd\\VideoComparator.db";
	private Connection connection = null;
	private Statement statement1 = null;
	private Statement statement2 = null;
	
	public void connect()
	{
		try{
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:"+DBPath);
			statement1 = connection.createStatement();
			statement2 = connection.createStatement();
			System.out.println("Connexion a"+DBPath+" avec succ�s");	
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("Erreur de connexion : "+e);
		}catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Erreur de connexion : "+e);
		}
	}
	
	public void close(){
		try{
			connection.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Erreur de connexion : "+e);
		}
	}
	
	public ResultSet query1(String request)
	{
		ResultSet resultat = null;
		try{
			resultat = statement1.executeQuery(request);
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("Erreur de requ�te : "+e);
		}
		
		return resultat;
	}
	
	public ResultSet query2(String request)
	{
		ResultSet resultat = null;
		try{
			resultat = statement2.executeQuery(request);
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("Erreur de requ�te : "+e);
		}
		
		return resultat;
	}
	
	public String getEditorById(int id)
	{
		ResultSet res = query1("SELECT nomEditeur FROM Editors WHERE idEditeur ="+id);
		String name = "";
		try {
			while(res.next())
			{
				name = res.getString("nomEditeur");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	
	public ArrayList<TreeMap<String, String>> getAccessoriesById(Integer item)
	{
		String id = (item==-1)? "":"WHERE idAccessoire="+item.toString();
		ArrayList<TreeMap<String, String>> retour = new ArrayList<>();
		ResultSet res = query1("SELECT * FROM Accessories INNER JOIN Editors ON numEditeur=idEditeur "+id);
		int nbColonnes = 0;
		
		
		try {
			ResultSetMetaData metadata = res.getMetaData();
			nbColonnes = metadata.getColumnCount();
			
			while(res.next())
			{
				TreeMap<String, String> current= new TreeMap<>();
				// Pour chaque colonnes pr�sentes dans la table accessoire.
				for(int i=1; i <= nbColonnes; i++)
				{
					if(!metadata.getColumnName(i).equals("idAccessoire"))
						if(!metadata.getColumnName(i).equals("idEditeur") && !metadata.getColumnName(i).equals("numEditeur"))
							current.put(metadata.getColumnName(i), res.getString(i));
				}
				retour.add(current);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return retour;
	}
	
	public ArrayList<TreeMap<String, String>> getSupportsById(Integer item)
	{
		ArrayList<TreeMap<String, String>> retour = new ArrayList<>();
		String id = (item==-1)? "":"WHERE idSupport="+item.toString();
		ResultSet res = query1("SELECT * FROM Supports INNER JOIN Editors ON numEditeur=idEditeur "+id);
		int nbColonnes = 0;
		
		
		try {
			ResultSetMetaData metadata = res.getMetaData();
			nbColonnes = metadata.getColumnCount();
			
			while(res.next())
			{
				TreeMap<String, String> current= new TreeMap<>();
				// Pour chaque colonnes pr�sentes dans la table accessoire.
				for(int i=1; i <= nbColonnes; i++)
				{
					if(!metadata.getColumnName(i).equals("idSupport"))
						if(!metadata.getColumnName(i).equals("idEditeur") && !metadata.getColumnName(i).equals("numEditeur"))
							current.put(metadata.getColumnName(i), res.getString(i));
				}
				retour.add(current);
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally{ 
			try{if(res!=null){res.close();}}catch(Exception e){} 
		}
		return retour;
	}
	
	public ArrayList<Integer> getJoueAvecByIdOffre(int indice)
	{
		ArrayList<Integer> retour = new ArrayList<>();
		ResultSet res = query1("SELECT numAccessoire FROM JoueAvec J WHERE J.numOffre ="+indice);
		try {
			while(res.next())
			{
				retour.add(res.getInt("numAccessoire"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retour;
	}
	
	public ArrayList<Integer> getJoueSurByIdOffre(int indice)
	{
		ArrayList<Integer> retour = new ArrayList<>();
		ResultSet res = query1("SELECT numSupport FROM JoueSur J WHERE J.numOffre ="+indice);
		try {
			while(res.next())
			{
				retour.add(res.getInt("numSupport"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retour;
	}
	
	public ArrayList<Integer> getStyleStoriesByIdOffre(int indice)
	{
		ArrayList<Integer> retour = new ArrayList<>();
		ResultSet res = query1("SELECT numStyle FROM StyleStories SS WHERE numOffre ="+indice);
		try {
			while(res.next())
			{
				retour.add(res.getInt("numStyle"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retour;
	}
	
	public ArrayList<String> getTypeStoriesById(Integer indice)
	{
		String id = (indice==-1)? "":"WHERE idStyle="+indice.toString();
		ResultSet res = query1("SELECT * FROM TypeStories "+id);
		ArrayList<String> retour = new ArrayList<>();

		try {
			while(res.next())
				retour.add(res.getString("nomStyle"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retour;	
	}
	
	public ArrayList<Supply> getSupply()
	{
		ResultSet offres = query2("SELECT S.*  FROM Supplies S");

		ArrayList<Supply> supplies = new ArrayList<>();
		try {
			while(offres.next())
			{
				int idOffre = offres.getInt("idOffre");
				STitle title = new STitle(offres.getString("titre")); 
				
				SDescription desc = new SDescription(offres.getString("description")); 
				
				SEditor edit = new SEditor(getEditorById(offres.getInt("numEditeur")));
				System.out.println(offres);
				SMark mark = new SMark((float) 15.2);//new SMark((float)offres.getDouble("note"));
				
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				try {
					cal.setTime(sdf.parse(offres.getString("dateSortie")));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				SReleaseDate  rd = new SReleaseDate(cal);
				
				SGameType gt = new SGameType(offres.getString("modeJeu"));
				SPrice price = new SPrice(offres.getFloat("prix"));
				SBuyMethod bm = new SBuyMethod(
						price, offres.getString("modePaiement"));
				SDifficulty diff = new SDifficulty(offres.getString("difficulte"));
				SLifeTime lt = new SLifeTime(offres.getString("dureeVie"));
				SGameStyle gst = new SGameStyle(offres.getString("styleJeu"));
				String lienImg = offres.getString("lienImage");
				
				ArrayList<String> stories = new ArrayList<>();
				ArrayList<Integer> ids = this.getStyleStoriesByIdOffre(idOffre);
				for(int id : ids)
					for(String s : getTypeStoriesById(id))
						stories.add(s);
				String[] t = new String[stories.size()];
				SStoryType st = new SStoryType(stories.toArray(t));
				
				
				ArrayList<TreeMap<String, String>> supports = new ArrayList<>();
				ids = getJoueSurByIdOffre(idOffre);
				for(int id : ids)
					for(TreeMap<String, String> a :getSupportsById(id))
						supports.add(a);
				SGameSupport gs =  new SGameSupport(supports);
				
				ArrayList<TreeMap<String, String>> accessories = new ArrayList<>();
				ids = getJoueAvecByIdOffre(idOffre);
				for(int id : ids)
					for(TreeMap<String, String> a :getAccessoriesById(id))
						accessories.add(a);
				SAccessory acce =  new SAccessory(accessories);
				
				Supply offre = new Supply(idOffre, lienImg, title, desc, edit, mark, rd, gt, bm, diff, lt, gst, st ,gs, acce);
			
				supplies.add(offre);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return supplies;
	}
	
	//public get
}