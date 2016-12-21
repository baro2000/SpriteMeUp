import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FileMenu {
	final JFileChooser fileChooser = new JFileChooser();
	static File selectedFile = null;

	public static File getSelectedFile() {
		return selectedFile;
	}
	public final JMenu createFileMenu() {
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);

		JMenuItem newFileItem = new JMenuItem("New", KeyEvent.VK_N);
		newFileItem.addActionListener(newFileAction());
		fileMenu.add(newFileItem);
		JMenuItem loadFileItem = new JMenuItem("Load", KeyEvent.VK_L);
		loadFileItem.addActionListener(loadFileAction());
		fileMenu.add(loadFileItem);
		JMenuItem saveFileItem = new JMenuItem("Save", KeyEvent.VK_S);
		saveFileItem.addActionListener(saveFileAction());
		fileMenu.add(saveFileItem);
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(exitAction());
		fileMenu.add(exitItem);
		return fileMenu;
	}
	
	private ActionListener newFileAction() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		};
	}
	private ActionListener loadFileAction() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = fileChooser.showOpenDialog(SpriteMeUp.mainPanel);
				if (result == JFileChooser.APPROVE_OPTION) {
					selectedFile = fileChooser.getSelectedFile();

					System.out.println("Selected file: " + selectedFile.getAbsolutePath());
					ImageIcon image = new ImageIcon("");
					if (FileMenu.getSelectedFile() != null)
						image = new ImageIcon(FileMenu.getSelectedFile().toString());
					SpriteMeUp.label.setIcon(image);
				}
			}
		};
	}
	private ActionListener saveFileAction() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = fileChooser.showSaveDialog(SpriteMeUp.mainPanel);
				if (result == JFileChooser.APPROVE_OPTION) {
					selectedFile = fileChooser.getSelectedFile();
					
					System.out.println("Selected file: " + selectedFile.getAbsolutePath());
					Icon icon = SpriteMeUp.label.getIcon();
					BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
					Graphics g = bi.createGraphics();
					// paint the Icon to the BufferedImage.
					icon.paintIcon(null, g, 0,0);
					g.dispose();
					try {
						ImageIO.write(bi, "png", selectedFile);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		};
	}
	private ActionListener exitAction() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
	}

}
