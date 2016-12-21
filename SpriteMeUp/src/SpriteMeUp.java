import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class SpriteMeUp {
	final static String title = "SpriteMeUp v0.1";
	final static String titleIcon = "C:\\Home\\eclipse\\workspace\\SpriteMeUp\\res\\titleIcon.png";
	final static JPanel mainPanel = new JPanel(); 
	final static JLabel label = new JLabel();
	
	public static void main(String[] args) {
		ImageIcon img = new ImageIcon(titleIcon);
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new FileMenu().createFileMenu(); 
		menuBar.add(fileMenu);
		JMenu menu2 = new JMenu("menu2");
		menuBar.add(menu2);

		JFrame frame = new JFrame(title);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);

		frame.setIconImage(img.getImage());
		frame.setJMenuBar(menuBar);
		frame.add(mainPanel);
		mainPanel.add(label, BorderLayout.CENTER );

	}

}
