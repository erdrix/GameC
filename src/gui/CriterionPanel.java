package gui;

import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CriterionPanel extends  JPanel {
	@SuppressWarnings("unused")
	private static final String[] Keyword = 	{	"DTitle",
													"DDescription",
													"DEditor"
												};	
	@SuppressWarnings("unused")
	private static final String[] Ecart =  		{	"DLifeTime",
													"DDifficulty"
												};	
	@SuppressWarnings("unused")
	private static final String[] Intervalle = 	{	"DMark",
													"DPrice",
													"DReleaseDate"
												};
	@SuppressWarnings("unused")
	private static final String[] Binary =		{	"DBuyMethod",
													"DGameType"
												};
	@SuppressWarnings("unused")
	private static final String[] Multiple = 	{	"DAccessory",
													"DStoryType",
													"DGameSupport"
												};
	@SuppressWarnings("unused")
	private static final String[] Style = 		{	"DGameStyle" 
												};
	public CriterionPanel(){
		super();
	}
	
	public CriterionPanel(String name, String[] main_infos, String[] aux_infos){
		for(String s : main_infos){
			getType(s);
		}
	}
	
	public String getType(String s){
		try {
			Field [] fields = Class.forName("gui.CriterionPanel").getDeclaredFields();
			Field[] crit_type = new Field[fields.length];
			int i = 0;
			for(Field f : fields)	{
				if(f.getType().toString().equals("class [Ljava.lang.String;")) crit_type[i]=f;
				
			}
			
			for(Field f : crit_type){

				//System.out.println(f.getType().toString());
				try {
					String[] crit_values = (String[]) f.get(new CriterionPanel());
					for(String st : (String[])crit_values)
						if(st.equals(s)) return f.getName();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return"";
	}
}
