import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * 
 * @author thibaut
 * MenuBar hérité de JMenuBar permettant de dire au jeu ce que l'on veut faire
 */

public class MenuBar extends JMenuBar {
	
	private static final long serialVersionUID = 7325618304237937679L;
	private JMenu mnuFichier, mnuInterrogativeDot, mnuLevel, mnuLevel1, mnuLevel2, mnuLevel3;
	private JMenuItem mniRecommencer, mniQuitter, mniHelp, mniAPropos;
	/* menu des niveaux */
	private JMenuItem mniMyLevel, mniLvl11, mniLvl12, mniLvl13, mniLvl21, mniLvl22, mniLvl23, mniLvl31, mniLvl32, mniLvl33;
	/* icones des menus */
	private ImageIcon icoOpen, icoRetry, icoExit, icoHelp, icoInfo, icoLvl1, icoLvl2, icoLvl3, icoSearch;
	private MenuBarMethod mbm;
	
	public MenuBar(Plateau p){
		super();
		mbm = new MenuBarMethod(p);
		initUI();
	}
	
	public void initUI(){		 
		mnuFichier = new JMenu("Fichier");
		mnuInterrogativeDot = new JMenu("?");		
		mnuLevel = new JMenu("Level");
		mnuLevel1 = new JMenu("Level 1");
		mnuLevel2 = new JMenu("Level 2");
		mnuLevel3 = new JMenu("Level 3");
		
		mniRecommencer = new JMenuItem("Recommencer");
		mniQuitter = new JMenuItem("Quitter");
		mniHelp = new JMenuItem("Aide");
		mniAPropos = new JMenuItem("A propos");
		mniMyLevel = new JMenuItem("My level");
		mniLvl11 = new JMenuItem("lvl 1.1");
		mniLvl12 = new JMenuItem("lvl 1.2");
		mniLvl13 = new JMenuItem("lvl 1.3");
		mniLvl21 = new JMenuItem("lvl 2.1");
		mniLvl22 = new JMenuItem("lvl 2.2");
		mniLvl23 = new JMenuItem("lvl 2.3");
		mniLvl31 = new JMenuItem("lvl 3.1");
		mniLvl32 = new JMenuItem("lvl 3.2");
		mniLvl33 = new JMenuItem("lvl 3.3");
		/* action item command */
        mniRecommencer.setActionCommand("recommencer");
        mniRecommencer.addActionListener(mbm);
        mniQuitter.setActionCommand("quitter");
        mniQuitter.addActionListener(mbm);
        mniHelp.setActionCommand("help");
        mniHelp.addActionListener(mbm);
        mniAPropos.setActionCommand("info");
        mniAPropos.addActionListener(mbm);
        mniLvl11.setActionCommand("lvl11");
        mniLvl11.addActionListener(mbm);
        mniLvl12.setActionCommand("lvl12");
        mniLvl12.addActionListener(mbm);
        mniLvl13.setActionCommand("lvl13");
        mniLvl13.addActionListener(mbm);
        mniLvl21.setActionCommand("lvl21");
        mniLvl21.addActionListener(mbm);
        mniLvl22.setActionCommand("lvl22");
        mniLvl22.addActionListener(mbm);
        mniLvl23.setActionCommand("lvl23");
        mniLvl23.addActionListener(mbm);
        mniLvl31.setActionCommand("lvl31");
        mniLvl31.addActionListener(mbm);
        mniLvl32.setActionCommand("lvl32");
        mniLvl32.addActionListener(mbm);
        mniLvl33.setActionCommand("lvl33");
        mniLvl33.addActionListener(mbm);
        mniMyLevel.setActionCommand("ouvrir");
        mniMyLevel.addActionListener(mbm);
		/* icon menu */
		icoOpen = new ImageIcon((getClass().getResource("icons/open.png")));
	    Image image = icoOpen.getImage();
	    Image newimg = image.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
	    icoOpen = new ImageIcon(newimg);
	    
	    icoRetry = new ImageIcon((getClass().getResource("icons/retry.png")));
	    image = icoRetry.getImage();
	    newimg = image.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
	    icoRetry = new ImageIcon(newimg);
	    
	    icoExit = new ImageIcon((getClass().getResource("icons/exit.png")));
	    image = icoExit.getImage();
	    newimg = image.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
	    icoExit = new ImageIcon(newimg);
	    
	    icoHelp = new ImageIcon((getClass().getResource("icons/help.png")));
	    image = icoHelp.getImage();
	    newimg = image.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
	    icoHelp = new ImageIcon(newimg);
	    
	    icoInfo = new ImageIcon((getClass().getResource("icons/info.png")));
	    image = icoInfo.getImage();
	    newimg = image.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
	    icoInfo = new ImageIcon(newimg);
	    /* icon des niveaux */
	    icoLvl1 = new ImageIcon((getClass().getResource("icons/level1.png")));
	    image = icoLvl1.getImage();
	    newimg = image.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
	    icoLvl1 = new ImageIcon(newimg);
	    icoLvl2 = new ImageIcon((getClass().getResource("icons/level2.png")));
	    image = icoLvl2.getImage();
	    newimg = image.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
	    icoLvl2 = new ImageIcon(newimg);
	    icoLvl3 = new ImageIcon((getClass().getResource("icons/level3.png")));
	    image = icoLvl3.getImage();
	    newimg = image.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
	    icoLvl3 = new ImageIcon(newimg);
	    icoSearch = new ImageIcon((getClass().getResource("icons/search.png")));
	    image = icoSearch.getImage();
	    newimg = image.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
	    icoSearch = new ImageIcon(newimg);
	    /* set icon*/
	    mnuLevel.setIcon(icoOpen);
	    mnuLevel1.setIcon(icoLvl1);
	    mnuLevel2.setIcon(icoLvl2);
	    mnuLevel3.setIcon(icoLvl3);	    
	    mniRecommencer.setIcon(icoRetry);
	    mniQuitter.setIcon(icoExit);
	    mniHelp.setIcon(icoHelp);
	    mniAPropos.setIcon(icoInfo);
	    mniMyLevel.setIcon(icoSearch);
	    /* repartition des menu */
	    mnuLevel1.add(mniLvl11);
	    mnuLevel1.add(mniLvl12);
	    mnuLevel1.add(mniLvl13);
	    mnuLevel2.add(mniLvl21);
	    mnuLevel2.add(mniLvl22);
	    mnuLevel2.add(mniLvl23);
	    mnuLevel3.add(mniLvl31);
	    mnuLevel3.add(mniLvl32);
	    mnuLevel3.add(mniLvl33);
	    
	    mnuFichier.add(mnuLevel);
	    mnuFichier.add(mniRecommencer);
	    mnuFichier.addSeparator();
		mnuFichier.add(mniQuitter);
		mnuLevel.add(mnuLevel1);
		mnuLevel.add(mnuLevel2);
		mnuLevel.add(mnuLevel3);
		mnuLevel.addSeparator();
		mnuLevel.add(mniMyLevel);
		mnuInterrogativeDot.add(mniHelp);
		mnuInterrogativeDot.add(mniAPropos);
		
		this.add(mnuFichier);
		this.add(mnuInterrogativeDot);
	}
}
