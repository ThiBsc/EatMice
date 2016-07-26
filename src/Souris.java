import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Souris extends CharacterObject implements Runnable {
	
	public Souris(int x, int y) {
		super(x, y);
		BufferedImageLoader loader = new BufferedImageLoader();
		BufferedImage spriteSheet = null;
		try {
			spriteSheet = loader.loadImage("sprites/sprite_mouse.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		SpriteSheet ss = new SpriteSheet(spriteSheet);
		ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();
		sprites.add(ss.grabSprite(0, 10, 48, 46));
		sprites.add(ss.grabSprite(48, 10, 48, 46));
		sprites.add(ss.grabSprite(96, 10, 48, 46));
		sprites.add(ss.grabSprite(144, 10, 48, 46));
		
		super.setAnim(new Animator(sprites));
		super.getAnim().setSpeed(300);
	}
	public synchronized void run(){
		getAnim().play();
		while (getAnim().isRunning()){
			Random r = new Random();
			int i = 1 + r.nextInt(4);
			switch (i) {
				case 1:
					lastPosX = posX;
					posX++;
					break;
				case 2:
					lastPosX = posX;
					posX--;
					break;
				case 3:
					lastPosY = posY;
					posY++;
					break;
				case 4:
					lastPosY = posY;
					posY--;
					break;
				default:
					break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
