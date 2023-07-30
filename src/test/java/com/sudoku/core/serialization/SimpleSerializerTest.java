package com.sudoku.core.serialization;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.sudoku.core.common.InvalidSudokuException;

public class SimpleSerializerTest {

    @Test
    void testSerializeSudoku() {
        int[][] deserializedSudoku = {
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9}
        };
        int[] serializedSudoku = {1,2,3,4,5,6,7,8,9,
                                    1,2,3,4,5,6,7,8,9,
                                        1,2,3,4,5,6,7,8,9,
                                            1,2,3,4,5,6,7,8,9,
                                                1,2,3,4,5,6,7,8,9,
                                                    1,2,3,4,5,6,7,8,9,
                                                        1,2,3,4,5,6,7,8,9,
                                                            1,2,3,4,5,6,7,8,9,
                                                                1,2,3,4,5,6,7,8,9};
        Serializer serializer = new SimpleSerializer();
        assertArrayEquals(serializedSudoku, serializer.serializeSudoku(deserializedSudoku));
        assertThrows(InvalidSudokuException.class, () -> {serializer.serializeSudoku(new int[3][3]);});
        assertThrows(InvalidSudokuException.class, () -> {serializer.serializeSudoku(null);});
    }

    @Test
    void testDeserializeSudoku() {
        int[][] deserializedSudoku = {
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9}
        };
        int[] serializedSudoku = {1,2,3,4,5,6,7,8,9,
                                    1,2,3,4,5,6,7,8,9,
                                        1,2,3,4,5,6,7,8,9,
                                            1,2,3,4,5,6,7,8,9,
                                                1,2,3,4,5,6,7,8,9,
                                                    1,2,3,4,5,6,7,8,9,
                                                        1,2,3,4,5,6,7,8,9,
                                                            1,2,3,4,5,6,7,8,9,
                                                                1,2,3,4,5,6,7,8,9};
        Serializer serializer = new SimpleSerializer();
        assertArrayEquals(deserializedSudoku, serializer.deserializeSudoku(serializedSudoku));
        assertThrows(InvalidSudokuException.class, () -> {serializer.deserializeSudoku(new int[3]);});
        assertThrows(InvalidSudokuException.class, () -> {serializer.deserializeSudoku(null);});
    }
}
