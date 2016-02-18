package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import supply.Supply;

@SuppressWarnings("serial")
public class SMultipleComplexePanel extends JPanel{
	private JLabel jl;
	private String classe;
	private ArrayList<JCheckBox> jb;
	private Supply supply;
	private String meth;
	private String methChoix;
	@SuppressWarnings("unchecked")
	public SMultipleComplexePanel(JButton save, TreeMap<String, String> t, Supply s)
	{
		jl = new JLabel(t.get("label"));
		classe = t.get("classe");
		meth = t.get("methodOptions"); methChoix = t.get("methodChoix");
		this.setPreferredSize(new Dimension(300,100));
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
			TreeMap<String, ArrayList<TreeMap<String, String>>> value = (TreeMap<String, ArrayList<TreeMap<String, String>>>) m.invoke(supply);
			System.out.println("Supply.S"+classe+"  "+methChoix);
			Method getChoix = Class.forName("supply.S"+classe).getDeclaredMethod(methChoix);
			Method getOption = Class.forName("supply.S"+classe).getDeclaredMethod(meth);

			ArrayList<String> options = (ArrayList<String>) getOption.invoke(supply);
			TreeMap<String, ArrayList<TreeMap<String, String>>> choix = (TreeMap<String, ArrayList<TreeMap<String, String>>>) getChoix.invoke(supply);
			System.out.println(choix);
			int c_x = 0; int c_y = 1;
			boolean test =false;
			for(String o : options)
			{
				test = false;
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
				JPanel pan = new JPanel();
				ArrayList<TreeMap<String, String>> elmts = choix.get(o);
				
				pan.setLayout(new GridLayout(2,1));
				pan.setPreferredSize(new Dimension(300, 100));
				// Boutton de premier niveau
				JCheckBox bu = new JCheckBox(o);pan.add(bu);
				if(value.containsKey(o))
				{
					bu.setSelected(true);
					test = true;
				}
				
				// Pour chaque elements possibles 
				
				String[] elmt = new String[elmts.size()];
				int cpt = 0;
				for(TreeMap<String, String> e : elmts)
				{
					elmt[cpt] = e.get(t.get("premier"))+"["+e.get(t.get("deuxieme"))+"]";
					cpt++;
				}
				
				JList<String> list = new JList<>(elmt);
				list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				list.setLayoutOrientation(JList.VERTICAL);
				JScrollPane js = new JScrollPane(list);
				bu.setPreferredSize(new Dimension(300, 50));
				js.setPreferredSize(new Dimension(300, 50));
				pan.add(js);
				
				jb.add(bu); add(pan, gbc);
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
