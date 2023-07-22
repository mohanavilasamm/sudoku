package com.sudoku.core.masker;

import java.util.concurrent.ThreadLocalRandom;
import com.sudoku.core.common.InvalidSudokuException;
import com.sudoku.core.common.SudokuSlicer;

public class EasySudokuMasker implements SudokuMasker {

	@Override
	public int[][] mask(int[][] sudoku) throws InvalidSudokuException {
		if (sudoku == null || sudoku.length != 9 || sudoku[0].length != 9)
			throw new InvalidSudokuException();
		int[][] maskedSudoku = new int[9][9];
		for (int i=0; i<sudoku.length; i++)
			for(int j=0; j<sudoku[i].length; j++)
				maskedSudoku[i][j] = sudoku[i][j];
		for (int i=0; i<maskedSudoku.length; i++)
			for (int j=0; j<maskedSudoku[i].length; j++) {
				int currentNumber = maskedSudoku[i][j];
				if (currentNumber == 0)
					break;
				if (j==0 || j==3 || j==6) {
					//check middle and end columns
					//if there are three values mask one
					maskWithLeftColumnStrategy(maskedSudoku, i, j);

				} else if (j==1 || j==4 || j==7) {
					//check left and right columns
					//if there are three values mask one
					maskWithMiddleColumnStrategy(maskedSudoku, i, j);
				} else if (j==2 || j==5 || j==8) {
					//check left and middle columns
					//if there are three values mask one
					maskWithRightColumnStrategy(maskedSudoku, i, j);
				}
				if (i==0 || i==3 || i==6) {
					//check middle and bottom rows
					//if there are three values mask one
					maskWithTopRowStrategy(maskedSudoku, i, j);

				} else if (i==1 || i==4 || i==7) {
					//check top and bottom rows
					//if there are three values mask one
					maskWithMiddleRowStrategy(maskedSudoku, i, j);
				} else if (i==2 || i==5 || i==8) {
					//check top and middle rows
					//if there are three values mask one
					maskWithBottomRowStrategy(maskedSudoku, i, j);
				}
				
			}
		return maskedSudoku;
	}
	
	private void maskWithLeftColumnStrategy(int[][] sudoku, int leftIndex, int rightIndex) {
		int[] middleColumn =  SudokuSlicer.getCurrentColumn(sudoku, rightIndex + 1);
		int middleIndex = -1;
		int[] endColumn =  SudokuSlicer.getCurrentColumn(sudoku, rightIndex + 2);
		int endIndex = -1;
		int currentNumber = sudoku[leftIndex][rightIndex];
		if (currentNumber==0)
			return;
		for (int k=0; k<middleColumn.length; k++) {
			if (middleColumn[k] == currentNumber)
				middleIndex = k;
			if (endColumn[k] == currentNumber)
				endIndex = k;
		}
		if(middleIndex!=-1 &&  endIndex!=-1) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, 3);
			if (randomNum==0)
				sudoku[leftIndex][rightIndex]  = 0;
			else if (randomNum==1)
				middleColumn[middleIndex] = 0;
			else
				endColumn[endIndex] = 0;
		}
	}
	
	private void maskWithMiddleColumnStrategy(int[][] sudoku, int leftIndex, int rightIndex) {
		int[] leftColumn =  SudokuSlicer.getCurrentColumn(sudoku, rightIndex - 1);
		int leftColumnIndex = -1;
		int[] endColumn =  SudokuSlicer.getCurrentColumn(sudoku, rightIndex + 1);
		int endIndex = -1;
		int currentNumber = sudoku[leftIndex][rightIndex];
		if (currentNumber==0)
			return;
		for (int k=0; k<leftColumn.length; k++) {
			if (leftColumn[k] == currentNumber)
				leftColumnIndex = k;
			if (endColumn[k] == currentNumber)
				endIndex = k;
		}
		if(leftColumnIndex!=-1 &&  endIndex!=-1) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, 3);
			if (randomNum==0)
				sudoku[leftIndex][rightIndex]  = 0;
			else if (randomNum==1)
				leftColumn[leftColumnIndex] = 0;
			else
				endColumn[endIndex] = 0;
		}
	}
	
	private void maskWithRightColumnStrategy(int[][] sudoku, int leftIndex, int rightIndex) {
		int[] middleColumn =  SudokuSlicer.getCurrentColumn(sudoku, rightIndex - 1);
		int middleIndex = -1;
		int[] leftColumn =  SudokuSlicer.getCurrentColumn(sudoku, rightIndex - 2);
		int leftColumnIndex = -1;
		int currentNumber = sudoku[leftIndex][rightIndex];
		if (currentNumber==0)
			return;
		for (int k=0; k<middleColumn.length; k++) {
			if (middleColumn[k] == currentNumber)
				middleIndex = k;
			if (leftColumn[k] == currentNumber)
				leftColumnIndex = k;
		}
		if(middleIndex!=-1 &&  leftColumnIndex!=-1) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, 3);
			if (randomNum==0)
				sudoku[leftIndex][rightIndex]  = 0;
			else if (randomNum==1)
				middleColumn[middleIndex] = 0;
			else
				leftColumn[leftColumnIndex] = 0;
		}
	}
	
	
	private void maskWithTopRowStrategy(int[][] sudoku, int leftIndex, int rightIndex) {
		int[] middleRow =  sudoku[leftIndex + 1];
		int middleRowIndex = -1;
		int[] bottomRow =  sudoku[leftIndex + 2];
		int bottomRowIndex = -1;
		int currentNumber = sudoku[leftIndex][rightIndex];
		if (currentNumber==0)
			return;
		for (int k=0; k<middleRow.length; k++) {
			if (middleRow[k] == currentNumber)
				middleRowIndex = k;
			if (bottomRow[k] == currentNumber)
				bottomRowIndex = k;
		}
		if(middleRowIndex!=-1 &&  bottomRowIndex!=-1) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, 3);
			if (randomNum==0)
				sudoku[leftIndex][rightIndex]  = 0;
			else if (randomNum==1)
				middleRow[middleRowIndex] = 0;
			else
				bottomRow[bottomRowIndex] = 0;
		}
	}
	
	private void maskWithMiddleRowStrategy(int[][] sudoku, int leftIndex, int rightIndex) {
		int[] topRow =  sudoku[leftIndex - 1];
		int topRowIndex = -1;
		int[] bottomRow =  sudoku[leftIndex + 1];
		int bottomRowIndex = -1;
		int currentNumber = sudoku[leftIndex][rightIndex];
		if (currentNumber==0)
			return;
		for (int k=0; k<topRow.length; k++) {
			if (topRow[k] == currentNumber)
				topRowIndex = k;
			if (bottomRow[k] == currentNumber)
				bottomRowIndex = k;
		}
		if(topRowIndex!=-1 &&  bottomRowIndex!=-1) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, 3);
			if (randomNum==0)
				sudoku[leftIndex][rightIndex]  = 0;
			else if (randomNum==1)
				topRow[topRowIndex] = 0;
			else
				bottomRow[bottomRowIndex] = 0;
		}
	}
	
	private void maskWithBottomRowStrategy(int[][] sudoku, int leftIndex, int rightIndex) {
		//maskWithStrategy(sudoku, leftIndex, rightIndex, sudoku[leftIndex - 2], sudoku[leftIndex - 1]);
		int[] topRow =  sudoku[leftIndex - 2];
		int topRowIndex = -1;
		int[] middleRow =  sudoku[leftIndex - 1];
		int middleRowIndex = -1;
		int currentNumber = sudoku[leftIndex][rightIndex];
		if (currentNumber==0)
			return;
		for (int k=0; k<topRow.length; k++) {
			if (topRow[k] == currentNumber)
				topRowIndex = k;
			if (middleRow[k] == currentNumber)
				middleRowIndex = k;
		}
		if(topRowIndex!=-1 &&  middleRowIndex!=-1) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, 3);
			if (randomNum==0)
				sudoku[leftIndex][rightIndex]  = 0;
			else if (randomNum==1)
				topRow[topRowIndex] = 0;
			else
				middleRow[middleRowIndex] = 0;
		}
	}
	
	private void maskWithStrategy(int[][] sudoku, int leftIndex, int rightIndex, int[] arrayOne, int[] arrayTwo) {
		int arraryOneIndex = -1;
		int arrayTwoIndex = -1;
		int currentValue = sudoku[leftIndex][rightIndex];
		for (int k=0; k<arrayOne.length; k++) {
			if (arrayOne[k] == currentValue)
				arraryOneIndex = k;
			if (arrayTwo[k] == currentValue)
				arrayTwoIndex = k;
		}
		if(arraryOneIndex!=-1 &&  arrayTwoIndex!=-1) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, 3);
			if (randomNum==0)
				sudoku[leftIndex][rightIndex]  = 0;
			else if (randomNum==1)
				arrayOne[arraryOneIndex] = 0;
			else
				arrayTwo[arrayTwoIndex] = 0;
		}
	}
}

