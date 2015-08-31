import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class AIPaddle {
	
		int x;
		int y;
		int width = 10;
		int height = 40;
		
		Rectangle collisionBox;
		
		boolean goingUp = false;
		boolean goingDown = false;
		
		public AIPaddle(int x, int y)
		{
			this.x = x;
			this.y = y;
			
			collisionBox = new Rectangle(x, y, width, height); // collisionBox same size as AI Paddle
			collisionBox.setBounds(x, y, width, height);
			
		}
		
		public void tick(Game game)
		{
			collisionBox.setBounds(x, y, width, height);
			
			if(Game.ball.y < y + height  && y >= 0)
			{
				y--;
			}
			else if(Game.ball.y > y && y + height <= game.getHeight() )
			{
				y++;
			}
			
		}
		
		public void render(Graphics g)
		{
			g.setColor(Color.BLACK);
			
			g.fillRect(x, y, width, height);
			
		}
		

	}



