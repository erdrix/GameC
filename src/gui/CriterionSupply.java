package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import supply.Supply;

@SuppressWarnings("serial")
public class CriterionSupply extends JPanel{
	private static ArrayList<TreeMap<String, String>> elements;
	
	public CriterionSupply(){super();}
	public CriterionSupply(JButton save, String name, String[] infos, Supply s)
	{
		TitledBorder tb = BorderFactory.createTitledBorder(name);
		setBorder(tb);
		setLayout(new GridLayout(infos.length/2,2));
		for(String i : infos)
		{
			if(i.equals("Quantite"))
			{
				JPanel pan = new JPanel();add(pan);
				JLabel jl = new JLabel("Quantite : ");pan.add(jl);
				JTextField jtf = new JTextField(12);
				jtf.setText(""+s.getQuantite()); pan.add(jtf);				
				save.addActionListener(new ActionListener(){
					public void actionPerformed( ActionEvent e)
					{
						Class<?> c = s.getClass();
						try {
							Method m = c.getMethod("setQuantite", int.class);
							m.invoke(s, Integer.parseInt(jtf.getText()));
						} catch (Exception et) {et.printStackTrace();}
					}
				});
				jtf.getDocument().addDocumentListener(new DocumentListener(){

					@Override
					public void changedUpdate(DocumentEvent arg0) {
						
					}

					@Override
					public void insertUpdate(DocumentEvent arg0) {
						if(!(0<=Float.parseFloat(jtf.getText())))
						{
							save.setEnabled(false);
							jtf.setBorder(BorderFactory.createLineBorder(Color.RED));
						}
						else
						{
							jtf.setBorder( UIManager.getBorder("TextField.border") );
							save.setEnabled(true);
						}						
					}

					@Override
					public void removeUpdate(DocumentEvent arg0) {
						if(!(0<=Float.parseFloat(jtf.getText())))
						{
							save.setEnabled(false);
							jtf.setBorder(BorderFactory.createLineBorder(Color.RED));
						}
						else
						{
							jtf.setBorder( UIManager.getBorder("TextField.border") );
							save.setEnabled(true);
						}
					}
				});
			}
			else if(i.equals("Image"))
			{
				JPanel pan = new JPanel();add(pan);
				JLabel jl = new JLabel("Url Image : ");pan.add(jl);
				JTextField jtf = new JTextField(12);
				jtf.setText(s.getImage()); pan.add(jtf);
				save.addActionListener(new ActionListener(){
					public void actionPerformed( ActionEvent e)
					{
						Class<?> c = s.getClass();
						try {
							Method m = c.getMethod("setImage", String.class);
							m.invoke(s, jtf.getText());
						} catch (Exception et) {et.printStackTrace();}
					}
				});
			}
			else
			{
				String type = getType(i);
				try{
					
					Constructor<?> constructors = Class.forName("gui.S"+type+"Panel").getDeclaredConstructor((new JButton()).getClass(), (new TreeMap<>()).getClass(), s.getClass());
					for(TreeMap<String, String> value : elements)
					{
						if(i.equals(value.get("classe")))
						{
							Component c = (Component) constructors.newInstance(save, value, s);
							add(c);
						}
					}
				}catch(Exception e){e.printStackTrace();}
			}
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
	
}
