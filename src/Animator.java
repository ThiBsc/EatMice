import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Animator {

	/** frames: contient toutes les images necessaire à l'animation du sprite */
	private ArrayList<BufferedImage> frames;	
	/** sprite: contient l'image qui doit être affiché */
	private BufferedImage sprite;
	/** running: permet de savoir si l'animation est active ou non */
	private volatile boolean running = false;
	private long previousTime, speed;
	private int frameAtPause, currentFrame;
	/** playOnce: permet de dire si c'est une animation en boucle ou non */
	private boolean playOnce = false;
	
	public Animator(ArrayList<BufferedImage> frames){
		this.frames = frames;
	}
	
	public void setPlayOnce(boolean val){
		playOnce = val;
	}
	public boolean isRunning(){
		return running;
	}
	public void setSpeed(long speed){
		this.speed = speed;
	}
	public BufferedImage getSprite(){
		return sprite;
	}
	/**
	 * 
	 * @param time: permet de savoir si en fonction du temps écoulé il faut actualisé le sprite à afficher ou non
	 */
	public void update(long time){
		if (running){
			if (time - previousTime >= speed){
				currentFrame++;
				try {
					sprite = frames.get(currentFrame);
				} catch (IndexOutOfBoundsException e) {
					currentFrame = 0;
					sprite = frames.get(currentFrame);
					if (playOnce)
						this.stop();
				}
				previousTime = time;
			}
		}
		else if (playOnce)
			sprite = frames.get(0);
	}
	public void play(){
		running = true;
		previousTime = 0;
		frameAtPause = 0;
		currentFrame = 0;
	}
	public void stop(){
		running = false;
		previousTime = 0;
		frameAtPause = 0;
		currentFrame = 0;
	}
	public void pause(){
		frameAtPause = currentFrame;
		running = false;
	}
	public void resume(){
		currentFrame = frameAtPause;
		running = true;
	}
	
}
