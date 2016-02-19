package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import supply.Supply;

@SuppressWarnings("serial")
public class SMultiplePanel extends JPanel{
	private JLabel jl;
	private String classe;
	private ArrayList<JCheckBox> jb;
	private Supply supply;
	private String meth;
	@SuppressWarnings("unchecked")
	public SMultiplePanel(JButton save, TreeMap<String, String> t, Supply s)
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
		jb = new ArrayList<>(); 
		try{
			Class<?> c = supply.getClass();
			Method m = c.getMethod("get"+classe);
			ArrayList<String> value = (ArrayList<String>) m.invoke(supply);
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
				}else
				{
					gbc.gridwidth = 1; gbc.gridx = c_x; c_x++;
					gbc.gridy =c_y;
				}
				JCheckBox bu = new JCheckBox(o);
				if(supply.getIdOffre()!=-1 &&value.indexOf(o)!= -1) bu.setSelected(true);
				jb.add(bu); add(bu, gbc);
			}
		}catch(Exception e){e.printStackTrace();}
		
		save.addActionListener(new ActionListener(){
			public void actionPerformed( ActionEvent e){
				Class<?> c = supply.getClass();
				try{
					Method m = c.getMethod("set"+classe, new ArrayList<String>().getClass());
					ArrayList<String> elmts = new ArrayList<>();
					for(JCheckBox r : jb)
						if(r.isSelected())
							elmts.add(r.getText());
					m.invoke(supply, elmts);
							
				}catch(Exception ex){ex.printStackTrace();}
			}
		});
	}

}
