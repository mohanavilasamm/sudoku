package com.sudoku.core;

import com.sudoku.core.generator.SudokuGenerator;
import com.sudoku.core.masker.SudokuMasker;
import com.sudoku.core.validator.SudokuValidator;

public interface Sudoku extends SudokuGenerator, SudokuValidator, SudokuMasker {

}
