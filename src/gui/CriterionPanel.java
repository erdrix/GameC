package gui;

import java.lang.reflect.Field;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CriterionPanel extends  JPanel {
	private static final String[] Keyword = 	{	"DTitle",
													"DDescription",
													"DEditor"
												};	
	private static final String[] Ecart =  		{	"DLifeTime",
													"DDifficulty"
												};	
	private static final String[] Intervalle = 	{	"DMark",
													"DPrice",
													"DReleaseDate"
												};
	private static final String[] Binary =		{	"DBuyMethod",
													"DGameType"
												};
	private static final String[] Multiple = 	{	"DAccessory",
													"DStoryType",
													"DGameSupport"
												};
	private static final String[] Style = 		{	"DGameStyle" 
												};
	
	
	public CriterionPanel(String name, String[] main_infos, String[] aux_infos){
		setBorder(BorderFactory.createTitledBorder(name));
		for(String s : main_infos){			
			try {
				Class.forName(getType(s)+"Panel").newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		for(String s : aux_infos){
			try {
				Class.forName(getType(s)+"Panel").newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	public String getType(String s){
		Field[] fields;
		try {
			fields = Class.forName("CriterionPanel").getDeclaredFields();
			for(Field f : fields){
				//if(!f.getType().equals( new Field(new String[]) );
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
