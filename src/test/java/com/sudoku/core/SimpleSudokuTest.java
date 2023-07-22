package com.sudoku.core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.sudoku.core.common.InvalidSudokuException;
import com.sudoku.core.generator.SimpleSudokuGenerator;
import com.sudoku.core.generator.SudokuGenerator;
import com.sudoku.core.masker.EasyMaskingStrategy;
import com.sudoku.core.masker.MaskingStrategy;
import com.sudoku.core.masker.SimpleSudokuMasker;
import com.sudoku.core.masker.SudokuMasker;
import com.sudoku.core.validator.SimpleSudokuValidator;
import com.sudoku.core.validator.SudokuValidator;

class SimpleSudokuTest {
	
	private Sudoku sudoku;
	
	@BeforeEach
	public void initEach(){
		SudokuGenerator sudokuGenerator = new SimpleSudokuGenerator();
		SudokuValidator sudokuValidator = new SimpleSudokuValidator();
		MaskingStrategy sudokuMaskingStrategy = new EasyMaskingStrategy();
		SudokuMasker sudokuMasker = new SimpleSudokuMasker(sudokuMaskingStrategy);
		this.sudoku = new SimpleSudoku(sudokuGenerator, sudokuValidator, sudokuMasker);
	}

	@Test
	void testGenerate() {
		int[][] simpleSudoku = sudoku.generate();
		assertNotNull(simpleSudoku);
	}

	@Test
	void testValidate() {
		int[][] simpleSudoku = sudoku.generate();
		assertTrue(sudoku.validate(simpleSudoku));
		int[][] invalidSudoku = new int[9][9];
		assertFalse(sudoku.validate(invalidSudoku));
		final int[][] invalid = new int[3][3];
		assertThrows(InvalidSudokuException.class, () -> sudoku.validate(invalid));
	}

	@Test
	void testMask() {
		int[][] simpleSudoku = sudoku.generate();
		int[][] maskedSudoku = sudoku.mask(simpleSudoku);
		assertFalse(sudoku.validate(maskedSudoku));
		int[][] invalidSudoku = new int[9][9];
		assertFalse(sudoku.validate(invalidSudoku));
		final int[][] invalid = new int[3][3];
		assertThrows(InvalidSudokuException.class, () -> sudoku.validate(invalid));
	}

}
