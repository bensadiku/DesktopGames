package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;

import Framework.GameObject;
import Framework.ObjectId;
import Framework.Texture;
import Window.Animation;
import Window.Game;
import Window.Handler;
public class Robot extends GameObject {
	
Texture tex = Game.getInstance();
	
	private Animation robotAnimation;
	private Handler handler;
	private GameObject player;
	Random r = new Random ();
	int choose =0;
	int hp =100;
	
	
	
	public Robot(int x, int y, ObjectId id,Handler handler) {
		super(x, y, id);
		 this.handler = handler;
	        
	        for(int i=0;i<handler.object.size();i++)
	        {
	        	if(handler.object.get(i).getId() == id.Player) player = handler.object.get(i);
	        }
	        
	        
	        
	        velX =5;
	        velY=5;
	        
		robotAnimation = new Animation(10,tex.robot[0],tex.robot[1],tex.robot[2],tex.robot[3],tex.robot[4],tex.robot[5] );

		
	}

	public void tick(LinkedList<GameObject>object) {

	       x+=velX;
	       y+=velY;
	       
	       float diffX = x - player.getX()-8;
	       float diffY = y - player.getY() -8;
	       float distance = (float) Math.sqrt ( (x-player.getX())*(x-player.getX()) + (y - player.getY()) * (y - player.getY()));
	       
	       
	       velX = (float) ((-1.0/distance) * diffX);
	       velY = (float) ((-1.0/distance) * diffY);
	       
	       if(y<=0||y>=Game.HEIGHT-32) velY *= -1;
	        if(x<=0||x>=Game.WIDTH-16) velX *= -1;
	        
	      //  handler.addObject(new Robot((int)x,(int)y,id.Robot,Color.green,16,16,0.05f,handler));
	   
	   
		robotAnimation.runAnimation();
	}

	public void render(Graphics g) {
		//g.drawImage(tex.robot[0],(int)x,(int) y, 48,96,null);
		
		robotAnimation.drawAnimation(g, (int)x,(int) y);
	}

	public Rectangle getBounds() {
		return new Rectangle ((int)x,(int)y,232,232);
	}
	
	

}
