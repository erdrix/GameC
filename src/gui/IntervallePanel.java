package gui;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.TreeMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import supply.Intervalle;


@SuppressWarnings("serial")
public class IntervallePanel extends JPanel{
	private String classe; String meth;
	private JLabel jl;
	private JSlider js;
	
	public IntervallePanel(TreeMap<String,String> type){
		classe = type.get("classe"); meth = type.get("methodOptions");
		jl = new JLabel(type.get("label")); add(jl);		
		
		try {
			Constructor<?> constructors = 
					Class.forName("supply.S"+classe).getDeclaredConstructor(float.class); 
			Object obj = constructors.newInstance(0.f);
			Method getIntervalle =  Class.forName("supply.S"+classe).getDeclaredMethod(meth);
			int[] limits = (int[])getIntervalle.invoke(obj);
			
			int ecart = limits[1]-limits[0];
			Intervalle def = new Intervalle(limits[0],ecart/2);
			UserPanel.custom_demand.setField(classe, def);
			js = new JSlider(limits[0],limits[1]);
			js.setMajorTickSpacing(ecart/4);
			js.setMinorTickSpacing(ecart/20);
			js.setPaintTicks(true);
			js.setPaintLabels(true);
			js.addChangeListener(new ChangeListener(){
				@Override
				public void stateChanged(ChangeEvent arg0) {
					int intervalle = ecart/10;
					JSlider source = (JSlider) arg0.getSource();
					int value = source.getValue();
					float min = (float)value - intervalle;
					float max = (float)value + intervalle; 
					
					UserPanel.custom_demand.setField(classe, new Intervalle(min,max));
					
					
				}
				
			});
			add(js);
		} catch (InvocationTargetException | IllegalAccessException | InstantiationException | IllegalArgumentException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
