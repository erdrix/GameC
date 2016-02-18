package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import supply.Supply;

public class SStylePanel extends JPanel{
	private JLabel jl;
	private String classe;
	private Supply supply;
	private String meth;
	private JComboBox<String> jcb;
	@SuppressWarnings("unchecked")
	public SStylePanel(JButton save, TreeMap<String, String> t, Supply s)
	{
		jl = new JLabel(t.get("label"));
		classe = t.get("classe");
		meth = t.get("methodOptions");
		supply = s;
		add(jl);
		try{
			Class<?> c = supply.getClass();
			Method m = c.getMethod("get"+classe);
			String value = (String) m.invoke(supply);
			Method getOption = Class.forName("supply.S"+classe).getDeclaredMethod(meth);
			TreeMap<String, String> options = (TreeMap<String, String>) getOption.invoke(supply);
			Set<String> keys = options.keySet();
			String[] tab = new String[keys.size()];
			keys.toArray(tab);
			jcb = new JComboBox<String>(tab);
			jcb.setSelectedItem(value);
			add(jcb);
			
			save.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					Class<?> c = supply.getClass();
					try {
						Method m = c.getMethod("set"+classe, String.class);
						m.invoke(supply, (String) jcb.getSelectedItem());
					} catch (Exception et) {et.printStackTrace();}
				}
				
			});
		}catch(Exception e){e.printStackTrace();}
	}
	
}
