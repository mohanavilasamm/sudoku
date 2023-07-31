package com.sudoku.api.v1.sudoku;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface SudokuRepository extends CrudRepository<Sudoku, UUID> {

    List<Sudoku> findBySudokuId(UUID sudokuId);;
    
}
