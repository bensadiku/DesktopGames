package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Framework.GameObject;
import Framework.ObjectId;
import Framework.Texture;
import Window.Animation;
import Window.Game;
import Window.Handler;
public class Zombie extends GameObject {
	
Texture tex = Game.getInstance();
	
	private Animation zombieAnimationLeft,zombieAnimationRight;
	private Handler handler;
	private GameObject player;
	private float width = 48, height = 96;
	private int facing =1;//1 is right, -1 is left
	
	
	public Zombie(int x, int y, ObjectId id,Handler handler) {
		super(x, y, id);
		 this.handler = handler;
		 
		 for(int i=0;i<handler.object.size();i++)
	        {
	        	if(handler.object.get(i).getId() == ObjectId.Player) player = handler.object.get(i);
	        }
		 	velX =5;
	        velY=5;
	        
	        zombieAnimationLeft = new Animation(10,tex.zombie[0],tex.zombie[1],tex.zombie[2],tex.zombie[3] );
		 zombieAnimationRight = new Animation(10,tex.zombie[4],tex.zombie[5],tex.zombie[6],tex.zombie[7]);
		//combine smart enemy w collision
	}
	
	public void tick(LinkedList<GameObject>object) {
		  x+=velX;
	       y+=velY;
	       if(velX < 0) facing =-1;
			else if(velX > 0) facing =1;
	       float diffX = x - player.getX()-8;
	       float diffY = y - player.getY() -8;
	       float distance = (float) Math.sqrt ( (x-player.getX())*(x-player.getX()) + (y - player.getY()) * (y - player.getY()));
	       
	       
	       velX = (float) ((-1.0/distance) * diffX);
	       velY = (float) ((-1.0/distance) * diffY);
	       
	       if(y<=0||y>=Game.HEIGHT-32) velY *= -1;
	        if(x<=0||x>=Game.WIDTH-16) velX *= -1;
	        
	        Collision(object);
		zombieAnimationLeft.runAnimation();
		zombieAnimationRight.runAnimation();
	}
	private void Collision(LinkedList<GameObject> object) {
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
			
		}
	}

	public void render(Graphics g) {
		
		
    		if(facing ==-1){
    		
    			zombieAnimationRight.drawAnimation(g,(int) x, (int)y);
    		
    		}
    		else if(facing ==1){
    		
    			zombieAnimationLeft.drawAnimation(g,(int) x, (int)y);
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
