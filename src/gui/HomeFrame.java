package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import bd.Connexion;

@SuppressWarnings("serial")
public class HomeFrame extends GUIMainFrame{


	private static HomePanel hp;
	private static AuthPanel ap;
	private static UserPanel up;
	private static AdminPanel adp;
	private GUIMainFrame me;
	private Connexion connexion;
	
	public HomeFrame(Connexion c){
		super();
		connexion = c;
		setLayout(new BorderLayout());
		
		GUIMainFrame me = this;

		setJMenuBar(new GUIMenu());
		hp = new HomePanel();
		ap = new AuthPanel();
       	//up = new UserPanel();
		add(hp,BorderLayout.CENTER);
		hp.homebutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				hp.setVisible(false);
				add(ap, BorderLayout.CENTER);
            	setTitle("Le Hoatton");
			}
			
		});
		
		ap.buser.addActionListener(
            new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
                    LoginDialogUser loginDlg = new LoginDialogUser(new JFrame());
                    loginDlg.setVisible(true);
                    // if logon successfully
                    if(loginDlg.isSucceeded()){
                       	ap.setVisible(false);
                       	up.setVisible(true);
                       	add(up,BorderLayout.CENTER);
                    	setTitle("Le Hoatton - Comparateur");
                    }
				}
            });;		
            
            
    	ap.badmin.addActionListener(
            new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
                    LoginDialogAdmin loginDlg = new LoginDialogAdmin(new JFrame());
                    loginDlg.setVisible(true);
                    // if logon successfully
                    if(loginDlg.isSucceeded()){
                       	ap.setVisible(false);
                       	adp = new AdminPanel(me.getSize(), connexion);
                       	adp.setVisible(true);                     	
                       	add(adp);
                    	setTitle("Le Hoatton - Administration");
                    }
				}
            });;
		
		/*up.getBP().logoutbutton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Object[] options = {"Annuler","Déconnexion"};
				int choice = JOptionPane.showOptionDialog(up, 
						"Êtes-vous sûr de vouloir vous déconnecter?", "Déconnexion", 
						JOptionPane.YES_NO_CANCEL_OPTION, 
						JOptionPane.WARNING_MESSAGE,
						null,
						options,
						options[0]
						);
				if(choice == JOptionPane.NO_OPTION){
					up.setVisible(false);
					ap.setVisible(true);
	            	setTitle("Le Hoatton");
				}
				
				
			}
		});*/
		setVisible(true);		
	}
	public static void main(String [] args){
		Connexion connexion = new Connexion();
		new HomeFrame(connexion);
		
	}
}
