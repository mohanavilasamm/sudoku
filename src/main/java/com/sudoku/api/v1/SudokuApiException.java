package com.sudoku.api.v1;

public class SudokuApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public SudokuApiException(String message) {
		super(message);
	}

}
