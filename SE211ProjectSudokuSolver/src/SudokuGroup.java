import javax.swing.*;
import java.awt.*;

public class SudokuGroup {
	
	JTextField[][] field = new JTextField[3][3];
	
	public SudokuGroup(int positionX, int positionY, JPanel addTo) {
		
		for(int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				//field[i][j] = new JTextField(""+(i*3 +  j+1), 1);
				field[i][j] = new JTextField("", 1);
				field[i][j].setBounds(positionX + 30 * j, positionY + 30 * i, 30, 30);
				field[i][j].setFont(new Font("SansSerif", Font.BOLD, 20));
				field[i][j].setHorizontalAlignment(JTextField.CENTER);
				//field[i][j]
				
				
				
				addTo.add(field[i][j]);
				
			}
		}
	
	
	
	
	

	
	
}
