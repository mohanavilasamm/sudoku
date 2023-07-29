package com.sudoku.core.masker;

import java.util.concurrent.ThreadLocalRandom;

import com.sudoku.core.common.SudokuSlicer;

public class EasyMaskingStrategy implements MaskingStrategy {

	@Override
	public int[][] maskWithStrategy(int[][] sudoku) {
		int[][] maskedSudoku = new int[9][9];
		for (int i=0; i<sudoku.length; i++)
			for(int j=0; j<sudoku[i].length; j++)
				maskedSudoku[i][j] = sudoku[i][j];
		for (int leftIndex=0; leftIndex<maskedSudoku.length; leftIndex++)
			for (int rightIndex=0; rightIndex<maskedSudoku[leftIndex].length; rightIndex++) {
				int currentNumber = maskedSudoku[leftIndex][rightIndex];
				if (currentNumber == 0)
					break;
				if (rightIndex==0 || rightIndex==3 || rightIndex==6) {
					//check middle and end columns
					//if there are three values mask one
					mask(maskedSudoku, leftIndex, rightIndex, SudokuSlicer.getCurrentColumn(maskedSudoku, rightIndex + 1), SudokuSlicer.getCurrentColumn(maskedSudoku, rightIndex + 2));

				} else if (rightIndex==1 || rightIndex==4 || rightIndex==7) {
					//check left and right columns
					//if there are three values mask one
					mask(maskedSudoku, leftIndex, rightIndex, SudokuSlicer.getCurrentColumn(maskedSudoku, rightIndex - 1), SudokuSlicer.getCurrentColumn(maskedSudoku, rightIndex + 1));
				} else if (rightIndex==2 || rightIndex==5 || rightIndex==8) {
					//check left and middle columns
					//if there are three values mask one
					mask(maskedSudoku, leftIndex, rightIndex, SudokuSlicer.getCurrentColumn(maskedSudoku, rightIndex - 1), SudokuSlicer.getCurrentColumn(maskedSudoku, rightIndex - 2));
				}
				if (leftIndex==0 || leftIndex==3 || leftIndex==6) {
					//check middle and bottom rows
					//if there are three values mask one
					mask(maskedSudoku, leftIndex, rightIndex, maskedSudoku[leftIndex + 1], maskedSudoku[leftIndex + 2]);

				} else if (leftIndex==1 || leftIndex==4 || leftIndex==7) {
					//check top and bottom rows
					//if there are three values mask one
					mask(maskedSudoku, leftIndex, rightIndex, maskedSudoku[leftIndex - 1], maskedSudoku[leftIndex + 1]);
				} else if (leftIndex==2 || leftIndex==5 || leftIndex==8) {
					//check top and middle rows
					//if there are three values mask one
					mask(maskedSudoku, leftIndex, rightIndex, maskedSudoku[leftIndex - 2], maskedSudoku[leftIndex - 1]);
				}
				
			}
		return maskedSudoku;
	}
	
	private void mask(int[][] sudoku, int leftIndex, int rightIndex, int[] arrayOne, int[] arrayTwo) {
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
