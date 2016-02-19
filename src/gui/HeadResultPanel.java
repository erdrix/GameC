package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HeadResultPanel extends JPanel{
	private HomeFrame frame;
	public HeadResultPanel(Dimension d, String title, Color c, HomeFrame f)
	{
		frame = f;
	    setPreferredSize(new Dimension((int) d.getWidth()-2,60));
	    int headerSize = (int) ((80*getPreferredSize().getWidth()-2)/100);
		
	    // Définition du header.
	    HeaderPanel header = new HeaderPanel(title, c , headerSize);				
		
		// Définition du retour
		JPanel retour = new JPanel();
		JLabel rtr_lbl = new JLabel("Retour");
		rtr_lbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		rtr_lbl.setHorizontalAlignment(JLabel.CENTER);
		rtr_lbl.setVerticalAlignment(JLabel.CENTER);
		rtr_lbl.setForeground(Color.WHITE);
		rtr_lbl.setPreferredSize(new Dimension((int) ((getPreferredSize().getWidth()-2))-headerSize-30,45));
		retour.add(rtr_lbl);
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
				frame.reloadUserPanel();
				
			}
		});
	}

}
