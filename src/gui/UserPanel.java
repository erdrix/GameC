package gui;

import java.awt.BorderLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class UserPanel extends JPanel {
	private InformationsPanel cp;
	private ButtonPanel bp;
	public UserPanel(){
		setLayout(new BorderLayout());
		bp = new ButtonPanel();
		String[] main_infos = {"DTitle","DEditor","DDescription","DMark","DReleaseDate","DGameStyle"};
		String[] aux_infos = {"DDifficulty","DLifeTime"};
		cp = new InformationsPanel(main_infos,aux_infos);
		add(cp,BorderLayout.CENTER);
		add(bp,BorderLayout.SOUTH);
	}
	
	public ButtonPanel getBP(){
		return bp;
	}
}
