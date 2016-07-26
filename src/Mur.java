import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;


public class Mur extends CharacterObject {
	
	public Mur(int x, int y) {
		super(x, y);
		BufferedImageLoader loader = new BufferedImageLoader();
		BufferedImage spriteSheet = null;
		try {
			spriteSheet = loader.loadImage("sprites/sprite_wall.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		SpriteSheet ss = new SpriteSheet(spriteSheet);
		ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();
		sprites.add(ss.grabSprite(0, 0, 32, 32));
		
		super.setAnim(new Animator(sprites));
		super.getAnim().setSpeed(1000);
	}
	
}
