package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import supply.Supply;

public class SupplyPanel extends JPanel{
	
	private Supply supply;
	private Dimension d;
	private Color couleur;
	public SupplyPanel(Supply s, Dimension dim)
	{
		supply = s;
		d= dim;
		couleur = new Color(238,238,238);
		
		// L'objet servant � positionner les composants
		GridBagConstraints gbc = new GridBagConstraints();
		
		setLayout(new GridBagLayout());
    	
    	// On positionne le titre
    	JLabel sTitle = new JLabel(s.getTitle());
    	sTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
    	sTitle.setPreferredSize(new Dimension(((int) (4*(d.getWidth()-25)/5)), 28));
    	gbc.gridx = 0;
		gbc.gridy = 0;
		// Taille et hauteu
		gbc.gridwidth = 4;
		gbc.gridheight = 1;
		//gbc.insets.left = 6;
		add(sTitle, gbc);
		sTitle.setHorizontalAlignment(JLabel.LEFT);
		
		// On position la note
		JPanel mark = new JPanel();
		mark.setLayout(new GridLayout(2,1));
		JLabel note = new JLabel("<html><center><font size=\"4\" color=\"rgb(237, 191, 101)\"><b>NOTE</b></font><br/>"+s.getMark()+"</center></html>");
		note.setHorizontalAlignment(JLabel.CENTER);
		note.setFont(new Font("Segoe UI", Font.BOLD, 14));
		gbc.gridx = 4;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 2;
		gbc.insets.left = 2;gbc.insets.right = 2;gbc.insets.top = 2;gbc.insets.bottom = 2;
		add(note, gbc);
		
		// Affichage de la jacquette
		Image img = null;

        URL url;
		try {
			url = new URL(s.getImage());
			img = ImageIO.read(url);
			
		} catch (MalformedURLException e1) {e1.printStackTrace();} 
		catch (IOException e) {e.printStackTrace();}
		ImageIcon test = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(100, 142, Image.SCALE_SMOOTH));
        JLabel image = new JLabel(test);
		image.setPreferredSize(new Dimension(100,142));
		//img.setBackground(Color.BLACK);
	
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 5;
		gbc.gridwidth =1;
		gbc.insets.left = 4; gbc.insets.bottom = 2;
		add(image, gbc);
		
		// Affichage de la date de sortie
		SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
		JLabel lSortie = new JLabel("<html><font size=\"4\" color=\"rgb(92,106,192)\"><b>Sortie France : </b></font>"+format1.format(s.getReleaseDate().getTime())+"</html>");
		lSortie.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lSortie.setPreferredSize(new Dimension((int) (3*(d.getWidth()-25)/5)-10, 28));
		lSortie.setHorizontalAlignment(JLabel.LEFT);
		gbc.gridx = 1; gbc.gridwidth = 3; gbc.gridheight = 1;
		add(lSortie, gbc);
		
		// Affichage de l'editeur
		JLabel lEdit = new JLabel("<html><font size=\"4\" color=\"rgb(92,106,192)\"><b>Editeur  : </b></font>"+s.getEditor()+"</html>");
		lEdit.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lEdit.setPreferredSize(new Dimension((int) (4*(d.getWidth()-25)/5)-18, 28));
		lEdit.setHorizontalAlignment(JLabel.LEFT);
		gbc.gridx = 1; gbc.gridy = 2;gbc.gridwidth = GridBagConstraints.REMAINDER ;
		add(lEdit, gbc);
		
		// Affichage du genre
		JLabel lGenre = new JLabel("<html><font size=\"4\" color=\"rgb(92,106,192)\"><b>Genre : </b></font>"+s.getGameStyle()+"</html>");
		lGenre.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lGenre.setPreferredSize(new Dimension((int) (3*(d.getWidth()-25)/5)-10, 28));
		lGenre.setHorizontalAlignment(JLabel.LEFT);
		gbc.gridx = 1; gbc.gridy = 3; gbc.gridwidth = 3 ;
		add(lGenre, gbc);
		
		// Affichage du bouton de suppression
		JButton delete = new JButton("DELETE");
		delete.setFocusPainted(false);
		delete.setForeground(Color.WHITE);
		delete.setBackground(new Color(234, 49 ,49));
		delete.setPreferredSize(new Dimension(80, 24));
		gbc.gridx = 4;
		gbc.gridy = 3;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(delete, gbc);
		
		// Affichage du mode
		JLabel lMode = new JLabel("<html><font size=\"4\" color=\"rgb(92,106,192)\"><b>Mode : </b></font>"+s.getGameType()+"</html>");
		lMode.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lMode.setPreferredSize(new Dimension((int) (3*(d.getWidth()-25)/5)-10, 28));
		lMode.setHorizontalAlignment(JLabel.LEFT);
		gbc.gridx = 1; gbc.gridy = 4; gbc.gridwidth = 3 ; gbc.insets.left = 4;
		add(lMode, gbc);
		
		// Affichage du bouton de suppression
		JButton update = new JButton("UPDATE");
		update.setFocusPainted(false);
		update.setForeground(Color.WHITE);
		update.setBackground(new Color(99, 151, 229));
		update.setPreferredSize(new Dimension(80, 24));
		gbc.gridx = 4;
		gbc.gridy = 4;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(update, gbc);

		// Affichage du Paiment
		JLabel lPaiement = new JLabel("<html><font size=\"4\" color=\"rgb(92,106,192)\"><b>Paiement : </b></font>"+s.getBuyMethod()+"</html>");
		lPaiement.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lPaiement.setHorizontalAlignment(JLabel.LEFT);
		lPaiement.setPreferredSize(new Dimension((int) (4*(d.getWidth()-25)/5)-18, 28));
		gbc.gridx = 1; gbc.gridy = 5; gbc.gridwidth =  GridBagConstraints.REMAINDER;
		add(lPaiement, gbc);
		
		// Affichage de la Description
		JLabel lDesc = new JLabel("<html><font size=\"4\" color=\"rgb(92,106,192)\"><b>Description : </b></font>"+s.getDescription()+"</html>");
		lDesc.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lDesc.setPreferredSize(new Dimension((int) (d.getWidth()-30), 56));
		lDesc.setHorizontalAlignment(JLabel.LEFT);
		lDesc.setVerticalAlignment(JLabel.TOP);
		
		gbc.gridx = 0; gbc.gridy = 6; gbc.gridheight = 2; gbc.gridwidth =  GridBagConstraints.REMAINDER;
		add(lDesc, gbc);	
		repaint();
		
		addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){couleur = new Color(225,225,225); repaint();}
			public void mouseExited(MouseEvent e ){couleur = new Color(238,238,238); repaint();}
			
		});
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		Line2D l = new Line2D.Double(10, getHeight()-1,getWidth()-10,  getHeight()-1);
		g2.setColor(Color.BLACK);
		setBackground(couleur);
		g2.draw(l);
		
	}
}
