package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImgPanel extends JPanel{
	private Image img;
	public ImgPanel(String u)
	{
		Image img = null;

        URL url;
		try {
			url = new URL(u);
			img = ImageIO.read(url);
		} catch (MalformedURLException e1) {e1.printStackTrace();} 
		catch (IOException e) {e.printStackTrace();}		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawImage(img, 0, 0, this);
	}
}