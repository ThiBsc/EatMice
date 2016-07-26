import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;


public class Tomb extends CharacterObject {

	public Tomb(int x, int y) {
		super(x, y);
		BufferedImageLoader loader = new BufferedImageLoader();
		BufferedImage spriteSheet = null;
		try {
			spriteSheet = loader.loadImage("sprites/sprite_rip.gif");
		} catch (IOException e) {
			e.printStackTrace();
		}
		SpriteSheet ss = new SpriteSheet(spriteSheet);
		ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();
		sprites.add(ss.grabSprite(0, 0, 27, 28));
		
		super.setAnim(new Animator(sprites));
		super.getAnim().setSpeed(1000);
	}

}
