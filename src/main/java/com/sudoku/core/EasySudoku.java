package com.sudoku.core;

import com.sudoku.core.generator.SudokuGenerator;
import com.sudoku.core.masker.EasyMaskingStrategy;
import com.sudoku.core.masker.MaskingStrategy;
import com.sudoku.core.masker.SudokuMasker;
import com.sudoku.core.masker.SudokuMaskerImpl;
import com.sudoku.core.common.InvalidSudokuException;
import com.sudoku.core.generator.SimpleSudokuGenerator;
import com.sudoku.core.validator.SudokuValidator;
import com.sudoku.core.validator.SimpleSudokuValidator;

public class EasySudoku implements Sudoku{

	@Override
	public int[][] generate() {
		SudokuGenerator sudokuGenerator = new SimpleSudokuGenerator();
		return sudokuGenerator.generate();
	}

	@Override
	public boolean isValid(int[][] sudoku) throws InvalidSudokuException {
		SudokuValidator sudokuValidator = new SimpleSudokuValidator();
		return sudokuValidator.isValid(sudoku);
	}

	@Override
	public int[][] mask(int[][] sudoku) throws InvalidSudokuException {
		MaskingStrategy easyMaskingStrategy = new EasyMaskingStrategy();
		SudokuMasker sudokuMasker = new SudokuMaskerImpl(easyMaskingStrategy);
		return sudokuMasker.mask(sudoku);
	}
}
