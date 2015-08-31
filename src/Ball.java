import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
	
	int x;
	int y;
	int size = 16;
	int speed = 2;
	
	int velocityX;
	int velocityY;
	
	Rectangle collisionBox;
	
	public Ball(int x,int y)
	{
		this.x = x;
		this.y=y;
		
		velocityX = speed;
		velocityY = speed;
		
		collisionBox = new Rectangle(x, y, size, size);
		collisionBox.setBounds(this.x, this.y, this.size, this.size);
	}
	
	public void print(String a)
	{
		System.out.println(a);
	}
	
	public void tick(Game game)
	{
		collisionBox.setBounds(x, y, size, size);
		
		if(x <= 0 )
		{
			print("Player 2 scored");
			//play sound <insert code here>
			game.p2Score++;
			velocityX = speed;	
		}
		else if(x + size >= game.getWidth() )
		{
			print("Player 1 scored");
			//play sound <insert code here>
			game.p1Score++;
			velocityX = -speed;
		}
		
		if(y <= 0)
		{
			velocityY = speed;
		}
		else if(y + size >= game.getHeight() )
		{
			velocityY =-speed;
		}
		
		
		x += velocityX;
		y += velocityY;
		
		paddleCollide(game);
	}
	private void paddleCollide(Game game){
		
		if(collisionBox.intersects(Game.player.collisionBox))
		{
			velocityX = speed;
		}
		else if(collisionBox.intersects(Game.AI.collisionBox))
		{
			velocityX = -speed;
		}
	}
	
	public void render(Graphics g){
		g.setColor(Color.BLACK);
		g.fillOval(x, y, size, size);
	}

}
