package com.sudoku.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.sudoku.core.common.InvalidSudokuException;
import com.sudoku.core.masker.EasyMaskingStrategy;
import com.sudoku.core.masker.SimpleSudokuMasker;

class SimpleSudokuFactoryTest {

	@Test
	void testCreateSudoku() {
		SudokuFactory sudokuFactory = new SimpleSudokuFactory();
		assertThrows(InvalidSudokuException.class, ()-> sudokuFactory.createSudoku(null));
		assertThrows(InvalidSudokuException.class, ()-> sudokuFactory.createSudoku(Level.INTERMEDIATE));
		assertThrows(InvalidSudokuException.class, ()-> sudokuFactory.createSudoku(Level.HARD));
		Sudoku sudoku = sudokuFactory.createSudoku(Level.EASY);
		assertInstanceOf(EasyMaskingStrategy.class, ((SimpleSudokuMasker)((SimpleSudoku)sudoku).getSudokuMasker()).getMaskingStrategy());
	}

}
