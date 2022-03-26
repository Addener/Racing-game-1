import java.awt.Graphics;
import java.awt.Rectangle;

public class Car {
	
	boolean moving = false;
	
	
	boolean active = true;
	
	Rectangle collider;
	
	boolean bot = true;
	double x, y;
	double targetX;
	int width;
	int height;
	Texture t;
	int lane; // Полоса движения // ширина 124 пикселя
	
	double speedX = 0.005;
	int    velocityX = 1;
	
	double speedY = 0.005;
	
	public void speedUp() {
		speedY += 0.01;
	}
	public void speedDown() {
		speedY -= 0.01;
	}
	
	public void update () {
		
		if (!active) {
			return;
		}
		
		
		if (bot) {
			double random = Math.random();
			if (random < 0.001) {
				left();
			}
			if (random > 0.999) {
				right();
			}
		}
		x = x + velocityX * speedX;
		y = y - speedY;
				
		
		if (velocityX > 0 && x > targetX ) {
			x = targetX;
			moving = false;
			
		}
		if (velocityX < 0 && x < targetX ) {
			x = targetX;
			moving = false;
			
		}
		
	}
	
	public void right() {
		if (lane < 4  && moving == false ) {
			lane++;
			velocityX = 1;
			moving = true;
			calculateTagetX();
		}
	}
	
	public void left() {
		if (lane > 0  && moving == false) {
			lane--;
			moving = true;
			velocityX = -1;
			calculateTagetX();
		}
	}
	
	private void calculateTagetX() {
		targetX = lane * 124;
	}
	
	public Rectangle getCollider () {
		collider.x = (int)this.x;
		collider.y = (int)this.y;
		return collider;
	}
	
	public Car (int lane, double y, Texture t) {
		this.x = lane * 124;
		this.y = y;
		this.width =  t.getWidth();
		this.height = t.getHeight();
		this.t = t;
		
		collider = new Rectangle((int)this.x, (int)this.y, this.width, this.height);
		
		this.velocityX = 1;
		calculateTagetX();		
	}
	
	public void paint (Graphics g, Camera cam) {
		if (active) {
			t.paint(g, cam.getScreenX(x), cam.getScreenY(y));
		}
	}
	

}










