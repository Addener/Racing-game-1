import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener {

	Camera camera1;
	Camera camera2;
	
	Road road;
	
	Texture bg1, bg2;
	Car track1;
	Car auto;

	Color c1 = new Color(97, 227, 64);
	
	public GamePanel() {
		road = new Road(100, 1000);
		
		bg1 = new Texture("road.png");
		auto = road.getPlayerPolice();	
		auto.bot = false;
		auto.speedY = 2;
		auto.speedX = 2;
		
		track1 = road.getPlayerThief();
		track1.bot = false;
		track1.speedY = 1.3;
		track1.speedX = 2;
		
		
		camera1 = new Camera();
		camera2 = new Camera();
		camera2.x = -600;
		
		

	}
	
	private void update () {
		road.update();
		auto.update();
		track1.update();
		
		camera1.y = track1.y - 500;
		camera2.y = auto.y - 500;
		
		
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		update();
		
		bg1.paint(g, 0, 0);
		
		bg1.paint(g, 600, 0);
		
		track1.paint(g, camera1);
		auto.paint(g, camera1);
		road.paint(g, camera1);
		
		
		track1.paint(g, camera2);
		auto.paint(g, camera2);
		road.paint(g, camera2);
		
		
		
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_A) {
			track1.left();
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			track1.right();
		}
		
		
		
		

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			auto.left();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			auto.right();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			auto.speedUp();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			auto.speedDown();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
		
	}
	
}








