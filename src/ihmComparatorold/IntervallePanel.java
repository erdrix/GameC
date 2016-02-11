package ihmComparatorold;


import javax.swing.JPanel;

import gui.MyRangeSlider;


public class IntervallePanel extends JPanel{
	/**
	 * 
	 */
	private MyRangeSlider mrs;
	
	private static final long serialVersionUID = 1L;

	public IntervallePanel(String classname){
		if(classname.equals("DPrice")){
			mrs = new MyRangeSlider(0,100,25,50);
			mrs.setMajorTickSpacing(25);	
			mrs.setMinorTickSpacing(5);
			mrs.setPaintTicks(true);
			mrs.setPaintLabels(true);	
			add(mrs);
		}
		
		if(classname.equals("DReleaseDate")){
			mrs = new MyRangeSlider(1950,2020,1975,2000);
			mrs.setMajorTickSpacing(35);
			mrs.setMinorTickSpacing(5);
			mrs.setPaintTicks(true);
			mrs.setPaintLabels(true);		
			add(mrs);
		}
		
		if(classname.equals("DMark")){
			mrs = new MyRangeSlider(0,20,0,10);
			mrs.setMajorTickSpacing(5);
			mrs.setMinorTickSpacing(1);
			mrs.setPaintTicks(true);
			mrs.setPaintLabels(true);		
			add(mrs);
		}
	}
}
	
