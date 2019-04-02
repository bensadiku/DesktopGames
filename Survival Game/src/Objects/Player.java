package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Framework.GameObject;
import Framework.ObjectId;
import Framework.Texture;
import Window.Animation;
import Window.Camera;
import Window.Game;
import Window.HUD;
import Window.Handler;

public class Player extends GameObject {

	private float width = 48, height = 96;

	private float gravity  = 0.5f;
	private final float MAX_SPEED =10f;
	private int facing =1;//1 is right, -1 is left
	
	
	private Handler handler;
	private Camera cam;
	private Game game;
	
	Texture tex = Game.getInstance();
	
	private Animation playerWalk,playerWalkLeft,playerJumpLeft,playerJumpRight;
	
	public Player(float x, float y,Handler handler, Camera cam, Game game, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
		this.cam = cam;
		this.game = game;
		
		playerWalk = new Animation(10,tex.player[2],tex.player[3],tex.player[4],tex.player[5],tex.player[6]);
		playerWalkLeft = new Animation(10,tex.player[7],tex.player[8],tex.player[9],tex.player[10],tex.player[11]);
		
		playerJumpLeft = new Animation(10,tex.player_jump[0],tex.player_jump[1],tex.player_jump[2]);
		playerJumpRight = new Animation(10,tex.player_jump[3],tex.player_jump[4],tex.player_jump[5]);

	}
	 public  void tick() {
	    
	    }
		public  void tick(LinkedList<GameObject>object) {
			x+= velX;
			y+= velY;
			
			
			if(velX < 0) facing =-1;
			else if(velX > 0) facing =1;
			
			
			if(falling || jumping) {
				velY += gravity;
				
				if(velY > MAX_SPEED) {
					velY = MAX_SPEED;
				}
			}
			Collision(object);
			
			playerWalk.runAnimation();  
			playerWalkLeft.runAnimation();
			playerJumpLeft.runAnimation();
			playerJumpRight.runAnimation();
		}
		
		private void Collision(LinkedList<GameObject> object) 
		{
			for(int i=0;i<handler.object.size();i++)
			{
				GameObject tempObject = handler.object.get(i);
				
				if(tempObject.getId() == ObjectId.Block || tempObject.getId() == ObjectId.DesertBlock ) 
				{
					if(getBoundsTop().intersects(tempObject.getBounds()))
					{
						y = tempObject.getY();
						velY =0;
					}
					
					if(getBounds().intersects(tempObject.getBounds()))
					{
						y = tempObject.getY()-height;
						velY =0;
						falling =false;
						
						jumping =false;
					}else 
						falling =true;
					

					//Right Collision
					if(getBoundsRight().intersects(tempObject.getBounds()))
					{
						x = tempObject.getX()-width;
					}
					
					//Left
					if(getBoundsLeft().intersects(tempObject.getBounds()))
					{
						x = tempObject.getX()+32;
					}	
				}
				else if(tempObject.getId() == ObjectId.Flag) {
					//next level
					if(getBounds().intersects(tempObject.getBounds())) {
						handler.clearLevel();
						Game.LEVEL++;
						game.NextLevel();
						//cam.setX(0);
					}
					
				}else if(tempObject.getId() == ObjectId.Zombie) {
					if(getBounds().intersects(tempObject.getBounds())) {
						HUD.HEALTH-=2;
					}
				}
			}
		}
		
		
		
	    public  void render (Graphics g) 
	    {
	    	
	    	
	    	g.setColor(Color.blue);
	    	if(jumping) {
	    		if(facing ==1){
	    		
	    			playerJumpLeft.drawAnimation(g,(int) x, (int)y,48,96);
	    		
	    		}
	    		else if(facing ==-1){
	    			playerJumpRight.drawAnimation(g,(int) x, (int)y,48,96);
	    			
	    		}
	    	}else {
	    		if(velX != 0) 
		    	{
		    		if(facing==1) {
		    			playerWalk.drawAnimation(g,(int) x, (int)y,48,96);
		    		}
		    		else 
		    			playerWalkLeft.drawAnimation(g,(int) x, (int)y,48,96);
		    		
		    		
		    	}
		    	else {
		    		if(facing ==1) {
		    			g.drawImage(tex.player[0],(int)x,(int) y, 48,96,null);
		    		}
		    		
		    		else if(facing ==-1) {
		    			g.drawImage(tex.player[7],(int)x,(int) y, 48,96,null);
		    		}
		    	    
		    	}
	    	}
	    	
	    	
	    	
	    	
	    }
	    
	    
	    public Rectangle getBounds () {
	    	
	    	return new Rectangle((int) ((int) (int)x+(width/4)), (int) ((int )y+(height/2)), (int ) width/2, (int) height/2);
	    }
	    public Rectangle getBoundsTop () {
	     	
	    	return new Rectangle((int) ((int)x+(width/2)-(width/2)/2), (int )y, (int ) width/2, (int) height/2);
	    }
	    public Rectangle getBoundsRight () {
	    	
	    	return new Rectangle((int) ((int)x+width-5), (int )y+5, (int ) 5, (int) height-10);
	    }
	    public Rectangle getBoundsLeft () {
 	
	    	return new Rectangle((int)x, (int )y+5, (int ) 5, (int) height-10);
	    }
	    
}
