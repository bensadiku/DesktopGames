package LojaSrc;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author B.Sadiku
 */
public class Player extends GameObject{
    Random r = new Random ();
    Handler handler;
    
    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
       
      
    }
    
    public Rectangle getBounds() {
    	return new Rectangle((int)x,(int)y,32,32);
    }
   
    public void tick() {
       x+=velX;
       y+=velY;
       
       x = Game.clamp(x, 0, Game.WIDTH-37);
       y = Game.clamp(y, 0, Game.HEIGHT-66);
       
       handler.addObject(new Trail((int)x,(int)y,ID.Trail,Color.white,32,32,0.09f,handler));
       
       collision();

    }
    private void collision () {
    	for (int i =0;i<handler.object.size();i++) {
    		GameObject tempObject = handler.object.get(i);
    		
    		if(tempObject.getID()==ID.BasicEnemy || tempObject.getID()==ID.FastEnemy || tempObject.getID() == ID.SmartEnemy  ) {
    			if(getBounds().intersects(tempObject.getBounds())) {
    				HUD.HEALTH -=2;
    			}
    		}
    	}
    }

    
    public void render(Graphics g) {
        
    	
            g.setColor(Color.white);
            
          
        //else if (id==ID.Player2)
           // g.setColor(Color.blue);
            g.fillRect((int)x,(int) y, 32, 32);
            
      
    }
    
    
    
}
