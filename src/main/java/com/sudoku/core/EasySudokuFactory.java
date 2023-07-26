package com.sudoku.core;

import com.sudoku.core.common.InvalidSudokuException;
import com.sudoku.core.generator.SimpleSudokuGenerator;
import com.sudoku.core.generator.SudokuGenerator;
import com.sudoku.core.masker.EasyMaskingStrategy;
import com.sudoku.core.masker.MaskingStrategy;
import com.sudoku.core.masker.SimpleSudokuMasker;
import com.sudoku.core.masker.SudokuMasker;
import com.sudoku.core.validator.SimpleSudokuValidator;
import com.sudoku.core.validator.SudokuValidator;
import com.sudoku.core.solver.*;

public class EasySudokuFactory implements SudokuFactory{

	@Override
	public Sudoku createSudoku() throws InvalidSudokuException {
			SudokuGenerator sudokuGenerator = new SimpleSudokuGenerator();
			SudokuValidator sudokuValidator = new SimpleSudokuValidator();
			MaskingStrategy sudokuMaskingStrategy = new EasyMaskingStrategy();
			SudokuMasker sudokuMasker = new SimpleSudokuMasker(sudokuMaskingStrategy);
			SudokuSolver sudokuSolver = new SimpleSudokuSolver(sudokuValidator);
			Sudoku sudoku = new SimpleSudoku(sudokuGenerator, sudokuValidator, sudokuMasker, sudokuSolver);
			return sudoku;	
	}

}
