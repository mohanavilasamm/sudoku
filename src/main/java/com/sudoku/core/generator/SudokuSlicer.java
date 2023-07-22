package com.sudoku.core.generator;

import com.sudoku.core.InvalidSudokuException;

public final class SudokuSlicer {

	public static int[] getCurrentColumn(int[][] sudoku, int rightIndex) {
		if (sudoku == null || sudoku.length != 9 || sudoku[0].length != 9)
			throw new InvalidSudokuException();
		return new int[] { sudoku[0][rightIndex], sudoku[1][rightIndex], sudoku[2][rightIndex], sudoku[3][rightIndex],
				sudoku[4][rightIndex], sudoku[5][rightIndex], sudoku[6][rightIndex], sudoku[7][rightIndex],
				sudoku[8][rightIndex] };
	}

	public static int[][] getCurrentSubSection(int[][] sudoku, int leftIndex, int rightIndex) {
		if (sudoku == null || sudoku.length != 9 || sudoku[0].length != 9)
			throw new InvalidSudokuException();
		int[][] currentSection = new int[3][3];
		if (leftIndex < 3 && rightIndex < 3) {
			currentSection = new int[][] { 
					new int[] { sudoku[0][0], sudoku[0][1], sudoku[0][2] },
					new int[] { sudoku[1][0], sudoku[1][1], sudoku[1][2] },
					new int[] { sudoku[2][0], sudoku[2][1], sudoku[2][2] } };
		} else if (leftIndex >= 3 && leftIndex < 6 && rightIndex < 3) {
			currentSection = new int[][] { 
					new int[] { sudoku[3][0], sudoku[3][1], sudoku[3][2] },
					new int[] { sudoku[4][0], sudoku[4][1], sudoku[4][2] },
					new int[] { sudoku[5][0], sudoku[5][1], sudoku[5][2] } };
		} else if (leftIndex >= 6 && leftIndex < 9 && rightIndex < 3) {
			currentSection = new int[][] { 
					new int[] { sudoku[6][0], sudoku[6][1], sudoku[6][2] },
					new int[] { sudoku[7][0], sudoku[7][1], sudoku[7][2] },
					new int[] { sudoku[8][0], sudoku[8][1], sudoku[8][2] } };
		}
		if (leftIndex < 3 && rightIndex >= 3 && rightIndex < 6) {
			currentSection = new int[][] { 
					new int[] { sudoku[0][3], sudoku[0][4], sudoku[0][5] },
					new int[] { sudoku[1][3], sudoku[1][4], sudoku[1][5] },
					new int[] { sudoku[2][3], sudoku[2][4], sudoku[2][5] } };
		} else if (leftIndex >= 3 && leftIndex < 6 && rightIndex >= 3 && rightIndex < 6) {
			currentSection = new int[][] { 
					new int[] { sudoku[3][3], sudoku[3][4], sudoku[3][5] },
					new int[] { sudoku[4][3], sudoku[4][4], sudoku[4][5] },
					new int[] { sudoku[5][3], sudoku[5][4], sudoku[5][5] } };
		} else if (leftIndex >= 6 && leftIndex < 9 && rightIndex >= 3 && rightIndex < 6) {
			currentSection = new int[][] {
					new int[] { sudoku[6][3], sudoku[6][4], sudoku[6][5] },
					new int[] { sudoku[7][3], sudoku[7][4], sudoku[7][5] },
					new int[] { sudoku[8][3], sudoku[8][4], sudoku[8][5] } };
		}
		if (leftIndex < 3 && rightIndex >= 6 && rightIndex < 9) {
			currentSection = new int[][] { 
					new int[] { sudoku[0][6], sudoku[0][7], sudoku[0][8] },
					new int[] { sudoku[1][6], sudoku[1][7], sudoku[1][8] },
					new int[] { sudoku[2][6], sudoku[2][7], sudoku[2][8] } };
		} else if (leftIndex >= 3 && leftIndex < 6 && rightIndex >= 6 && rightIndex < 9) {
			currentSection = new int[][] { 
					new int[] { sudoku[3][6], sudoku[3][7], sudoku[3][8] },
					new int[] { sudoku[4][6], sudoku[4][7], sudoku[4][8] },
					new int[] { sudoku[5][6], sudoku[5][7], sudoku[5][8] } };
		} else if (leftIndex >= 6 && leftIndex < 9 && rightIndex >= 6 && rightIndex < 9) {
			currentSection = new int[][] { 
					new int[] { sudoku[6][6], sudoku[6][7], sudoku[6][8] },
					new int[] { sudoku[7][6], sudoku[7][7], sudoku[7][8] },
					new int[] { sudoku[8][6], sudoku[8][7], sudoku[8][8] } };
		}
		return currentSection;
	}

}
