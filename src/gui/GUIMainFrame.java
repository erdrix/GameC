package gui;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class GUIMainFrame extends JFrame{
	public GUIMainFrame(){
		setLayout(new BorderLayout() );
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int w = 500;
		int h = 400;
		int x = (int)d.getWidth()/2 - w/2;
		int y = (int)d.getHeight()/2 - h/2;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x,y,w,h);
		setResizable(false);
		setTitle("Le Hoatton");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//pack();	
	}
}
