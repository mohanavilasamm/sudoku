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

public class SimpleSudokuFactory implements SudokuFactory{

	@Override
	public Sudoku createSudoku(Level level) throws InvalidSudokuException {
		if(level == null)
			throw new InvalidSudokuException("A level is needed to create a sudoku");
		if(level.equals(Level.EASY)) {
			SudokuGenerator sudokuGenerator = new SimpleSudokuGenerator();
			SudokuValidator sudokuValidator = new SimpleSudokuValidator();
			MaskingStrategy sudokuMaskingStrategy = new EasyMaskingStrategy();
			SudokuMasker sudokuMasker = new SimpleSudokuMasker(sudokuMaskingStrategy);
			SudokuSolver sudokuSolver = new SimpleSudokuSolver(sudokuValidator);
			Sudoku sudoku = new SimpleSudoku(sudokuGenerator, sudokuValidator, sudokuMasker, sudokuSolver);
			return sudoku;
		} else {
			throw new InvalidSudokuException("Unimplemented levels");
		}
		
	}

}
