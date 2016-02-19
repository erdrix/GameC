package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TreeMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import supply.Supply;

@SuppressWarnings("serial")
public class SIntervallePanel extends JPanel {
	private JLabel jl;
	private String classe, meth;
	private JTextField jtf;
	private Supply supply;
	private int[] limits;
	
	public SIntervallePanel(JButton save, TreeMap<String, String> t, Supply s)
	{
		jl = new JLabel(t.get("label"));
		classe = t.get("classe"); meth = t.get("methodOptions");
		supply = s; 
		add(jl);
		Constructor<?> constructors;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			constructors = Class.forName("supply.S"+classe).getDeclaredConstructor(float.class);
		
			Object obj = constructors.newInstance(0.f);
			Method getIntervalle = 
					Class.forName("supply.S"+classe).getDeclaredMethod(meth);
			limits = (int[])getIntervalle.invoke(obj);
			Class<?> c = supply.getClass();
			Method m = c.getMethod("get"+classe);
			
			jtf = new JTextField(12);
			if(!classe.equals("ReleaseDate"))
			{
				float value = (float) m.invoke(supply);
				jtf.setText(""+value);
			}
			else
				jtf.setText(sdf.format(((Calendar)m.invoke(supply)).getTime()));

				
			
			save.addActionListener(new ActionListener(){
				public void actionPerformed( ActionEvent e)
				{
					Class<?> c = supply.getClass();
					try {
						if(!classe.equals("ReleaseDate"))
						{
							Method m = c.getMethod("set"+classe, float.class);
							m.invoke(supply, Float.parseFloat(jtf.getText()));
						}
						else
						{
							Method m = c.getMethod("set"+classe, Calendar.class);
							Calendar cal = Calendar.getInstance();
							cal.setTime(sdf.parse(jtf.getText()));
							m.invoke(supply,cal);
						}
					} catch (Exception et) {et.printStackTrace();}
				}
			});
			jtf.getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void changedUpdate(DocumentEvent arg0) {
					
				}

				@Override
				public void insertUpdate(DocumentEvent arg0) {
					
					if(!classe.equals("ReleaseDate"))
					{
						if(!(limits[0]<=Float.parseFloat(jtf.getText()) && Float.parseFloat(jtf.getText())<=limits[1]))
						{
							save.setEnabled(false);
							jtf.setBorder(BorderFactory.createLineBorder(Color.RED));
						}
						else
						{
							jtf.setBorder( UIManager.getBorder("TextField.border") );
							save.setEnabled(true);
						}
					}
					else
					{
						if(!(jtf.getText().matches("[0-9]{2}-[0-9]{2}-[0-9]{4}")))
						{
							save.setEnabled(false);
							jtf.setBorder(BorderFactory.createLineBorder(Color.RED));
						}
						else
						{
							jtf.setBorder( UIManager.getBorder("TextField.border") );
							save.setEnabled(true);
						}
					}
					
				}

				@Override
				public void removeUpdate(DocumentEvent arg0) {
					
					if(!classe.equals("ReleaseDate"))
					{
						if(!(limits[0]<=Float.parseFloat(jtf.getText()) && Float.parseFloat(jtf.getText())<=limits[1]))
						{
							save.setEnabled(false);
							jtf.setBorder(BorderFactory.createLineBorder(Color.RED));
						}
						else
						{
							jtf.setBorder( UIManager.getBorder("TextField.border") );
							save.setEnabled(true);
						}
					}
					else
					{
						if(!(jtf.getText().matches("[0-9]{2}-[0-9]{2}-[0-9]{4}")))
						{
							save.setEnabled(false);
							jtf.setBorder(BorderFactory.createLineBorder(Color.RED));
						}
						else
						{
							jtf.setBorder( UIManager.getBorder("TextField.border") );
							save.setEnabled(true);
						}
					}
						
					
				}
				
			});
			add(jtf);
			
		} catch (Exception e) {e.printStackTrace();} 
		
	
	}
}
