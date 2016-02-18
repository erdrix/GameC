package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImgPanel extends JPanel{
	private Image img;
	@SuppressWarnings("unused")
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