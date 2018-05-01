package asd;

import asd.GamesLite.Core;
import asd.GamesLite.Main;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.stream.IntStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class ArrayField {


	private int [][]array;
	private int n;
	private int m;
	private JFrame frame;

	public ArrayField(JPanel panel, JFrame frame) {
		n = 9;
		m = 9;
		array = Core.playingField;
//		array = new int[n][m];
		this.frame = frame;
	}
	
	private int levelCounter;

	public void init1() {
		levelCounter = 1;
		array = new int[][] {
				{6, 0, 0, 5, 0, 8, 0, 0, 2},
				{0, 3, 0, 4, 0, 0, 1, 6, 0},
				{0, 1, 7, 6, 9, 0, 8, 0, 0},
				{7, 0, 0, 0, 8, 0, 6, 9, 5},
				{0, 0, 6, 2, 5, 4, 7, 0, 0},
				{5, 8, 3, 0, 6, 0, 0, 0, 1},
				{0, 0, 2, 0, 4, 6, 9, 8, 0},
				{0, 7, 1, 0, 0, 5, 0, 4, 0},
				{4, 0, 0, 9, 0, 2, 0, 0, 3}
		};
	}
	
	public void init2() {
		levelCounter = 2;
		array = new int[][] {
				{1, 0, 6, 0, 0, 0, 9, 0, 2},
				{0, 3, 0, 1, 0, 5, 0, 8, 0},
				{7, 0, 0, 6, 9, 4, 0, 0, 5},
				{0, 7, 3, 9, 0, 6, 8, 5, 0},
				{0, 0, 8, 0, 7, 0, 1, 0, 0},
				{0, 6, 1, 4, 0, 2, 7, 9, 0},
				{3, 0, 0, 7, 4, 8, 0, 0, 9},
				{0, 2, 0, 3, 0, 1, 0, 7, 0},
				{8, 0, 7, 0, 0, 0, 5, 0, 1}
		};
	}
	
	public void init3() {
		levelCounter = 3;
		array = new int[][] {
				{0, 3, 6, 0, 8, 7, 2, 0, 0},
				{2, 0, 0, 0, 0, 9, 3, 5, 0},
				{0, 5, 8, 0, 0, 4, 6, 9, 0},
				{5, 0, 7, 0, 6, 8, 0, 3, 0},
				{0, 6, 0, 3, 0, 1, 0, 7, 0},
				{0, 8, 0, 7, 4, 0, 9, 0, 2},
				{0, 9, 2, 4, 0, 0, 7, 1, 0},
				{0, 1, 5, 8, 0, 0, 0, 0, 3},
				{0, 0, 3, 1, 7, 0, 5, 8, 0}
		};
	}
	
	public void init4() {
		levelCounter = 4;
		array = new int[][] {
				{8, 4, 7, 3, 5, 0, 2, 6, 9},
				{5, 6, 9, 4, 8, 2, 1, 7, 3},
				{2, 3, 1, 6, 9, 7, 5, 4, 8},
				{1, 8, 5, 9, 7, 4, 3, 2, 6},
				{6, 7, 3, 2, 1, 5, 9, 8, 4},
				{9, 2, 4, 8, 6, 3, 7, 5, 1},
				{7, 9, 6, 1, 2, 8, 4, 3, 5},
				{3, 1, 2, 5, 4, 6, 8, 9, 7},
				{4, 5, 8, 7, 3, 9, 6, 1, 2}
		};
	}
	
	public void initTest() {
		levelCounter = 0;
		array = new int[][] {
				{8, 4, 7, 3, 5, 1, 2, 6, 9},
				{5, 6, 9, 4, 8, 2, 0, 7, 3},
				{2, 3, 1, 6, 9, 7, 5, 4, 8},
				{1, 8, 5, 9, 7, 4, 3, 2, 6},
				{6, 7, 3, 2, 1, 5, 9, 8, 4},
				{9, 2, 4, 8, 6, 3, 7, 5, 1},
				{7, 9, 6, 1, 2, 8, 4, 3, 5},
				{3, 1, 2, 5, 4, 6, 8, 9, 7},
				{4, 5, 8, 7, 3, 9, 6, 1, 2}
		};
	}
	
	private void start(JPanel panel){
		panel.setBackground(Color.WHITE);
		for (int i=0; i<n; i++)
			for (int j=0; j<m; j++){
				SudokuCell cell = new SudokuCell(i, j);
				panel.add(cell);
				int num = array[i][j];
				if(num != 0){
					cell.setText(String.valueOf(num));
					cell.setEnabled(false);
				}
				addCellListener(panel, cell);
			}
	}
	
	private void addCellListener(JPanel panel, SudokuCell cell){
		cell.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				highlightCellsByNumber(panel);						
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub				
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub						
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub				
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub						
			}
		});
	}
	
	private void highlightCellsByNumber(JPanel panel){
		CellPosition currentCellPos = Main.currentCell.getPosition();
		String currentCellValue = Main.currentCell.getText();
		for(Component cell : panel.getComponents())	
			if(SudokuCell.class.isInstance(cell)){
				boolean valueIsEqual = ((SudokuCell)cell).getText().equals(currentCellValue);
				boolean isNotCurrent = ((SudokuCell)cell).getPosition().isEqual(currentCellPos) == false;
				if(isNotCurrent){
					if(valueIsEqual && currentCellValue != "")
						cell.setBackground(Color.YELLOW);
					else
						cell.setBackground(null);
				}
			}
	}
	
	public void initStart(JPanel panel, int levelNum){
		levelCounter = levelNum - 1;
		initNext(panel);
	}
	public void initNext(JPanel panel){

		if(levelCounter == 4)
			return;
		levelCounter++;
        panel.removeAll();
		frame.setTitle("Уровень: " + String.valueOf(levelCounter));
		switch(levelCounter){
			case 0:
				initTest();
				break;
			case 1:
				init1();
				break;
			case 2:
				init2();
				break;
			case 3:
				init3();
				break;
			case 4:
				init4();
				break;
		}
		
		start(panel);
		panel.repaint();

	}
	
	public void initBack(JPanel panel){

		if(levelCounter == 0)
			return;
		levelCounter--;
        panel.removeAll();
		frame.setTitle("Уровень: " + String.valueOf(levelCounter));
		switch(levelCounter){
			case 0:
				initTest();
				break;
			case 1:
				init1();
				break;
			case 2:
				init2();
				break;
			case 3:
				init3();
				break;
			case 4:
				init4();
				break;
		}
		start(panel);
		panel.repaint();

	}
	
	private void finish(JPanel panel){
		resetValidation(panel);
		if(isValid(panel)){
			int dialogResult = JOptionPane.showConfirmDialog(frame, 
					"Вы выиграли! Перейти на следующий уровень?",
                    "Победа!",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
			if(dialogResult == JOptionPane.YES_OPTION){
		    	initNext(panel);
			}
		} else {
			JOptionPane.showMessageDialog(frame, "Вы проиграли! Исправьте ошибки");
		}
	}
	
	private void resetValidation(JPanel panel){
		for(Component c : panel.getComponents())
			if(SudokuCell.class.isInstance(c))
				c.setBackground(Color.WHITE);
	}
	
	private boolean isValid(JPanel panel){
		SudokuChecker checker = new SudokuChecker();
		int[][] arrayCopy = new int[n][m];
		for (int i=0; i<9; i++)
			arrayCopy[i] = array[i].clone();
		CellPosition[] wrongPositions = checker.validate(arrayCopy);
		if (wrongPositions.length == 0)
			return true;
		for(CellPosition wrongPos : wrongPositions){
			for(Component cell : panel.getComponents())	
				if(SudokuCell.class.isInstance(cell))
					if(((SudokuCell)cell).getPosition().isEqual(wrongPos))
						cell.setBackground(Color.RED);
		}
		return false;
	}
	
	public void setCellValue(JPanel arrayPanel, String value){
		if (Main.currentCell != null){
			CellPosition pos = Main.currentCell.getPosition();
			array[pos.x][pos.y] = Integer.parseInt(value);	
			Main.currentCell.setText(value);
			highlightCellsByNumber(arrayPanel);
		}
		int foolCount = 0;
		for(int i = 0; i < 9; i++)
			if (IntStream.of(array[i]).anyMatch(x -> x == 0) == false)
				foolCount++;
			if (foolCount == 9)
				finish(arrayPanel);
	}

	public String toString() {

		String str = "";

		for (int i = 0; i < n; i++) {			

			for (int j = 0; j < m ; j++) {
				str = str + array[i][j] + " ";
			}
			str = str + "\n";
		}

		return str;
	}
}