alter table SUDOKU rename column SERIALIZED_SUDOKU to GENERATED_SUDOKU;
alter table SUDOKU add column MASKED_SUDOKU integer[];
alter table SUDOKU add column SOLVED_SUDOKU integer[];