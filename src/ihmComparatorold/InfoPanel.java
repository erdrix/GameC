package ihmComparatorold;

import java.lang.reflect.Field;

import javax.swing.JPanel;

public class InfoPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	public InfoPanel(String[] criterions){
		// R�cup�ration du nom de chaque attribut
			Field[] field;
			String[] fname_array;
			try {
				field = Class.forName("demand.Demand").getDeclaredFields();
				fname_array = new String[field.length];
				int i = 0;
				for(Field f : field){
					String[] temp = f.getType().toString().split("demand.");
					temp = temp[1].split(";");
					fname_array[i] = temp[0];
					i++;
				}
				for(i = 0; i < criterions.length; i++ ){
					for(int j = 0; j < fname_array.length; j++){
						if(criterions[i].equals(fname_array[j])) System.out.println(criterions[i]+"!");
					}
				}
				
				
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
