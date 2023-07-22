package com.sudoku.core.generator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.sudoku.core.InvalidSudokuException;

class SudokuSlicerTest {

	@Test
	void testGetCurrentColumn() {
		int[][] sudoku = new int[][] { new int[] { 6, 3, 9, 5, 7, 4, 1, 8, 2 }, new int[] { 5, 4, 1, 8, 2, 9, 3, 7, 6 },
				new int[] { 7, 8, 2, 6, 1, 3, 9, 5, 4 }, new int[] { 1, 9, 8, 4, 6, 7, 5, 2, 3 },
				new int[] { 3, 6, 5, 9, 8, 2, 4, 1, 7 }, new int[] { 4, 2, 7, 1, 3, 5, 8, 6, 9 },
				new int[] { 9, 5, 6, 7, 4, 8, 2, 3, 1 }, new int[] { 8, 1, 3, 2, 9, 6, 7, 4, 5 },
				new int[] { 2, 7, 4, 3, 5, 1, 6, 9, 8 } };
		assertArrayEquals(new int[] { 6, 5, 7, 1, 3, 4, 9, 8, 2 }, SudokuSlicer.getCurrentColumn(sudoku, 0));
		assertArrayEquals(new int[] { 9, 1, 2, 8, 5, 7, 6, 3, 4 }, SudokuSlicer.getCurrentColumn(sudoku, 2));
		assertThrows(InvalidSudokuException.class, () -> {
			SudokuSlicer.getCurrentColumn(null, 0);
		});
		int[][] invalidSudoku = new int[][] { new int[] { 6, 3, 9, 5, 7, 4, 1, 8, 2 },
				new int[] { 5, 4, 1, 8, 2, 9, 3, 7, 6 }, new int[] { 2, 7, 4, 3, 5, 1, 6, 9, 8 } };
		assertThrows(InvalidSudokuException.class, () -> {
			SudokuSlicer.getCurrentColumn(invalidSudoku, 0);
		});
	}

	@Test
	void testGetCurrentSubSection() {
		int[][] sudoku = new int[][] { new int[] { 6, 3, 9, 5, 7, 4, 1, 8, 2 }, new int[] { 5, 4, 1, 8, 2, 9, 3, 7, 6 },
				new int[] { 7, 8, 2, 6, 1, 3, 9, 5, 4 }, new int[] { 1, 9, 8, 4, 6, 7, 5, 2, 3 },
				new int[] { 3, 6, 5, 9, 8, 2, 4, 1, 7 }, new int[] { 4, 2, 7, 1, 3, 5, 8, 6, 9 },
				new int[] { 9, 5, 6, 7, 4, 8, 2, 3, 1 }, new int[] { 8, 1, 3, 2, 9, 6, 7, 4, 5 },
				new int[] { 2, 7, 4, 3, 5, 1, 6, 9, 8 } };
		assertArrayEquals(new int[][] { new int[] { 6, 3, 9 }, new int[] { 5, 4, 1 }, new int[] { 7, 8, 2 } },
				SudokuSlicer.getCurrentSubSection(sudoku, 0, 0));
		assertArrayEquals(new int[][] { new int[] { 5, 7, 4 }, new int[] { 8, 2, 9 }, new int[] { 6, 1, 3 } },
				SudokuSlicer.getCurrentSubSection(sudoku, 0, 3));
		assertArrayEquals(new int[][] { new int[] { 1, 8, 2 }, new int[] { 3, 7, 6 }, new int[] { 9, 5, 4 } },
				SudokuSlicer.getCurrentSubSection(sudoku, 0, 7));
		assertArrayEquals(new int[][] { new int[] { 1, 9, 8 }, new int[] { 3, 6, 5 }, new int[] { 4, 2, 7 } },
				SudokuSlicer.getCurrentSubSection(sudoku, 5, 1));
		assertArrayEquals(new int[][] { new int[] { 4, 6, 7 }, new int[] { 9, 8, 2 }, new int[] { 1, 3, 5 } },
				SudokuSlicer.getCurrentSubSection(sudoku, 4, 4));
		assertArrayEquals(new int[][] { new int[] { 5, 2, 3 }, new int[] { 4, 1, 7 }, new int[] { 8, 6, 9 } },
				SudokuSlicer.getCurrentSubSection(sudoku, 4, 6));
		assertArrayEquals(new int[][] { new int[] { 9, 5, 6 }, new int[] { 8, 1, 3 }, new int[] { 2, 7, 4 } },
				SudokuSlicer.getCurrentSubSection(sudoku, 6, 0));
		assertArrayEquals(new int[][] { new int[] { 7, 4, 8 }, new int[] { 2, 9, 6 }, new int[] { 3, 5, 1 } },
				SudokuSlicer.getCurrentSubSection(sudoku, 7, 4));
		assertArrayEquals(new int[][] { new int[] { 2, 3, 1 }, new int[] { 7, 4, 5 }, new int[] { 6, 9, 8 } },
				SudokuSlicer.getCurrentSubSection(sudoku, 8, 8));
	}
}
