package com.sudoku.core.generator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import com.sudoku.core.common.SudokuSlicer;
import com.sudoku.core.common.SudokuValueAssister;

public class SimpleSudokuGenerator implements SudokuGenerator {

	private List<Integer> allowedValues = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
	
	public List<Integer> getAllowedValues() {
		return this.allowedValues;
	}

	@Override
	public int[][] generate() {
		int[][] sudoku = new int[9][9];
		populate(sudoku, 0, 0);
		return sudoku;
	}

	private boolean populate(int[][] sudoku, int leftIndex, int rightIndex) {
		if (sudoku[8][8] != 0)
			return true;
		int[] currentRow = sudoku[leftIndex];
		int[] currentColumn = SudokuSlicer.getCurrentColumn(sudoku, rightIndex);
		int[] currentSection = SudokuSlicer.getCurrentSubSection(sudoku, leftIndex, rightIndex);
		Set<Integer> usedValues = SudokuValueAssister.getUsedValues(currentRow, currentColumn, currentSection);
		Collections.shuffle(getAllowedValues());
		List<Integer> availableValues = SudokuValueAssister.getAvailableValues(usedValues, getAllowedValues());
		for(int i=0; i<availableValues.size(); i++) {
			sudoku[leftIndex][rightIndex] = availableValues.get(i);
			int nextLeftIndex = leftIndex;
			int nextRightIndex = rightIndex;
			if (nextRightIndex == 8) {
				nextLeftIndex++;
				nextRightIndex = 0;
			} else {
				nextRightIndex++;
			}
			if (!populate(sudoku, nextLeftIndex, nextRightIndex))
				sudoku[nextLeftIndex][nextRightIndex] = 0;
			else
				return true;
		}
		return false;
	}
}
