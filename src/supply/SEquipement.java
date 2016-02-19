/**
 * 
 */
package supply;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import score.MultipleComplexeScore;

/**
 * @author guitt
 *
 */
public abstract class SEquipement extends MultipleComplexeScore{
		// ATTRIBUTS
	protected TreeMap<String, ArrayList<TreeMap<String, String>>> equipements;
	
		// CONSTRUCTEUR
	public SEquipement(ArrayList<TreeMap<String, String>> items)
	{
		super();
		ArrayList<TreeMap<String, String>> init = new ArrayList<>();
		equipements = new TreeMap<String, ArrayList<TreeMap<String, String>>>();
		
		// Cr�ation du TreeMap contenant en cl� les noms des type d'�quipements et en valeur un ArrayList de couple repr�sentant le Constructeur et le nom.
		if(items == null)
			equipements = null;
		else
		{
			for(TreeMap<String, String> item : items)
			{
				init = new ArrayList<>();
				// si il y a une cl� "type".
				if(item.containsKey("type"))
				{
					String type = item.get("type");
					item.remove("type");
					// Si on rencontre pour la premi�re fois ce type d'�quipement.
					if(!equipements.containsKey(type))
					{
						init.add(item);	
						equipements.put(type,init);	// On initialise la nouvelle entr�e avec un premier couple (constructeur, nom).
					}
					else // Sinon 
						equipements.get(type).add(item);	// On ajoute un couple (constructeur, nom).
				}
			}
		}
	}
	
		// METHODES
	// Ajout d'un nouvel �quipements dans l'offre.
	public void addEquipement(TreeMap<String, String> item)
	{
		if(item.containsKey("type"))
		{
			
			String type = item.get("type");
			item.remove("type");
			
			if(equipements.containsKey(type))
				equipements.get(type).add(item);
			else
			{
				ArrayList<TreeMap<String, String>> nouv = new ArrayList<>();
				nouv.add(item);
				equipements.put(type, nouv);
			}
		}
	}
	
	// Suppression d'un �quipements dans l'offre
	public void deleteEquipement(TreeMap<String, String> item)
	{
		if(item.containsKey("type"))
		{
			String type = item.get("type");
			item.remove("type");
			// si l'offre poss�de l'�quipement
			if(equipements.containsKey(type))
			{
				Iterator<TreeMap<String, String>> it = equipements.get(type).iterator();
				TreeMap<String, String> current = null;
				// on parcours l'ensemble des couples constructeur, nom pour le type d'�quipements selectionn�
				while(it.hasNext())
				{
					current = it.next();
					
					// Si on trouve une occurence de notre couple.
					Set<String> keys = current.keySet();
					boolean supp = true;
					for(String key : keys)
						if(!current.get(key).equals(item.get(key)))
							supp = false;
					if(supp)it.remove();
				}
			}
		}
	}
	
	// Supprime tous les �quipements
	public void setEquipements(ArrayList<TreeMap<String, String>> items)
	{
		equipements = new TreeMap<>();
		for(TreeMap<String, String> item : items)
			addEquipement(item);
	}
	
}
