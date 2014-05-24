import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class HigherOrLowerSwing extends JFrame {

	public static void main(String args[]) {
		new HigherOrLowerSwing();
	}
	
	HigherOrLowerSwing() {
		
		//setting frame settings and layout
		final JFrame frame = new JFrame("Higher Or Lower");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((int)(dim.getHeight()/2),(int)(dim.getWidth()/4), 500, 80);
		frame.setSize(500, 80);
		frame.setLayout(new GridLayout(3,2));
		frame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	             System.exit(0);
	          }        
	       });  
		
		//setting button functionality
		final HigherOrLower h = new HigherOrLower();
		final JLabel textArea = new JLabel("Your opponent rolled: "+h.getComp());
		final JLabel textArea2 = new JLabel("");
		final JLabel compScore = new JLabel("Computer: "+h.getCompScore());
		final JLabel userScore = new JLabel("You: "+h.getUserScore());
		final int comp=0,user=0;
		
		JButton higher = new JButton("Higher");
		JButton lower = new JButton("Lower");
		
		higher.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 
	        	 String message=h.Guess("higher");
	        	 JOptionPane.showMessageDialog(frame, message);
	        	 textArea.setText("Your opponent rolled: "+h.getComp());
	        	 compScore.setText("Computer: "+h.getCompScore());
	        	 userScore.setText("You: "+h.getUserScore());
	         }          
	      });
		lower.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 
	        	 String message=h.Guess("lower");
	        	 JOptionPane.showMessageDialog(frame, message);
	        	 textArea.setText("Your opponent rolled: "+h.getComp());
	        	 compScore.setText("Computer: "+h.getCompScore());
	        	 userScore.setText("You: "+h.getUserScore());
	         }          
	      });
		
		//adding the text and button to frame
		frame.add(textArea);
		frame.add(textArea2);
		frame.add(higher);
		frame.add(lower);
		frame.add(compScore);
		frame.add(userScore);
		
		frame.setVisible(true);

	}

}
