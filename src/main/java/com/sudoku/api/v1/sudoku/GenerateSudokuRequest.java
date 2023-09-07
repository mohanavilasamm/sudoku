package com.sudoku.api.v1.sudoku;

import java.util.UUID;
import com.sudoku.api.v1.Level;
import jakarta.validation.constraints.NotNull;

public record GenerateSudokuRequest(@NotNull UUID requestedBy, @NotNull Level level) {
}
