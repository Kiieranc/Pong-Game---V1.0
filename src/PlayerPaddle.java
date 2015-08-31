import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlayerPaddle 
{
	int x;
	int y;
	int width = 10;
	int height = 40;
	int speed = 2;
	
	Rectangle collisionBox;
	
	boolean goingUp = false;
	boolean goingDown = false;
	
	public PlayerPaddle(int x, int y)
	{
		this.x = x;
		this.y = y;
		
		//setting up collision box same size as playerPaddle
		//////////////
		//			//
		//			//
		//		   |//
		// 			//
		//| o		//
		//////////////
		collisionBox = new Rectangle(x, y, width, height);
		collisionBox.setBounds(x, y, width, height);
		
	}
	
	public void tick(Game game)
	{
		collisionBox.setBounds(x, y, width, height);
		
		if(goingUp == true && y > 0 )
		{
			y -= speed;
		}
		if(goingDown == true &&  y < game.getHeight() - height )
		{
			y += speed;
		}
		
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.BLACK);
		
		g.fillRect(x, y, width, height);
		
	}
	

}
