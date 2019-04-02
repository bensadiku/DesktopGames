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

public class Flag  extends GameObject{
	
	Texture tex = Game.getInstance();
	
	private Animation flagAnimation;
	
	
	public Flag(float x, float y, ObjectId id) {
		super(x, y, id);
		flagAnimation = new Animation(5,tex.flag[0],tex.flag[1],tex.flag[2],tex.flag[3],tex.flag[4],tex.flag[5],tex.flag[6],tex.flag[7],tex.flag[8],tex.flag[9]);
	}

	public void tick(LinkedList<GameObject>object)  {
		flagAnimation.runAnimation();
	}
	
	public void render(Graphics g) {
	//	g.setColor(Color.yellow);
		//g.fillRect((int)x,(int) y, 32, 32);
		flagAnimation.drawAnimation(g,(int) x,(int) y);
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32,32);
	}
}
