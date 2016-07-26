
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * 
 * @author thibaut
 * Contient les actions à réaliser en fonction des clics sur la MenuBar
 */
public class MenuBarMethod implements ActionListener {
	
	private Plateau plt;
	
	public MenuBarMethod(Plateau p){
		plt = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if("ouvrir".equals(e.getActionCommand())){
            JFileChooser fc = new JFileChooser();
            int ret = fc.showOpenDialog(null);
            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                String map = "";
                try {
    				Scanner sc = new Scanner(new File(file.getPath()));
    				while (sc.hasNextLine()){
    					map += sc.nextLine()+"\n";
    				}
    				sc.close();
    			} catch (Exception e1) {
    				map = "error";
    			}			
    			finally{
    				plt.setMap(map);
    				plt.repaint();
    			}
            }
        }
		else if("quitter".equals(e.getActionCommand())){
            System.exit(0);
        }
		else if("help".equals(e.getActionCommand())){
            HelpFrame hf = new HelpFrame();
            hf.setVisible(true);
        }
		else if("info".equals(e.getActionCommand())){
            JOptionPane.showMessageDialog(null, "Eat mice !\nDev by Thibaut Biscay" +
            		"\nLicence Pro - 2015/2016.", "A propos", JOptionPane.INFORMATION_MESSAGE);
        }
		else if ("recommencer".equals(e.getActionCommand())){
			plt.retry();
		}
		else if (e.getActionCommand().contains("lvl")){
			String map = "";
			try {
				Scanner sc = new Scanner(new File(getClass().getResource("maps/"+e.getActionCommand()+".txt").getFile()));
				while (sc.hasNextLine()){
					map += sc.nextLine()+"\n";
				}
				sc.close();
			} catch (Exception e1) {
				map = "error";
			}			
			finally{
				plt.setMap(map);
			}
		}
	}
}