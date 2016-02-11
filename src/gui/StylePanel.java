package gui;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import supply.Couple;
import supply.SGameStyle;

@SuppressWarnings("serial")
public class StylePanel extends JPanel {
	private JLabel jl;
	private JComboBox<String> jcb;
	
	@SuppressWarnings("unchecked")
	public StylePanel(TreeMap<String,String> type){
		SGameStyle.Init(
				new Couple<String, String>("Fiction Intéractive", "Aventure, Sous-Aventure"),
				new Couple<String, String>("Visual Novel", "Aventure, Sous-Aventure"),
				new Couple<String, String>("Infiltration", "Action Aventure, Sous-Action, Sous-Aventure"),				new Couple<String, String>("Survival Horror", "Action Aventure, Sous-Action, Sous-Aventure"),
				new Couple<String, String>("A-RPG", "Jeu de role, Sous-Action"),
				new Couple<String, String>("MMORPG", "Jeu de role")
			);
		jl = new JLabel(type.get("label"));
		add(jl);
		try {
			Constructor<?> constructors = 
					Class.forName("supply."+type.get("classe").replace("D","S"))
					.getDeclaredConstructor(String.class); 
			Object obj = constructors.newInstance("");
			Method getOptions = 
					Class.forName("supply."+type.get("classe").replace("D","S"))
					.getDeclaredMethod(type.get("methods"));
			TreeMap<String, String> options = (TreeMap<String, String>) getOptions.invoke(obj);
			String[] items;
			int i = 0 ;
			int size = 0;
			for(Map.Entry<String, String> style : options.entrySet()){
				size = size ++;
			}
			System.out.println("size : "+size);
			items = new String[6];
			i = 0;
			for(Map.Entry<String, String> style : options.entrySet()){
				items[i] = style.getKey();
				i++;				
			}
			
			jcb = new JComboBox<String>(items);
			add(jcb);
		} catch (InvocationTargetException | IllegalAccessException | InstantiationException | IllegalArgumentException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
			
	}

}
