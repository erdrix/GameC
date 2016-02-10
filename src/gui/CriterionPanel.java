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

@SuppressWarnings("serial")
public class CriterionPanel extends  JPanel {
	private static ArrayList<TreeMap<String,String>> Keyword;	
	private static ArrayList<TreeMap<String,String>> Ecart;	
	private static ArrayList<TreeMap<String,String>> Intervalle;
	private static ArrayList<TreeMap<String,String>> Binary;
	private static ArrayList<TreeMap<String,String>> Multiple;
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
				Constructor<?> constructors = Class.forName("gui."+type+"Panel").getDeclaredConstructor( (new String()).getClass() );
				Field[] fields = Class.forName("gui.CriterionPanel").getDeclaredFields();
				for(Field f : fields){
						Object field_value = f.get(f.getClass());
						for(TreeMap<String,String> value : (ArrayList<TreeMap<String,String>>) field_value){
							if(s.equals(value.get("classe"))){
								String label = value.get("label");
								Component c = (Component) constructors.newInstance(label);
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
						if(value.get("classe").equals(s)){
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
	
	
	public void init_arrays(){

		TreeMap<String,String> elmt = new TreeMap<>();
		
		// Instanciation des Keyword
		Keyword = new ArrayList<>();
		elmt.put("classe", "DTitle");
		elmt.put("label", "Titre du jeu : ");
		Keyword.add(elmt);
		
		elmt = new TreeMap<>();
		elmt.put("classe", "DEditor");
		elmt.put("label", "Editeur : ");
		Keyword.add(elmt);
		
		elmt = new TreeMap<>();
		elmt.put("classe", "DDescription");
		elmt.put("label", "Mots-clés : ");
		Keyword.add(elmt);
		
		// Instanciation des Ecart
		Ecart = new ArrayList<>();
		elmt = new TreeMap<>();
		elmt.put("classe", "DLifeTime");
		elmt.put("label", "Durée de vie : ");
		Ecart.add(elmt);
		elmt = new TreeMap<>();
		elmt.put("classe", "DDifficulty");
		elmt.put("label", "Difficulté : ");
		Ecart.add(elmt);
		
		// Instanciation des Intervalle
		Intervalle = new ArrayList<>();
		elmt = new TreeMap<>();
		elmt.put("classe", "DMark");
		elmt.put("label", "Note : ");
		Intervalle.add(elmt);
		
		elmt = new TreeMap<>();
		elmt.put("classe", "DPrice");
		elmt.put("label", "Prix :");
		Intervalle.add(elmt);
		
		elmt = new TreeMap<>();
		elmt.put("classe", "DReleaseDate");
		elmt.put("label", "Date de sortie : ");
		Intervalle.add(elmt);
		
		// Instanciation des Binary
		Binary = new ArrayList<>();
		elmt = new TreeMap<>();
		elmt.put("classe", "DBuyMethod");
		elmt.put("label", "Type de paiement : ");
		Binary.add(elmt);
		
		elmt = new TreeMap<>();
		elmt.put("classe", "DGameType");
		elmt.put("label", "Mode de jeu : ");
		Binary.add(elmt);
		
		// Instanciation des Multiple
		Multiple = new ArrayList<>();
		elmt = new TreeMap<>();
		elmt.put("classe", "DAccessory");
		elmt.put("label", "Accessoires");
		Multiple.add(elmt);

		elmt = new TreeMap<>();
		elmt.put("classe", "DStoryType");
		elmt.put("label", "Type d'histoire : ");		
		Multiple.add(elmt);
		
		elmt = new TreeMap<>();
		elmt.put("classe", "DGameSupport");
		elmt.put("label", "Supports de jeu : ");
		Multiple.add(elmt);
		
		// Instanciation des Style
		Style = new ArrayList<>();
		elmt = new TreeMap<>();
		elmt.put("classe", "DGameStyle");
		elmt.put("label", "Genre : ");
		Style.add(elmt);
	}
}
