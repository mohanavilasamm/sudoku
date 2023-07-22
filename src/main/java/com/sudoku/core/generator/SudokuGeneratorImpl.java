package com.sudoku.core.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SudokuGeneratorImpl implements SudokuGenerator {

	private static List<Integer> ALLOWED_VALUES = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

	@Override
	public int[][] generateSudoku() {
		int[][] sudoku = new int[9][9];
		populate(sudoku, 0, 0);
		return sudoku;
	}

	private boolean populate(int[][] sudoku, int leftIndex, int rightIndex) {
		if (sudoku[8][8] != 0)
			return true;
		int[] currentRow = sudoku[leftIndex];
		int[] currentColumn = SudokuSlicer.getCurrentColumn(sudoku, rightIndex);
		int[][] currentSection = SudokuSlicer.getCurrentSubSection(sudoku, leftIndex, rightIndex);
		Set<Integer> usedValues = new HashSet<>();
		for (int i = 0; i < currentRow.length; i++) {
			if (currentRow[i] != 0)
				usedValues.add(currentRow[i]);
			if (currentColumn[i] != 0)
				usedValues.add(currentColumn[i]);
		}
		for (int i = 0; i < currentSection.length; i++)
			for (int j = 0; j < currentSection[0].length; j++)
				if (currentSection[i][j] != 0)
					usedValues.add(currentSection[i][j]);
		List<Integer> availableValues = new ArrayList<>();
		Collections.shuffle(ALLOWED_VALUES);
		for (int i = 0; i < 9; i++) {
			if (!usedValues.contains(ALLOWED_VALUES.get(i)))
				availableValues.add(ALLOWED_VALUES.get(i));
		}
		Iterator<Integer> availableValuesIterator = availableValues.iterator();
		while (availableValuesIterator.hasNext()) {
			int value = availableValuesIterator.next();
			sudoku[leftIndex][rightIndex] = value;
			int nextLeftIndex = leftIndex;
			int nextRightIndex = rightIndex;
			if (nextRightIndex == 8) {
				nextLeftIndex++;
				nextRightIndex = 0;
			} else {
				nextRightIndex++;
			}
			if (!populate(sudoku, nextLeftIndex, nextRightIndex))
				for (int i = nextLeftIndex; i < 9; i++)
					for (int j = nextRightIndex; j < 9; j++)
						sudoku[nextLeftIndex][nextRightIndex] = 0;
			else
				return true;
		}
		return false;
	}
}
