package Framework;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Window.Game;
import Window.Game.STATE;


public class Menu extends MouseAdapter {
	private Game game;
	
	public Menu(Game game) {
		this.game = game;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX(); // stores mouse position when presesed
		int my = e.getY();
		if(game.gameState == STATE.Menu) {
			//play btn
			if(mouseOver( mx, my,200, 150, 400, 60)) {
				game.gameState = STATE.Game;
				//System.out.println(game.gameState.toString());
				game.innit();
			}
			//help btn
			if(mouseOver( mx, my,200, 250, 400, 60)) {
				game.gameState = STATE.Help;
				
			}
			
			//quit btn
			 if(mouseOver( mx, my,200, 350, 400, 60)) {
				System.exit(1);
			}
		} else if(game.gameState == STATE.Help) {
			
			//back btn
			 if(mouseOver( mx, my,200, 350, 400, 60)) {
				game.gameState = STATE.Menu;
			}
		}else if(game.gameState == STATE.EndGame) {
			
			//try again btn
			 if(mouseOver( mx, my,200, 500, 400, 60)) {
				 game.gameState = STATE.Menu;
				//game.innit();
				
			}
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my,int x, int y, int width,int height) {
		if(mx > x && mx < x + width ) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}return false;
	}
	
	
	public void tick () {
		
	}
	
	public void render(Graphics g) {
		Font fnt = new Font("arial",1,50);
		Font fnt2 = new Font("arial",1,40);
		if(game.gameState == STATE.Menu) {
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Menu",  320,100);
			
			g.setFont(fnt2);
			
			g.drawRect(200, 150, 400, 60);
			g.drawString("Play", 350, 195);
			
			g.drawRect(200, 250, 400, 60);
			g.drawString("Help", 350, 295);
			
			g.drawRect(200, 350, 400, 60);
			g.drawString("Quit", 350, 395);
			
		}else if(game.gameState == STATE.Help) {
			
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Help",320,100);
			
			g.setFont(fnt2);
			g.drawString("Line 1", 200, 300);
			
			
			g.drawRect(200, 350, 400, 60);
			g.drawString("Back", 350, 395);
		}
		else if(game.gameState == STATE.EndGame) {
			
			g.setColor(Color.WHITE);
			
			g.setFont(fnt2);
			g.drawString("Game Over", 250, 100);
			g.drawString("You lost ", 250, 295);
			
			g.drawRect(200, 500, 400, 60);
			g.drawString("Try again ", 310, 545);
		}
	}
}
