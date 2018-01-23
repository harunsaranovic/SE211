
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Window{
		
		private static final int WIDTH = 600;
		private static final int HEIGHT = 500;
		int groupsNo = 9;
		static JFrame frame = new JFrame("Sudoku Solver");
		JPanel panel = new JPanel();
		JButton checkStart = new JButton("Check");
		JTextArea errors = new JTextArea("Errors:");
		JLabel howMany = new JLabel("How many groups to be solved:");
		JLabel howManyDesc = new JLabel("*Less groups less time to be solved");
		JTextField howManyGroups = new JTextField("9");
		
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
				if(checkStart.getText().equals("Check")) {
			    	checkFields();
		    		setGroupsNo();
				}
			    else {
			    	lockFields();
			    	checkPossibleValues();
			    	startSolving();
			    }
			} 
		});

	
		errors.setBounds(385, 150, 180, 190);
		errors.setEditable(false);
		howMany.setBounds(50, 400, 300, 20);
		howManyDesc.setBounds(50, 416, 300, 20);
		howManyDesc.setFont(new Font("SansSerif", Font.ITALIC, 10));
		howManyGroups.setBounds(270, 400, 20, 20);
		
		panel.setLayout(null);
		panel.setBounds(0, 0, WIDTH, HEIGHT);
		
		frame.add(howManyGroups);
		frame.add(errors);
		frame.add(checkStart);
		frame.add(howMany);
		frame.add(howManyDesc);
		frame.add(panel);
	}
	
	public void visible(){
		frame.setVisible(true);
	}
	
	private void setGroupsNo() {
		if(Character.isDigit(howManyGroups.getText().charAt(0)) && howManyGroups.getText().length()==1 ) {
			groupsNo = Integer.parseInt(howManyGroups.getText());
			System.out.println(howManyGroups.getText());
			System.out.println(groupsNo);
		}
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
	
	/**
	 * Function for filling possible values lists
	 */
	private void checkPossibleValues() {
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				
				/*Removing possible values in other fields based on
				**on values in group1
				*/
				if(!group1.field[i][j].getText().isEmpty()) {
					
					String stringToRemove = group1.field[i][j].getText();
					group1.possibleValues[i][j].values.clear();
					group1.possibleValues[i][j].values.add(stringToRemove);
					
					
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
				if(!group2.field[i][j].getText().isEmpty()) {
					
					String stringToRemove = group2.field[i][j].getText();
					group2.possibleValues[i][j].values.clear();
					group2.possibleValues[i][j].values.add(stringToRemove);
					
					
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
				if(!group3.field[i][j].getText().isEmpty()) {
					
					String stringToRemove = group3.field[i][j].getText();
					group3.possibleValues[i][j].values.clear();
					group3.possibleValues[i][j].values.add(stringToRemove);				
					
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
				if(!group4.field[i][j].getText().isEmpty()) {
					
					String stringToRemove = group4.field[i][j].getText();
					group4.possibleValues[i][j].values.clear();
					group4.possibleValues[i][j].values.add(stringToRemove);
					
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
				if(!group5.field[i][j].getText().isEmpty()) {
					
					String stringToRemove = group5.field[i][j].getText();
					group5.possibleValues[i][j].values.clear();
					group5.possibleValues[i][j].values.add(stringToRemove);
					
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
				if(!group6.field[i][j].getText().isEmpty()) {
					
					String stringToRemove = group6.field[i][j].getText();
					group6.possibleValues[i][j].values.clear();
					group6.possibleValues[i][j].values.add(stringToRemove);
					
					
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
						group5.possibleValues[i][f].values.remove(stringToRemove);
						group3.possibleValues[f][j].values.remove(stringToRemove);
						group9.possibleValues[f][j].values.remove(stringToRemove);
					}					
				}
				
				/*Removing possible values in other fields based
				**on values in group7
				*/
				if(!group7.field[i][j].getText().isEmpty()) {
					
					String stringToRemove = group7.field[i][j].getText();
					group7.possibleValues[i][j].values.clear();
					group7.possibleValues[i][j].values.add(stringToRemove);
					
					
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
				if(!group8.field[i][j].getText().isEmpty()) {
					
					String stringToRemove = group8.field[i][j].getText();
					group8.possibleValues[i][j].values.clear();
					group8.possibleValues[i][j].values.add(stringToRemove);
					
					
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
				if(!group9.field[i][j].getText().isEmpty()) {
					
					String stringToRemove = group9.field[i][j].getText();
					group9.possibleValues[i][j].values.clear();
					group9.possibleValues[i][j].values.add(stringToRemove);
					
					
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
						group8.possibleValues[i][f].values.remove(stringToRemove);
						group3.possibleValues[f][j].values.remove(stringToRemove);
						group6.possibleValues[f][j].values.remove(stringToRemove);
					}					
				}
				
				
			}
		}
		
		group1.printPossibleValues(0,0);
		group2.printPossibleValues(0,3);
		group3.printPossibleValues(0,6);
		group4.printPossibleValues(3,0);
		group5.printPossibleValues(3,3);
		group6.printPossibleValues(3,6);
		group7.printPossibleValues(6,0);
		group8.printPossibleValues(6,3);
		group9.printPossibleValues(6,6);
		
	}
	
	private void startSolving() {
		
		int count = 0;
		Random rand = new Random();
		
		boolean ok = true;
		
		do{	
			ok=true;
			count++;
			System.out.println(count);
			group1.cloneValues();
			group2.cloneValues();
			group3.cloneValues();
			group4.cloneValues();
			group5.cloneValues();
			group6.cloneValues();
			group7.cloneValues();
			group8.cloneValues();
			group9.cloneValues();
			
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {				
					
					int rand1=0;
					if(group1.possibleValues[i][j].clones.size()==0)
						ok=false;
					else
						rand1 = rand.nextInt(group1.possibleValues[i][j].clones.size());
					
					int rand2=0;
					if(group2.possibleValues[i][j].clones.size()==0)
						ok=false;
					else
						rand2 = rand.nextInt(group2.possibleValues[i][j].clones.size());
					
					int rand3=0;
					if(group3.possibleValues[i][j].clones.size()==0)
						ok=false;
					else	
						rand3 = rand.nextInt(group3.possibleValues[i][j].clones.size());
					
					int rand4=0;
					if(group4.possibleValues[i][j].clones.size()==0)
						ok=false;
					else	
						rand4 = rand.nextInt(group4.possibleValues[i][j].clones.size());
					
					int rand5=0;
					if(group5.possibleValues[i][j].clones.size()==0)
						ok=false;
					else
						rand5 = rand.nextInt(group5.possibleValues[i][j].clones.size());
					
					int rand6=0;
					if(group6.possibleValues[i][j].clones.size()==0)
						ok=false;
					else
						rand6 = rand.nextInt(group6.possibleValues[i][j].clones.size());
					
					int rand7=0;
					if(group7.possibleValues[i][j].clones.size()==0)
						ok=false;
					else
						rand7 = rand.nextInt(group7.possibleValues[i][j].clones.size());
					
					int rand8=0;
					if(group8.possibleValues[i][j].clones.size()==0)
						ok=false;
					else
						rand8 = rand.nextInt(group8.possibleValues[i][j].clones.size());
					
					int rand9=0;
					if(group9.possibleValues[i][j].clones.size()==0)
						ok=false;
					else
						rand9= rand.nextInt(group9.possibleValues[i][j].clones.size());
					
					
					if(ok) {
							
						group1.field[i][j].setText(""+group1.possibleValues[i][j].clones.get(rand1));
						group1.removeFromClones(group1.field[i][j].getText());
						
						if(groupsNo>=2) {
						group2.field[i][j].setText(""+group2.possibleValues[i][j].clones.get(rand2));
						group2.removeFromClones(group2.field[i][j].getText());
						}
						
						if(groupsNo>=3) {
						group3.field[i][j].setText(""+group3.possibleValues[i][j].clones.get(rand3));
						group3.removeFromClones(group3.field[i][j].getText());
						}
						
						if(groupsNo>=4) {
						group4.field[i][j].setText(""+group4.possibleValues[i][j].clones.get(rand4));
						group4.removeFromClones(group4.field[i][j].getText());
						}
						
						if(groupsNo>=5) {
						group5.field[i][j].setText(""+group5.possibleValues[i][j].clones.get(rand5));
						group5.removeFromClones(group5.field[i][j].getText());
						}
						
						if(groupsNo>=6) {
						group6.field[i][j].setText(""+group6.possibleValues[i][j].clones.get(rand6));
						group6.removeFromClones(group6.field[i][j].getText());
						}
						
						if(groupsNo>=7) {
						group7.field[i][j].setText(""+group7.possibleValues[i][j].clones.get(rand7));
						group7.removeFromClones(group7.field[i][j].getText());
						}
						
						if(groupsNo>=8) {
						group8.field[i][j].setText(""+group8.possibleValues[i][j].clones.get(rand8));
						group8.removeFromClones(group8.field[i][j].getText());
						}
						
						if(groupsNo>=9) {
						group9.field[i][j].setText(""+group9.possibleValues[i][j].clones.get(rand9));
						group9.removeFromClones(group9.field[i][j].getText());
						}
					}
					
				}
			}
		//}while(group1.isDuplicateInGroup());
		}while(checkIsDuplicate() || !ok);
		System.out.println("GOTOVO");
		//}while(false);
		
	}
}