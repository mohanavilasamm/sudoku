package com.sudoku.core.validator;

import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

public class SudokuValidatorImpl {

	private static Set<Integer> PURE_SET = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

	public boolean validate(int[][] sudoku) {
		if (sudoku == null || sudoku.length != 9 || sudoku[0].length != 9)
			return false;
		for (int i = 0; i < sudoku.length; i++)
			if (!isValidArray(sudoku[i]))
				return false;
		for (int i = 0; i < sudoku.length; i++) {
			int[] array = new int[] { sudoku[0][i], sudoku[1][i], sudoku[2][i], sudoku[3][i], sudoku[4][i],
					sudoku[5][i], sudoku[6][i], sudoku[7][i], sudoku[8][i] };
			if (!isValidArray(array))
				return false;
		}
		return isValidSubSection(new int[][] { new int[] { sudoku[0][0], sudoku[0][1], sudoku[0][2] },
				new int[] { sudoku[1][0], sudoku[1][1], sudoku[1][2] },
				new int[] { sudoku[2][0], sudoku[2][1], sudoku[2][2] } })
				&& isValidSubSection(new int[][] { new int[] { sudoku[0][3], sudoku[0][4], sudoku[0][5] },
						new int[] { sudoku[1][3], sudoku[1][4], sudoku[1][5] },
						new int[] { sudoku[2][3], sudoku[2][4], sudoku[2][5] } })
				&& isValidSubSection(new int[][] { new int[] { sudoku[0][6], sudoku[0][7], sudoku[0][8] },
						new int[] { sudoku[1][6], sudoku[1][7], sudoku[1][8] },
						new int[] { sudoku[2][6], sudoku[2][7], sudoku[2][8] } })
				&& isValidSubSection(new int[][] { new int[] { sudoku[3][0], sudoku[3][1], sudoku[3][2] },
						new int[] { sudoku[4][0], sudoku[4][1], sudoku[4][2] },
						new int[] { sudoku[5][0], sudoku[5][1], sudoku[5][2] } })
				&& isValidSubSection(new int[][] { new int[] { sudoku[3][3], sudoku[3][4], sudoku[3][5] },
						new int[] { sudoku[4][3], sudoku[4][4], sudoku[4][5] },
						new int[] { sudoku[5][3], sudoku[5][4], sudoku[5][5] } })
				&& isValidSubSection(new int[][] { new int[] { sudoku[3][6], sudoku[3][7], sudoku[3][8] },
						new int[] { sudoku[4][6], sudoku[4][7], sudoku[4][8] },
						new int[] { sudoku[5][6], sudoku[5][7], sudoku[5][8] } })
				&& isValidSubSection(new int[][] { new int[] { sudoku[6][0], sudoku[6][1], sudoku[6][2] },
						new int[] { sudoku[7][0], sudoku[7][1], sudoku[7][2] },
						new int[] { sudoku[8][0], sudoku[8][1], sudoku[8][2] } })
				&& isValidSubSection(new int[][] { new int[] { sudoku[6][3], sudoku[6][4], sudoku[6][5] },
						new int[] { sudoku[7][3], sudoku[7][4], sudoku[7][5] },
						new int[] { sudoku[8][3], sudoku[8][4], sudoku[8][5] } })
				&& isValidSubSection(new int[][] { new int[] { sudoku[6][6], sudoku[6][7], sudoku[6][8] },
						new int[] { sudoku[7][6], sudoku[7][7], sudoku[7][8] },
						new int[] { sudoku[8][6], sudoku[8][7], sudoku[8][8] } });
	}

	public boolean isValidArray(int[] array) {
		if (array == null || array.length != 9)
			return false;
		Set<Integer> uniqueSet = new HashSet<>();
		for (int i = 0; i < array.length; i++) {
			if (!PURE_SET.contains(array[i]) || !uniqueSet.add(array[i]))
				return false;
		}
		return true;
	}

	public boolean isValidSubSection(int[][] subSection) {
		if (subSection == null || subSection.length != 3 || subSection[0].length != 3)
			return false;
		int[] array = new int[9];
		int i = 0;
		for (int j = 0; j < subSection.length; j++)
			for (int k = 0; k < subSection[0].length; k++) {
				array[i] = subSection[j][k];
				i++;
			}
		return isValidArray(array);
	}
}
