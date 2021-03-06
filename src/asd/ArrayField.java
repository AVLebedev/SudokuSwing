package asd;

import asd.GamesLite.Main;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.stream.IntStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class ArrayField implements Serializable {
	private final static int MAX_LEVEL = 4;

	private int[][] array;
	private int n;
	private int m;
	private JFrame frame;
	private JPanel panel;

	public ArrayField(JFrame frame, JPanel panel) {
		n = 9;
		m = 9;
		array = new int[n][m];
		this.frame = frame;
		this.panel = panel;
	}
	
	private int levelCounter;

	private void init1() {
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
	
	private void init2() {
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
	
	private void init3() {
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
	
	private void init4() {
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
	
	private void initTest() {
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
	
	private void start(){
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
				addCellListener(cell);
			}
	}
	
	private void addCellListener(SudokuCell cell){
		cell.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				highlightCellsByNumber();						
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
	
	private void highlightCellsByNumber(){
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
	
	public void initStart(String user){
		levelCounter = 0;
		if(tryLoad(user) == false){
			init(user, true);
		}
	}
	
	public void initNext(String user){
		if(levelCounter == MAX_LEVEL)
			return;
		levelCounter++;
		if(tryLoad(user) == false){
			init(user, true);
		}
	}
	
	public void initBack(String user){
		if(levelCounter == 0)
			return;
		levelCounter--;
		if(tryLoad(user) == false){
			init(user, true);
		}
	}
	
	private void init(String user, boolean needInitArray){
        panel.removeAll();
		frame.setTitle("�������: " + String.valueOf(levelCounter));
		if(needInitArray)
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
		start();
		panel.repaint();
		saveField(user);
	}
	
	private void finish(String user){
		resetValidation();
		if(isValid()){
			if(levelCounter == MAX_LEVEL)
				JOptionPane.showMessageDialog(frame, "�� ��������! ���� ���������");
			else {
				int dialogResult = JOptionPane.showConfirmDialog(frame, 
						"�� ��������! ������� �� ��������� �������?",
	                    "������!",
	                    JOptionPane.YES_NO_OPTION,
	                    JOptionPane.QUESTION_MESSAGE);
				if(dialogResult == JOptionPane.YES_OPTION){
			    	initNext(user);
				}
			}
		} else {
			JOptionPane.showMessageDialog(frame, "�� ���������! ��������� ������");
		}
	}
	
	private void resetValidation(){
		for(Component c : panel.getComponents())
			if(SudokuCell.class.isInstance(c))
				c.setBackground(Color.WHITE);
	}
	
	private boolean isValid(){
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

	public void setCellValue(String value, String user){
		if (Main.currentCell == null || Main.currentCell.isEnabled() == false)
			return;
		
		CellPosition pos = Main.currentCell.getPosition();
		array[pos.x][pos.y] = Integer.parseInt(value);	
		Main.currentCell.setText(value);
		highlightCellsByNumber();

		int foolCount = 0;
		for(int i = 0; i < 9; i++)
			if (IntStream.of(array[i]).anyMatch(x -> x == 0) == false)
				foolCount++;
		saveField(user);
		if (foolCount == 9)
			finish(user);
	}
	
	public void saveField(String user){
		try(ObjectOutput output = new ObjectOutputStream (new FileOutputStream(user+levelCounter+".game"))){
       	   output.writeObject(this);			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean restoreField(String user){
		try(ObjectInput input = new ObjectInputStream (new FileInputStream(user+levelCounter+".game")))
        {
			ArrayField savedField = (ArrayField)input.readObject();
			this.array = savedField.array.clone(); 
			this.levelCounter = savedField.levelCounter; 
        }
        catch(IOException ex){
              
            System.out.println(ex.getMessage());
        } catch (Throwable cause) {
			// TODO Auto-generated catch block
			cause.printStackTrace();
		}
		init(user, false);
		return true;
	}
	
	private boolean tryLoad(String user){
		File savedFile = new File(user + levelCounter + ".game");
		if(savedFile.exists()){
			restoreField(user);
			return true;
		}
		return false;
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
	
	public void goUp(){
//		Main.currentCell = 
	}
}