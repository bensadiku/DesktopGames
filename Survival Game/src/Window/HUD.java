package Window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import Framework.Texture;

public class HUD{
	Texture tex = Game.getInstance();
	public static int HEALTH =100;
	public static int GOLD =1;
	private float greenValue = 255.0f;
	public int bounds=0;
	private int score =0;
	private int level =1;
	protected int fps =0;

	
//	private Animation 	hudAnimation = new Animation(15,tex.huds[0],tex.huds[1] );

	
	
	public void tick () {
		//HEALTH--;
		//HEALTH = Game.clamp(HEALTH, 0, 100);
	
		//hudAnimation.runAnimation();
		
		HEALTH = Game.clamp(HEALTH,0,100+(bounds)/2);
		greenValue = HEALTH *2;
		greenValue = Game.clamp((int)greenValue, 0, 255);
		
	}
	
	public void render(Graphics g) {
		Font fnt = new Font("serif",1,35);
		//g.setColor(Color.GRAY);
		//g.drawRect(15, 25, 200, 32);
	
		//hudAnimation.drawAnimation(g, 15,25 );
		g.drawImage(tex.huds[0],1,15,null);
		g.drawImage(tex.huds[1],315,15,null);
		g.drawImage(tex.huds[2],558,12,null);
		g.setColor(new Color(75,(int)greenValue,0));
		g.fillRect(60, 29, HEALTH*2-20, 32);
		g.setColor(Color.white);
		g.fillRect(575, 29, 180, 32);
		g.setColor(Color.yellow);
		g.setFont(fnt);
		g.drawString(""+GOLD, 405, 58);
		//g.drawImage(tex.huds[3],335,55,null);
	}
	public void setScore (int score) {
		this.score = score;
	}
	
	public int getScore ()
	{
		return score;
	}
	
	public int getLevel ()
	{
		return level;
	}
	
	public void setLevel (int level)
	{
		this.level = level;
	}
	
	public int getFPS()
	{
		return fps;
	}
	
	public void setFPS (int fps)
	{
		this.fps =fps;
	}
}
