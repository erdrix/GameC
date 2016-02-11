package score;

import supply.DemandMethods;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
public abstract class KeywordScore extends Score<String>{
	
	// ATTRIBUTS
	protected String element;
	int exact_score;
	int approx_score;
	int final_score;
	
	// CONSTRUCTEURS
	public KeywordScore(String item){
		element = item;
		exact_score=0;
		approx_score=0;
		final_score=0;
	}
	
	// METHODES	
	public int getScore(DemandMethods myDemand){		
		// Mots-clés de chaque champ
		String[] s_split = element.split(" ");
		String[] d_split = extractD(myDemand).split(" ");
		
		TreeMap<String,Integer> supply_occur = new TreeMap<String,Integer>();
		for(int i = 0; i < s_split.length; i++){
			if(supply_occur.containsKey(s_split[i])) supply_occur.put(s_split[i], supply_occur.get(s_split[i])+1);
			else supply_occur.put(s_split[i],1);
		}
		
		TreeMap<String,Integer> demand_occur = new TreeMap<String,Integer>();
		for(int i = 0; i < d_split.length; i++){
			if(demand_occur.containsKey(d_split[i])) demand_occur.put(d_split[i], demand_occur.get(d_split[i])+1);
			else demand_occur.put(d_split[i],1);
		}
		// En sortie 
		// exact_score : contient le nombre de mots exacts contenus dans les deux chaînes
		// approx_score : contient la somme des pourcentages de ressemblance entre les mots les plus proche
		exact_score = getex_score(demand_occur,supply_occur,s_split);
		approx_score = getap_score(supply_occur,demand_occur);
		demand_occur.clear();
		supply_occur.clear();
		return score = (scoreMax*(exact_score+approx_score))/(100*Math.max(element.split(" ").length, extractD(myDemand).split(" ").length));
	}

	public int getex_score(TreeMap<String,Integer> d,TreeMap<String,Integer> tree_s,String[] s){
		int scoreD = 0;
		// Comparaison exacte des deux chaînes
		for(Map.Entry<String, Integer> d_entry : d.entrySet()){
			int cpt = 0;
			int i = 0;
			int d_occur = d_entry.getValue();
			while(i < s.length && cpt < d_occur){
				if(d_entry.getKey().equals(s[i])){
					scoreD++;
					cpt++;
					d.put(d_entry.getKey(), d_entry.getValue()-1);
					tree_s.put(d_entry.getKey(), d_entry.getValue()-1);
				}
				i++;
			}
		}
		
		// Suppression des mots trouvés dans les treemap
		ArrayList<String> remove = new ArrayList<String>();
		for(Map.Entry<String, Integer> d_entry : d.entrySet()){
			if(d_entry.getValue()==0) remove.add(d_entry.getKey());
		}
		for(String key : remove){
			d.remove(key);
		}

		remove = new ArrayList<String>();
		for(Map.Entry<String, Integer> s_entry : tree_s.entrySet()){
			if(s_entry.getValue()<=0) remove.add(s_entry.getKey());
		}
		for(String key : remove){
			tree_s.remove(key);
		}
		return 100*scoreD;
	}
	
	public int getap_score(TreeMap<String,Integer> s,TreeMap<String,Integer> d){
		double scoreD = 0 ;
		ArrayList<String> d_array = new ArrayList<String>();
		for(Map.Entry<String, Integer> d_entry : d.entrySet()) d_array.add(d_entry.getKey());
		ArrayList<String> s_array = new ArrayList<String>();
		for(Map.Entry<String, Integer> s_entry : s.entrySet()) s_array.add(s_entry.getKey());

		TreeMap<Character,Integer> d_char = new TreeMap<Character,Integer>();
		TreeMap<Character,Integer> s_char = new TreeMap<Character,Integer>();
		// Recherche du mot de l'offre le plus proche du mot de la demande
		for(String d_key : d_array){
			double approx_local = 0;
			double percent_local = 0;
			char[] achar_d =d_key.toLowerCase().toCharArray();
			for(String s_key : s_array){
				char[] achar_s =s_key.toLowerCase().toCharArray();
				// Création des TreeMap d'occurrence des lettres dans le mot
				for(int i = 0; i < achar_d.length; i++){
					if(d_char.containsKey(achar_d[i])) d_char.put(achar_d[i], d_char.get(achar_d[i])+1);
					else d_char.put(achar_d[i], 1);
				}
				for(int i = 0; i < achar_s.length; i++){
					if(s_char.containsKey(achar_s[i])) s_char.put(achar_s[i], s_char.get(achar_s[i])+1);
					else s_char.put(achar_s[i], 1);
				}
				// ICI, ON A DEUX TREEMAP (SUPPLY/DEMAND) AVEC LES OCCURENCES DE LETTRE DANS CHACUN DES CAS
				// COMPARAISON EXACTE ENTRE CES TREEMAP
				double char_score = 0;
				// Extraction des occurences des lettres
				for(Map.Entry<Character, Integer> d_entry : d_char.entrySet()){
					for(Map.Entry<Character, Integer> s_entry : s_char.entrySet()){
						// Comparaison des caractères : si exacts, décrementation du nb d'occurences restantes
						if(d_entry.getKey().equals(s_entry.getKey()) && d_entry.getValue() >0 && s_entry.getValue() > 0 ){
							char_score++;
							d_entry.setValue(d_entry.getValue()-1);
							s_entry.setValue(s_entry.getValue()-1);
						}
					}
				}
				approx_local = Math.max(approx_local,char_score);
				if(approx_local == char_score){
					percent_local = Math.min(approx_local/d_key.length(), approx_local/s_key.length());
				}
				char_score=0;
				// Pourcentage du nombre de lettres apparaissant
				s_char.clear();
				//approx_local = Math.min(approx_local/s_key.length(), approx_local/d_key.length());
			}
			d_char.clear();
			scoreD = scoreD+percent_local;
		}
		return (int)(100*scoreD);
	}
	
	public String toString()
	{
		return "("+score+")";
	}
}
