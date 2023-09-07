package com.sudoku.api.v1.sudoku;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;
import com.sudoku.api.v1.Level;
import com.sudoku.api.v1.Status;
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
    private int[] serializedSudoku;
    private UUID createdBy; 
    private Level sudokuLevel;
    private Status sudokuStatus;
    private Timestamp createdAt;
	private Timestamp modifiedAt;

    protected Sudoku() {}

    public Sudoku(int[] serializedSudoku, UUID createdBy, Level level, Status status) {
        this.serializedSudoku = serializedSudoku;
        this.createdBy = createdBy;
        this.sudokuLevel = level;
        this.sudokuStatus = status;
    }

    public UUID getSudokuId() {
        return this.sudokuId;
    }

    public int[] getSerializedSudoku() {
        return this.serializedSudoku;
    }

    public UUID getCreatedBy() {
        return this.createdBy;
    }

    public Level getSudokuLevel() {
        return this.sudokuLevel;
    }

    public Status getSudokuStatus() {
        return this.sudokuStatus;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
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
