package com.sudoku.api.v1.sudoku;

import java.util.UUID;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
public class SudokuController {

	private SudokuService sudokuService;

	public SudokuController(SudokuService sudokuService) {
		this.sudokuService = sudokuService;
	}

	public SudokuService getSudokuService() {
		return this.sudokuService;
	}

	@PostMapping("/sudoku")
	public GenerateSudokuResponse generateSudoku(@RequestBody @Valid GenerateSudokuRequest genereateRequest) {
		return getSudokuService().generateSudoku(genereateRequest);
	}

	@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "Requestor-Type", exposedHeaders = "X-Get-Header")
	@GetMapping("/sudoku/{sudokuId}")
	public GenerateSudokuResponse getSudoku(@PathVariable UUID sudokuId) {
		return getSudokuService().getSudoku(sudokuId);
	}

}
