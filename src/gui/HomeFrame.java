package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import bd.Connexion;

@SuppressWarnings("serial")
public class HomeFrame extends GUIMainFrame{


	private static HomePanel hp;
	private static AuthPanel ap;
	private static UserPanel up;
	private static AdminPanel adp;
	private static ResultPanel rp;
	private Connexion connexion;
	public static HomeFrame me;
	
	public HomeFrame(Connexion c){
		super();
		connexion = c;
		setLayout(new BorderLayout());
		
		me= this;
		// Création de la barre de menu
		setJMenuBar(new GUIMenu());
		
		// Création des différents panels de l'IHM
		hp = new HomePanel();
		ap = new AuthPanel();
       	up = new UserPanel(this,d,c);
       	rp = new ResultPanel();
       	adp = new AdminPanel();
		add(hp,BorderLayout.CENTER);
		
		// Passage Home => Authentification
		hp.homebutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				hp.setVisible(false);
				add(ap, BorderLayout.CENTER);
            	setTitle("Le Hoatton");
			}
			
		});
		
		// Passage Authentification => Comparateur
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
            
        // Passage Authentification => Panneau d'administration
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
                       	adp = new AdminPanel(me.getSize(), connexion, me);
                       	adp.setVisible(true);                     	
                       	add(adp);
                    	setTitle("Le Hoatton - Administration");
                    }
				}
            });;
		
		// Passage Comparateur => Résultats
        up.bp.applybutton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					up.setVisible(false);
					rp = new ResultPanel(HomeFrame.me, HomeFrame.d, UserPanel.custom_demand);
					rp.setVisible(true);
					add(rp);
					setTitle("Le Hoatton - Résultats");
					
				}
				
        });		
		setVisible(true);		
	}
	
	//*******************************************//
	// FONCTION POUR RELOAD LES PANEL EN CAS     //
	// DE CHANGEMENT DE VALEURS DANS LES CHAMPS  //
	//*******************************************//

	public void reloadAdminPanel()
	{
		adp.setVisible(false);
		remove(adp);
		adp = new AdminPanel(me.getSize(), connexion, me);
		adp.setVisible(true);                     	
       	add(adp);
       	
	}
	
	public void reloadMenuPanel()
	{
		rp.setVisible(false);
		adp.setVisible(false);
		up.setVisible(false);
		hp.setVisible(false);
		ap.setVisible(true);
	}
	public void reloadUserPanel()
	{
		rp.setVisible(false);
		adp.setVisible(false);
		up.setVisible(true);
		hp.setVisible(false);
		ap.setVisible(false);
	}
	public void reloadResultPanel()
	{
		
		rp.setVisible(false);
		remove(rp);
		rp = new ResultPanel(HomeFrame.me, HomeFrame.d, UserPanel.custom_demand);
		rp.setVisible(true);
		adp.setVisible(false);
		up.setVisible(false);
		hp.setVisible(false);
		ap.setVisible(false);
		add(rp);
	}
}
