
/**
* Driver class is what runs everything, 
* the initial framework and additional 
* classes are assigned here.
* @author Dakota Henderson
* @author James Martin
*/



public class Driver{
		
	
	/**
	 * Main method
	 * Creates required classes.
	 * Assigns class variables to certain classes.
	 * that require them in order to maintain integrity.
	 */
	public static void main(String[] args) {
		Framework frames = new Framework();
		CreateAccount createAccount = new CreateAccount();
		LoginU login = new LoginU();
		UserSubmissions userSubmissions = new UserSubmissions();
		
		frames.createAccount = createAccount;
		frames.login = login;
		frames.userSubmissions = userSubmissions;
		
		login.frames = frames;
		
		
	}

	
	
}
