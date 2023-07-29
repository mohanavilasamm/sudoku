package com.sudoku.api.v1;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SudokuServiceController {

	private final SudokuService sudokuService;

	public SudokuServiceController(SudokuService sudokuService) {
		this.sudokuService = sudokuService;
	}

	public SudokuService getSudokuService() {
		return this.sudokuService;
	}

	@PostMapping("/sudoku")
	public Sudoku postSudoku() {
		return getSudokuService().generateEasySudoku();
	}

}
