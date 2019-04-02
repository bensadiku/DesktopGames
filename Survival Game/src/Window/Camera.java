package Window;

import Framework.GameObject;

public class Camera {

	private float x,y;
	
	public Camera (float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void tick (GameObject player) {
	
		/*x+= ((player.getX()- x) - 1000/2 ) * 0.05f;
		y+= ((player.getY()- y) - 563/2 ) * 0.05f;
		
		
		

			if(x <= 0) x=0;
			if(x >= 1032) x= 1032;
							/// Limiting Camera bounds
			if(y <= 0) y=0;
			if(y >= 620) y= 620;
		*/
		
		
		x = -player.getX() + Game.WIDTH/2;
		
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
}
