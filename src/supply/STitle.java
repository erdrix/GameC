package supply;

public class STitle extends SKeywords{
	
	public STitle(String s){super(s); scoreMax = 200;}	
	public String extractD(DemandMethods myDemand){return myDemand.getTitle();}
	
	public String getTitle(){return element;}
	public void setTitle(String value){element = value;}
}

