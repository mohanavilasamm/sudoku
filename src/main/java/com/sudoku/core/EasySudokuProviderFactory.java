package com.sudoku.core;

import com.sudoku.core.common.InvalidSudokuException;
import com.sudoku.core.generator.SimpleSudokuGenerator;
import com.sudoku.core.generator.SudokuGenerator;
import com.sudoku.core.masker.EasyMaskingStrategy;
import com.sudoku.core.masker.MaskingStrategy;
import com.sudoku.core.masker.SimpleSudokuMasker;
import com.sudoku.core.masker.SudokuMasker;
import com.sudoku.core.serialization.Serializer;
import com.sudoku.core.serialization.SimpleSerializer;
import com.sudoku.core.validator.SimpleSudokuValidator;
import com.sudoku.core.validator.SudokuValidator;
import com.sudoku.core.solver.*;

public class EasySudokuProviderFactory implements SudokuProviderFactory {

	public EasySudokuProviderFactory() {
	}

	@Override
	public SudokuProvider createSudokuProvider() throws InvalidSudokuException {
		SudokuGenerator sudokuGenerator = new SimpleSudokuGenerator();
		SudokuValidator sudokuValidator = new SimpleSudokuValidator();
		MaskingStrategy sudokuMaskingStrategy = new EasyMaskingStrategy();
		SudokuMasker sudokuMasker = new SimpleSudokuMasker(sudokuMaskingStrategy);
		SudokuSolver sudokuSolver = new SimpleSudokuSolver(sudokuValidator);
		Serializer sudokuSerializer = new SimpleSerializer();
		SudokuProvider sudoku = new SimpleSudokuProvider(sudokuGenerator, sudokuValidator, sudokuMasker, sudokuSolver,
				sudokuSerializer);
		return sudoku;
	}

}
