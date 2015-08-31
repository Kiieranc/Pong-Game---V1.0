import java.awt.Color;
import java.awt.Graphics;

public class CircleMain {
	
	int x;
	int y;
	
	int size = 200;
	
	public CircleMain(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void tick(Game game){
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.RED);
		g.fillOval(x, y, size, size);
	}

}
