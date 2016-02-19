package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import supply.Supply;

@SuppressWarnings("serial")
public class SKeywordPanel extends JPanel{
	private JLabel jl;
	private String classe;
	private JTextField jtf;
	private Supply supply;
	
	public SKeywordPanel(JButton save, TreeMap<String, String> t, Supply s)
	{
		jl = new JLabel(t.get("label")); add(jl);
		classe = t.get("classe");
		supply = s;
		
		try {
			Class<?> c = supply.getClass();
			Method m = c.getMethod("get"+classe);
			String value = (String) m.invoke(supply);
			jtf = new JTextField(12);
			jtf.setText(value);
			add(jtf);
			
		} catch (Exception e) {e.printStackTrace();} 
		
		save.addActionListener(new ActionListener(){
			public void actionPerformed( ActionEvent e)
			{
				Class<?> c = supply.getClass();
				try {
					Method m = c.getMethod("set"+classe, String.class);
					m.invoke(supply, jtf.getText());
				} catch (Exception et) {et.printStackTrace();}
			}
		});
	}
}
