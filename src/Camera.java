
public class Camera {

	double x, y;
	int width  = 800;
	int height = 800;
	
	public int getScreenX(double carX) {
		return (int)(carX - x);
	}
	
	public int getScreenY(double carY) {
		return (int)(carY - y);
	}
	
	
	
}
