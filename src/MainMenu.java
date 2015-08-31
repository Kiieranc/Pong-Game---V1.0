import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainMenu extends JFrame{
	private static final long serialVersionUID = 1L;
	
	int screenWidth = 300;
	int screenHeight = 350;
	
	int buttonWidth = 100;
	int buttonHeight = 40;
	
	JButton Play;
	JButton Quit;
	JButton info;
	
	
	
	public MainMenu()
	{
		getContentPane().setLayout(null);
		
		// call methods
		addButtons();
		addActions();
		
		
		Play.setBounds((screenWidth - buttonWidth) / 2, 5, buttonWidth, buttonHeight);
		Quit.setBounds((screenWidth - buttonWidth) / 2, 50, buttonWidth, buttonHeight);
		info.setBounds((screenWidth - buttonWidth) / 2, 95, buttonWidth, buttonHeight);


		// placing buttons
		getContentPane().add(Play);
		getContentPane().add(Quit);
		getContentPane().add(info);
		
		// Jframe
		pack(); 
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(screenWidth, screenHeight);
		setTitle("Pong Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	

	
	
	private void addButtons(){
		
		Play = new JButton("Play");
		Quit = new JButton("Quit");
		info = new JButton("info");
	}
	
	private void addActions(){
		
		Play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				Game game = new Game();
				game.start();
				
			}
		});
		
		Quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				//insert code for info page here
				//Info info = new Info();
				//info.start();
			}
		});
		
	}

}
