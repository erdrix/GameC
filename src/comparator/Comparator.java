package comparator;

import java.util.ArrayList;
import java.util.Collections;

import demand.Demand;
import supply.Supply;

public class Comparator {
	
		// ATTRIBUTS
	private ArrayList<Supply> supplies;	// Ensemble des offres proposées.
	private Demand demand;		// Demande soumise par le client.
	
		// CONSTRUCTEUR
	public Comparator(ArrayList<Supply> supply1, Demand D){supplies = supply1; demand = D;}
	
		// METHODES
	/**
	 * Fonction permettant de comparer chaque offre avec la demande.
	 */
	public void compare()
	{
		for(Supply s : supplies)
			s.compare(demand);
	}
	
	public ArrayList<Supply> getListeSupply(){
		compare();
		Collections.sort(supplies, Collections.reverseOrder());
		return supplies;
	}
	/**
	 * Fonction affichant le score final de chaque offre par rapport à la demande du client.
	 */
	public void afficherScore()
	{
		for (Supply s : supplies)
			System.out.println("\n\n Caractéristique de l'offre n°"+s.getIdOffre()+" \n\n"+s+"\n");

	}
}
