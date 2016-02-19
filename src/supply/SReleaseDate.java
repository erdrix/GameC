package supply;

import score.IntervalleScore;
import java.util.Calendar;

/***************** Affichage date : yyy-MM-dd *********************
 * 	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
 *	System.out.println(format1.format(c.getTime()));
 ******************************************************************/
public class SReleaseDate extends IntervalleScore{
		// CONSTRUCTEUR
	public SReleaseDate(Calendar d){super(d.getTimeInMillis()); desc = false;}
	public SReleaseDate(float f){super(0L); scoreMax = 60;}
	
		// METHODES
	public Intervalle extractD(DemandMethods myDemand){return myDemand.getReleaseDate();}

	public Calendar getReleaseDate(){
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis((long) val);

		return c;
	}
	public void setReleaseDate(Calendar value){val = value.getTimeInMillis();}
	public static int[] getLimits(){
		int limits[] = {1960,2020};
		return limits;
		}
}
