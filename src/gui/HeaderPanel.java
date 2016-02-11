package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HeaderPanel extends JPanel{
	
	public HeaderPanel(String t, Color c, int headerSize){
		setBackground(c);
		setLayout(new FlowLayout());
		JLabel title = new JLabel(t);
		title.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		setPreferredSize(new Dimension( headerSize,60));
		title.setForeground(Color.WHITE);
		title.setPreferredSize(new Dimension (headerSize, 50));
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);
		add(title);
	}
}
