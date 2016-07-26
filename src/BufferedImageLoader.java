import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * 
 * @author thibaut
 * Classe permettant de charger une image présente dans les ressources
 *
 */
public class BufferedImageLoader {
	
	public BufferedImage loadImage(String path) throws IOException{
		URL url = getClass().getResource(path);
		BufferedImage img = ImageIO.read(url);
		return img;
	}

}
