import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Bomb extends CharacterObject {

	public Bomb(int x, int y) {
		super(x, y);
		BufferedImageLoader loader = new BufferedImageLoader();
		BufferedImage spriteSheet = null;
		try {
			spriteSheet = loader.loadImage("sprites/sprite_bomb.gif");
		} catch (IOException e) {
			e.printStackTrace();
		}
		SpriteSheet ss = new SpriteSheet(spriteSheet);
		ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();
		// black bomb
		sprites.add(ss.grabSprite(122, 124, 32, 32));
		sprites.add(ss.grabSprite(150, 124, 32, 32));
		sprites.add(ss.grabSprite(178, 124, 32, 32));
		//red bomb
		sprites.add(ss.grabSprite(122, 156, 32, 32));
		sprites.add(ss.grabSprite(150, 156, 32, 32));
		sprites.add(ss.grabSprite(178, 156, 32, 32));
		// bomb explosion
		sprites.add(ss.grabSprite(30, 196, 50, 50));
		sprites.add(ss.grabSprite(82, 196, 50, 50));
		sprites.add(ss.grabSprite(133, 196, 50, 50));
		sprites.add(ss.grabSprite(187, 196, 50, 50));
		sprites.add(ss.grabSprite(241, 196, 50, 50));
		sprites.add(ss.grabSprite(294, 196, 50, 50));
		
		super.setAnim(new Animator(sprites));
		super.getAnim().setPlayOnce(true);
		super.getAnim().setSpeed(150);
	}
}
