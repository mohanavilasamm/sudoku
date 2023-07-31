package com.sudoku.api.v1.sudoku;

import java.util.UUID;
import com.sudoku.api.v1.Status;

public record GenerateSudokuResponse(UUID sudokuId, int[][] sudoku, Status status) {
}
