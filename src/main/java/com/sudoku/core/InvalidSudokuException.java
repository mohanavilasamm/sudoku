package com.sudoku.core;

public class InvalidSudokuException extends RuntimeException {

	private static final long serialVersionUID = 7785811679448615468L;

	public InvalidSudokuException() {
		super("This sudoku is invalid");
	}
}
