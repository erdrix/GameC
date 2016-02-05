package ihmComparator;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabelPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LabelPanel(String classname){
		if(classname.equals("DTitle")) add(new JLabel("Titre du jeu :"));
		if(classname.equals("DDescription")) add(new JLabel("Mots-clés :"));
		if(classname.equals("DEditor")) add(new JLabel("Éditeur :"));
		if(classname.equals("DPrice")) add(new JLabel("Prix :"));
		if(classname.equals("DMark")) add(new JLabel("Note :"));
		if(classname.equals("DReleaseDate")) add(new JLabel("Date de sortie :"));
	}

}
