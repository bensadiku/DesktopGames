package Objects;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Framework.GameObject;
import Framework.ObjectId;
import Framework.Texture;
import Window.Game;

public class Block extends GameObject {
	
	Texture tex = Game.getInstance();

	private int type;
	public Block(int x, int y,int type, ObjectId id) {
		super(x, y, id);
		this.type =type;
	}

	public void tick() {
		
	}

	public void render(Graphics g)
	{
		switch(type) {
		
		case 0: g.drawImage(tex.block[0],(int)x,(int)y,null); // dirt block
		break;
		case 1: g.drawImage(tex.block[1],(int)x,(int)y,null); // grass block
		break;
		case 2: g.drawImage(tex.block[2],(int)x,(int)y,null); // lava block
		break;
		case 3: g.drawImage(tex.block[3],(int)x,(int)y,null); // lava block
		break;
		case 4: g.drawImage(tex.block[4],(int)x,(int)y,null); // lava block
		break;
		case 5: g.drawImage(tex.block[5],(int)x,(int)y,null); // lava block
		break;
		case 6: g.drawImage(tex.block[6],(int)x,(int)y,null); // lava block
		break;
		case 7: g.drawImage(tex.block[7],(int)x,(int)y,null); // lava block
		break;
		case 8: g.drawImage(tex.block[8],(int)x,(int)y,null); // lava block
		break;
		
		
		default: g.drawImage(tex.block[0],(int)x,(int)y,null); // dirt default block
		
		}
		
		
	}

	
	public Rectangle getBounds() {
		return new Rectangle ((int)x,(int)y,32,32);
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
		// TODO Auto-generated method stub
		
	}

}
