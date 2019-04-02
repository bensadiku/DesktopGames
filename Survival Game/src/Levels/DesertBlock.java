package Levels;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Framework.GameObject;
import Framework.ObjectId;
import Framework.Texture;
import Window.Game;

public class DesertBlock extends GameObject {
	
	Texture tex = Game.getInstance();

	private int type;
	public DesertBlock(int x, int y,int type, ObjectId id) {
		super(x, y, id);
		this.type =type;
	}

	public void tick() {
		
	}

	public void render(Graphics g)
	{
		switch(type) {
		case 0: g.drawImage(tex.desert_block[0],(int)x,(int)y,null);
		break;
		case 1: g.drawImage(tex.desert_block[1],(int)x,(int)y,null);
		break;
		case 2: g.drawImage(tex.desert_block[2],(int)x,(int)y,null);
		break;
		case 3: g.drawImage(tex.desert_block[3],(int)x,(int)y,null);
		break;
		case 4: g.drawImage(tex.desert_block[4],(int)x,(int)y,null);
		break;
		case 5: g.drawImage(tex.desert_block[5],(int)x,(int)y,null);
		break;
		case 6: g.drawImage(tex.desert_block[6],(int)x,(int)y,null);
		break;
		case 7: g.drawImage(tex.desert_block[7],(int)x,(int)y,null);
		break;
		case 8: g.drawImage(tex.desert_block[8],(int)x,(int)y,null);
		break;
		case 9: g.drawImage(tex.desert_block[9],(int)x,(int)y,null);
		break;
		case 10: g.drawImage(tex.desert_block[10],(int)x,(int)y,null);
		break;
		case 11: g.drawImage(tex.desert_block[11],(int)x,(int)y,null);
		break;
		case 12: g.drawImage(tex.desert_block[12],(int)x,(int)y,null);
		break;
		case 13: g.drawImage(tex.desert_block[13],(int)x,(int)y,null);
		break;
		case 14: g.drawImage(tex.desert_block[14],(int)x,(int)y,null);
		break;
		case 15: g.drawImage(tex.desert_block[15],(int)x,(int)y,null);
		break;
		
		default:
			g.drawImage(tex.desert_block[15],(int)x,(int)y,null);
		
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
