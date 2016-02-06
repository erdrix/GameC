package gui;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUIMenu extends JMenuBar{
	public GUIMenu(){
		JMenuBar jm = new JMenuBar();
		JMenu fm = new JMenu("Fichier");
		JMenu am = new JMenu("Aide");
		JMenuItem quit = new JMenuItem("Quitter");
		quit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

		JMenuItem aprop = new JMenuItem("� propos");
		aprop.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JPanel jp = new JPanel();
				jp.setLayout(new BoxLayout(jp,BoxLayout.Y_AXIS));
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.anchor = GridBagConstraints.CENTER;
				gbc.weighty = 1;
				jp.add(new JLabel	("Comparateur de Jeux-Vid�os - Projet POO 2016",JLabel.CENTER),gbc);
				jp.add(new JLabel	("Alexandre Guitton | Jordan Hoareau",JLabel.CENTER),gbc);
				jp.add(new JLabel	("Comparer des jeux � partir d'une demande et d'offres stock�es dans une base de donn�es",JLabel.CENTER),gbc);
				jp.add(new JLabel   ("Version 1.0 - Derni�re �dition le 06/02/2016",JLabel.CENTER),gbc);
				JOptionPane.showMessageDialog(aprop, jp, "� propos", JOptionPane.INFORMATION_MESSAGE);
				
				
			}
		});
		
		// Ajout des boutons dans les sous-menus
		fm.add(quit);
		am.add(aprop);
		
		// Ajout des menus
		jm.add(fm);
		jm.add(am);
		
		// Ajout de la barre de menu
		add(jm);
	}
}
