import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Texture {
	
	Image img;
	
	public int getWidth() {
		return img.getWidth(null);
	}
	public int getHeight() {
		return img.getHeight(null);
	}
	
	public void paint (Graphics g, int x, int y) {
		g.drawImage(img, x, y, null);
	}

	public Texture (String name) {
		File f = new File(name);
		try {
			img = ImageIO.read(f);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ошибка чтения файла");
			System.exit(0);
		}
	}
	
	
}
