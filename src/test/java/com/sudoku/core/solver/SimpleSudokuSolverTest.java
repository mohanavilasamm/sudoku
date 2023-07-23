package com.sudoku.core.solver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.sudoku.core.generator.SimpleSudokuGenerator;
import com.sudoku.core.generator.SudokuGenerator;
import com.sudoku.core.masker.EasyMaskingStrategy;
import com.sudoku.core.masker.SimpleSudokuMasker;
import com.sudoku.core.masker.SudokuMasker;
import com.sudoku.core.validator.SimpleSudokuValidator;
import com.sudoku.core.validator.SudokuValidator;

class SimpleSudokuSolverTest {

	@Test
	void testSolve() {
		SudokuGenerator sudokuGeneratorImpl = new SimpleSudokuGenerator();
		int[][] sudoku = sudokuGeneratorImpl.generate();
		SudokuMasker sudokuMasker = new SimpleSudokuMasker(new EasyMaskingStrategy());
		int [][] maskedSudoku = sudokuMasker.mask(sudoku);
		SudokuValidator validator = new SimpleSudokuValidator();
		SudokuSolver solver = new SimpleSudokuSolver(validator);
		int [][] solvedSudoku = solver.solve(maskedSudoku);
		assertTrue(validator.isValid(solvedSudoku));
		//assertArrayEquals(sudoku, solvedSudoku);
	}

}
