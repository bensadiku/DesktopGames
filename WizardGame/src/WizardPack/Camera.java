package WizardPack;

public class Camera {

	private float x,y;
	
	public Camera (float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void tick (GameObject object) {
		x+= ((object.getX()- x) - 1000/2 ) * 0.05f;
		y+= ((object.getY()- y) - 563/2 ) * 0.05f;
		
		
		if(Game.wizardLevel ==1) {

			if(x <= 0) x=0;
			if(x >= 1032) x= 1032;
							/// Limiting Camera bounds
			if(y <= 0) y=0;
			if(y >= 620) y= 620;
		}
		else if (Game.wizardLevel ==2) {
			if(x <= 0) x=0;
			if(x >= 3032) x= 3032;
							/// Limiting Camera bounds for lvl2
			if(y <= 0) y=0;
			if(y >= 2000) y= 2000;
		}
		else if (Game.wizardLevel ==3) {
			

			if(x <= 0) x=0;
			if(x >= 1050) x= 1050;
							/// Limiting Camera bounds for lvl3
			if(y <= 0) y=0;
			if(y >= 1510) y= 1510;
		}
		else if (Game.wizardLevel == 4) {
			

			if(x <= 0) x=0;
			if(x >= 1032) x= 1032;
							/// Limiting Camera bounds for lvl4
			if(y <= 0) y=0;
			if(y >= 1510) y= 1510;
		}
		
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
