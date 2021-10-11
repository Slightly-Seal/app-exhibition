/** 
 * Author: Dakota Henderson
 * Date: 10/11/21
 * 
 * Is the first instance of App Exhibition. The main job is to get a 
 * window open with a closeable menu.
 */

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Driver {
	
	public static void main(String[] args) {
		
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		JMenuBar menubar = new JMenuBar();
		//JMenu menu = new JMenu();
		
		//menu.
		
		
		frame.add(panel);
		frame.add(menubar);
		panel.setVisible(true);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
