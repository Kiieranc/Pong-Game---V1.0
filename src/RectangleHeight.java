import java.awt.Color;
import java.awt.Graphics;

public class RectangleHeight {
	
	int x;
	int y;
	
	int rectWidth = 3;
	int rectHeight = 416;
	
	public RectangleHeight(int x, int y){
		
		this.x = x;
		this.y = y;
		
	}
	
	public void tick(Game game)
	{
	
		
	}
	public void render(Graphics g)
	{
		g.setColor(Color.RED);
		
		g.fillRect(x, y, rectWidth, rectHeight);
		
	}

}
