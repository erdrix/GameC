package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HomeFrame extends GUIMainFrame{

	private JLabel hometext;
	private JLabel desctext;
	private JButton homebutton;
	
	public HomeFrame(){
		super();
		setLayout(new BorderLayout() );
		hometext = new JLabel("Comparateur de Jeux-Vidéos");
		hometext.setFont(new Font("",1,20));
		desctext = new JLabel("Créé par Alexandre Guitton et Jordan Hoareau");
		homebutton = new JButton("Démarrer");
		JPanel jp = new JPanel();
		jp.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();    
		gbc.anchor = GridBagConstraints.CENTER;
	    gbc.weighty = 1;
	    JPanel jg = new JPanel();
	    jg.setLayout(new BoxLayout(jg, BoxLayout.PAGE_AXIS));
		JPanel jht = new JPanel();
		jht.add(hometext);
		jg.add(jht);
		JPanel jdt = new JPanel();
		jdt.add(desctext);
		jg.add(jdt);
		JPanel jhb = new JPanel();
		jhb.add(homebutton);
		jg.add(jhb);
		
		jp.add(jg);
		add(jp,BorderLayout.CENTER);
		setVisible(true);

		//add(homebutton);
		
	}
	public static void main(String [] args){
		new HomeFrame();
	}
}
