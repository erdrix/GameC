package gui;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import supply.Supply;

@SuppressWarnings("serial")
public class SupplyInfo extends JPanel{
	private Supply s;
	private CriterionSupply main_panel;
	private CriterionSupply aux_panel;
	public SupplyInfo(JButton save, Supply supply, String[] main_infos, String[] aux_infos )
	{
		setLayout(new GridLayout(2,1));
		s = supply;
		CriterionSupply.init_arrays();
		main_panel = new CriterionSupply(save,"Informations principales", main_infos, s);add(main_panel);
		aux_panel = new CriterionSupply(save,"Information secondaires", aux_infos, s); add(aux_panel);
	}
 
}
