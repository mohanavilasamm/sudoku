package com.sudoku.api.v1.sudoku;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Sudoku {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID sudokuId;
    private int[] generatedSudoku;
    private UUID createdBy; 
    private String sudokuLevel;
    private String sudokuStatus;
    private Timestamp createdAt;
	private Timestamp modifiedAt;
    private int[] maskedSudoku;
    private int[] solvedSudoku;

    protected Sudoku() {}

    public Sudoku(int[] generatedSudoku, UUID createdBy, String level, String status, int[] maskedSudoku) {
        this.generatedSudoku = generatedSudoku;
        this.createdBy = createdBy;
        this.sudokuLevel = level;
        this.sudokuStatus = status;
        this.maskedSudoku = maskedSudoku;
    }

    public UUID getSudokuId() {
        return this.sudokuId;
    }

    public int[] getGeneratedSudoku() {
        return this.generatedSudoku;
    }

    public UUID getCreatedBy() {
        return this.createdBy;
    }

    public String getSudokuLevel() {
        return this.sudokuLevel;
    }

    public String getSudokuStatus() {
        return this.sudokuStatus;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public int[] getMaskedSudoku() {
        return this.maskedSudoku;
    }

    public void setMaskedSudoku(int[] maskedSudoku) {
        this.maskedSudoku = maskedSudoku;
    }

    public int[] getSolvedSudoku() {
        return this.solvedSudoku;
    }

    public void setSolvedSudoku(int[] solvedSudoku) {
        this.solvedSudoku = solvedSudoku;
    }

    public Timestamp getModifiedAt() {
        return this.modifiedAt;
    }

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = Timestamp.from(Instant.now());
    }

    @PreUpdate
    public void setModifiedAt() {
        this.modifiedAt = Timestamp.from(Instant.now());
    }
    
}
