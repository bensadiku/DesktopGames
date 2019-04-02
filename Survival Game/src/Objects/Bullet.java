package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Framework.GameObject;
import Framework.ObjectId;
import Framework.SpriteSheet;
import Window.Handler;

public class Bullet extends GameObject {

	private Handler handler;
	public Bullet(int x, int y, ObjectId id,Handler handler,int mx, int my,SpriteSheet ss) {
		super(x, y, id);
		this.handler = handler;
		
		velX = (mx -x) /10;
		velY = (my -y) /10;// speed of the bullet
		
	}

	public void tick() {
		x+= velX;
		y+= velY;
		
		for(int i=0;i<handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Block ) {
				if(getBounds().intersects(tempObject.getBounds())){
					handler.removeObject(this);
				}
				
			}
		}
		
		//handler.addObject(new Trail((int)x,(int)y,ID.Trail,Color.cyan,8,8,0.04f,handler,null));
//		handler.addObject(new Trail((int)x,(int)y,ID.Trail,Color.red,8,8,0.06f,handler,null));

	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillOval((int)x,(int) y, 8, 8);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle ((int)x,(int)y,8,8);
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
		// TODO Auto-generated method stub
		
	}

}
