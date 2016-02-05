package demand;

import java.util.Calendar;
import supply.Intervalle;

public class DReleaseDate {
		// ATTRIBUT
	protected Intervalle range;	// Contient l'intervalle de date de sortie.
	
		// CONSTRUCTEUR
	public DReleaseDate(Calendar d, Calendar f)
	{
		if( d != null && f!= null)
			range = new Intervalle(d.getTimeInMillis(), f.getTimeInMillis());	// Créer un intervalle de double en convertissant la date en TimeStamp.
		else 
			range = new Intervalle(0,0);
	}
	
		// METHODE
	/**
	 * Fonction retournant l'intervalle de temps souhaité pour la sortie du jeu.
	 * @return range : Intervalle représentant la date de sortie.
	 */
	public Intervalle getRange()
	{
		return range;
	}
}
