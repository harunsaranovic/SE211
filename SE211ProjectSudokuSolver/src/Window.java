
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Window{
		
		private static final int WIDTH = 600;
		private static final int HEIGHT = 500;
		static JFrame frame = new JFrame("Sudoku Solver");
		JLabel txt = new JLabel("UNDER CONSTRUCTION!");
		JTextField txtPath = new JTextField(" ", 20);
		JTextField destinationPath = new JTextField(" Destinacija za excel file", 20);
		JPanel panel = new JPanel();
		JButton checkStart = new JButton("Check");
		JTextArea errors = new JTextArea("Errors:");
		
		//JLabels
		SudokuGroup group1 = new SudokuGroup(50, 50, panel); 
		SudokuGroup group2 = new SudokuGroup(150, 50, panel); 
		SudokuGroup group3 = new SudokuGroup(250, 50, panel); 
		SudokuGroup group4 = new SudokuGroup(50, 150, panel); 
		SudokuGroup group5 = new SudokuGroup(150, 150, panel); 
		SudokuGroup group6 = new SudokuGroup(250, 150, panel); 
		SudokuGroup group7 = new SudokuGroup(50, 250, panel); 
		SudokuGroup group8 = new SudokuGroup(150, 250, panel); 
		SudokuGroup group9 = new SudokuGroup(250, 250, panel); 
		

	public Window(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocation(200, 200);
		
		checkStart.setBounds(400, 90, 150, 50);
		checkStart.setFont(new Font("SansSerif", Font.BOLD, 20));
		checkStart.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
			    if(checkStart.getText().equals("Check"))
			    	checkFields();
			    else {
			    	lockFields();
			    	startSolving();
			    }
			} 
		});
		

			//public void actionPerformed(KeyEvent e) {
			    
			//} 
		
		

		errors.setBounds(385, 150, 180, 190);
		errors.setEditable(false);
		
		panel.setLayout(null);
		panel.setBounds(0, 0, WIDTH, HEIGHT);
		
		frame.add(errors);
		frame.add(checkStart);
		frame.add(panel);
	}
	
	public void visible(){
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) { 
		//TO BE BUILD	
	}
	
	private void checkFields() {
		
		errors.setText("Errors:");
		
		checker(group1, 1, 1);
		checker(group2, 4, 1);
		checker(group3, 7, 1);
		checker(group4, 1, 4);
		checker(group5, 4, 4);
		checker(group6, 7, 4);
		checker(group7, 1, 7);
		checker(group8, 4, 7);
		checker(group9, 7, 7);
		
		if(errors.getText().length() == 7)
			checkStart.setText("Start");
		else
			checkStart.setText("Check");
	}
	
	private void checker(SudokuGroup group, int x, int y) {
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				
				if(group.field[j][i].getText().length() > 1) {
					errors.setText(errors.getText() + "\nField " + (i+x) + "x" + (j+y) + " must be 1 decimal length");
				}
				else if(group.field[j][i].getText().equals("0")) {
					errors.setText(errors.getText() + "\nField " + (i+x) + "x" + (j+y) + " cannot be 0");
				}
				else if(group.field[j][i].getText().length() == 1) {
					if(!Character.isDigit(group.field[j][i].getText().charAt(0))) {
						errors.setText(errors.getText() + "\nField " + (i+x) + "x" + (j+y) + " must be digit");
					}
				}
				
			}
		}	
		
	}
	
	private void lockFields() {

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				group1.field[j][i].setEditable(false);
				group2.field[j][i].setEditable(false);
				group3.field[j][i].setEditable(false);
				group4.field[j][i].setEditable(false);
				group5.field[j][i].setEditable(false);
				group6.field[j][i].setEditable(false);
				group7.field[j][i].setEditable(false);
				group8.field[j][i].setEditable(false);
				group9.field[j][i].setEditable(false);
			}
		}
	}
	
	private void startSolving() {
		
		int[][][] x = new int[9][9][9];
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				for(int k = 0; k < 9; k++) {
					x[i][j][k] = 0;
				}
			}
		}
		
		
	}
}