package com.sudoku.core.generator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.sudoku.core.validator.*;

class SimpleSudokuGeneratorTest {

	@Test
	void testPopulate() {
		SudokuGenerator sudokuGeneratorImpl = new SimpleSudokuGenerator();
		int[][] sudoku = sudokuGeneratorImpl.generate();
		SudokuValidator validator = new SimpleSudokuValidator();
		assertTrue(validator.isValid(sudoku));
	}

}
