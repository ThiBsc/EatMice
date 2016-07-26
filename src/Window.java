
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * 
 * @author thibaut
 * Ma classe window hérité de JFrame
 *
 */
public class Window extends JFrame {
	
	private static final long serialVersionUID = 8799814155423117081L;
	/** menuBar: la barre de menu permettant des interactions avec le programme */
	private MenuBar menubar;
	/** plateau: Objet plateau qui sert à l'affichage du jeu -> hérité de JPanel */
	private Plateau plateau;
	private BorderLayout layout;
	
	private Window()
    {
		layout = new BorderLayout();
        plateau = new Plateau();
        initUI();
    }
	private void initUI(){
		this.setLayout(layout);
		this.setTitle("Eat mice !");
	    // Taille de la frame
	    this.setSize(1024, 768);
	    // Placer au centre de l'ecran
	    this.setLocationRelativeTo(null);
	    // Resizable ou non
	    this.setResizable(true);
        menubar = new MenuBar(plateau);
        this.add(menubar, BorderLayout.NORTH);
        this.add(plateau, BorderLayout.CENTER);
        this.add(plateau.getScore().getLabelScore(), BorderLayout.SOUTH);
        // Action a la fermeture (croix)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        this.setVisible(true);
	}

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Window();
            }
        });
    }

}
