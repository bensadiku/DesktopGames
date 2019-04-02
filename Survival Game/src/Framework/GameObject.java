package Framework;


	

    
	import java.awt.Color;

/*
	 * To change this license header, choose License Headers in Project Properties.
	 * To change this template file, choose Tools | Templates
	 * and open the template in the editor.
	 */

	import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

	/**
	 *
	 * @author B.Sadiku
	 */
	public abstract class GameObject {
	 

		protected float x, y;
	    protected ObjectId id;
	    protected float velX, velY;
		protected boolean falling = true;
		protected boolean jumping = false;
	    
	    public GameObject (float x, float y, ObjectId id)
	    {
	        this.x=x;
	        this.y=y;
	        this.id =id;
	        
	        
	    }
	    public  void tick() {
	    	
	    }
		public  abstract void tick(LinkedList<GameObject>object);
	    public  abstract void render (Graphics g) ;
	    
	    public abstract  Rectangle getBounds();
	    
	    public void setX(int x)
	    {
	        this.x= x;
	    }         
	    
	    public void setY (int y)
	    {
	        this.y= y;
	    }
	    
	    public float getX ()
	    {
	        return x;
	    }
	    
	    public float getY ()
	    {
	        return y;
	    }
	    
	    public void setID (ObjectId id)
	    {
	        this.id = id;
	    }
	    
	    public ObjectId getId()
	    {
	        return id;
	    }
	    
	    public void setVelX (float velX)
	    {
	        this.velX =velX;
	        
	    }
	    
	    public void setVelY (float velY)
	    {
	        this.velY = velY;
	    }
	    
	    public float getVelX ()
	    {
	        return velX;
	    }
	    
	    public float getVelY ()
	    {
	        return velY;
	    }
	    public boolean isFalling() {
	 			return falling;
	 		}
	 		public void setFalling(boolean falling) {
	 			this.falling = falling;
	 		}
	 		public boolean isJumping() {
	 			return jumping;
	 		}
	 		public void setJumping(boolean jumping) {
	 			this.jumping = jumping;
	 		}
	    
	}
