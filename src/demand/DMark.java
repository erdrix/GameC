package demand;

import supply.Intervalle;

public class DMark {
		// ATTRIBUT
	protected Intervalle range;	// Contient l'intervalle de note voulu.
	
		// CONSTRUCTEUR
	public DMark(float fst, float snd)
	{
		range = new Intervalle(fst, snd);
	}
		// METHODE
	/**
	 * Fonction retournant l'intervalle de la note voulu.
	 * @return range : Intervalle représentant la gamme de notes voulues.
	 */
	public Intervalle getRange()
	{
		return range;
	}
}
