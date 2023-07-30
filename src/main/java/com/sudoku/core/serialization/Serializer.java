package com.sudoku.core.serialization;

import com.sudoku.core.common.InvalidSudokuException;

public interface Serializer {
    
    public int[] serializeSudoku(int[][] sudokuMatrix) throws InvalidSudokuException;

    public int[][] deserializeSudoku(int[] sudokuArray) throws InvalidSudokuException;
}
