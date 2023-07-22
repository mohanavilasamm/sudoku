package com.sudoku.core.generator;

import java.util.HashMap;
import java.util.Map;

import com.sudoku.core.InvalidSudokuException;

public final class SudokuSlicer {

	public static int[] getCurrentColumn(int[][] sudoku, int rightIndex) {
		if (sudoku == null || sudoku.length != 9 || sudoku[0].length != 9)
			throw new InvalidSudokuException();
		return new int[] { sudoku[0][rightIndex], sudoku[1][rightIndex], sudoku[2][rightIndex], sudoku[3][rightIndex],
				sudoku[4][rightIndex], sudoku[5][rightIndex], sudoku[6][rightIndex], sudoku[7][rightIndex],
				sudoku[8][rightIndex] };
	}

	public static int[] getCurrentSubSection(int[][] sudoku, int leftIndex, int rightIndex) {
		if (sudoku == null || sudoku.length != 9 || sudoku[0].length != 9)
			throw new InvalidSudokuException();
		int[] section = new int[9];
		int k = 0;
		Map<Integer, Integer> sectionMap = new HashMap<Integer, Integer>();
		sectionMap.put(0, 0);
		sectionMap.put(1, 3);
		sectionMap.put(2, 6);
		for (int i = sectionMap.get(leftIndex / 3); i < sectionMap.get(leftIndex / 3) + 3; i++)
			for (int j = sectionMap.get(rightIndex / 3); j < sectionMap.get(rightIndex / 3) + 3; j++)
				section[k++] = sudoku[i][j];
		return section;
	}

}
