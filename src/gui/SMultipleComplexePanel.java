package gui;

import java.awt.Dimension;
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
	private String classe, meth, methChoix;
	private ArrayList<JCheckBox> jb;
	private TreeMap<String, JList<String>> jList;
	private Supply supply;
	@SuppressWarnings("unchecked")
	public SMultipleComplexePanel(JButton save, TreeMap<String, String> t, Supply s)
	{
		classe = t.get("classe"); meth = t.get("methodOptions"); methChoix = t.get("methodChoix");
		jl = new JLabel(t.get("label"));
		jList = new TreeMap<>();
		supply = s;
		
		jb = new ArrayList<>(); 
		try{
			Class<?> c = supply.getClass();
			Method m = c.getMethod("get"+classe);
			TreeMap<String, ArrayList<TreeMap<String, String>>> value = (TreeMap<String, ArrayList<TreeMap<String, String>>>) m.invoke(supply);
			Method getChoix = Class.forName("supply.S"+classe).getDeclaredMethod(methChoix);
			Method getOption = Class.forName("supply.S"+classe).getDeclaredMethod(meth);

			ArrayList<String> options = (ArrayList<String>) getOption.invoke(supply);
			TreeMap<String, ArrayList<TreeMap<String, String>>> choix = (TreeMap<String, ArrayList<TreeMap<String, String>>>) getChoix.invoke(supply);
			boolean test =false;
			setLayout(new GridLayout( (int) Math.ceil(options.size()+1/2.0),2));
			add(jl);
			for(String o : options)
			{
				test = false;
				
				JPanel pan = new JPanel();
				ArrayList<TreeMap<String, String>> elmts = choix.get(o);
				
				
				// Boutton de premier niveau
				JCheckBox bu = new JCheckBox(o);pan.add(bu);
				if(supply.getIdOffre() != -1 && value.containsKey(o))
				{
					bu.setSelected(true);
					test = true;
				}
				
				// Pour chaque elements possibles 
				String[] elmt = new String[elmts.size()];
				int cpt = 0;
				for(TreeMap<String, String> e : elmts)
				{
					elmt[cpt] = e.get(t.get("premier"))+" ["+e.get(t.get("deuxieme"))+"]";
					cpt++;
				}
				
				JList<String> list = new JList<>(elmt);
				list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				list.setLayoutOrientation(JList.VERTICAL);
				if(!test) list.setEnabled(false); jList.put(o, list);
				JScrollPane js = new JScrollPane(list);
				js.setPreferredSize(new Dimension(170,25));
				pan.add(js);
				ArrayList<Integer> items = new ArrayList<>();
				if(supply.getIdOffre()!=-1 && value.get(o) != null)
					for(TreeMap<String, String> v : value.get(o))
					{
						for(int i = 0; i< elmt.length; i++)
							if(elmt[i].equals(v.get(t.get("premier"))+" ["+v.get(t.get("deuxieme"))+"]"))
								items.add(i);						
					}
				int[] tab = new int[items.size()];
				for(int i = 0; i< items.size(); i++)
					tab[i]=items.get(i);
					
				list.setSelectedIndices(tab);
				bu.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						if (bu.isSelected())
							list.setEnabled(true);
						else 
							list.setEnabled(false);
					}
				});
				
				jb.add(bu); add(pan);
			}
			
			
		}catch(Exception e){e.printStackTrace();}
		
		save.addActionListener(new ActionListener(){
			public void actionPerformed( ActionEvent e){
				
				Class<?> c = supply.getClass();
				try{
					Method m = c.getMethod("set"+classe, new ArrayList<TreeMap<String, String>>().getClass());
					ArrayList<TreeMap<String, String>> elmts = new ArrayList<>();
					for(JCheckBox r : jb)
						if(r.isSelected())
						{
							String s;
							String[] contenu = new String[2];
							
							for(int i : jList.get(r.getText()).getSelectedIndices())
							{
								s = jList.get(r.getText()).getModel().getElementAt(i);
								s = s.replace("[", ""); s = s.replace("]", "");
								contenu = s.split(" ");
								TreeMap<String, String> crit = new TreeMap<>();
								crit.put(t.get("premier"), contenu[0]);
								crit.put(t.get("deuxieme"), contenu[1]);
								crit.put("type", r.getText());
								System.out.println(crit);
								elmts.add(crit);
							}
						}
					m.invoke(supply, elmts);
							
				}catch(Exception ex){ex.printStackTrace();}
			}
		});
	}
}
