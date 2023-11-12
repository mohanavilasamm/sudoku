package com.sudoku.api.v1.sudoku;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.sudoku.api.v1.Level;
import com.sudoku.api.v1.Status;

@WebMvcTest(SudokuController.class)
public class SudokuControllerTest {

    @Autowired
	private MockMvc mockMvc;

	@MockBean
	private SudokuService service;
    
    @Test
    void testGenerateSudoku() {
        assertNotNull(mockMvc);
        UUID userId = UUID.randomUUID();
        GenerateSudokuRequest request = new GenerateSudokuRequest(userId, Level.EASY);
        UUID sudokuId = UUID.randomUUID();
        GenerateSudokuResponse response = new GenerateSudokuResponse(sudokuId, null, Status.IN_PROGRESS);
        when(service.generateSudoku(request)).thenReturn(null);
    }
    
}
