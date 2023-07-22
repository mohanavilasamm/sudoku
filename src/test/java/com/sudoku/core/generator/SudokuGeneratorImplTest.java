package com.sudoku.core.generator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.sudoku.core.validator.SudokuValidatorImpl;

class SudokuGeneratorImplTest {

	@Test
	void testPopulate() {
		SudokuGeneratorImpl sudokuGeneratorImpl = new SudokuGeneratorImpl();
		int[][] sudoku = sudokuGeneratorImpl.generateSudoku();
		SudokuValidatorImpl validator = new SudokuValidatorImpl();
		assertTrue(validator.validate(sudoku));
	}

}
