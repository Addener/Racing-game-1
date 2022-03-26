import javax.swing.JFrame;

public class Program {

	public static void main(String[] args) {
		
		JFrame w = new JFrame();
		w.setSize(1200, 720);
		w.setResizable(false);
		
		w.setLocation(0, 0);
		w.setVisible(true);
		w.setTitle("Crazy drivers");
		w.setDefaultCloseOperation(3);
		
		GamePanel panel = new GamePanel();
		w.add(panel);
		
		w.addKeyListener(panel);
		
		w.revalidate();
	}

}
