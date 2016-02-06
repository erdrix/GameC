package gui;

import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HomePanel extends JPanel{
	private JLabel hometext;
	private JLabel desctext;
	public JButton homebutton;
	public HomePanel(){
		// Création des éléments à afficher
		hometext = new JLabel("Comparateur de Jeux-Vid�os");
		hometext.setFont(new Font("",1,20));
		desctext = new JLabel("Cr�� par Alexandre Guitton et Jordan Hoareau");
		homebutton = new JButton("D�marrer");
		setLayout(new GridBagLayout());
	
		
	    JPanel jg = new JPanel();
	    jg.setLayout(new BoxLayout(jg, BoxLayout.PAGE_AXIS));
	    
	    // Ajout des panels pour centrer verticalement/horizontalement
		// le contenu
	    
	    // Titre
		JPanel jht = new JPanel();
		jht.add(hometext);
		jg.add(jht);
		
		// Cr�� par
		JPanel jdt = new JPanel();
		jdt.add(desctext);
		jg.add(jdt);
		
		// Bouton de l'ambiance
		JPanel jhb = new JPanel();
		jhb.add(homebutton);
		jg.add(jhb);
		add(jg);
	}
}
