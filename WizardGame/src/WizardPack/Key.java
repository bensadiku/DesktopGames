package WizardPack;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Key extends GameObject{

	//private BufferedImage key_image;
	
	private BufferedImage[] key_image = new BufferedImage[6];
	
	Animation anim;
	
	public Key(int x, int y, ID id,SpriteSheet ss) {
		super(x, y, id, ss);
		//key_image[0] = ss.grabImage(9, 2, 32, 32);
		key_image[0] = ss.grabImage(7, 1, 32, 32);
		key_image[1] = ss.grabImage(8, 1, 32, 32);
		key_image[2] = ss.grabImage(9, 1, 32, 32);
		key_image[3] = ss.grabImage(7, 2, 32, 32);
		key_image[4] = ss.grabImage(8, 2, 32, 32);
		key_image[5] = ss.grabImage(9, 2, 32, 32);
		
		anim = new Animation(6, key_image[0], key_image[1], key_image[2],key_image[3],key_image[4],key_image[5]);
		//
	}

	public void tick() {
		anim.runAnimation();
	}

	public void render(Graphics g) {
		//g.drawImage(key_image, x, y, null);
		
		//g.drawImage(key_image[0], x, y, null);
		
		anim.drawAnimation(g, x, y, 0);
	}

	public Rectangle getBounds() {
		return new Rectangle (x,y,32,32);
	}

}
