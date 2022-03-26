import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Road {

	Car[] cars ;
	
	int indexPoliceCar = 0;
	int indexThiefCar  = 0;
	
	
	// Получить полицейское авто
	public Car getPlayerPolice () {
		return cars[indexPoliceCar];
	}
	
	// ПОлучить машину вора
	public Car getPlayerThief () {
		return cars[indexThiefCar];
	}
	
	
	public void paint (Graphics g, Camera cam) {
		
		// Длина маршрута
		int length    = 100000;
		int mapHeight = 700;
		
		
		for (Car c  : cars ) {
			c.paint(g, cam);
			
			if (c.active == false) {
				continue;
			}
			
			
			int y =  (int)( c.y / length * mapHeight + mapHeight + 10 );
			
			if (c == getPlayerPolice()) {
				g.setColor(Color.BLUE);
				g.fillOval(10, y, 8, 8);
				g.fillOval(610, y, 8, 8);
			}
			else if (c == getPlayerThief()) {
				g.setColor(Color.ORANGE);
				g.fillOval(10, y, 8, 8);
				g.fillOval(610, y, 8, 8);
			} 
			else {
				g.setColor(Color.GRAY);
				g.fillOval(10, y, 5, 5);
				g.fillOval(610, y, 5, 5);
			}
			
			
			
			
		}
	}
	
	public void update () {
		
		Car player1 = getPlayerPolice();
		Car player2 = getPlayerThief();
		
		for (Car c  : cars ) {
			c.update();
			
			if (player1 != c && player1.getCollider().intersects( c.getCollider() ) ) {
				player1.active = false;
				c.active = false;
			}
			
			if (player2 != c && player2.getCollider().intersects( c.getCollider() ) ) {
				player2.active = false;
				c.active = false;
			}
			
			
		}
	}
	
	
	public Road (int quantinty, int distance) {
		
		cars = new Car[quantinty];
		
		Random r = new Random ();
		
		
		int lane, y;
		lane = 1;
		for (int i = 0; i <= quantinty - 1 ;i++) {
			y = - i * distance/* + РАНДОМНУЮ ВЫСОТУ*/;
			
			double random = Math.random(); 
			
			if (random < 0.6) {
				cars[i] = new Police(lane, y);
			}
			else if (random < 0.8) {
				cars[i] = new Track(lane, y);
			}
			else {
				cars[i] = new Thief(lane, y);
			}
			
			
			if (cars[i] instanceof Police && indexPoliceCar == 0) {
				indexPoliceCar = i;
			}
			else if (cars[i] instanceof Thief && indexThiefCar == 0) {
				indexThiefCar = i;
			}
			
			
		
		}
	}
	
	
}












