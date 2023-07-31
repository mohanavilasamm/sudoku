package com.sudoku.core;

public interface SudokuProvider {
	
	int[][] generate();
	
	boolean validate(int[][] sudoku);
	
	int[][] mask(int[][] sudoku);
	
	int[][] solve(int[][] sudoku);

	int[] serialize(int[][] sudokuMatrix);

	int[][] deserialize(int[] sudokuArray);

}
