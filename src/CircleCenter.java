import java.awt.Color;
import java.awt.Graphics;

public class CircleCenter {
	
	int x;
	int y;
	
	int size = 194;
	
	public CircleCenter(int x, int y){
		this.x = x;
		this.y = y; 
	}
	
	public void tick(Game game)
	{
		
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillOval(x, y, size, size);
	}

}
