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
		String[] main_infos = {"DTitle"};
		String[] aux_infos = {"DDescription"};
		cp = new InformationsPanel(main_infos,aux_infos);
		add(cp,BorderLayout.CENTER);
		add(bp,BorderLayout.SOUTH);
	}
	
	public ButtonPanel getBP(){
		return bp;
	}
}
