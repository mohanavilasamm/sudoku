package com.sudoku.api.v1;

import java.sql.Timestamp;
import java.util.UUID;

public record Sudoku(UUID sudoku_id, int[][] sudoku, UUID created_by, Level level, Status status, Timestamp created_at,
		Timestamp modified_at) {
}
