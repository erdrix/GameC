package gui;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.TreeMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import supply.SBuyMethod;
import supply.SGameType;

@SuppressWarnings("serial")
public class BinaryPanel extends JPanel {
	private JLabel jl;
	private JSlider js;
	@SuppressWarnings("unchecked")
	public BinaryPanel(TreeMap<String,String> type){

		SGameType.Init("Hors Ligne", "En Ligne");
		SBuyMethod.Init("Abonnement", "Licence", "Gratuit");
		jl = new JLabel(type.get("label"));
		add(jl);
		try {
			Constructor<?> constructors = 
					Class.forName("supply."+type.get("classe").replace("DBuyMethod","SBuyMethod").replace("DGameType","SGameType"))
					.getDeclaredConstructor(String.class); 
			Object obj = constructors.newInstance("");
			Method getOptions = 
					Class.forName("supply."+type.get("classe").replace("DBuyMethod","SBuyMethod").replace("DGameType","SGameType"))
					.getDeclaredMethod(type.get("methods"));
			ArrayList<String> options = (ArrayList<String>) getOptions.invoke(obj);
			HashSet<String> tri = new HashSet<>(options);
			options = new ArrayList<String>(tri);
			
			js = new JSlider(0,options.size()-1);
			Hashtable<Integer,JLabel> labelTable = new Hashtable<>();
			int i = 0;
			for(String s : options){
				//float index = (float)i/options.size();
				System.out.println(s+" à " +(int) i);
				labelTable.put(new Integer(i), new JLabel(s));
				i++;
			}
			js.setLabelTable(labelTable);
			js.setMajorTickSpacing(1);
			js.setPaintTicks(true);
			js.setPaintLabels(true);
			add(js);
		} catch (InvocationTargetException | IllegalAccessException | InstantiationException | IllegalArgumentException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
