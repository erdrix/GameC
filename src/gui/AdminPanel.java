package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import bd.Connexion;
import supply.Supply;

@SuppressWarnings("serial")
public class AdminPanel extends JPanel {
	private HeadPanel head;
	@SuppressWarnings("unused")
	private Dimension dim;
	private Connexion connexion;
	private HomeFrame frame;
	public AdminPanel(){
		
	}
	public AdminPanel(Dimension d, Connexion c, HomeFrame f){
		connexion = c;
		frame = f;
		connexion.connect();
		ArrayList<Supply> supplies = connexion.getSupply();
		
	    //On définit le layout en lui indiquant qu'il travaillera en ligne
		dim = new Dimension(d);
		setLayout(new BorderLayout());
		
	    head = new HeadPanel(d, "Administration des offres",new Color(181,94,94), frame );
	    
		// Définition des listes des offres
	    JPanel body = new JPanel();
       
	    body.setPreferredSize(new Dimension((int) d.getWidth()-25, supplies.size()*270));
	    body.setLayout(new GridLayout(supplies.size(),1));
	    connexion.close();
	    for(Supply s : supplies){SupplyPanel offre = new SupplyPanel(s, d, connexion, frame);body.add(offre);}

	    JButton add = new JButton("AJOUTER");
	    add.setPreferredSize(new Dimension((int) (d.getWidth()-2),28));
	    add.setHorizontalAlignment(JLabel.CENTER);
	    add.setVerticalAlignment(JLabel.CENTER);
	    add.setBackground(new Color(128,214, 160)); add.setForeground(Color.WHITE);
	    add.setFont(new Font("Segoe UI", Font.BOLD, 14));add.setFocusPainted(false);
	    JScrollPane sSupplies = new JScrollPane(body);
	    sSupplies.getVerticalScrollBar().setUnitIncrement(16);
	    add(head, BorderLayout.NORTH); add(sSupplies, BorderLayout.CENTER); add(add, BorderLayout.SOUTH);

	    add.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		FrameSupply fs = new FrameSupply(connexion, frame, new Supply());
	    		fs.setVisible(true);
	    	}
	    });
	}
}
