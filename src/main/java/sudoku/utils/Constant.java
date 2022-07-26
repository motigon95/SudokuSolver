package sudoku.utils;

public class Constant {
    public static final String MULTITHREAD_COMMAND = "-p";
    public static final String FILE_NAME_1 = "sudoku1";
    public static final String FILE_NAME_2 = "sudoku2";
    public static final String IDENTIFIER_MULTITHREAD = "0";
    public static final String IDENTIFIER_SINGLETHREAD = "1";
    public static final String SUDOKU_SOLVED = "Solved!";
    public static final String SUDOKU_UNSOLVED = "Unsolved";

    public static final String SEPARATOR = ",";
    public static final String EMPTY_CELL_SYMBOL = "x";

    public static final String COMMAND_ERROR_MESSAGE = "Error - command should be: java –jar sudoku.jar –p n " +
            "filename\\nExample: java -jar sudoku.jar -p 0 sudoku1";
}
