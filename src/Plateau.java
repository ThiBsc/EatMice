import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;


public class Plateau extends JPanel {
	
	private static final long serialVersionUID = 2101759990723112394L;
	private ArrayList<CharacterObject> listSourisWallTrap; // liste des objets à afficher
	private Chat chat; // le chat
	private int sizeX=1; // nombre de case en x de la map
	private int sizeY=1; // nombre de case en y de la map
	private int objSizeX = 32; // taille d'affichage d'un objet en x
	private int objSizeY = 32; // taille d'affichage d'un objet en y
	private int secondes; // temps de la map
	private Score score; // score du joueur
	private static boolean partiFini; // savoir si la partie est finie ou non
	private boolean error, welcome, stopScore; // si il y a une erreur, si on vient de lancer l'appli, si on arrete de mettre à jour le score
	private Chrono compteARebours; // compte à rebours de la map
	private String curMap; // chaine de la map
	Image dbImage;
	
	public Plateau(){
		partiFini = true;
		welcome = true;
		error = false;
		stopScore = false;
		score = new Score(0);
		score.addPropertyChangeListener(score);
		listSourisWallTrap = new ArrayList<CharacterObject>();		
		setBackground(Color.white);
		compteARebours = new Chrono(1);	
		compteARebours.setTempsRestant(0);
		setFocusable(true);
	}
	public Score getScore(){
		return score;
	}
	public String getCurrentMap(){
		return curMap;
	}
	public void retry(){
		setMap(curMap);
	}
	/**
	 * Charge le plateau à partir de la map en chaine de caracteres
	 * @param map: la string de la map
	 */
	public void setMap(String map){
		try {
			curMap = map;
			listSourisWallTrap.clear();
			sizeX = Integer.parseInt(map.split("\n")[0]);
			sizeY = Integer.parseInt(map.split("\n")[1]);
			secondes = Integer.parseInt(map.split("\n")[2]);
			// On construit le terrain d'accueil -> algo de lecture de map
			for (int i=0; i<sizeY; i++){
				for (int j=0; j<sizeX; j++){
					String ligne = map.split("\n")[3+i];
					char objType = ligne.charAt(j);
					switch (objType) {
						case '#':
							listSourisWallTrap.add(new Mur(j, i));
							break;
						case 'S':
							listSourisWallTrap.add(new Souris(j, i));
							break;
						case 'C':						
							chat = new Chat(j, i, sizeX, sizeY);
							addKeyListener(chat);
							break;
						case 'T':
							listSourisWallTrap.add(new Tapette(j, i));
							break;
						case 'B':
							listSourisWallTrap.add(new Bomb(j, i));
							break;
						default:
							break;
					}
				}
			}
			// On lance les animations des sprites
			for (int i=0; i<listSourisWallTrap.size(); i++){
				CharacterObject co = listSourisWallTrap.get(i);
				if (co instanceof Souris)
					new Thread((Souris) co).start();
				else if (co instanceof Bomb){
					co.getAnim().play();
					co.getAnim().pause();
				}
				else
					co.getAnim().play();
			}
			score.resetScore();
			chat.getAnim().play();
			compteARebours.setTemps(secondes);
			compteARebours.setTempsRestant(secondes);
			compteARebours.start();
			welcome = false;
			partiFini = false;
			error = false;
			stopScore = false;
		} catch (Exception e) {
			error = true;
		}		
	}
	public static boolean getPartiFini(){
		return partiFini;
	}
	// stop toutes les animations des sprites
	public void stopAllAnim(){
		for (int i=0; i<listSourisWallTrap.size(); i++){
			CharacterObject co = listSourisWallTrap.get(i);
			if (!(co instanceof Bomb))
				co.getAnim().stop();
		}
		chat.getAnim().stop();
	}
	@Override
	public void paint(Graphics g){
		//super.paint(g);
		g.drawRect(0, 0, getWidth()-1, getHeight()-1);
		dbImage = createImage(getWidth(), getHeight());		
		if (!error){
			if (welcome){
				g.setColor(Color.black);
				g.drawString("For begin, choose a level!", 0, 20);
			}
			else{
				paintComponent(g);
				if (partiFini) {
					compteARebours.stop();
					stopAllAnim();
					g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
					if (checkIfWin()){
						if (!stopScore){
							score.updateScore(compteARebours.getTempsRestant()*10);
							stopScore = true;
						}
						g.setColor(Color.green);
						g.drawString("WIN!", getWidth()/2, getHeight()/2);
					}
					else{
						g.setColor(Color.red);
						g.drawString("LOOSE!", getWidth()/2, getHeight()/2);
					}
				}
			}
		}
		else{
			g.setColor(Color.red);
			g.drawString("Error!", 0, 20);
		}
	}
	// Dessine les objets à partir de la liste listSourisWallTrap et du chat
	public void paintComponent(Graphics g){
		objSizeX = getWidth()/sizeX;
		objSizeY = getHeight()/sizeY;
		g.setColor(Color.white);
	    g.fillRect(0, 0, this.getWidth(), this.getHeight());	
		if (listSourisWallTrap.size() > 0){
			for (int i=0; i<listSourisWallTrap.size(); i++){
				CharacterObject co = listSourisWallTrap.get(i);
				if (co instanceof Souris){
					// verifier si il y a un event en fonction de la position de la souris
					for (int j=0; j<listSourisWallTrap.size(); j++){
						if (listSourisWallTrap.get(i) instanceof CharacterObject){
							CharacterObject co1 = listSourisWallTrap.get(j);
							if (j!=i && co.getPosX()==co1.getPosX() && co.getPosY()==co1.getPosY()){
								// la souris tombe dans un piege
								if (co1 instanceof Tapette){
									co.getAnim().stop();
									listSourisWallTrap.remove(i);
									if (checkIfWin())
										partiFini = true;
								}
								else if (co1 instanceof Mur){
									co.setPosX(co.getLastPosX());
									co.setPosY(co.getLastPosY());
								}
								break;
							}
						}
					}
				}
				co.getAnim().update(System.currentTimeMillis());
				g.drawImage(co.getAnim().getSprite(), co.getPosX()*objSizeX, co.getPosY()*objSizeY, objSizeX, objSizeY, null);
			}
			// verifier si il y a un event en fonction de la position du chat
			boolean bMortSurBomb = false;
			for (int i=0; i<listSourisWallTrap.size(); i++){
				CharacterObject co = listSourisWallTrap.get(i);
				if (co.getPosX()==chat.getPosX() && co.getPosY()==chat.getPosY()){
					// on mange la souris
					if (co instanceof Souris){
						score.updateScore(100);
						co.getAnim().stop();
						listSourisWallTrap.remove(i);
						if (checkIfWin())
							partiFini = true;
					}
					else if (co instanceof Bomb){
						bMortSurBomb = true;
						if (!co.getAnim().isRunning() && !partiFini){
							co.getAnim().play();
							score.updateScore(-50);
						}
						else if (!co.getAnim().isRunning() && partiFini){
							listSourisWallTrap.remove(i);
							Tomb t = new Tomb(chat.getPosX(), chat.getPosY());
							t.getAnim().setPlayOnce(true);
							t.getAnim().play();
							listSourisWallTrap.add(t);
						}
						partiFini = true;
					}
					else{
						if (chat.getLastKey() == 'L' || chat.getLastKey() == 'R')
							chat.setPosX(chat.getLastPosX());
						else if (chat.getLastKey() == 'U' || chat.getLastKey() == 'D')
							chat.setPosY(chat.getLastPosY());
					}
					break;
				}
			}
			chat.getAnim().update(System.currentTimeMillis());		
			if (!bMortSurBomb)	
				g.drawImage(chat.getAnim().getSprite(), chat.getPosX()*objSizeX, chat.getPosY()*objSizeY, objSizeX, objSizeY, null);
		}
		compteARebours.paintComponent(g, objSizeX/2, objSizeY/2);
		if (compteARebours.getTempsRestant() == 0)
			partiFini = true;
		repaint();
	}
	// verifie si le chat a gagné
	public boolean checkIfWin(){
		boolean win = true;
		int i = 0;
		while (win && i<listSourisWallTrap.size()){
			if (listSourisWallTrap.get(i) instanceof Souris){
				win = false;
			}
			i++;
		}
		return win;
	}
}
