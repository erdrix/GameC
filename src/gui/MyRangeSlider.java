package gui;


import java.awt.Dimension;

import com.jidesoft.swing.RangeSlider;

public class MyRangeSlider extends RangeSlider{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MyRangeSlider(int min, int max, int x, int y ){
		super(min,max,x,y);
		setMajorTickSpacing(25);	
		setMinorTickSpacing(5);
		setPaintTicks(true);
		setPaintLabels(true);
		setPreferredSize(new Dimension(200,50));
	}

		
}
