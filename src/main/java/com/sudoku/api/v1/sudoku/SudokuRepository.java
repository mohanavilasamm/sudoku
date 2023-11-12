package com.sudoku.api.v1.sudoku;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface SudokuRepository extends CrudRepository<Sudoku, UUID> {
}
