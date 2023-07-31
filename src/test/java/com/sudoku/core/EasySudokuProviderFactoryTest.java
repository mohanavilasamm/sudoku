package com.sudoku.core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.sudoku.core.masker.EasyMaskingStrategy;
import com.sudoku.core.masker.SimpleSudokuMasker;

class EasySudokuProviderFactoryTest {

	@Test
	void testCreateSudoku() {
		SudokuProviderFactory sudokuFactory = new EasySudokuProviderFactory();
		SudokuProvider sudoku = sudokuFactory.createSudokuProvider();
		assertInstanceOf(EasyMaskingStrategy.class, ((SimpleSudokuMasker)((SimpleSudokuProvider)sudoku).getSudokuMasker()).getMaskingStrategy());
	}

}
