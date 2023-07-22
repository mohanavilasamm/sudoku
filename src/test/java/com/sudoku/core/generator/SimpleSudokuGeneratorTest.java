package com.sudoku.core.generator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.sudoku.core.validator.SimpleSudokuValidator;

class SimpleSudokuGeneratorTest {

	@Test
	void testPopulate() {
		SimpleSudokuGenerator sudokuGeneratorImpl = new SimpleSudokuGenerator();
		int[][] sudoku = sudokuGeneratorImpl.generate();
		SimpleSudokuValidator validator = new SimpleSudokuValidator();
		assertTrue(validator.isValid(sudoku));
	}

}
