package com.sudoku.api.v1.sudoku;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
public class SudokuServiceController {

	private SudokuService sudokuService;

	public SudokuServiceController(SudokuService sudokuService) {
		this.sudokuService = sudokuService;
	}

	public SudokuService getSudokuService() {
		return this.sudokuService;
	}

	@PostMapping("/sudoku")
	public GenerateSudokuResponse generateSudoku(@RequestBody @Valid GenerateSudokuRequest genereateRequest) {
		return getSudokuService().generateSudoku(genereateRequest);
	}
}
