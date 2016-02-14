package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import demand.Demand;

@SuppressWarnings("serial")
public class UserPanel extends JPanel {
	private InformationsPanel cp;
	private ButtonPanel bp;
	public static Demand custom_demand;
	
	public UserPanel(){
		setLayout(new BorderLayout());
		custom_demand = new Demand();
		bp = new ButtonPanel();
		bp.applybutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
			
		});
		String[] main_infos = {"DTitle","DDescription","DEditor","DMark","DReleaseDate","DGameStyle",};
		String[] aux_infos = {"DDifficulty","DLifeTime"};
		cp = new InformationsPanel(main_infos,aux_infos);
		add(cp,BorderLayout.CENTER);
		add(bp,BorderLayout.SOUTH);
	}
	
	public ButtonPanel getBP(){
		return bp;
	}
}
