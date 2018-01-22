
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Window{
		
		private static final int WIDTH = 600;
		private static final int HEIGHT = 500;
		static JFrame frame = new JFrame("Sudoku Solver");
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
		
		if(checkIsDuplicate()) {
			errors.setText(errors.getText() + "\nDuplicate number in the\nsame row/column");
		}
		
		if(errors.getText().length() == 7) {
			checkStart.setText("Start");
			lockFields();
		}
		else
			checkStart.setText("Check");
	}
	
	private void checker(SudokuGroup group, int x, int y) {
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				
				if(group.field[j][i].getText().length() > 1) {
					errors.setText(errors.getText() + "\nField " + (i+x) + "x" + (j+y) + " must be 1 decimal\nlength");
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
	
	/**
	 * Function for checking if there is duplicate number in the same row, column or group
	 * 
	 * @return true if there is a same number in the same row, column or group
	 */
	private boolean checkIsDuplicate() {
		
		//Group checker
		if(group1.isDuplicateInGroup())
			return true;
		if(group2.isDuplicateInGroup())
			return true;
		if(group3.isDuplicateInGroup())
			return true;
		if(group4.isDuplicateInGroup())
			return true;
		if(group5.isDuplicateInGroup())
			return true;
		if(group6.isDuplicateInGroup())
			return true;
		if(group7.isDuplicateInGroup())
			return true;
		if(group8.isDuplicateInGroup())
			return true;
		if(group9.isDuplicateInGroup())
			return true;
		
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				for(int k=0; k < 3; k++) {

					//Horizontal checker
					if(group1.field[k][i].getText().equals(group2.field[k][j].getText()) && !group1.field[k][i].getText().equals(""))
						return true;
					if(group1.field[k][i].getText().equals(group3.field[k][j].getText()) && !group1.field[k][i].getText().equals(""))
						return true;
					if(group2.field[k][i].getText().equals(group3.field[k][j].getText()) && !group2.field[k][i].getText().equals(""))
						return true;
					if(group4.field[k][i].getText().equals(group5.field[k][j].getText()) && !group4.field[k][i].getText().equals(""))
						return true;
					if(group4.field[k][i].getText().equals(group6.field[k][j].getText()) && !group4.field[k][i].getText().equals(""))
						return true;
					if(group5.field[k][i].getText().equals(group6.field[k][j].getText()) && !group5.field[k][i].getText().equals(""))
						return true;
					if(group7.field[k][i].getText().equals(group8.field[k][j].getText()) && !group7.field[k][i].getText().equals(""))
						return true;
					if(group7.field[k][i].getText().equals(group9.field[k][j].getText()) && !group7.field[k][i].getText().equals(""))
						return true;
					if(group8.field[k][i].getText().equals(group9.field[k][j].getText()) && !group8.field[k][i].getText().equals(""))
						return true;
					
					//Vertical checker
					if(group1.field[i][k].getText().equals(group4.field[j][k].getText()) && !group1.field[i][k].getText().equals(""))
						return true;
					if(group1.field[i][k].getText().equals(group7.field[j][k].getText()) && !group1.field[i][k].getText().equals(""))
						return true;
					if(group4.field[i][k].getText().equals(group7.field[j][k].getText()) && !group4.field[i][k].getText().equals(""))
						return true;
					if(group2.field[i][k].getText().equals(group5.field[j][k].getText()) && !group2.field[i][k].getText().equals(""))
						return true;
					if(group2.field[i][k].getText().equals(group8.field[j][k].getText()) && !group2.field[i][k].getText().equals(""))
						return true;
					if(group5.field[i][k].getText().equals(group8.field[j][k].getText()) && !group5.field[i][k].getText().equals(""))
						return true;
					if(group3.field[i][k].getText().equals(group6.field[j][k].getText()) && !group3.field[i][k].getText().equals(""))
						return true;
					if(group3.field[i][k].getText().equals(group9.field[j][k].getText()) && !group3.field[i][k].getText().equals(""))
						return true;
					if(group6.field[i][k].getText().equals(group9.field[j][k].getText()) && !group6.field[i][k].getText().equals(""))
						return true;					
				}
			}
		}
		
		return false;
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
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				
				/*Removing possible values in other fields based on
				**on values in group1
				*/
				if(!group1.field[i][j].equals("")) {
					
					String stringToRemove = group1.field[i][j].getText();
					//group1.possibleValues[i][j].values.clear();
					//group1.possibleValues[i][j].values.add(stringToRemove);
					
					//deleting field value in other other fields
					for(int m = 0; m < 3; m++) {
						for(int n = 0; n < 3; n++) {							
							if(i!=m || j!=n) {
								group1.possibleValues[m][n].values.remove(stringToRemove);
							}
						}
					}
					
					for(int f=0; f<3; f++) {
						group2.possibleValues[i][f].values.remove(stringToRemove);
						group3.possibleValues[i][f].values.remove(stringToRemove);
						group4.possibleValues[f][j].values.remove(stringToRemove);
						group7.possibleValues[f][j].values.remove(stringToRemove);
					}					
				}
				
				/*Removing possible values in other fields based on
				**on values in group2
				*/
				if(!group2.field[i][j].equals("")) {
					
					String stringToRemove = group2.field[i][j].getText();
					
					//deleting field value in other other fields
					for(int m = 0; m < 3; m++) {
						for(int n = 0; n < 3; n++) {							
							if(i!=m || j!=n) {
								group2.possibleValues[m][n].values.remove(stringToRemove);
							}
						}
					}
					
					for(int f=0; f<3; f++) {
						group1.possibleValues[i][f].values.remove(stringToRemove);
						group3.possibleValues[i][f].values.remove(stringToRemove);
						group5.possibleValues[f][j].values.remove(stringToRemove);
						group8.possibleValues[f][j].values.remove(stringToRemove);
					}					
				}
				
				/*Removing possible values in other fields based
				**on values in group3
				*/
				if(!group3.field[i][j].equals("")) {
					
					String stringToRemove = group3.field[i][j].getText();
					
					//deleting field value in other other fields
					for(int m = 0; m < 3; m++) {
						for(int n = 0; n < 3; n++) {							
							if(i!=m || j!=n) {
								group3.possibleValues[m][n].values.remove(stringToRemove);
							}
						}
					}
					
					for(int f=0; f<3; f++) {
						group1.possibleValues[i][f].values.remove(stringToRemove);
						group2.possibleValues[i][f].values.remove(stringToRemove);
						group6.possibleValues[f][j].values.remove(stringToRemove);
						group9.possibleValues[f][j].values.remove(stringToRemove);
					}					
				}
				
				/*Removing possible values in other fields based
				**on values in group4
				*/
				if(!group4.field[i][j].equals("")) {
					
					String stringToRemove = group4.field[i][j].getText();
					
					//deleting field value in other other fields
					for(int m = 0; m < 3; m++) {
						for(int n = 0; n < 3; n++) {							
							if(i!=m || j!=n) {
								group4.possibleValues[m][n].values.remove(stringToRemove);
							}
						}
					}
					
					for(int f=0; f<3; f++) {
						group5.possibleValues[i][f].values.remove(stringToRemove);
						group6.possibleValues[i][f].values.remove(stringToRemove);
						group1.possibleValues[f][j].values.remove(stringToRemove);
						group7.possibleValues[f][j].values.remove(stringToRemove);
					}					
				}
				
				/*Removing possible values in other fields based
				**on values in group5
				*/
				if(!group5.field[i][j].equals("")) {
					
					String stringToRemove = group5.field[i][j].getText();
					
					//deleting field value in other other fields
					for(int m = 0; m < 3; m++) {
						for(int n = 0; n < 3; n++) {							
							if(i!=m || j!=n) {
								group5.possibleValues[m][n].values.remove(stringToRemove);
							}
						}
					}
					
					for(int f=0; f<3; f++) {
						group4.possibleValues[i][f].values.remove(stringToRemove);
						group6.possibleValues[i][f].values.remove(stringToRemove);
						group2.possibleValues[f][j].values.remove(stringToRemove);
						group8.possibleValues[f][j].values.remove(stringToRemove);
					}					
				}
				
				/*Removing possible values in other fields based
				**on values in group6
				*/
				if(!group6.field[i][j].equals("")) {
					
					String stringToRemove = group6.field[i][j].getText();
					
					//deleting field value in other other fields
					for(int m = 0; m < 3; m++) {
						for(int n = 0; n < 3; n++) {							
							if(i!=m || j!=n) {
								group6.possibleValues[m][n].values.remove(stringToRemove);
							}
						}
					}
					
					for(int f=0; f<3; f++) {
						group4.possibleValues[i][f].values.remove(stringToRemove);
						group6.possibleValues[i][f].values.remove(stringToRemove);
						group3.possibleValues[f][j].values.remove(stringToRemove);
						group9.possibleValues[f][j].values.remove(stringToRemove);
					}					
				}
				
				/*Removing possible values in other fields based
				**on values in group7
				*/
				if(!group7.field[i][j].equals("")) {
					
					String stringToRemove = group7.field[i][j].getText();
					
					//deleting field value in other other fields
					for(int m = 0; m < 3; m++) {
						for(int n = 0; n < 3; n++) {							
							if(i!=m || j!=n) {
								group7.possibleValues[m][n].values.remove(stringToRemove);
							}
						}
					}
					
					for(int f=0; f<3; f++) {
						group8.possibleValues[i][f].values.remove(stringToRemove);
						group9.possibleValues[i][f].values.remove(stringToRemove);
						group1.possibleValues[f][j].values.remove(stringToRemove);
						group4.possibleValues[f][j].values.remove(stringToRemove);
					}					
				}
				
				/*Removing possible values in other fields based
				**on values in group8
				*/
				if(!group8.field[i][j].equals("")) {
					
					String stringToRemove = group8.field[i][j].getText();
					
					//deleting field value in other other fields
					for(int m = 0; m < 3; m++) {
						for(int n = 0; n < 3; n++) {							
							if(i!=m || j!=n) {
								group8.possibleValues[m][n].values.remove(stringToRemove);
							}
						}
					}
					
					for(int f=0; f<3; f++) {
						group7.possibleValues[i][f].values.remove(stringToRemove);
						group9.possibleValues[i][f].values.remove(stringToRemove);
						group2.possibleValues[f][j].values.remove(stringToRemove);
						group5.possibleValues[f][j].values.remove(stringToRemove);
					}					
				}
				
				/*Removing possible values in other fields based
				**on values in group7
				*/
				if(!group9.field[i][j].equals("")) {
					
					String stringToRemove = group9.field[i][j].getText();
					
					//deleting field value in other other fields
					for(int m = 0; m < 3; m++) {
						for(int n = 0; n < 3; n++) {							
							if(i!=m || j!=n) {
								group9.possibleValues[m][n].values.remove(stringToRemove);
							}
						}
					}
					
					for(int f=0; f<3; f++) {
						group7.possibleValues[i][f].values.remove(stringToRemove);
						group9.possibleValues[i][f].values.remove(stringToRemove);
						group3.possibleValues[f][j].values.remove(stringToRemove);
						group6.possibleValues[f][j].values.remove(stringToRemove);
					}					
				}
				
				
			}
		}
		
		group1.printPossibleValues();
		group2.printPossibleValues();
		group3.printPossibleValues();
		group4.printPossibleValues();
		group5.printPossibleValues();
		group6.printPossibleValues();
		group7.printPossibleValues();
		group8.printPossibleValues();
		group9.printPossibleValues();
		
	}
}