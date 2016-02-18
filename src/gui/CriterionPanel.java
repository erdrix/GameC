package gui;

import java.awt.Component;
import java.awt.GridLayout;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import demand.Demand;

@SuppressWarnings("serial")
public class CriterionPanel extends  JPanel {
	private static ArrayList<TreeMap<String,String>> Keyword;	
	private static ArrayList<TreeMap<String,String>> Ecart;	
	private static ArrayList<TreeMap<String,String>> Intervalle;
	private static ArrayList<TreeMap<String,String>> Binary;
	private static ArrayList<TreeMap<String,String>> Multiple;
	private static ArrayList<TreeMap<String,String>> MultipleComplexe;
	private static ArrayList<TreeMap<String,String>> Style;
	public CriterionPanel(){
		super();
	}
	
	@SuppressWarnings("unchecked")
	public CriterionPanel(String name, String[] infos){
		TitledBorder tb;
		tb = BorderFactory.createTitledBorder(name);
		setBorder(tb);
		setLayout(new GridLayout(infos.length/2,2));
		init_arrays();
		for(String s : infos){
			String type = getType(s); System.out.println(type);
			try {
				Constructor<?> constructors = Class.forName("gui."+type+"Panel").getDeclaredConstructor( (new TreeMap<>()).getClass() );
				Field[] fields = Class.forName("gui.CriterionPanel").getDeclaredFields();
				for(Field f : fields){
						Object field_value = f.get(f.getClass());
						for(TreeMap<String,String> value : (ArrayList<TreeMap<String,String>>) field_value){
							if(s.equals("D"+value.get("classe"))){
								Component c = (Component) constructors.newInstance(value);
								add(c);
							}
						}
				}
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public String getType(String s){
		Field[] fields;
		try {
			fields = Class.forName("gui.CriterionPanel").getDeclaredFields();
			for(Field f : fields){
					Object field_value = f.get(f.getClass());
					for(TreeMap<String,String> value : (ArrayList<TreeMap<String,String>>) field_value){
						if(s.equals("D"+value.get("classe"))){
							String type = f.toString();
							type = type.replace("private static java.util.ArrayList gui.CriterionPanel.","");
							return type;
						}
					}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return"";
	}
	
	public Demand addValues(){
		Demand d = new Demand();
		return d;
	}
	public void init_arrays(){

		TreeMap<String,String> elmt = new TreeMap<>();
		
		// Instanciation des Keyword
		Keyword = new ArrayList<>();
		elmt.put("classe", "Title");
		elmt.put("label", "Titre du jeu : ");
		Keyword.add(elmt);
		
		elmt = new TreeMap<>();
		elmt.put("classe", "Editor");
		elmt.put("label", "Editeur : ");
		Keyword.add(elmt);
		
		elmt = new TreeMap<>();
		elmt.put("classe", "Description");
		elmt.put("label", "Mots-clés : ");
		Keyword.add(elmt);
		
		// Instanciation des Ecart
		Ecart = new ArrayList<>();
		elmt = new TreeMap<>();
		elmt.put("classe", "LifeTime");
		elmt.put("label", "Durée de vie : ");
		elmt.put("methods", "getOptions");
		Ecart.add(elmt);
		elmt = new TreeMap<>();
		elmt.put("classe", "Difficulty");
		elmt.put("label", "Difficulté : ");
		elmt.put("methods", "getOptions");
		Ecart.add(elmt);
		
		// Instanciation des Intervalle
		Intervalle = new ArrayList<>();
		elmt = new TreeMap<>();
		elmt.put("classe", "Mark");
		elmt.put("label", "Note : ");
		elmt.put("methods", "getLimits");
		Intervalle.add(elmt);
		
		elmt = new TreeMap<>();
		elmt.put("classe", "Price");
		elmt.put("label", "Prix :");
		elmt.put("methods", "getLimits");
		Intervalle.add(elmt);
		
		elmt = new TreeMap<>();
		elmt.put("classe", "ReleaseDate");
		elmt.put("label", "Année : ");
		elmt.put("methods", "getLimits");
		Intervalle.add(elmt);
		
		// Instanciation des Binary
		Binary = new ArrayList<>();
		elmt = new TreeMap<>();
		elmt.put("classe", "BuyMethod");
		elmt.put("label", "Paiement : ");
		elmt.put("methods", "getOptions");
		Binary.add(elmt);
		
		elmt = new TreeMap<>();
		elmt.put("classe", "GameType");
		elmt.put("label", "Mode de jeu : ");
		elmt.put("methods", "getOptions");
		Binary.add(elmt);
		
		// Instanciation des Multiple
		MultipleComplexe = new ArrayList<>();
		elmt = new TreeMap<>();
		elmt.put("classe", "Accessory");
		elmt.put("label", "Accessoires");
		elmt.put("methods", "getOptions");
		MultipleComplexe.add(elmt);
		
		Multiple = new ArrayList<>();
		elmt = new TreeMap<>();
		elmt.put("classe", "StoryType");
		elmt.put("label", "Type d'histoire : ");	
		elmt.put("methods", "getStoryType");	
		Multiple.add(elmt);
		
		elmt = new TreeMap<>();
		elmt.put("classe", "GameSupport");
		elmt.put("label", "Supports de jeu : ");
		elmt.put("methods", "getOptions");
		Multiple.add(elmt);
		
		// Instanciation des Style
		Style = new ArrayList<>();
		elmt = new TreeMap<>();
		elmt.put("classe", "GameStyle");
		elmt.put("label", "Genre : ");
		elmt.put("methods", "getOptions");
		Style.add(elmt);
	}
}
