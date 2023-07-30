package com.sudoku.core.serialization;

import com.sudoku.core.common.InvalidSudokuException;

public class SimpleSerializer implements Serializer{

    @Override
    public int[] serializeSudoku(int[][] sudokuMatrix) throws InvalidSudokuException {
        if (sudokuMatrix == null || sudokuMatrix.length != 9 || sudokuMatrix[0].length != 9)
			throw new InvalidSudokuException();
        int index = 0;
        int[] sudokuArray = new int[81];
        for(int i=0; i<9; i++)
            for(int j=0; j<9; j++) {
                sudokuArray[index] = sudokuMatrix[i][j];
                index++;
            }
        return sudokuArray;
    }

    @Override
    public int[][] deserializeSudoku(int[] sudokuArray) throws InvalidSudokuException {
        if (sudokuArray == null || sudokuArray.length != 81)
			throw new InvalidSudokuException();
            int[][] sudokuMatrix = new int[9][9];
        int index = 0;
        for(int i=0; i<9; i++)
            for(int j=0; j<9; j++) {
                sudokuMatrix[i][j] = sudokuArray[index];
                index++;
            }
        return sudokuMatrix;
    }
    
}
