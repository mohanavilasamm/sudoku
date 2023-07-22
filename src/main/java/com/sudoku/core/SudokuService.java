package com.sudoku.core;

import org.springframework.stereotype.Service;

@Service
public class SudokuService {

	public Sudoku generateSudoku() {
		return new Sudoku("123456789", Status.VALID);
	}

	public Sudoku isValid(Sudoku sudoku) {
		return new Sudoku("123456789", Status.VALID);
	}
}
