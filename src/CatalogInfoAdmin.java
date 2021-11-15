/**
* CatalogInfoAdmin displays the information of a specific application that
* a user submitted.
* Scans both "Substitute.txt" and "Submissions.txt"
* Prints to "Catalog.txt"
* @author James Martin
*/
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;

/**
* Displays selected application's information 
* Allows Admin to Accept or Reject Submission
*/
public class CatalogInfoAdmin implements ActionListener{
	//Frame + Panel
	JFrame frame;
	JPanel panel;
	//Scanner
	Scanner scanner = null;
	//Labels
	JLabel titleLabel = new JLabel("");
	JLabel descLabel = new JLabel("");
	Button confirmButton = new Button ("Accept");
	Button denyButton = new Button ("Reject");
	Button sourceButton;
	public Admin parent;
	public Framework frames;
	File file = new File("Substitute.txt");
    File file3 = new File("Submissions.txt");
    
	boolean scanCheck = false;
	
	/**
	 * Used to display the information of a user submitted app.
	 * @param title, is the title of the user submission. Used for the frame label and to verify a scanned line in order to display the correct information.
	 * @param button, is used to remove the button from the Admin class, making it impossible to open a second CatalogInfoAdmin class. 
	 */
	CatalogInfoAdmin(String title, Button button){
		sourceButton = button;
		frame = new JFrame("Submission Item: " + title);
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel bottomP = new JPanel();
		bottomP.setLayout(new GridLayout(1, 2, 5, 5));
		frame.setSize(400, 250);
		confirmButton.addActionListener(this);
		denyButton.addActionListener(this);
		if (!file.exists()) {
			try {
				file.createNewFile();
			}
			catch (Exception IOException){
				System.out.println("Cannot find Substitute.txt");
			}
		}
		try {
			scanner = new Scanner(new File("Submissions.txt"));
		} catch (FileNotFoundException e1) {
			System.out.print("Cannot Access Catalog Info");
		}
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if(scanCheck) {
				if(line.substring(0, line.indexOf("\\")).equals(title)) {
					titleLabel.setText(line.substring(0, line.indexOf("\\")));
					descLabel.setText(line.substring(line.indexOf("\\") + 1));
			   }
			}
			//System.out.println(line.substring(0, 6));
			//System.out.println(line.substring(7, line.indexOf("\\")));
			//System.out.println(line.substring(line.indexOf("\\") + 1));
			else {
				scanCheck = true;
			}
		}
		bottomP.add(confirmButton);
		bottomP.add(denyButton);
		panel.add(titleLabel, "North");
		panel.add(descLabel, "Center");
		panel.add(bottomP, "South");
		
		bottomP.setVisible(true);
		panel.setVisible(true);
		frame.add(panel);
		frame.setVisible(false);
		}
	
	/**
	* Used to turn the frame visible/invisible
	* @param boolean, true sets it visible, false sets it invisible.
	*/
	public void setActive(boolean value) {
		frame.setVisible(value);
	}

	/**
	* Override from ActionListener.
	* If the Admin accepts a submitted application, it will appear in the Framework class and 
	* be added to Catalog.txt and Substitute.txt. If it is rejected, it will be added to the
	* Substitute.txt.
	* @param Action event e that's used to verify which button is being pressed.
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == confirmButton) {  
	        PrintWriter pw = null;
			try {
				pw = new PrintWriter(new FileWriter(file, true));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	          
	        // BufferedReader object for input.txt
	        BufferedReader br1 = null;
			try {
				br1 = new BufferedReader(new FileReader(file3));
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			}
	          
	        String line1 = null;
			try {
				line1 = br1.readLine();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
	          
	        // loop for each line of input.txt
	        while(line1 != null)
	        {   
	            String line2 = titleLabel.getText() + "\\" + descLabel.getText();
	              
	            // loop for each line of delete.txt
	            if(line1.equals(line2))
                {
	            	pw.printf("\n" +line1);
                }
	                           
	            try {
					line1 = br1.readLine();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	              
	        }
	          
	        // closing resources
	        try {
				br1.close();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	        pw.close();
	        
			File file2 = new File("Catalog.txt");
			PrintWriter fout2 = null;
			
			try {
				fout2 = new PrintWriter(new FileWriter(file2, true));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("File operation performed successfully");
			
			parent.numberOfApps++;
			int index = parent.numberOfApps;
			fout2.printf("\n" +"App " + String.valueOf(index)  + ": " + titleLabel.getText() + " \\ " + descLabel.getText());
			fout2.close();
			parent.removeItem(sourceButton);
			frame.setVisible(false);
			frames.submissionCheck();
			frames.isSorted = false;
			frames.alphaSort.setLabel("Sort By Name");
		}
		if(e.getSource() == denyButton) {
			PrintWriter pw = null;
			try {
				pw = new PrintWriter(new FileWriter(file, true));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	          
	        // BufferedReader object for input.txt
	        BufferedReader br1 = null;
			try {
				br1 = new BufferedReader(new FileReader(file3));
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			}
	          
	        String line1 = null;
			try {
				line1 = br1.readLine();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
	          
	        // loop for each line of input.txt
	        while(line1 != null)
	        {   
	            String line2 = titleLabel.getText() + "\\" + descLabel.getText();
	              
	            // loop for each line of delete.txt
	            if(line1.equals(line2))
                {
	            	pw.printf("\n" +line1);
                }
	                           
	            try {
					line1 = br1.readLine();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	              
	        }
	          
	        // closing resources
	        try {
				br1.close();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	        pw.close();
			parent.removeItem(sourceButton);
			frame.setVisible(false);
		}
	}
}
