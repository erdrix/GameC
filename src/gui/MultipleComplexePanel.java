package gui;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class MultipleComplexePanel extends JPanel {
	private String classe, methChoix;
	private JPanel jp; 
	private ArrayList<TreeMap<String,String>> selected_accessories;
	ArrayList<String> a;
	
	@SuppressWarnings("unchecked")
	public MultipleComplexePanel(TreeMap<String,String> type){
		classe = type.get("classe"); methChoix = type.get("methodChoix");
		JLabel label = new JLabel(type.get("label"));
		jp = new JPanel();
		add(label);
		try {
			Constructor<?> constructors = 
					Class.forName(("supply.S"+classe))
					.getDeclaredConstructor( (new ArrayList<TreeMap<String, String>>()).getClass() ) ;
			TreeMap<String, ArrayList<TreeMap<String, String>>> options = new TreeMap<>();			
			Object obj = constructors.newInstance(new ArrayList<TreeMap<String, String>>());
			Method getOptions = Class.forName("supply.S"+classe).getDeclaredMethod(methChoix);
			
			options = (TreeMap<String, ArrayList<TreeMap<String, String>>>) getOptions.invoke(obj);
			
			selected_accessories = new ArrayList<TreeMap<String,String>>();
			UserPanel.custom_demand.setField(classe, selected_accessories);
			for(Map.Entry<String, ArrayList<TreeMap<String, String>>> current_accessory : options.entrySet()){
				ArrayList<String> accessories_list = new ArrayList<>(options.size());
				
				for(TreeMap<String, String> accessory_type : current_accessory.getValue()){
						accessories_list.add(accessory_type.get(type.get("premier")));
				}
				JList<Object> jl = new JList<>(accessories_list.toArray());
				jl.setSelectionModel(new DefaultListSelectionModel() {
			        private static final long serialVersionUID = 1L;

			        boolean gestureStarted = false;

			        @Override
			        public void setSelectionInterval(int index0, int index1) {
			            if(!gestureStarted){
			            if (index0==index1) {
			                if (isSelectedIndex(index0)) {
			                    removeSelectionInterval(index0, index0);
			                    return;
			                }
			            }
			            super.setSelectionInterval(index0, index1);
			            }
			            gestureStarted = true;
			        }

			        @Override
			        public void addSelectionInterval(int index0, int index1) {
			            if (index0==index1) {
			                if (isSelectedIndex(index0)) {
			                    removeSelectionInterval(index0, index0);
			                    return;
			                }
			            super.addSelectionInterval(index0, index1);
			            }
			        }

			        @Override
			        public void setValueIsAdjusting(boolean isAdjusting) {
			            if (isAdjusting == false) {
			                gestureStarted = false;
			            }
			        }

			    });
				jl.setLayoutOrientation(JList.VERTICAL);
				jl.setVisibleRowCount(4);
				selected_accessories = new ArrayList<TreeMap<String,String>>();
				jl.addListSelectionListener(new ListSelectionListener(){

					@Override
					public void valueChanged(ListSelectionEvent e) {
						// TODO Auto-generated method stub
						String current = (String) jl.getSelectedValue();	
						// Mise à jour de l'arraylist à envoyer
						int deletion_index =  -1;
						boolean havetoDelete=false;
						for(TreeMap<String,String> t : selected_accessories)
							if(t.containsValue(current)){
								deletion_index = selected_accessories.indexOf(t);
								havetoDelete = true;
							}
						if(havetoDelete) selected_accessories.remove(deletion_index);
						
						// Création du nouvel élément à ajouter
						TreeMap<String,String> new_accessory = new TreeMap<String,String>();
						new_accessory.put("type",current_accessory.getKey());
						for(TreeMap<String, String> accessory_type : current_accessory.getValue()){
							if(accessory_type.containsValue(current)){
							
								new_accessory.put(type.get("premier"), accessory_type.get(type.get("premier")));
								new_accessory.put(type.get("deuxieme"), accessory_type.get(type.get("deuxieme")));								
							}
						}
						selected_accessories.add(new_accessory);
						UserPanel.custom_demand.setField(classe, selected_accessories);
					}
					
				});
				JScrollPane listscroller = new JScrollPane(jl);
				jp.add(listscroller);
			}
			add(jp);
			
		} catch (InvocationTargetException | IllegalAccessException | InstantiationException | IllegalArgumentException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
