package gui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class IntervallePanel extends JPanel{
	private JLabel jl;
	private MyRangeSlider mrs;
	
	public IntervallePanel(String name){
		jl = new JLabel("Note : ");
		add(jl);
		mrs = new MyRangeSlider(0,20,0,10);
		mrs.setMajorTickSpacing(25);	
		mrs.setMinorTickSpacing(5);
		mrs.setPaintTicks(true);
		mrs.setPaintLabels(true);
		add(mrs);
	}
}
