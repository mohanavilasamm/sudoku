package com.sudoku.api.v1.sudoku;

import org.springframework.stereotype.Service;
import com.sudoku.api.v1.Level;
import com.sudoku.api.v1.Status;
import com.sudoku.api.v1.SudokuApiException;
import com.sudoku.core.EasySudokuProviderFactory;
import com.sudoku.core.SudokuProvider;
import com.sudoku.core.SudokuProviderFactory;

@Service
public class SudokuService {

	private final SudokuRepository sudokuRepository;

	public SudokuService(SudokuRepository sudokuRepository) {
		this.sudokuRepository = sudokuRepository;
	}

	public SudokuRepository getSudokuRepository() {
		return this.sudokuRepository;
	}
	
	public GenerateSudokuResponse generateSudoku(GenerateSudokuRequest request) throws SudokuApiException{
		SudokuProviderFactory sudokuProviderFactory;
		if(Level.EASY.equals(request.level())) {
			sudokuProviderFactory = new EasySudokuProviderFactory();
		} else 
			throw new SudokuApiException("Level not implemented");
		SudokuProvider sudokuProvider = sudokuProviderFactory.createSudokuProvider();
		int[][] sudoku = sudokuProvider.generate();
		Sudoku sudokuEntity = new Sudoku(sudokuProvider.serialize(sudoku), request.requestedBy(), Level.EASY, Status.IN_PROGRESS);
		getSudokuRepository().save(sudokuEntity);
		GenerateSudokuResponse response = new GenerateSudokuResponse(sudokuEntity.getSudokuId(), sudoku, sudokuEntity.getSudokuStatus());
		return response;
	}
}
