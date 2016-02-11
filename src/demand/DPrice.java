package demand;

import supply.Intervalle;

public class DPrice {
		// ATTRIBUTS
	protected Intervalle price;	// Contient le prix d'un jeu.
	
		// CONSTRUCTEUR
	public DPrice(float f, float s)
	{
		price = new Intervalle(f,s);
	}
	
		// METHODE
	/**
	 * Fonction retournant le prix du jeu.
	 * @return price : Intervalle du prix du jeu.
	 */
	public Intervalle getPrice()
	{
		return price;
	}
}
