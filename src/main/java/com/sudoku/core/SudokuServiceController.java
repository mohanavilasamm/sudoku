package com.sudoku.core;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/sudoku")
	public Sudoku getSudoku() {
		return getSudokuService().generateSudoku();
	}

	@PostMapping("/sudoku")
	public Sudoku postSudoku(@RequestBody Sudoku sudoku) {
		return getSudokuService().isValid(sudoku);
	}

}
