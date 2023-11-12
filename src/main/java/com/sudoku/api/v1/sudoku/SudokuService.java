package com.sudoku.api.v1.sudoku;

import org.springframework.stereotype.Service;
import com.sudoku.core.serialization.Serializer;
import com.sudoku.core.serialization.SimpleSerializer;
import com.sudoku.api.v1.Level;
import com.sudoku.api.v1.Status;
import com.sudoku.api.v1.SudokuApiException;
import com.sudoku.core.EasySudokuProviderFactory;
import com.sudoku.core.SudokuProvider;
import com.sudoku.core.SudokuProviderFactory;
import java.util.UUID;

@Service
public class SudokuService {

	private final SudokuRepository sudokuRepository;

	public SudokuService(SudokuRepository sudokuRepository) {
		this.sudokuRepository = sudokuRepository;
	}

	public SudokuRepository getSudokuRepository() {
		return this.sudokuRepository;
	}

	public GenerateSudokuResponse generateSudoku(GenerateSudokuRequest request) throws SudokuApiException {
		SudokuProviderFactory sudokuProviderFactory;
		if (Level.EASY.equals(request.level())) {
			sudokuProviderFactory = new EasySudokuProviderFactory();
		} else
			throw new SudokuApiException("Level not implemented");
		SudokuProvider sudokuProvider = sudokuProviderFactory.createSudokuProvider();
		int[][] generatedSudoku = sudokuProvider.generate();
		int[][] maskedSudoku = sudokuProvider.mask(generatedSudoku);
		Sudoku sudokuEntity = new Sudoku(sudokuProvider.serialize(generatedSudoku), request.requestedBy(),
				Level.EASY.toString(), Status.IN_PROGRESS.toString(), sudokuProvider.serialize(maskedSudoku));
		getSudokuRepository().save(sudokuEntity);
		GenerateSudokuResponse response = new GenerateSudokuResponse(sudokuEntity.getSudokuId(), maskedSudoku,
				Status.valueOf(sudokuEntity.getSudokuStatus()));
		return response;
	}

	public GenerateSudokuResponse getSudoku(UUID sudokuId) {
		Sudoku sudoku = getSudokuRepository().findById(sudokuId)
				.orElseThrow(() -> new SudokuApiException("Sudoku with ID not found"));
		Serializer serializer = new SimpleSerializer();
		GenerateSudokuResponse response = new GenerateSudokuResponse(sudoku.getSudokuId(),
				serializer.deserializeSudoku(sudoku.getMaskedSudoku()),
				Status.valueOf(sudoku.getSudokuStatus()));
		return response;
	}
}
