package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StylePanel extends JPanel {
	private JLabel jl;
	private JComboBox<String> jcb;
	
	@SuppressWarnings({ "unchecked", "unused" })
	public StylePanel(TreeMap<String,String> type){
		
		jl = new JLabel(type.get("label"));
		add(jl);
		try {
			Constructor<?> constructors = 
					Class.forName("supply.S"+type.get("classe"))
					.getDeclaredConstructor(String.class); 
			Object obj = constructors.newInstance("");
			Method getOptions = 
					Class.forName("supply.S"+type.get("classe"))
					.getDeclaredMethod(type.get("methods"));
			TreeMap<String, String> options = (TreeMap<String, String>) getOptions.invoke(obj);
			String[] items;
			int i = 0 ;
			int size = 0;
			for(Map.Entry<String, String> style : options.entrySet()){
				size = size ++;
			}
			System.out.println("size : "+size);
			items = new String[5];
			i = 0;
			for(Map.Entry<String, String> style : options.entrySet()){
				items[i] = style.getKey();
				i++;				
			}
			jcb = new JComboBox<String>(items);
			jcb.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					String item = (String) jcb.getSelectedItem();
					System.out.println(item);
					UserPanel.custom_demand.setField(type.get("classe"), item);
				}
				
			});
			add(jcb);
		} catch (InvocationTargetException | IllegalAccessException | InstantiationException | IllegalArgumentException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
			
	}

}
