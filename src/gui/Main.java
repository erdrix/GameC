package gui;

import java.util.TreeMap;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf = new JFrame();
		TreeMap<String,String> elmt = new TreeMap<>();

		elmt.put("classe", "DTitle");
		elmt.put("label", "Titre du jeu : ");
		jf.add(new KeywordPanel(elmt));
		jf.pack();
		jf.setVisible(true);
	}

}
