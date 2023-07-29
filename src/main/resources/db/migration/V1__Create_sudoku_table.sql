create table SUDOKU (
    SUDOKU_ID uuid primary key,
    SUDOKU integer[][] not null,
    CREATED_BY uuid,
    SUDOKU_LEVEL varchar(16) not null,
    SUDOKU_STATUS varchar(16) not null,
    CREATED_AT timestamp not null,
    MODIFIED_AT timestamp
);
