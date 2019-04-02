package LojaSrc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import LojaSrc.Game.STATE;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random ();
	
	public Menu(Game game, Handler handler,HUD hud) {
		this.handler =handler;
		this.game = game;
		this.hud =hud;
	} 
	
	
	public void mousePressed (MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState == STATE.Menu) {
			//play btn
			if(mouseOver(mx,my,210, 150, 200, 64)){
			
				
				
	             game.gameState = STATE.Select;
	             AudioPlayer.getSound("menu_sound").play();
	             return;
	             
			}
			//help btn
			if(mouseOver(mx,my,210, 250, 200, 64))
			{
				
				game.gameState = STATE.Help;
			    AudioPlayer.getSound("menu_sound").play();
			}
			
			//quit btn
			if(mouseOver(mx,my,210, 350, 200, 64)){
				System.exit(1);	
			}
		}
		if(game.gameState == STATE.Select) {
			//Normal btn
			if(mouseOver(mx,my,210, 150, 200, 64)){
				game.gameState = STATE.Game;
				
				handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32, ID.Player, handler));
				handler.clearEnemies();
	            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50),r.nextInt(Game.HEIGHT -50),ID.BasicEnemy,handler));
	            game.diff = 0;
	            
	            
	             AudioPlayer.getSound("menu_sound").play();         
			}
			//Hard btn
			if(mouseOver(mx,my,210, 250, 200, 64))
			{
				
				game.gameState = STATE.Game;

				handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32, ID.Player, handler));
				handler.clearEnemies();
	            handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH -50),r.nextInt(Game.HEIGHT -50),ID.BasicEnemy,handler));
	            game.diff = 1;
	            
	            AudioPlayer.getSound("menu_sound").play();  
	            
			}
			
			//Back btn
			if(mouseOver(mx,my,210, 350, 200, 64)){			
				
					    AudioPlayer.getSound("menu_sound").play();
						game.gameState = STATE.Menu;
						return;
			}
		}
		//Try again btn for game over
				if(game.gameState == STATE.End)
				{
					if(mouseOver(mx,my,210, 350, 200, 64)){
						
						game.gameState = STATE.Select;
						 hud.setLevel(1);
		            	 hud.setScore(0);
						
			             AudioPlayer.getSound("menu_sound").play();
					}
				}
				
		//back btn for help
		if(game.gameState == STATE.Help)
		{
			if(mouseOver(mx,my,210, 350, 200, 64)){
				
			    AudioPlayer.getSound("menu_sound").play();
				game.gameState = STATE.Menu;
				return;
			}
		}
	}
	public void mouseReleased (MouseEvent e) {
		
			
		
	}
	
	private boolean mouseOver (int mx, int my,int x, int y, int width, int height) {
		if (mx > x && mx < x + width) {
			if (my > y && my < y + height) {
				return true;
			}
			else return false;
		}else return false;
	}
	
	public void tick () {
		
	}
	
	public void render(Graphics g) {
		if(game.gameState == STATE.Menu) {
			Font fnt = new Font ("arial",1,50);
			Font fnt2 = new Font ("arial",1,30);
			
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Menu", 240, 70);
			
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			
			
			g.setColor(Color.white);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Play", 280, 195);
			
			g.setColor(Color.white);
			g.drawRect(210, 250, 200, 64);
			g.drawString("Help", 280, 295);
			
			g.setColor(Color.white);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Quit", 280, 395);
		}else if (game.gameState == STATE.Help) {
			Font fnt = new Font ("arial",1,50);
			Font fnt2 = new Font ("arial",1,30);
			Font fnt3 = new Font ("arial",10,25);
			
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Help", 250, 40);
			
			g.setFont(fnt2);
			g.drawString("Use W,A,S,D keys to move around.", 10, 100);
			
			g.setFont(fnt3);
			g.drawString("The longer you survive, the higher level you get.", 8, 150);
			g.drawString("The higher levels you get, you'll encounter more bosses.", 8, 200);
			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 270, 395);
		}
		else if (game.gameState == STATE.End) {
			Font fnt = new Font ("arial",1,50);
			Font fnt2 = new Font ("arial",1,30);
			Font fnt3 = new Font ("arial",10,25);
			
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Game Over", 200, 90);
			
			
			
			
			g.setFont(fnt3);
			g.drawString("You lost with a score of: "+hud.getScore(), 165, 225);
			
			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Try again.", 245, 395);
		}else if(game.gameState == STATE.Select) {
			Font fnt = new Font ("arial",1,50);
			Font fnt2 = new Font ("arial",1,30);
			
			g.setFont(fnt);
			g.setColor(Color.cyan);
			g.drawString("Select Difficulty", 155, 70);
			
			
			
			
			g.setFont(fnt2);
			g.setColor(Color.green);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Normal", 265, 195);
			
			g.setColor(Color.red);
			g.drawRect(210, 250, 200, 64);
			g.drawString("Hard", 280, 295);
			
			g.setColor(Color.white);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 280, 395);
		}
	
	}

}
