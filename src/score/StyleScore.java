package score;

import supply.DemandMethods;
import java.util.TreeMap;


public abstract class StyleScore extends Score<String>{
	
	// Nom du Style de jeu => Groupe de Style principal, Groupe secondaire
	private TreeMap<String,String> style_tree; 
	protected String s_style;
	private String d_style;

	public StyleScore(String s1){
		style_tree = getListe();
		// 	Styles de jeux de l'offre et de la demande
		s_style = s1;
	}
	@Override
	public abstract String extractD(DemandMethods myDemand); 
	public abstract TreeMap<String, String> getListe();
	@Override
	public int getScore(DemandMethods myDemand) {
		d_style = extractD(myDemand);
		// Si le champ � remplir est vide
		if(d_style == null) return score = 0;
		
		// Si le style choisi est exactement celui de l'offre courante : score maximal
		if(s_style == d_style && style_tree.containsKey(s_style)) return score = 100;
		
		// Rapprochement entre les styles
		else if(style_tree.containsKey(s_style) && style_tree.containsKey(d_style)){
			// R�cup�ration des groupes de styles de l'offre et de la demande
			String[] s_groups = style_tree.get(s_style).toLowerCase().split(", ");
			String[] d_groups = style_tree.get(d_style).toLowerCase().split(", ");
			
			// M�me groupe principal
			if(s_groups[0].equals(d_groups[0])) return score = 50;
			
			// M�me groupe secondaire
			for(int i = 1; i < s_groups.length; i++)
				for(int j = 1; j < d_groups.length;j++)
					if(s_groups[i].equals(d_groups[j])) return score = 25;
		}
		return score = 0;
		
	}
}

