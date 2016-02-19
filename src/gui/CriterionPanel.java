package gui;

import java.awt.Component;
import java.awt.GridLayout;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import demand.Demand;

@SuppressWarnings("serial")
public class CriterionPanel extends  JPanel {
	private static ArrayList<TreeMap<String, String>> elements;

	public CriterionPanel(){
		super();
	}
	
	public CriterionPanel(String name, String[] infos){
		TitledBorder tb;
		tb = BorderFactory.createTitledBorder(name);
		setBorder(tb);
		setLayout(new GridLayout(infos.length/2,2));
		for(String s : infos){
			String type = getType(s); 
			try {
				Constructor<?> constructors = Class.forName("gui."+type+"Panel").getDeclaredConstructor( (new TreeMap<>()).getClass() );
				
				for(TreeMap<String, String> value : elements)
				{
					if(s.equals(value.get("classe")))
					{
						Component c = (Component) constructors.newInstance(value);
						add(c);
					}
				}
			} catch (Exception e) {e.printStackTrace();} 
		}
	}
	
	public String getType(String c)
	{
		for( TreeMap<String, String> elmt : elements)
			if(elmt.get("classe").equals(c))
				return elmt.get("critere");
		
		return "";
	}
	public static void init_arrays(){
		elements = new ArrayList<>();
		TreeMap<String, String> elmt = new TreeMap<>();
		
		// Instanciation
		JSONParser parser = new JSONParser();
		try{
			Object obj = parser.parse(new FileReader("./src/config.json"));
			JSONObject jsonObj = (JSONObject) obj;
			JSONObject interf = (JSONObject) jsonObj.get("Interface");
			JSONObject critere = (JSONObject) interf.get("Criteres");
			
			@SuppressWarnings("unchecked")
			Set<String> field  = critere.keySet();
			for(String f : field)
			{
				JSONArray cArray = (JSONArray) critere.get(f);
				for( Object c : cArray)
				{
					JSONObject e = (JSONObject) c;
					elmt = new TreeMap<>();
					elmt.put("critere", f);
					elmt.put("classe", (String) e.get("classe"));
					elmt.put("label", (String) e.get("label"));
					if(e.get("methods") != null)
					{
						JSONArray methods = (JSONArray) e.get("methods");
						elmt.put("methodOptions", (String) methods.get(0));
						if(methods.size() == 2)
							elmt.put("methodChoix", (String) methods.get(1));
					}
					if(e.get("premier") != null) elmt.put("premier", (String) e.get("premier"));
					if(e.get("deuxieme") != null) elmt.put("deuxieme", (String) e.get("deuxieme"));
					elements.add(elmt);
				}
			}
		}catch(Exception e){e.printStackTrace();}
	}
	
	public static ArrayList<TreeMap<String, String>> getCritere(String critere)
	{
		ArrayList<TreeMap<String, String>> elmt = new ArrayList<>();		
		for( TreeMap<String, String> tm : elements)
			if(tm.get("critere") == critere)
				elmt.add(tm);
		return elmt;
	}
	
	public Demand addValues(){
		Demand d = new Demand();
		return d;
	}
}
