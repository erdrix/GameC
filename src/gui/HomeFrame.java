package gui;

import java.awt.BorderLayout;
import java.awt.Font;
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
		
		// Création des éléments à afficher
		hometext = new JLabel("Comparateur de Jeux-Vidéos");
		hometext.setFont(new Font("",1,20));
		desctext = new JLabel("Créé par Alexandre Guitton et Jordan Hoareau");
		homebutton = new JButton("Démarrer");
		JPanel jp = new JPanel();
		jp.setLayout(new GridBagLayout());
	
		
	    JPanel jg = new JPanel();
	    jg.setLayout(new BoxLayout(jg, BoxLayout.PAGE_AXIS));
	    
	    // Ajout des panels pour centrer verticalement/horizontalement
		// le contenu
	    
	    // Titre
		JPanel jht = new JPanel();
		jht.add(hometext);
		jg.add(jht);
		
		// Créé
		JPanel jdt = new JPanel();
		jdt.add(desctext);
		jg.add(jdt);
		
		// Bouton de l'ambiance
		JPanel jhb = new JPanel();
		jhb.add(homebutton);
		jg.add(jhb);
		jp.add(jg);
		add(jp,BorderLayout.CENTER);
		
		
		
		setVisible(true);		
	}
	public static void main(String [] args){
		new HomeFrame();
	}
}
