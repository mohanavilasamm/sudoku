package com.sudoku.core;

public interface Sudoku {
	
	int[][] generate();
	
	boolean validate(int[][] sudoku);
	
	int[][] mask(int[][] sudoku);
	
	int[][] solve(int[][] sudoku);

}
