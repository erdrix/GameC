package ihmComparatorold;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class CompInfoPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompInfoPanel(String [] criterions){
		setLayout(new GridLayout((int)Math.ceil((double)criterions.length/2),4));
		for(int i = 0; i < criterions.length; i++){
			// Panel Keyword
			add(new LabelPanel(criterions[i]));
			if(	isKeywordScore(criterions[i]))
				add(new KeywordPanel(criterions[i]));
			
			// Panel Ecart
			else if( isEcartScore(criterions[i]))
				add(new EcartPanel(criterions[i]));
			
			// Panel Intervalle
			else if( isIntervalleScore(criterions[i]))
				add(new IntervallePanel(criterions[i]));
			
			// Panel Binary
			else if( isBinaryScore(criterions[i]))
				add(new BinaryPanel(criterions[i]));
			
			// Panel Multiple
			else if( isMultipleScore(criterions[i]))
				add(new MultiplePanel(criterions[i]));
			
			// Panel Style
			else if( isStyleScore(criterions[i]))
				add(new StylePanel(criterions[i]));
		}
	}
	private boolean isKeywordScore(String s){
		return s.equals("DTitle") || s.equals("DEditor") || s.equals("DDescription");
	}	
	private boolean isEcartScore(String s){
		return s.equals("DLifeTime") || s.equals("DDifficulty");
	}	
	private boolean isIntervalleScore(String s){
		return s.equals("DMark") || s.equals("DPrice") || s.equals("DReleaseDate");
	}	
	private boolean isBinaryScore(String s){
		return s.equals("DBuyMethod") || s.equals("DGameType");
	}	
	private boolean isMultipleScore(String s){
		return s.equals("DEquipement") || s.equals("DStoryType");
	}
	private boolean isStyleScore(String s){
		return s.equals("DGameStyle");
	}

}
