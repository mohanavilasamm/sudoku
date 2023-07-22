package com.sudoku.core.validator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SimpleSudokuValidatorTest {

	@Test
	void testValidate() {
		SimpleSudokuValidator validator = new SimpleSudokuValidator();
		assertFalse(validator.validate(null));
		assertFalse(validator
				.validate(new int[][] { new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }, new int[] { 7, 8, 9 } }));
		assertTrue(validator.validate(new int[][] { new int[] { 6, 3, 9, 5, 7, 4, 1, 8, 2 },
				new int[] { 5, 4, 1, 8, 2, 9, 3, 7, 6 }, new int[] { 7, 8, 2, 6, 1, 3, 9, 5, 4 },
				new int[] { 1, 9, 8, 4, 6, 7, 5, 2, 3 }, new int[] { 3, 6, 5, 9, 8, 2, 4, 1, 7 },
				new int[] { 4, 2, 7, 1, 3, 5, 8, 6, 9 }, new int[] { 9, 5, 6, 7, 4, 8, 2, 3, 1 },
				new int[] { 8, 1, 3, 2, 9, 6, 7, 4, 5 }, new int[] { 2, 7, 4, 3, 5, 1, 6, 9, 8 } }));
	}

	@Test
	void testIsArrayValid() {
		SimpleSudokuValidator validator = new SimpleSudokuValidator();
		assertTrue(validator.isValidArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
		assertTrue(validator.isValidArray(new int[] { 9, 2, 3, 4, 5, 6, 7, 8, 1 }));
		assertFalse(validator.isValidArray(new int[] { 11, 2, 3, 4, 5, 6, 7, 8, 9 }));
		assertFalse(validator.isValidArray(new int[] { 0, 2, 3, 4, 5, 6, 7, 8, 9 }));
		assertFalse(validator.isValidArray(new int[] { 2, 3, 4, 5, 6, 7, 8, 9 }));
		assertFalse(validator.isValidArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }));
		assertFalse(validator.isValidArray(new int[] { 1, 1, 3, 4, 5, 6, 7, 8, 9, 0 }));
		assertFalse(validator.isValidArray(new int[] { 1, 1, 3, 4, 5, 6, 7, 8, 9, }));
		assertFalse(validator.isValidArray(new int[] {}));
		assertFalse(validator.isValidArray(null));
	}
}
