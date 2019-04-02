package Window;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import Framework.KeyInput;
import Framework.Menu;
import Framework.ObjectId;
import Framework.Texture;
import Levels.DesertBlock;
import Objects.Block;
import Objects.Flag;
import Objects.Player;
import Objects.Zombie;


public class Game extends Canvas implements Runnable 	 {

	private static final long serialVersionUID = 1L;

	
	private boolean running =false;
	private Thread thread;
	private Menu menu;
	public static int WIDTH, HEIGHT;
	private HUD hud;

	private BufferedImage [] background= new BufferedImage[10];

	
	Handler handler;
	Camera cam;
	static Texture tex;
	
	public static int LEVEL=2;
	public BufferedImage [] level = new BufferedImage[10];
	
	
	public enum STATE {
		Menu,
		Help,
		Game,
		EndGame
	};
	
	public STATE gameState = STATE.Menu; // casts STATE enumeration to Menu specifically
	
	
	
	
	
	public void innit() {
		WIDTH = getWidth();
		HEIGHT = getHeight();
		tex= new Texture ();
		
		cam = new Camera (0,0);
		handler = new Handler (cam);
		menu =new Menu (this);
		this.addMouseListener(menu);
		hud = new HUD();
		
		if(gameState == STATE.Game) {

			BufferedImageLoader loader= new BufferedImageLoader();
			level[1] = loader.loadImage("/level_1.png"); //loades the level
			level[2] = loader.loadImage("/level_2.png"); //loades the level
			
			LoadImageLevel(level[Game.LEVEL]);
			background[1] = loader.loadImage("/background_1.png"); // loads backgroynd
			background[2] = loader.loadImage("/background_2.png"); // loads backgroynd
			
			
			
			
		}
		
		
		
		
		this.addKeyListener(new KeyInput(handler));
	}
	
	public synchronized void start () {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run () {
		innit();
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
			//System.out.println(frames);
				timer += 1000;
				frames = 0;
			}
		}
		stop();		
	}
	private void stop(){
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void tick() {
		handler.tick();
		if(gameState == STATE.Game) {
			for(int i=0; i< handler.object.size();i++) {
				if(handler.object.get(i).getId() == ObjectId.Player) {
					cam.tick(handler.object.get(i));
					hud.tick();
					
					if(HUD.HEALTH <=0) {
						HUD.HEALTH =100;
						gameState=STATE.EndGame;
						handler.clearLevel();
					}
				}
			}
		}else if(gameState== STATE.Menu || gameState == STATE.EndGame){
			menu.tick();
		}
		
		
		
		
		
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D)g;
		/////////////////////
		
		
		////////////////
		g.fillRect(0, 0, getWidth(), getHeight());
		
		
		
		//handler.render(g);
		
		
		
		if(gameState == STATE.Game) {
			g2d.translate(cam.getX(),cam.getY());//begining of cam
			
			try{
				for(int xx=0;xx < background[LEVEL].getWidth()*10 ; xx+= background[LEVEL].getWidth()) {
					g.drawImage(background[LEVEL], xx, 0, this);
				}
			}
			catch (Exception e) {
				
			}
			
		
			handler.render(g);
			
			
			g2d.translate(-cam.getX(),-cam.getY()); //end of cams
			hud.render(g);
		
		}
		else if(gameState== STATE.Menu || gameState== STATE.Help || gameState== STATE.EndGame){
			menu.render(g);
		}
		
		
		
		g.dispose();
		bs.show();		
	}
	
	public static int clamp (int var,int min, int max) {
		if(var >= max) {
			return var =max;
		}
		else if(var<= min) {
			return var =min;
		}
		else
			return var;
		
	}
	

	public void LoadImageLevel (BufferedImage image) {
		
		try {
		
		int w = image.getWidth();
		int h = image.getHeight();
		
		
		for(int xx =0; xx<h; xx++) {
			for(int yy=0; yy<w; yy++) {
				
				int pixel  = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8 ) & 0xff;
				int blue = (pixel) & 0xff;
				
				if(LEVEL==1) {
					if(red== 0 && green == 0 & blue == 255)//blue color 
						handler.addObject(new Player(xx*32,yy*32,handler,cam,this,ObjectId.Player));
					
					if(red== 255 && green == 216 & blue == 0)//yellow color 
						handler.addObject(new Flag(xx*32,yy*32,ObjectId.Flag));
					
					if(red== 160 && green == 160 & blue == 160)//gray color 
						handler.addObject(new Block(xx*32,yy*32,0,ObjectId.Block));		
					
					if(red== 255 && green == 255 & blue == 255)//white color 
						handler.addObject(new Block(xx*32,yy*32,1,ObjectId.Block));
					
					if(red== 127 && green == 201 & blue == 255)//blue/ish color /lava
						handler.addObject(new Block(xx*32,yy*32,2,ObjectId.Block));
					
					if(red== 214 && green == 127 & blue == 255)// pink color /lava
						handler.addObject(new Block(xx*32,yy*32,3,ObjectId.Block));
					
					if(red== 91 && green == 127 & blue == 0)//yellow/ish color /lava
						handler.addObject(new Block(xx*32,yy*32,4,ObjectId.Block));
					
					if(red== 127 && green == 51 & blue == 0)//brown color /lava
						handler.addObject(new Block(xx*32,yy*32,5,ObjectId.Block));
					
					if(red== 255 && green == 178 & blue == 127)//brown color /lava
						handler.addObject(new Block(xx*32,yy*32,6,ObjectId.Block));
					
					if(red== 255 && green == 233 & blue == 127)//yellow/ish color /lava
						handler.addObject(new Block(xx*32,yy*32,7,ObjectId.Block));
					
					if(red== 218 && green == 255 & blue == 127)//yellow/ish color /lava
					handler.addObject(new Block(xx*32,yy*32,8,ObjectId.Block));
					
				}
				else if(LEVEL==2) {
					//desrt level
					if(red== 0 && green == 0 & blue == 255)//blue color 
						handler.addObject(new Player(xx*32,yy*32,handler,cam,this,ObjectId.Player));
					
					//if(red== 255 && green == 0 & blue == 220) 
						//.addObject(new Robot(xx*32,yy*32,ObjectId.Robot,handler));
					
					if(red== 127 && green == 63 & blue == 91)//desert block color 
						handler.addObject(new DesertBlock(xx*32,yy*32,0,ObjectId.DesertBlock));		
					
					if(red== 255 && green == 0 & blue == 110)//desert block color 
						handler.addObject(new DesertBlock(xx*32,yy*32,1,ObjectId.DesertBlock));		//
					
					if(red== 255 && green == 127 & blue == 182)//desert block color 
						handler.addObject(new DesertBlock(xx*32,yy*32,2,ObjectId.DesertBlock));	

					if(red== 255 && green == 0 & blue == 220)//desert block color 
						handler.addObject(new DesertBlock(xx*32,yy*32,3,ObjectId.DesertBlock));	//	4
					
					if(red== 127 && green == 0 & blue == 110)//desert block color 
						handler.addObject(new DesertBlock(xx*32,yy*32,4,ObjectId.DesertBlock));		//5
					
					if(red== 255 && green == 127 & blue == 237)//desert block color 
						handler.addObject(new DesertBlock(xx*32,yy*32,5,ObjectId.DesertBlock));		//

					if(red== 127 && green == 63 & blue == 118)//desert block color 
						handler.addObject(new DesertBlock(xx*32,yy*32,6,ObjectId.DesertBlock));	//	
					
					if(red== 178 && green == 0 & blue == 255)//desert block color 
						handler.addObject(new DesertBlock(xx*32,yy*32,7,ObjectId.DesertBlock));		//
					
					if(red== 87 && green == 0 & blue == 127)//desert block color 
						handler.addObject(new DesertBlock(xx*32,yy*32,8,ObjectId.DesertBlock));		//

					if(red== 214 && green == 127 & blue == 255)//desert block color 
						handler.addObject(new DesertBlock(xx*32,yy*32,9,ObjectId.DesertBlock));		//
					
					if(red== 72 && green == 0 & blue == 255)//desert block color 
						handler.addObject(new DesertBlock(xx*32,yy*32,10,ObjectId.DesertBlock));//		
					
					if(red== 0 && green == 19 & blue == 127)//desert block color 
						handler.addObject(new DesertBlock(xx*32,yy*32,11,ObjectId.DesertBlock));	//	

					if(red== 0 && green == 148 & blue == 255)//desert block color 
						handler.addObject(new DesertBlock(xx*32,yy*32,12,ObjectId.DesertBlock));//		
					
					if(red== 0 && green == 255 & blue == 255)//desert block color 
						handler.addObject(new DesertBlock(xx*32,yy*32,13,ObjectId.DesertBlock));	//	
					
					if(red== 0 && green == 255 & blue == 144)//desert block color 
						handler.addObject(new DesertBlock(xx*32,yy*32,14,ObjectId.DesertBlock));	//

					if(red== 0 && green == 127 & blue == 70)//desert block color 
						handler.addObject(new DesertBlock(xx*32,yy*32,15,ObjectId.DesertBlock));//		
					
					
					if(red== 255 && green == 216 & blue == 0)//yellow color 
						handler.addObject(new Flag(xx*32,yy*32,ObjectId.Flag));
					
					if(red== 255 && green == 255 & blue == 255)//white color 
						handler.addObject(new Zombie(xx*32,yy*32,ObjectId.Zombie,handler));
					
				}
			
				
			
				
		
			
			}
			
		}
	}
		catch(Exception e) {
				e.printStackTrace();
		
		}
	}
	public  void NextLevel () {
		
		LoadImageLevel(level[LEVEL]);
		}
	
	
	public static Texture getInstance() {
		return tex;
	}

	public static void main (String args[]) {
		new Window(800,600,"Survive", new Game());
	}
}
