package com.sudoku.core.masker;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.sudoku.core.generator.SimpleSudokuGenerator;
import com.sudoku.core.generator.SudokuGenerator;
import com.sudoku.core.validator.SimpleSudokuValidator;
import com.sudoku.core.validator.SudokuValidator;
import com.sudoku.core.solver.*;

class SudokuMaskerImplTest {

	@Test
	void testMask() {
		SudokuGenerator sudokuGenerator = new SimpleSudokuGenerator();
		int[][] sudoku = sudokuGenerator.generate();
		MaskingStrategy easyMaskingStrategy = new EasyMaskingStrategy();
		SudokuMasker sudokuMasker = new SimpleSudokuMasker(easyMaskingStrategy);
		int[][] maskedSudoku = sudokuMasker.mask(sudoku);
		SudokuValidator sudokuValidator = new SimpleSudokuValidator();
		assertFalse(sudokuValidator.isValid(maskedSudoku));
		SudokuSolver solver = new SimpleSudokuSolver(sudokuValidator);
		int[][] solvedSudoku = solver.solve(maskedSudoku);
		assertTrue(sudokuValidator.isValid(solvedSudoku));
	}
}
