package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AuthPanel extends JPanel{
	public JButton buser;
	public JButton badmin;
	public AuthPanel(){
		buser = new JButton("Comparateur");
		badmin = new JButton("Administration");
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weighty = 1;
		JPanel jb = new JPanel();
		jb.setLayout(new BoxLayout(jb, BoxLayout.PAGE_AXIS));
		
		JPanel jbu = new JPanel();
		jbu.add(buser,gbc);
		jb.add(jbu);
		
		JPanel jba = new JPanel();
		jba.add(badmin,gbc);
		jb.add(jba);
		
		add(jb);
	}
	
}
