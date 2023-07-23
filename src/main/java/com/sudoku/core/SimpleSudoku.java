package com.sudoku.core;

import com.sudoku.core.generator.SudokuGenerator;
import com.sudoku.core.masker.SudokuMasker;
import com.sudoku.core.solver.SudokuSolver;
import com.sudoku.core.common.InvalidSudokuException;
import com.sudoku.core.validator.SudokuValidator;

public class SimpleSudoku implements Sudoku{
	
	private SudokuGenerator sudokuGenerator;
	
	private SudokuValidator sudokuValidator;
	
	private SudokuMasker sudokuMasker;
	
	private SudokuSolver sudokuSolver;
	
	public SudokuGenerator getSudokuGenerator() {
		return this.sudokuGenerator;
	}
	
	public SudokuValidator getSudokuValidator() {
		return this.sudokuValidator;
	}
	
	public SudokuMasker getSudokuMasker() {
		return this.sudokuMasker;
	}
	
	public SudokuSolver getSudokuSolver() {
		return this.sudokuSolver;
	}
	
	
	public SimpleSudoku(SudokuGenerator sudokuGenerator, SudokuValidator sudokuValidator, SudokuMasker sudokuMasker, SudokuSolver sudokuSolver) {
		this.sudokuGenerator = sudokuGenerator;
		this.sudokuValidator = sudokuValidator;
		this.sudokuMasker = sudokuMasker;
		this.sudokuSolver = sudokuSolver;
	}

	@Override
	public int[][] generate() {
		return getSudokuGenerator().generate();
	}

	@Override
	public boolean validate(int[][] sudoku) throws InvalidSudokuException {
		return getSudokuValidator().isValid(sudoku);
	}

	@Override
	public int[][] mask(int[][] sudoku) throws InvalidSudokuException {
		return getSudokuMasker().mask(sudoku);
	}

	@Override
	public int[][] solve(int[][] sudoku) throws InvalidSudokuException {
		return getSudokuSolver().solve(sudoku);
	}
}
