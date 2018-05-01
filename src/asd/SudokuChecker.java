package asd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;


class SudokuValidationException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}

public class SudokuChecker {
	
	private HashSet<CellPosition> wrongPositions;
	private CellPosition[] getWrongCells(){
		return wrongPositions.toArray(new CellPosition[wrongPositions.size()]);
	}
	
	//словарь соответствия позиций (нужны для соотнесения с исходным массивом при проверке столбцов и блоков)
	private HashMap<CellPosition, CellPosition> positionsDict;
	
	public SudokuChecker(){
		wrongPositions = new HashSet<CellPosition>();
		positionsDict = new HashMap<CellPosition, CellPosition>();
	}

	public CellPosition[] validate(int[][] board) {
		try{
			//Проверяем по каждой строке
			checkRows(board);
			
			//Транспонируем матрицу
			int[][] transBoard = transpose(board);
			//Проверяем по каждому столбцу
			checkRows(transBoard);
			
			//Делим массив на блоки 3х3
			int[][] blocks = toBlocks(board);
			//Проверяем по каждому блоку
			checkRows(blocks);
			
		} catch(SudokuValidationException e) {
//			return false;
		}
		return getWrongCells();
//		return true;
	}
	
	private void checkRows(int[][] board) throws SudokuValidationException {
		for (int i = 0; i < 9; i++) {
			int[] arr = board[i].clone();	
			ArrayList<Integer> wrongColumnsIndexes = getWrongColumns(arr);
			for(int j : wrongColumnsIndexes){
				wrongPositions.add(getInitialPos(i, j));
			}
			/*if (isUniqueArray(arr))
					continue;
				else
					throw new SudokuValidationException(); */			
		}
	}
	
	private ArrayList<Integer> getWrongColumns(int[] array){
		ArrayList<Integer> wrongIndexes = new ArrayList<Integer>();
		for(int i=0; i<9; i++){
			final int a = array[i];
			array[i] = 0;
			if(IntStream.of(array).anyMatch(x -> x == a)){
				wrongIndexes.add(i);
			}
			array[i] = a;
		}			
		return wrongIndexes;
	}
	
	private boolean isUniqueArray(int[] array){
		int a;
		for(int i=0; i<9; i++){
			a = array[i];
			array[i] = 0;
			for (int j=0; j<9; j++) {
				if(array[j] == a){
					array[i] = a;
					return false;
				}
			}
			array[i] = a;
		}			
		return true;
	}
	
	private CellPosition getInitialPos(int x, int y){
		Set<CellPosition> keys = positionsDict.keySet();
		for(CellPosition pos : keys){
			if (pos.x == x && pos.y == y)
				return positionsDict.get(pos);
		}
		return new CellPosition(x, y);
	}
	
	private int[][] transpose(int[][] board) {
		positionsDict = new HashMap<CellPosition, CellPosition>();
		int[][] matrix = new int[9][9];
		for (int i = 0; i < 9; i++) 
            for (int j = 0; j < 9; j++) {
                matrix[i][j] = board[j][i];
                positionsDict.put(new CellPosition(j, i), new CellPosition(i, j));
        }
		return matrix;
	}
	
	private int[][] toBlocks(int[][] board) {
		positionsDict = new HashMap<CellPosition, CellPosition>();
		int[][] blocks = new int[9][9];
		int[] block = new int[9];
		int n = 0;
		for(int i=0; i < 9; i += 3)
			for(int j=0; j < 9; j += 3){
				int m = 0;
				for(int x=0; x<3; x++){
					for(int y=0; y<3; y++){
						block[m] = board[i+x][j+y];
		                positionsDict.put(new CellPosition(n, m), new CellPosition(i+x, j+y));
						m++;
					}
				}
				blocks[n] = block.clone();
				n++;
			}
		return blocks;
	}
}
