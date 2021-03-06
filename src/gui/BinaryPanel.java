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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class BinaryPanel extends JPanel {
	private String classe;
	private JLabel jl;
	private ButtonGroup bg;
	private JPanel jp;
	private String meth;
	@SuppressWarnings("unchecked")
	public BinaryPanel(TreeMap<String,String> type){
		
		classe = type.get("classe"); meth = type.get("methodOptions");
		jl = new JLabel(type.get("label")); add(jl);
		try {
			Constructor<?> constructors = 
					Class.forName("supply.S"+classe).getDeclaredConstructor(String.class); 
			Object obj = constructors.newInstance("");
			Method getOptions = 
					Class.forName("supply.S"+classe).getDeclaredMethod(meth);
			ArrayList<String> options = (ArrayList<String>) getOptions.invoke(obj);
			HashSet<String> tri = new HashSet<>(options);
			options = new ArrayList<String>(tri);
			
			UserPanel.custom_demand.setField(classe, 0);
			bg = new ButtonGroup();
			Integer i = 0;
			jp = new JPanel();
			jp.setLayout(new GridLayout(2,options.size()));
			for(String s : options){
				JRadioButton jrb = new JRadioButton(s);
				jrb.setActionCommand(i.toString());
				i++;
				jrb.setSelected(true);
				jrb.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Integer value = Integer.valueOf(jrb.getActionCommand());
						UserPanel.custom_demand.setField(classe, value);	
					}	
				});
				jp.add(jrb); bg.add(jrb); add(jp);
			}
			
		} catch (InvocationTargetException | IllegalAccessException | InstantiationException | IllegalArgumentException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
