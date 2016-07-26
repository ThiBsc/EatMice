import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JLabel;


public class Score extends PropertyChangeSupport implements PropertyChangeListener {

	private static final long serialVersionUID = 4236833058759200471L;
	private int score;
	private JLabel lblScore;
	
	public Score(int sourceBean) {
		super(sourceBean);
		score = sourceBean;
		lblScore = new JLabel();
		lblScore.setText("Score: "+score);
	}
	
	public void resetScore(){
		firePropertyChange("score", score, 0);
	}
	public JLabel getLabelScore(){
		return lblScore;
	}
	public void updateScore(int toAdd){
		firePropertyChange("score", score, score+toAdd);
		//score += toAdd;
	}
	public int getScore(){
		return score;
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equalsIgnoreCase("score")){
			score = (int) evt.getNewValue();
			lblScore.setText("Score: "+score);
		}		
	}
}
