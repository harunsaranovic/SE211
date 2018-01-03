import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Window implements ActionListener{
		
		private static final int WIDTH = 480;
		private static final int HEIGHT = 360;
		static JFrame frame = new JFrame("Sudoku Solver");
		JLabel txt = new JLabel("UNDER CONSTRUCTION!");
		JTextField txtPath = new JTextField(" ", 20);
		JTextField destinationPath = new JTextField(" Destinacija za excel file", 20);
		
		
	public Window(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocation(200, 200);
		JPanel panel = new JPanel();
		panel.setBounds(0, 30,WIDTH,40);

		frame.add(panel);
		panel.add(txt);
	}
	
	public void visible(){
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) { 
		//TO BE BUILD	
	}
	
}