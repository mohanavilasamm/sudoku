package com.sudoku.core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.sudoku.core.masker.EasyMaskingStrategy;
import com.sudoku.core.masker.SimpleSudokuMasker;

class EasySudokuFactoryTest {

	@Test
	void testCreateSudoku() {
		SudokuFactory sudokuFactory = new EasySudokuFactory();
		Sudoku sudoku = sudokuFactory.createSudoku();
		assertInstanceOf(EasyMaskingStrategy.class, ((SimpleSudokuMasker)((SimpleSudoku)sudoku).getSudokuMasker()).getMaskingStrategy());
	}

}
