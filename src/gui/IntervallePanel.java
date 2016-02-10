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
	private JSlider mrs;
	
	public IntervallePanel(TreeMap<String,String> t){
		jl = new JLabel(t.get("label"));
		add(jl);		
		try {
			Constructor<?> constructors = 
					Class.forName("supply."+t.get("classe").replace("DRelease","SRelease").replace("DMark","SMark").replace("DPrice", "SPrice"))
					.getDeclaredConstructor(float.class); 
			Object obj = constructors.newInstance(0.f);
			Method getIntervalle = 
					Class.forName("supply."+t.get("classe").replace("DRelease","SRelease").replace("DMark", "SMark").replace("DPrice", "SPrice"))
					.getDeclaredMethod(t.get("methods"));
			int[] limits = (int[])getIntervalle.invoke(obj);
			
			int ecart = limits[1]-limits[0];
			System.out.println(limits[0]+" "+limits[1]);
			mrs = new JSlider(limits[0],limits[1]);
			mrs.setMajorTickSpacing(ecart/4);
			mrs.setMinorTickSpacing(ecart/20);
			mrs.setPaintTicks(true);
			mrs.setPaintLabels(true);
			add(mrs);
		} catch (InvocationTargetException | IllegalAccessException | InstantiationException | IllegalArgumentException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
