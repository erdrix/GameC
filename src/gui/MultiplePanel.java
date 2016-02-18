package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class MultiplePanel extends JPanel {
	private String classe;
	private JLabel jl;
	private ButtonGroup bg;
	private JPanel jp;
	
	@SuppressWarnings("unchecked")
	public MultiplePanel(TreeMap<String,String> type){
		classe = type.get("classe");
		bg = new ButtonGroup();
		jl = new JLabel(type.get("label"));
		add(jl);		
		
		try {
			Constructor<?> constructors = 
					Class.forName(("supply.S"+type.get("classe")).replace("DStoryType","SStoryType"))
					.getDeclaredConstructor(String[].class);
			Object[] def = {new String[2]};
			Object obj = constructors.newInstance(def);
			Method getOptions = 
					Class.forName("supply.S"+type.get("classe"))
					.getDeclaredMethod(type.get("methods"));
			ArrayList<String> options = (ArrayList<String>) getOptions.invoke(obj);
			jp = new JPanel();
			jp.setLayout(new GridLayout(2,options.size()));
			Integer i = 0;
			int[] value = new int[options.size()];
			for(int k = 0 ; k < value.hashCode(); k++) value[k]=0;
			UserPanel.custom_demand.setField(classe, value);
			for(String s : options){
				JCheckBox jcb = new JCheckBox(s);
				jcb.setActionCommand(i.toString());
				jcb.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						Integer selection =  Integer.valueOf(jcb.getActionCommand());
						value[selection] = (value[selection]+1)%2;
						UserPanel.custom_demand.setField(classe, value);
						for(int valeur : value){
							System.out.println(valeur);
						}
					}
					
				});
				bg.add(jcb);
				jp.add(jcb);
				i++;		
			}
			add(jp);
			
		} catch (InvocationTargetException | IllegalAccessException | InstantiationException | IllegalArgumentException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
