package score;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import supply.DemandMethods;

public abstract class MultipleComplexeScore extends Score<ArrayList<TreeMap<String, String>>>{
	
		// ATTRIBUTS
	protected TreeMap<String, ArrayList<TreeMap<String, String>>> equipements;
	
		// MATHODES
	@Override
	public abstract ArrayList<TreeMap<String, String>> extractD(DemandMethods myDemand);
	public abstract ArrayList<String> getTypeE();
	
	public boolean compareField(String type, TreeMap<String, String> item)
	{
		boolean test = true;
		Iterator<TreeMap<String, String>> it = equipements.get(type).iterator();
		
		TreeMap<String, String> recept;
		Set<String> keys = item.keySet();
		
		// Pour chaque �quipements d'un type donn�
		while(it.hasNext())
		{
			recept = it.next();
			test = true;
			// On va comparer le contenu correspondant � chaques cl�es pr�sentes dans la demande
			for(String key : keys)
			{
				if(!key.equals("type"))
					// Si un des �l�ments li� � une cl� n'a pas la valeur attendu alors il n'y a pas correspondance
					if(!(recept.containsKey(key) && recept.get(key).equals(item.get(key))))
						test = false;
			}
			if(test) // si on trouve un ensemble correcte.
				break;		
		}
		return test;
	}
	
	public int getScore(DemandMethods myDemand) {
		// On r�cup�re l'ensemble des choix du client
		
		ArrayList<TreeMap<String, String>> fields = extractD(myDemand);
		if(fields == null) return score = 0;
		ArrayList<String> typeE = getTypeE();
		String type="";
		float cpt = 0; // Compteur servant � connaitre le nombre d'�l�ment de la demande pr�sent dans �quipement.		
		if(fields != null && equipements != null)
		{
			
			// Pour chaque choix du client
			for(TreeMap<String, String> f : fields)
			{
				if(f.containsKey("type"))
				{
					type = typeE.get(Integer.parseInt(f.get("type")));
					// Si l'�quipement contient au moins un objet du type voulu et que le couple(constructeur, nom) appartient � l'arrayList associ�.
					if( equipements.containsKey(type) && compareField(type, f))
						cpt+=1;
					else if (equipements.containsKey(type))// Prise en compte du r�sultat lvl 1.
						cpt +=0.5;
				}
			}
			
			double s = 1.0*scoreMax;
			return score =(int) (cpt*(s/fields.size()));
		}
		else 
			return score = 0;
	}	

}
