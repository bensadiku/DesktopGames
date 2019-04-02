package WizardPack;
import java.awt.Graphics;
import java.util.LinkedList;


public class Handler {
	
	LinkedList<GameObject> object = new LinkedList <GameObject>();
	
	private boolean up =false, down = false, right = false, left =false;
	
	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public void tick() {
		for(int i =0 ; i<object.size();i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}
	
	public void render (Graphics g) {
		for(int i =0 ; i<object.size();i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void addObject (GameObject tempObject) {
		object.add(tempObject);
	}
	
	public void removeObject (GameObject tempObject) {
		object.remove(tempObject);
	}
	
	 
    public void clearEnemies() {
        for (int i = 0; i < this.object.size(); i++) {
            GameObject tempObject = this.object.get(i);
            if (tempObject.getId() != ID.Player) {
                this.removeObject(tempObject);
                i--;
            }
        }
    }
    public void clearPlayer() {
        for (int i = 0; i < this.object.size(); i++) {
            GameObject tempObject = this.object.get(i);
            if (tempObject.getId() == ID.Player) {
                this.removeObject(tempObject);
                i--;
            }
        }
    }
    
    public void clearLevel () {
        for (int i = 0; i < this.object.size(); i++) {
            GameObject tempObject = this.object.get(i);
                this.removeObject(tempObject);
                i--;
        }
    }
	
}
