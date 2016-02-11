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
	    int headerSize = (int) ((80*head.getPreferredSize().getWidth()-2)/100);
		
	    // Définition du header.
	    HeaderPanel header = new HeaderPanel("Administration des offres", new Color(181,94,94), headerSize);				
		
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
	    for(Supply s : supplies){SupplyPanel offre = new SupplyPanel(s, d, connexion);body.add(offre);}

	    JButton add = new JButton("AJOUTER");
	    add.setPreferredSize(new Dimension((int) (d.getWidth()-2),28));
	    add.setHorizontalAlignment(JLabel.CENTER);
	    add.setVerticalAlignment(JLabel.CENTER);
	    add.setBackground(new Color(128,214, 160)); add.setForeground(Color.WHITE);
	    add.setFont(new Font("Segoe UI", Font.BOLD, 14));add.setFocusPainted(false);
	    JScrollPane sSupplies = new JScrollPane(body);
	    add(head, BorderLayout.NORTH); add(sSupplies, BorderLayout.CENTER); add(add, BorderLayout.SOUTH);
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
