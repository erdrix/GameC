package gui;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.TreeMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;


@SuppressWarnings("serial")
public class IntervallePanel extends JPanel{
	private JLabel jl;
	private JSlider js;
	
	public IntervallePanel(TreeMap<String,String> type){
		jl = new JLabel(type.get("label"));
		add(jl);		
		try {
			Constructor<?> constructors = 
					Class.forName("supply.S"+type.get("classe"))
					.getDeclaredConstructor(float.class); 
			Object obj = constructors.newInstance(0.f);
			Method getIntervalle = 
					Class.forName("supply.S"+type.get("classe"))
					.getDeclaredMethod(type.get("methods"));
			int[] limits = (int[])getIntervalle.invoke(obj);
			
			int ecart = limits[1]-limits[0];
			js = new JSlider(limits[0],limits[1]);
			js.setMajorTickSpacing(ecart/4);
			js.setMinorTickSpacing(ecart/20);
			js.setPaintTicks(true);
			js.setPaintLabels(true);
			add(js);
		} catch (InvocationTargetException | IllegalAccessException | InstantiationException | IllegalArgumentException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
