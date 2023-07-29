package com.sudoku.core.masker;

import com.sudoku.core.common.InvalidSudokuException;

public class SimpleSudokuMasker implements SudokuMasker {
	
	private MaskingStrategy maskingStrategy;
	
	public MaskingStrategy getMaskingStrategy( ) {
		return this.maskingStrategy;
	}
	
	public SimpleSudokuMasker(MaskingStrategy maskingStrategy) {
		this.maskingStrategy = maskingStrategy;
	}

	@Override
	public int[][] mask(int[][] sudoku) throws InvalidSudokuException {
		if (sudoku == null || sudoku.length != 9 || sudoku[0].length != 9)
			throw new InvalidSudokuException();
		return getMaskingStrategy().maskWithStrategy(sudoku);
	}
}

