package gui;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class GUIMainFrame extends JFrame{
	protected static Dimension d;
	public GUIMainFrame(){
		// Création de la fenêtre du programme avec ses dimensions
		setLayout(new BorderLayout() );
		Toolkit tk = Toolkit.getDefaultToolkit();
		d = tk.getScreenSize();
		int w = 850;
		int h = 800;
		int x = (int)d.getWidth()/2 - w/2;
		int y = (int)d.getHeight()/2 - h/2;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x,y,w,h);
		d.setSize(new Dimension(w,h));
		setResizable(false);
		setTitle("Le Hoatton");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//pack();	
	}
}
