package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import supply.Supply;

@SuppressWarnings("serial")
public class SEcartPanel extends JPanel{
	private JLabel jl;
	private String classe;
	private ButtonGroup gp;
	private ArrayList<JRadioButton> jb;
	private Supply supply;
	private String meth;
	@SuppressWarnings("unchecked")
	public SEcartPanel(JButton save, TreeMap<String, String> t, Supply s)
	{
		jl = new JLabel(t.get("label"));
		classe = t.get("classe");
		meth = t.get("methodOptions");
		supply = s;
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());
		gbc.gridx = 0; gbc.gridy = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight =1;
		gbc.anchor = GridBagConstraints.WEST;
		add(jl, gbc);
		jb = new ArrayList<>(); gp = new ButtonGroup();
		try{
			Class<?> c = supply.getClass();
			Method m = c.getMethod("get"+classe);
			String value = (String) m.invoke(supply);
			Method getOption = Class.forName("supply.S"+classe).getDeclaredMethod(meth);
			ArrayList<String> options = (ArrayList<String>) getOption.invoke(supply);
			
			int c_x = 0; int c_y = 1;
			for(String o : options)
			{
				if(c_x == 1)
				{
					gbc.gridwidth = GridBagConstraints.REMAINDER;
					gbc.gridx = c_x; gbc.gridy = c_y;
					c_x = 0; c_y++;
					System.out.println(c_y);
				}else
				{
					gbc.gridwidth = 1; gbc.gridx = c_x; c_x++;
					gbc.gridy =c_y;
				}
				JRadioButton bu = new JRadioButton(o);
				if(o.equals(value)) bu.setSelected(true);
				jb.add(bu); gp.add(bu); add(bu, gbc);
			}
		}catch(Exception e){e.printStackTrace();}
		
		save.addActionListener(new ActionListener(){
			public void actionPerformed( ActionEvent e){
				Class<?> c = supply.getClass();
				try{
					Method m = c.getMethod("set"+classe, String.class);
					for(JRadioButton r : jb)
						if(r.isSelected())
							m.invoke(supply, (String) r.getSelectedObjects()[0]);
				}catch(Exception ex){ex.printStackTrace();}
			}
		});
	}
}
