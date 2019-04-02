package LojaSrc;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	public int bounds=0;
	public static float HEALTH =100.0f;
	private float greenValue = 255.0f;
	private int score =0;
	private int level =1;
	protected int fps =0;
	
	public void tick() {
		
		HEALTH = Game.clamp(HEALTH,0,100+(bounds)/2);
		greenValue = HEALTH *2;
		greenValue = Game.clamp(greenValue, 0, 255);
		
		score++;
	}
	
	public void render (Graphics g) {
			g.setColor(Color.gray);
			g.fillRect(15, 15, 200+bounds, 32);
			g.setColor(new Color(75,(int)greenValue,0));
			g.fillRect(15, 15, (int)HEALTH *2, 32);
			g.setColor(Color.white);
			g.drawRect(15, 15, 200+bounds, 32);
			
			g.drawString("Score: "+score, 15,64);
			g.drawString("Level: "+level, 15,80);
			g.drawString("FPS: "+ fps, 535,45);
			g.drawString("Space for Shop ", 535,25);
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
