package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import bd.Connexion;
import supply.Supply;

@SuppressWarnings("serial")
public class AdminPanel extends JPanel {
	private JLabel admintext;
	private JPanel head;

	private Dimension dim;
	public AdminPanel(Dimension d, Connexion connexion){
		connexion.connect();
		ArrayList<Supply> supplies = connexion.getSupply();
		
	    //On définit le layout en lui indiquant qu'il travaillera en ligne
		dim = d;
		setLayout(new BorderLayout());
	    head = new JPanel();
	    head.setPreferredSize(new Dimension((int) d.getWidth()-2,60));
		JPanel header = new JPanel();
		
		// Définition du header.
		header.setBackground(new Color(181,94,94));
		int headerSize = (int) ((80*head.getPreferredSize().getWidth()-2)/100);
		header.setLayout(new FlowLayout());
		JLabel title = new JLabel("Administration des offres");
		title.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		header.setPreferredSize(new Dimension( headerSize,60));
		title.setForeground(Color.WHITE);
		title.setPreferredSize(new Dimension (headerSize, 50));
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);
		header.add(title);
		
		
		// Définition du retour
		JPanel retour = new JPanel();
		retour.setBackground(new Color(67,60,60));
		retour.setPreferredSize(new Dimension((int) (head.getPreferredSize().getWidth()-headerSize-10),60));
		// On définit le Layout manager
		head.setLayout(new GridBagLayout());
		
		// L'objet servant à positionner les composants
		GridBagConstraints gbc = new GridBagConstraints();
		
		// On positionne la case de départ du composant
		gbc.gridx = 0;
		gbc.gridy = 0;
		// La taille en hauteur et en largeur
		gbc.gridheight = 1;
		gbc.gridwidth = 4;
		//gbc.fill = GridBagConstraints.BOTH;
		head.add(header,gbc);
		
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets.left = 2;
		gbc.gridx = 4;
		//gbc.fill = GridBagConstraints.BOTH;
		head.add(retour, gbc);	

	    
		// Définition des listes des offres
	    JPanel body = new JPanel();
       
	    body.setPreferredSize(new Dimension((int) d.getWidth()-25, supplies.size()*270));
	    body.setLayout(new GridLayout(supplies.size(),1));
	    connexion.close();
	    for(Supply s : supplies)
	    {
	    	//Supply s = supplies.get(2);
	    	SupplyPanel offre = new SupplyPanel(s, d);body.add(offre);
	    	
	    }

	    JScrollPane sSupplies = new JScrollPane(body);
	    add(head, BorderLayout.NORTH); add(sSupplies, BorderLayout.CENTER); 
	    
	    //On positionne maintenant ces trois lignes en colonne
	    
	    /*
		admintext = new JLabel("ADMINISTRATION");
		add(admintext);
		JPanel jp = new JPanel();
		JButton ad = new JButton("admin");
		jp.add(ad);
		add(jp);*/
	}
}
