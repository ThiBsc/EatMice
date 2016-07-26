import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Chrono {
	
    /** timer : timer servant à décrémenter le chronometre */
    private Timer timer;    
    /** couleur : couleur de fond du chronometre */
    private Color couleur = Color.orange;    
    /** tempsRestant : temps restant */
    private int tempsRestant;      
    /** temps : temps initial */
    private int temps;
    
    public Chrono(int N){
        timer = createTimer ();
        timer.start();
        this.setTempsRestant(N);
        this.setTemps(N);
    }    
    public Chrono(int N, Color couleur){
        this.couleur=couleur;
        timer = createTimer ();
        timer.start();
        this.setTempsRestant(N);
        this.setTemps(N);
    }
    public void start(){
        timer.start ();
    }
    public void stop(){
        timer.stop ();
    }
    private Timer createTimer (){
        ActionListener action = new ActionListener (){
            public void actionPerformed (ActionEvent event){
                if(tempsRestant>0){
                    tempsRestant--;
                }
                else{
                    timer.stop();
                }
            }
        };
        return new Timer (1000, action);
    }
    public void paintComponent(Graphics g, int xSize, int ySize) {
    	int r = xSize > ySize ? ySize : xSize;
        this.drawCircle(g, xSize, ySize, r);
    }
    public void drawCircle(Graphics cg, int xCenter, int yCenter, int r) {
        cg.setColor(Color.white);
        cg.fillOval(xCenter-r, yCenter-r, 2*r, 2*r);
        cg.setColor(couleur);
        cg.fillArc(xCenter-r, yCenter-r, 2*r, 2*r, 90, -(360-tempsRestant*360/temps));
        cg.setColor(Color.black);
        cg.setFont(new Font("courier", Font.PLAIN, r));
        int decalage = cg.getFontMetrics().stringWidth("00");
        if(tempsRestant>9){
            cg.drawString(""+this.tempsRestant, xCenter-decalage/2, yCenter+decalage/4);
        }
        else{
            cg.drawString("0"+this.tempsRestant, xCenter-decalage/2, yCenter+decalage/4);
        }
    }    
    public Timer getTimer() {
        return timer;
    }    
    public void setTimer(Timer timer) {
        this.timer = timer;
    }    
    public int getTempsRestant() {
        return tempsRestant;
    }    
    public void setTempsRestant(int tempsRestant) {
        this.tempsRestant = tempsRestant; 
    }    
    public int getTemps() {
        return temps;
    }    
    public void setTemps(int temps) {
        this.temps = temps;
    }    
}