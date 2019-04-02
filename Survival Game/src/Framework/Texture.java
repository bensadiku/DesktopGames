package Framework;

import java.awt.image.BufferedImage;

import Window.BufferedImageLoader;

public class Texture {
	
	// bs is block sheet, ps is player sheet, flg flag, rb = robot,hd = HUD, zmb = zombie
	SpriteSheet bs,ps,dbs,flg,rb,hd,zmb;
	private BufferedImage block_sheet,player_sheet,desert_blocks_sheet,flag_sheet,robot_sheet,hud_sheet,zombie_sheet = null;
	
	public BufferedImage [] block = new BufferedImage[9];
	public BufferedImage [] desert_block = new BufferedImage[16];
	public BufferedImage [] player = new BufferedImage[14];// holds images for walking right and left
	public BufferedImage [] player_jump = new BufferedImage[6];
	public BufferedImage [] flag = new BufferedImage[10];
	public BufferedImage [] robot = new BufferedImage[6];
	public BufferedImage [] huds = new BufferedImage[4];
	public BufferedImage [] zombie = new BufferedImage[8];
	
	
	public Texture () {
		BufferedImageLoader  loader = new BufferedImageLoader();
		try {
			block_sheet = loader.loadImage("/block_sheet.png");
			player_sheet = loader.loadImage("/player_sheet.png");
			desert_blocks_sheet = loader.loadImage("/desert_blocks_sheet.png");
			flag_sheet = loader.loadImage("/flag_sheet.png");
			robot_sheet = loader.loadImage("/robot_walk_sheet.png");
			hud_sheet = loader.loadImage("/Untitled.png");
			zombie_sheet = loader.loadImage("/zombie_sheet.png");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		bs = new SpriteSheet(block_sheet);
		ps = new SpriteSheet(player_sheet);
		dbs = new SpriteSheet(desert_blocks_sheet);
		flg = new SpriteSheet (flag_sheet);
		rb = new SpriteSheet (robot_sheet);
		hd = new SpriteSheet (hud_sheet);
		zmb = new SpriteSheet (zombie_sheet);
		
		
		getTextures();
	}
	
	private void getTextures () {
		//HUD
		huds[0] = hd.grabImage(1, 1, 256, 63);//health bar
		huds[1] = hd.grabImage(1, 2, 256, 63); //gold bar
		huds[2] = hd.grabImage(1, 3, 256, 63);//shield bar
		huds[3] = hd.grabImage(1, 4, 256, 63); //?? bar
		
		
		
		block[0] = bs.grabImage(1, 1, 32, 32);// dirt block
		block[1] = bs.grabImage(2, 1, 32, 32); // grass block
		block[2] = bs.grabImage(3, 1, 32, 32); // lava block
		block[3] = bs.grabImage(4, 1, 32, 32); // lava block
		block[4] = bs.grabImage(5, 1, 32, 32); // lava block
		block[5] = bs.grabImage(6, 1, 32, 32); // lava block
		block[6] = bs.grabImage(7, 1, 32, 32); // lava block
		block[7] = bs.grabImage(8, 1, 32, 32); // lava block
		block[8] = bs.grabImage(9, 1, 32, 32); // lava block
		
		//desert blocks
		desert_block[0] = dbs.grabImage(1, 1, 32, 32);
		desert_block[1] = dbs.grabImage(2, 1, 32, 32); // desert blocks
		desert_block[2] = dbs.grabImage(3, 1, 32, 32);
		desert_block[3] = dbs.grabImage(4, 1, 32, 32);
		desert_block[4] = dbs.grabImage(5, 1, 32, 32);
		desert_block[5] = dbs.grabImage(6, 1, 32, 32); // desert blocks
		desert_block[6] = dbs.grabImage(7, 1, 32, 32);
		desert_block[7] = dbs.grabImage(8, 1, 32, 32);
		desert_block[8] = dbs.grabImage(1, 2, 32, 32);
		desert_block[9] = dbs.grabImage(2, 2, 32, 32); // desert blocks
		desert_block[10] = dbs.grabImage(3, 2, 32, 32);
		desert_block[11] = dbs.grabImage(4, 2, 32, 32);
		desert_block[12] = dbs.grabImage(5, 2, 32, 32);
		desert_block[13] = dbs.grabImage(6, 2, 32, 32); // desert blocks
		desert_block[14] = dbs.grabImage(7, 2, 32, 32);
		desert_block[15] = dbs.grabImage(8, 2, 32, 32);
		
		//looking right
		player[0] = ps.grabImage(1, 1, 32, 64); // idle frame for player
		player[1] = ps.grabImage(2, 1, 32, 64); // walking frame for player
		player[2] = ps.grabImage(3, 1, 32, 64); // walking frame for player
		player[3] = ps.grabImage(4, 1, 32, 64); // walking frame for player
		player[4] = ps.grabImage(5, 1, 32, 64); // walking frame for player
		player[5] = ps.grabImage(6, 1, 32, 64); // walking frame for player
		player[6] = ps.grabImage(7, 1, 32, 64); // walking frame for player

		//looking left
		player[7] =  ps.grabImage(20, 1, 32, 64); // idle frame for player
		player[8] =  ps.grabImage(19, 1, 32, 64); // walking frame for player
		player[9] =  ps.grabImage(18, 1, 32, 64); // walking frame for player
		player[10] = ps.grabImage(17, 1, 32, 64); // walking frame for player
		player[11] = ps.grabImage(16, 1, 32, 64); // walking frame for player
		player[12] = ps.grabImage(15, 1, 32, 64); // walking frame for player
		player[13] = ps.grabImage(14, 1, 32, 64); // walking frame for player
		
		//player jump 
		player_jump[0] =  ps.grabImage(8, 2, 32, 64); // jumping frame for player left
		player_jump[1] =  ps.grabImage(9, 2, 32, 64); // jumping frame for player				
		player_jump[2] =  ps.grabImage(10, 2, 32, 64); // jumping frame for player
		
		player_jump[3] =  ps.grabImage(11, 2, 32, 64); // jumping frame for player
		player_jump[4] =  ps.grabImage(12, 2, 32, 64); // jumping frame for player
		player_jump[5] =  ps.grabImage(13, 2, 32, 64); // jumping frame for player
		
		flag[0] = flg.grabImage(1, 1, 52, 60);
		flag[1] = flg.grabImage(1, 2, 52, 60);
		flag[2] = flg.grabImage(1, 3, 52, 60);
		flag[3] = flg.grabImage(1, 4, 52, 60);
		flag[4] = flg.grabImage(1, 5, 52, 60);
		flag[5] = flg.grabImage(1, 6, 52, 60);
		flag[6] = flg.grabImage(1, 7, 52, 60);
		flag[7] = flg.grabImage(1, 8, 52, 60);
		flag[8] = flg.grabImage(1, 9, 52, 60);
		flag[9] = flg.grabImage(1, 10, 52, 60);
		
		
		robot[0] =  rb.grabImage(1, 1, 311, 379);
		robot[1] =  rb.grabImage(2, 1, 311, 379);
		robot[2] =  rb.grabImage(3, 1, 311, 379);
		robot[3] =  rb.grabImage(4, 1, 311, 379);
		robot[4] =  rb.grabImage(5, 1, 311, 379);
		robot[5] =  rb.grabImage(6, 1, 311, 379);
		

		zombie[0] =  zmb.grabImage(1, 1, 64, 91);
		zombie[1] =  zmb.grabImage(2, 1, 64, 91);
		zombie[2] =  zmb.grabImage(3, 1, 64, 91);
		zombie[3] =  zmb.grabImage(4, 1, 64, 91);
		zombie[4] =  zmb.grabImage(1, 2, 64, 91);
		zombie[5] =  zmb.grabImage(2, 2, 64, 91);
		zombie[6] =  zmb.grabImage(3, 2, 64, 91);
		zombie[7] =  zmb.grabImage(4, 2, 64, 91);
		
		
	}
}
