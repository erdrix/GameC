package gui;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.TreeMap;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class EcartPanel extends JPanel {
	private JLabel jl;
	private String classe, meth;
	private JSlider js;
	@SuppressWarnings("unchecked")
	public EcartPanel(TreeMap<String,String> type){
		classe = type.get("classe"); meth = type.get("methodOptions");
		jl = new JLabel(type.get("label"));add(jl);
		UserPanel.custom_demand.setField(classe, 0);
		
		try {
			Constructor<?> constructors = 
					Class.forName("supply.S"+classe).getDeclaredConstructor(String.class); 
			Object obj = constructors.newInstance("");
			Method getOptions = 
					Class.forName("supply.S"+classe).getDeclaredMethod(meth);
			
			ArrayList<String> options = (ArrayList<String>) getOptions.invoke(obj);
			js = new JSlider(0,options.size()-1);
			Hashtable<Integer,JLabel> labelTable = new Hashtable<>();
			
			int i = 0;
			for(String s : options){
				labelTable.put(new Integer(i), new JLabel(s)); i++;
			}
			js.setLabelTable(labelTable);
			js.setMajorTickSpacing(1);
			js.setPaintTicks(true);
			js.setPaintLabels(true);
			js.addChangeListener(new ChangeListener(){

				@Override
				public void stateChanged(ChangeEvent arg0) {
					JSlider source = (JSlider) arg0.getSource();
					int value = source.getValue();
					UserPanel.custom_demand.setField(classe, value);
				}
				
			});
			add(js);
		} catch (InvocationTargetException | IllegalAccessException | InstantiationException | IllegalArgumentException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
