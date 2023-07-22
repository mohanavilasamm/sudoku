package com.sudoku.core.masker;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.sudoku.core.generator.SimpleSudokuGenerator;
import com.sudoku.core.generator.SudokuGenerator;

class EasySudokuMaskerTest {

	@Test
	void testMask() {
		SudokuGenerator sudokuGenerator = new SimpleSudokuGenerator();
		int[][] sudoku = sudokuGenerator.generateSudoku();
		SudokuMasker sudokuMasker = new EasySudokuMasker();
		int[][] maskedSudoku = sudokuMasker.mask(sudoku);
		for(int i=0; i<maskedSudoku.length; i++) {
			for(int j=0; j<maskedSudoku[i].length; j++)
				System.out.print(maskedSudoku[i][j]);
			System.out.println();
		}
			
	}

}
