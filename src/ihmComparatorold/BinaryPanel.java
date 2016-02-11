package ihmComparatorold;

import java.lang.reflect.Field;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class BinaryPanel extends JPanel{

	private JRadioButton jrb;
	private static final long serialVersionUID = 1L;
	public BinaryPanel(String classname){
		try {
			Field [] fields = Class.forName("demand."+classname).getDeclaredFields();
			for(Field f : fields){
				jrb = new JRadioButton(f.getName());
				add(jrb);
		}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
