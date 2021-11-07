import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

public class CatalogInfo {
	//Frame + Panel
	JFrame frame;
	JPanel panel;
	//Scanner
	Scanner scanner = null;
	//Labels
	JLabel titleLabel = new JLabel("");
	JLabel descLabel = new JLabel("");
	
	CatalogInfo(int index){
		String catalogIndex = String.valueOf(index);
		frame = new JFrame("Login Screen");
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		frame.setSize(400, 200);
		try {
			scanner = new Scanner(new File("Catalog.txt"));
		} catch (FileNotFoundException e1) {
			System.out.print("Cannot Access Catalog Info");
		}
		String indexCheck = "App " + catalogIndex + ":";
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			System.out.println(line.substring(0, 6));
			System.out.println(line.substring(7, line.indexOf("\\")));
			System.out.println(line.substring(line.indexOf("\\") + 1));
			if(line.substring(0, 6).equals(indexCheck)) {
				titleLabel.setText(line.substring(7, line.indexOf("\\")));
				descLabel.setText(line.substring(line.indexOf("\\") + 1));
		   }
		}
		
		panel.add(titleLabel, "North");
		panel.add(descLabel, "Center");
		
		panel.setVisible(true);
		frame.add(panel);
		frame.setVisible(false);
		}
	
	public void setActive(boolean value) {
		frame.setVisible(value);
	}
}
