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
import com.sudoku.core.serialization.Serializer;
import com.sudoku.core.serialization.SimpleSerializer;
import com.sudoku.core.solver.SimpleSudokuSolver;
import com.sudoku.core.solver.SudokuSolver;
import com.sudoku.core.validator.SimpleSudokuValidator;
import com.sudoku.core.validator.SudokuValidator;

class SimpleSudokuProviderTest {
	
	private SudokuProvider sudoku;
	
	@BeforeEach
	public void initEach(){
		SudokuGenerator sudokuGenerator = new SimpleSudokuGenerator();
		SudokuValidator sudokuValidator = new SimpleSudokuValidator();
		MaskingStrategy sudokuMaskingStrategy = new EasyMaskingStrategy();
		SudokuMasker sudokuMasker = new SimpleSudokuMasker(sudokuMaskingStrategy);
		SudokuSolver sudokuSolver = new SimpleSudokuSolver(sudokuValidator);
		Serializer sudokuSerializer = new SimpleSerializer();
		this.sudoku = new SimpleSudokuProvider(sudokuGenerator, sudokuValidator, sudokuMasker, sudokuSolver, sudokuSerializer);
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
	
	@Test
	void testSolve() {
		int[][] simpleSudoku = sudoku.generate();
		int[][] maskedSudoku = sudoku.mask(simpleSudoku);
		int[][] solveSudoku = sudoku.solve(maskedSudoku);
		assertTrue(sudoku.validate(solveSudoku));
	}

}
