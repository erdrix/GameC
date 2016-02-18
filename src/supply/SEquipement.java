/**
 * 
 */
package supply;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import score.MultipleScore;

/**
 * @author guitt
 *
 */
public abstract class SEquipement extends MultipleScore<ArrayList<TreeMap<String, String>>>{
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
