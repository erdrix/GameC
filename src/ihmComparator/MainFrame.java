package ihmComparator;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTabbedPane jtb;
	
	public MainFrame(){
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int l = d.width/2 - 150;
		int h = d.height/2 - 150;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(l/2,h/2,600,800);
		setResizable(false);
		setTitle("Le Hoatton");
		jtb = new JTabbedPane();
		// Ajout des onglets dans l'interface
		jtb.addTab("Comparateur", new CompPanel());	
		jtb.addTab("Administration", new AdminPanel());
		add(jtb);
		pack();
		setVisible(true);		
	}
	
	public static void main(String[] args){
		new MainFrame();
	}
}
