package com.sudoku.core.solver;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import com.sudoku.core.common.SudokuSlicer;
import com.sudoku.core.common.SudokuValueAssister;
import com.sudoku.core.validator.SudokuValidator;

public class SimpleSudokuSolver implements SudokuSolver{
	
	private SudokuValidator validator;
	
	private List<Integer> allowedValues = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
	
	public List<Integer> getAllowedValues() {
		return this.allowedValues;
	}
	
	public SudokuValidator getValidator() {
		return this.validator;
	}
	
	public SimpleSudokuSolver(SudokuValidator validator) {
		this.validator = validator;
	}

	@Override
	public int[][] solve(int[][] sudoku) {
		solve(sudoku, 0, 0);
		return sudoku;
	}

	private boolean solve(int[][] sudoku, int leftIndex, int rightIndex) {
		if(getValidator().isValid(sudoku))
			return true;
		else {
			if(sudoku[leftIndex][rightIndex] == 0) {
				int[] currentRow = sudoku[leftIndex];
				int[] currentColumn = SudokuSlicer.getCurrentColumn(sudoku, rightIndex);
				int[] currentSection = SudokuSlicer.getCurrentSubSection(sudoku, leftIndex, rightIndex);
				Set<Integer> usedValues = SudokuValueAssister.getUsedValues(currentRow, currentColumn, currentSection);
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
					if(solve(sudoku, nextLeftIndex, nextRightIndex))
						return true;
					else
						sudoku[leftIndex][rightIndex] = 0;
				}
				return false;
			} else {
				int nextLeftIndex = leftIndex;
				int nextRightIndex = rightIndex;
				if (nextRightIndex == 8) {
					nextLeftIndex++;
					nextRightIndex = 0;
				} else {
					nextRightIndex++;
				}
				if(solve(sudoku, nextLeftIndex, nextRightIndex))
					return true;
				else
					return false;
			}
		}
	}
}
