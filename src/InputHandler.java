import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class InputHandler implements KeyListener{

	public InputHandler(Game game){
		game.addKeyListener(this);
	}
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_W)
		{
			Game.player.goingUp = true; // if 'W' key is pressed move player up
		}
		
		if(keyCode == KeyEvent.VK_S)
		{
			Game.player.goingDown = true; // if 'S' is pressed move player down
			
		}
		
	}

	
	public void keyTyped(KeyEvent e) {
		
	}

	
	public void keyReleased(KeyEvent e) 
	{
		int keyCode = e.getKeyCode();
				
			if(keyCode == KeyEvent.VK_W)
			{
				Game.player.goingUp = false; // stop moving down
			}
			
			if(keyCode == KeyEvent.VK_S)
			{
				Game.player.goingDown = false; // if 'S' is pressed move player down
				
			}
		
	}

}


