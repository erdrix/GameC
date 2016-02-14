package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class HeadPanel extends JPanel{
	private HomeFrame frame;
	public HeadPanel(Dimension d, String title, Color c, HomeFrame f)
	{
		frame = f;
	    setPreferredSize(new Dimension((int) d.getWidth()-2,60));
	    int headerSize = (int) ((80*getPreferredSize().getWidth()-2)/100);
		
	    // Définition du header.
	    HeaderPanel header = new HeaderPanel(title, c , headerSize);				
		
		// Définition du retour
		JPanel retour = new JPanel();
		retour.setBackground(new Color(67,60,60));
		retour.setPreferredSize(new Dimension((int) (getPreferredSize().getWidth()-headerSize-10),60));
		// On définit le Layout manager
		setLayout(new GridBagLayout());
		
		// L'objet servant à positionner les composants
		GridBagConstraints gbc = new GridBagConstraints();
		
		// On positionne la case de départ du composant
		gbc.gridx = 0;
		gbc.gridy = 0;
		// La taille en hauteur et en largeur
		gbc.gridheight = 1;
		gbc.gridwidth = 4;
		//gbc.fill = GridBagConstraints.BOTH;
		add(header,gbc);
		
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets.left = 2;
		gbc.gridx = 4;
		//gbc.fill = GridBagConstraints.BOTH;
		add(retour, gbc);
		
		retour.addMouseListener( new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				System.out.println("test");
				frame.reloadMenuPanel();
				
			}
		});
	}

}
