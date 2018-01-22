import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SudokuGroup {
	
	JTextField[][] field = new JTextField[3][3];
	PossibleValues[][] possibleValues = new PossibleValues[3][3];
	
	
	public SudokuGroup(int positionX, int positionY, JPanel addTo) {
		
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				//field[i][j] = new JTextField(""+(i*3 +  j+1), 1);
				field[i][j] = new JTextField("", 1);
				field[i][j].setBounds(positionX + 30 * j, positionY + 30 * i, 30, 30);
				field[i][j].setFont(new Font("SansSerif", Font.BOLD, 20));
				field[i][j].setHorizontalAlignment(JTextField.CENTER);
				//field[i][j]
				
				addTo.add(field[i][j]);
				
				possibleValues[i][j] = new PossibleValues();
			}
		}
	
		
	}
	
	/**
	 * Function for checking if there is duplicate numbers in the same group
	 * 
	 * @return true if there is a duplicate number in the group, else false
	 */
	public boolean isDuplicateInGroup() {
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				
				for(int m = 0; m < 3; m++) {
					for(int n = 0; n < 3; n++) {
						
						if(i!=m || j!=n) {
							if(field[i][j].getText().equals(field[m][n].getText()) && !field[i][j].getText().equals(""))
								return true;
						}
					}
				}				
			}
		}	
		return false;
	}
	
	public void printPossibleValues() {
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.println("Possible values for field " + i + "x" + j + " : " + possibleValues[i][j].values.toString());
			}
		}
	}

	
	
}
