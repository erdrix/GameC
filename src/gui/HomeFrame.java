package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class HomeFrame extends GUIMainFrame{


	private static HomePanel hp;
	private static AuthPanel ap;
	private static UserPanel up;
	private static AdminPanel adp;
	
	public HomeFrame(){
		super();
		setLayout(new BorderLayout());
		

		setJMenuBar(new GUIMenu());
		hp = new HomePanel();
		ap = new AuthPanel();
       	up = new UserPanel();
       	adp = new AdminPanel();
		add(hp,BorderLayout.CENTER);
		hp.homebutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				hp.setVisible(false);
				add(ap, BorderLayout.CENTER);
			}
			
		});
		
		ap.buser.addActionListener(
            new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
                    LoginDialog loginDlg = new LoginDialog(new JFrame());
                    loginDlg.setVisible(true);
                    // if logon successfully
                    if(loginDlg.isSucceeded()){
                       	ap.setVisible(false);
                       	up.setVisible(true);
                    }
				}
            });;		
    	ap.badmin.addActionListener(
            new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
                    LoginDialog loginDlg = new LoginDialog(new JFrame());
                    loginDlg.setVisible(true);
                    // if logon successfully
                    if(loginDlg.isSucceeded()){
                       	ap.setVisible(false);
                       	adp.setVisible(true);
                    }
				}
            });;
		
		
		
		setVisible(true);		
	}
	public static void main(String [] args){
		new HomeFrame();
	}
}
