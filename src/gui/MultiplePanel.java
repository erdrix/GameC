package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MultiplePanel extends JPanel {
	private String classe, meth;
	private JLabel jl;
	private JPanel jp;
	
	@SuppressWarnings("unchecked")
	public MultiplePanel(TreeMap<String,String> type){
		classe = type.get("classe"); meth = type.get("methodOptions");
		jl = new JLabel(type.get("label")); add(jl);		
		
		try {
			Constructor<?> constructors = Class.forName(("supply.S"+classe)).getDeclaredConstructor((new ArrayList<String>()).getClass());
			ArrayList<String> options = new ArrayList<>();			
			Object obj = constructors.newInstance(options);
			Method getOptions = 
					Class.forName("supply.S"+classe).getDeclaredMethod(meth);
			options = (ArrayList<String>) getOptions.invoke(obj);
			Integer i = 0;
			jp = new JPanel();
			jp.setLayout(new GridLayout(2,options.size()/2));
			ArrayList<Integer> selected_values = new ArrayList<>();
			UserPanel.custom_demand.setField(classe, selected_values);
			for(String s : options){
				JCheckBox jcb = new JCheckBox(s);
				jcb.setActionCommand(i.toString());
				jcb.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						Integer value = Integer.parseInt(jcb.getActionCommand());
						if(jcb.isSelected()){
							if(!selected_values.contains(value)) selected_values.add(value);							
						}else selected_values.remove(value);
						UserPanel.custom_demand.setField(classe, selected_values);	
					}
				});
				i++;
				jp.add(jcb); add(jp);
			}
			
		} catch (InvocationTargetException | IllegalAccessException | InstantiationException | IllegalArgumentException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
