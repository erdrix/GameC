/**
 * 
 */
package demand;

/**
 * @author guitt
 *
 */
public class DGameStyle {
		// ATTRIBUTS
	private String main_style;
	
		// CONSTRUCTUEUR
	public DGameStyle(String s1)
	{
		main_style = s1;
	}
	
		// METHODE
	/**
	 * Fonction retournant le numero du type de jeu dont il s'agit (En ligne | Hors ligne).
	 * @return type : entier representant le choix du type de jeu.
	 */
	public String getStyle()
	{
		return main_style;
	}
}
