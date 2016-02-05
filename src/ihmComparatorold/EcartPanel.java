package ihmComparatorold;

import javax.swing.JPanel;
import javax.swing.JSlider;

public class EcartPanel extends JPanel{


	private JSlider js;
	private static final long serialVersionUID = 1L;
	public EcartPanel(String classname){
		if(classname.equals("DLifeTime") || classname.equals("DDifficulty")){
			js = new JSlider(0,4,0);
			add(js);
		}
	}

}
