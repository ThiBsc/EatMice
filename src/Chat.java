import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author thibaut
 * Chat est un CharacterObject qui implements KeyListener pour le déplacement
 */

public class Chat extends CharacterObject implements KeyListener {
	
	private char lastKey;
	private int limitX, limitY;
	
	public Chat(int x, int y, int limX, int limY) {
		super(x, y);
		limitX = limX;
		limitY = limY;
		BufferedImageLoader loader = new BufferedImageLoader();
		BufferedImage spriteSheet = null;
		try {
			spriteSheet = loader.loadImage("sprites/sprite_cat.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		SpriteSheet ss = new SpriteSheet(spriteSheet);
		ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();
		// de face
		sprites.add(ss.grabSprite(38, 97, 28, 28));
		sprites.add(ss.grabSprite(38, 125, 28, 28));
		sprites.add(ss.grabSprite(38, 153, 28, 28));
		
		super.setAnim(new Animator(sprites));
		super.getAnim().setSpeed(300);
	}
	public char getLastKey(){
		return lastKey;
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if (!Plateau.getPartiFini()){
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				lastPosX = posX;
				lastKey = 'L';
		        posX--; //when move is, called change the speed
		        if (posX<=0 || limitX<=posX) posX = lastPosX;
		    }
		    if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
		    	lastPosX = posX;
		    	lastKey = 'R';
		        posX++;
		        if (posX<=0 || limitX<=posX) posX = lastPosX;
		    }
		    if(e.getKeyCode() == KeyEvent.VK_UP) {
		    	lastPosY = posY;
		    	lastKey = 'U';
		        posY--; //when move is, called change the speed
		        if (posY<=0 || limitY<=posY) posY = lastPosY;
		    }
		    if(e.getKeyCode() == KeyEvent.VK_DOWN) {
		    	lastPosY = posY;
		    	lastKey = 'D';
		        posY++;
		        if (posY<=0 || limitY<=posY) posY = lastPosY;
		    }
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {		
	}
	@Override
	public void keyPressed(KeyEvent e) {
	}
}
