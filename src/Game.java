/*
 * author: Kieran Carratt
 * date start: saturday 8th august 2015
 * name: pong game v1.0
 * company: Lost At Sea
 */
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable //using methods of canvas / canvas is a high level jPannel
{
	
	private static final long serialVersionUID = 1L;
	
	public static PlayerPaddle player;
	public static AIPaddle AI;
	public static Ball ball;
	
	public static CircleMain circleCenterMain;
	public static CircleMain circlePlayerMain;
	public static CircleMain circleAiMain;
	
	public static CircleCenter pCenter;
	public static CircleCenter cCenter;
	public static CircleCenter aiCenter;
	
	public static RectangleWidth rectangleTop;
	public static RectangleWidth rectangleMiddle;
	public static RectangleWidth rectangleBottom;
	
	public static RectangleHeight rectangleMid;
	public static RectangleHeight rectanglePlayerGoal;
	public static RectangleHeight rectangleAiGoal;

	InputHandler IH;
	
	
	
	JFrame frame; //window of game
	public final int WIDTH = 600; //width of window
	public final int HEIGHT = WIDTH / 16 * 9;// height of window
	public final Dimension gameSize = new Dimension(WIDTH, HEIGHT);
	public final String TITLE = "Pong V1.0";
	
	public int ScreenWidth;
	public int ScreenHeight;
	
	BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_3BYTE_BGR);

	
	  static boolean gameRunning = false; //weither the game is running
	  
	  int p1Score = 0;
	  int p2Score = 0;
	  
	  Thread thread;
	

	public void run() //cannot 'extend' canvas without 'run' method
	{
		while(gameRunning)
		{
			tick();
			render();
			
			try
			{	
				Thread.sleep(7);
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
	}
	
	public synchronized void start()
	{
		gameRunning = true;
		thread = new Thread(this);
		thread.start();
		//start method
	}
	
	public static synchronized void stop()
	{
		gameRunning = false;
		System.exit(0);
	}
	
	public Game()
	{
		frame = new JFrame();
		
		setMinimumSize(gameSize); // referencing class (.this)
		setPreferredSize(gameSize);
		setMaximumSize(gameSize);
		
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes process when exited
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle(TITLE);
		frame.setLocationRelativeTo(null); //centralized the pannel
		
		ScreenWidth = getWidth();
		ScreenHeight = getHeight();
		
		IH = new InputHandler(this);

		player = new PlayerPaddle(5, 60);
		AI = new AIPaddle(getWidth() - 20,60);
		
		circleAiMain = new CircleMain(getWidth() - 100, getHeight() / 2 - 100);
		circlePlayerMain = new CircleMain(-100, getHeight() / 2 - 100);
		circleCenterMain = new CircleMain(getWidth() / 2 - 100, getHeight() / 2 - 100);
		
		pCenter = new CircleCenter(- 97, getHeight() / 2 - 97);
		cCenter = new CircleCenter(getWidth() / 2 - 97, getHeight() / 2 - 97);
		aiCenter = new CircleCenter(getWidth() - 97, getHeight() / 2 - 97);
		
		rectangleTop = new RectangleWidth(0,1);
		rectangleMiddle = new RectangleWidth(0, getHeight() / 2);
		rectangleBottom = new RectangleWidth(0,getHeight() - 4 );
		
		rectangleMid = new RectangleHeight(getWidth()/ 2, 0);
		rectanglePlayerGoal = new RectangleHeight(1, 0);
		rectangleAiGoal = new RectangleHeight(getWidth() - 4, 0);
		
		ball = new Ball(getWidth()/ 2,getHeight() / 2);

		
	}
	
	public void tick()
	{
		player.tick(this);
		AI.tick(this);
		ball.tick(this);
		
		circleAiMain.tick(this);
		circlePlayerMain.tick(this);
		circleCenterMain.tick(this);
		
		pCenter.tick(this);
		cCenter.tick(this);
		aiCenter.tick(this);
		
		rectangleTop.tick(this);
		rectangleMiddle.tick(this);
		rectangleBottom.tick(this);
		
		rectangleMid.tick(this);
		rectanglePlayerGoal.tick(this);
		rectangleAiGoal.tick(this);
	}
	
	public void render()
	{
		BufferStrategy bs = getBufferStrategy(); // how the buffer is done
		if(bs == null){ // if no buffer stratgey 
			createBufferStrategy(3); // create new buffer strategy with arg 3 (3 = max) reduces screen tearing 
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null); // 0,0 = top left corner
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(Color.BLACK);
		g.drawString("Player 1 Score : " + p1Score, 90, 25);
		g.drawString("Player 2 Score : " + p2Score, 390, 25);
		
		
		circleAiMain.render(g);
		circlePlayerMain.render(g);
		circleCenterMain.render(g);
		
		pCenter.render(g);
		cCenter.render(g);
		aiCenter.render(g);
		
		rectangleTop.render(g);
		//rectangleMiddle.render(g);
		rectangleBottom.render(g);
		
		rectangleMid.render(g);
		rectanglePlayerGoal.render(g);
		rectangleAiGoal.render(g);
		
		player.render(g); //uses graphics from 'getBufferStrategy' to draw the player
		AI.render(g);
		
		ball.render(g);
		
		g.dispose(); // dispose of graphics	
		bs.show(); // once its buffered it can be shown 
	}
	
	
	


}
