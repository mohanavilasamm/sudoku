package com.sudoku.api.v1.sudoku;

import java.util.UUID;
import com.sudoku.api.v1.Level;

public record GenerateSudokuRequest(UUID requestedBy, Level level) {
}
