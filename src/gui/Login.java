package gui;

public class Login {
	public static boolean user_authenticate(String username, String password){
		if(username.equals("user") && password.equals("user")) return true;
		return false;
	}
	public static boolean admin_authenticate(String username, String password){
		if(username.equals("admin") && password.equals("admin")) return true;
		return false;
	}
}
