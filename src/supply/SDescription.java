package supply;


public class SDescription extends SKeywords{
	public SDescription(String s){ super(s); scoreMax = 80;}
	
	public String extractD(DemandMethods myDemand){ return myDemand.getDescription(); }
	
	public void setDescription(String value){ element = value; }
	public String getDescription(){return element;}
}
