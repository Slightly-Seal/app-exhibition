/**
* CatalogInfo displays application information.
* Scans "Catalog.txt".
* @author James Martin
*/
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
* Displays information of selected application in catalog 
*/
public class CatalogInfo {
	//Frame + Panel
	JFrame frame;
	JPanel panel;
	//JPanel imagePanel;
	//JPanel textPanel;
	
	//Scanner
	Scanner scanner = null;
	
	//Labels
	JLabel titleLabel = new JLabel("");
	JTextArea descLabel = new JTextArea();
	
	//BufferedImage myPicture;
	JLabel picLabel;
	/**
	* Sets Frames/Panels for the Catalog Info
	* as well as sets formatting.
	* Scans "Catalog.txt" to display proper information.
	* Uses Labels to show information.
	*/
	CatalogInfo(int index){
		descLabel.setLineWrap(true);
		descLabel.setEditable(false);
		
		String catalogIndex = String.valueOf(index);
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		try {
			scanner = new Scanner(new File("Catalog.txt"));
		} catch (FileNotFoundException e1) {
			System.out.print("Cannot Access Catalog Info");
		}
		String indexCheck = "App " + catalogIndex + ":";
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			//System.out.println(line.substring(0, 6));
			//System.out.println(line.substring(7, line.indexOf("\\")));
			//System.out.println(line.substring(line.indexOf("\\") + 1));
			if(line.substring(0, 6).equals(indexCheck)) {
				titleLabel.setText(line.substring(line.indexOf(":") + 2, line.indexOf("\\")-1));
				descLabel.setText(line.substring(line.indexOf("\\") + 1));
		   }
		}
		try {
			//myPicture = ImageIO.read(new File("images\\test.png"));
			//System.out.println("images\\" + titleLabel.getText() + ".png");
			picLabel = new JLabel(new ImageIcon(new ImageIcon("images\\" + titleLabel.getText() + ".png").getImage().getScaledInstance(85, 85, Image.SCALE_DEFAULT)));
		}
		catch (Exception IOException){
			picLabel = new JLabel(new ImageIcon(new ImageIcon("images\\Default.png").getImage().getScaledInstance(85, 85, Image.SCALE_DEFAULT)));
			System.out.println("Picture not found");
		}
		
		frame = new JFrame(titleLabel.getText());
		frame.setSize(400, 200);
		
		panel.add(titleLabel, "North");
		panel.add(picLabel, "West");
		panel.add(descLabel, "Center");
		
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
}
