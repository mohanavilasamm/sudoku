package com.sudoku.api.v1;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.sudoku.core.EasySudokuFactory;
import com.sudoku.core.SudokuFactory;

@Service
public class SudokuService {
	
	public Sudoku generateEasySudoku() {
		SudokuFactory sudokuFactory = new EasySudokuFactory();
		Instant instant = Instant.now();
		return new Sudoku(UUID.randomUUID(), sudokuFactory.createSudoku().generate(), null, Level.EASY, Status.IN_PROGRESS, Timestamp.from(instant), null);
	}
}
