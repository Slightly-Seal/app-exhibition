/**
* Admin class is what appears when an admin is reviewing user submissions.
* Pressing on one of the buttons generated opens up the CatalogInfoAdmin with 
* information about that specific app.
* Scans "Submissions.txt" and "Substitute.txt"
* 
* @author James Martin
* 
*/
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
* Displays information for Admin that lists 
* all user submitted application ideas
*/
public class Admin implements ActionListener{
	
	//Frame + Panel
	JFrame frame;
	JPanel panel;
	
	//Variables
	JTextField userEnter;
	JTextField passEnter;
	JLabel label;
	File file;
	Button itemButton;
	Scanner scanner = null;
	Scanner scanner2 = null;
	
	public Framework frames;
	static public int numberOfApps = 7;
	
	boolean scanCheck = false;
	
	/**
	* This is the constructor for the admin page, it's responsible for setting the frame,
	* panel, textfields, and scanners. Compares two files via scanners, one with the User Submissions and
	* one with already implemented Catalog elements, comparing the two. If there's a submission that's in
	* both .txt files, then it's ignored when creating buttons.
	*/
	Admin(){
		frame = new JFrame("User Submissions");
		panel = new JPanel();
		userEnter = new JTextField(20);
		passEnter = new JTextField(15);
		label = new JLabel("");
		frame.setSize(400, 400);
		panel.setLayout(new GridLayout(10, 2, 5, 5));
		
		try {
			scanner = new Scanner(new File("Submissions.txt"));
		} catch (FileNotFoundException e1) {
			System.out.print("Cannot Access User Submissions");
		}

		
		while (scanner.hasNextLine()) {
			try {
				scanner2 = new Scanner(new File("Substitute.txt"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		   String line = scanner.nextLine();

		   System.out.println(line);
		   boolean lineCheck = false;
		   while(scanner2.hasNextLine()) {
			   String line2 = scanner2.nextLine();
			   System.out.println(line2);
			   if(line2.equals(line)) {
				   lineCheck = true;
				   System.out.println(lineCheck);
			   }
		   }
		   if(scanCheck) {
			   if(!lineCheck) {
				   
				   itemButton = new Button();
				   String title = line.substring(0, line.indexOf("\\"));
				   itemButton.setLabel(title);
				   itemButton.addActionListener(this);
				   panel.add(itemButton); 
			   }
		   
		   }   
		   else {
			   scanCheck = true;
		   }
		   
		}
		
		panel.setVisible(true);
		frame.add(panel);
		frame.setVisible(false);
	}
	
	/**
	* Used to turn the frame visible/invisible.
	* @param boolean, true sets it visible, false sets it invisible.
	*/
	public void setActive(boolean value) {
		frame.setVisible(value);
	}
	
	/**
	* Used to remove a specific button from the panel.
	* @param button that is to be removed.
	*/
	public void removeItem(Button button) {
		panel.remove(button);
	}
	
	/**
	* Override from ActionListener
	* @param Action event e that's used to verify which button is being pressed.
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			scanner = new Scanner(new File("Submissions.txt"));
		} catch (FileNotFoundException e1) {
			System.out.print("Cannot Access User Submissions");
		}
		while (scanner.hasNextLine()) {
			   itemButton = new Button();
			   String line = scanner.nextLine();
			   String title = line.substring(0, line.indexOf("\\"));
			   String sourceString = e.getSource().toString();
			   Button sourceButton = (Button) e.getSource();
			   if(sourceString.substring(sourceString.indexOf("=") +1, sourceString.indexOf("]")).equals(title)) {
				   CatalogInfoAdmin newCatalogAdmin = new CatalogInfoAdmin(title, sourceButton);
				   newCatalogAdmin.parent = this;
				   newCatalogAdmin.frames = frames;
				   newCatalogAdmin.setActive(true);
			   }
			}
		
		
	}
}
