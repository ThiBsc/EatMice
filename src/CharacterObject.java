/**
 * 
 * @author thibaut
 * Classe d'objet affichable sur le plateau de jeu
 *
 */
public abstract class CharacterObject {
	
	private Animator anim;
	protected int posX, posY, lastPosX, lastPosY;
	
	public CharacterObject(int x, int y){
		posX = x;
		posY = y;
		lastPosX = posX;
		lastPosY = posY;
	}
	
	public Animator getAnim(){
		return anim;
	}
	public void setAnim(Animator a){
		anim = a;
	}
	public int getPosX(){
		return posX;
	}
	public int getPosY(){
		return posY;
	}
	public void setPosX(int x){
		posX = x;
	}
	public void setPosY(int y){
		posY = y;
	}
	public int getLastPosX(){
		return lastPosX;
	}
	public int getLastPosY(){
		return lastPosY;
	}
}
