import java.awt.image.BufferedImage;

public class SpriteSheet {

    private static BufferedImage spriteSheet;
    
    public SpriteSheet(BufferedImage ss){
    	spriteSheet = ss;
    }

    /**
     * recupere un sprite à partir de l'image "spriteSheet"
     * @param x: debut de l'image en x
     * @param y: debut de l'image en y
     * @param width: taille de l'image en x
     * @param height: taille de l'image en y
     * @return le sprite voulu en fonction des params
     */
    public BufferedImage grabSprite(int x, int y, int width, int height) {
        BufferedImage sprite = spriteSheet.getSubimage(x, y, width, height);
        return sprite;
    }

}