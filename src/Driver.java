/** 
 * Author: Dakota Henderson
 * Date: 10/11/21
 * updated: 10/15/21
 * 
 * Is the first instance of App Exhibition. The main job is to get a 
 * window open with a closeable menu.
 */

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Driver {
	
	public static void main(String[] args) {
		// List of variables/items in the gui
		JPanel panel = new JPanel();
		JPanel innerP = new JPanel();
		JFrame frame = new JFrame();
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JTextField searchBar = new JTextField();
		JLabel searchLabel = new JLabel("Search: ");
		// Placeholder buttons for apps
		Button b1 = new Button("App 1");
		Button b2 = new Button("App 2");
		Button b3 = new Button("App 3");
		Button b4 = new Button("App 4");
		
		// General Setup for layout
		frame.setBounds(100, 25, 400, 350);
		innerP.setLayout(new GridLayout(5, 3, 10, 10));
		panel.setLayout(new BorderLayout());
		innerP.setBackground(Color.white);
		searchBar.add(searchLabel);
		panel.add(innerP, "Center");
		panel.add(searchBar, "North");
		
		// Adding "Apps" to the panel
		innerP.add(b1);
		innerP.add(b2);
		innerP.add(b3);
		innerP.add(b4);
		innerP.add(new Button("App 5"));
		innerP.add(new Button("App 6"));
		innerP.add(new Button("App 7"));
		
		// Making visible, and final adds to the frame
		innerP.setVisible(true);
		panel.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
