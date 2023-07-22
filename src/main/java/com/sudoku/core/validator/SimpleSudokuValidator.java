package com.sudoku.core.validator;

import java.util.Set;

import com.sudoku.core.common.SudokuSlicer;

import java.util.Arrays;
import java.util.HashSet;

public class SimpleSudokuValidator {

	private static Set<Integer> PURE_SET = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

	public boolean validate(int[][] sudoku) {
		if (sudoku == null || sudoku.length != 9 || sudoku[0].length != 9)
			return false;
		for (int i = 0; i < sudoku.length; i++)
			if (!isValidArray(sudoku[i]))
				return false;
		for (int i = 0; i < sudoku.length; i++) {
			int[] array = SudokuSlicer.getCurrentColumn(sudoku, i);
			if (!isValidArray(array))
				return false;
		}
		return isValidArray(SudokuSlicer.getCurrentSubSection(sudoku, 0, 0))
				&& isValidArray(SudokuSlicer.getCurrentSubSection(sudoku, 0, 3))
				&& isValidArray(SudokuSlicer.getCurrentSubSection(sudoku, 0, 6))
				&& isValidArray(SudokuSlicer.getCurrentSubSection(sudoku, 3, 0))
				&& isValidArray(SudokuSlicer.getCurrentSubSection(sudoku, 3, 3))
				&& isValidArray(SudokuSlicer.getCurrentSubSection(sudoku, 3, 6))
				&& isValidArray(SudokuSlicer.getCurrentSubSection(sudoku, 6, 0))
				&& isValidArray(SudokuSlicer.getCurrentSubSection(sudoku, 6, 3))
				&& isValidArray(SudokuSlicer.getCurrentSubSection(sudoku, 6, 6));
	}

	public boolean isValidArray(int[] array) {
		if (array == null || array.length != 9)
			return false;
		Set<Integer> uniqueSet = new HashSet<>();
		for (int i = 0; i < array.length; i++) {
			if (!PURE_SET.contains(array[i]) || !uniqueSet.add(array[i]))
				return false;
		}
		return true;
	}
}
