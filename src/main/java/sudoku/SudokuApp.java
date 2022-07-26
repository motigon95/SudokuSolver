package sudoku;

import sudoku.exceptions.CommandNotValidException;
import sudoku.utils.Command;
import sudoku.utils.Constant;
import sudoku.utils.SudokuMapper;

public class SudokuApp {

    private static final int GRID_SIZE = 9;
    private static Command command;

    static int[][] sudoku;

    public static void main(String[] args) throws Exception {
        if(!commandIsValid(args))
            throw new CommandNotValidException(Constant.COMMAND_ERROR_MESSAGE);
        solveSudoku();
    }

    private static void solveSudoku() {
        if(command.getIsMultiThread().equals(Constant.IDENTIFIER_MULTITHREAD)) solveSudokuInOneThread();
            //TODO: else should call method to resolve sudoku using mutithreads
        else solveSudokuInOneThread();
    }

    private static void solveSudokuInOneThread() {
        sudoku = loadSudoku();
        if (solveSudoku(sudoku)) {
            printSudoku(sudoku);
            System.out.println(Constant.SUDOKU_SOLVED);
        } else {
            System.out.println(Constant.SUDOKU_UNSOLVED);
        }
    }

    private static boolean commandIsValid(String[] args) {
        command = new Command();
        return command.commandIsValid(args);
    }

    private static int[][] loadSudoku() {
        SudokuMapper sudokuMapper = new SudokuMapper();
        return sudokuMapper.mapSudoku(command.getFilename());
    }

    private static boolean isNumberValid(int[][] sudoku, int number, int row, int column) {
        return !isThisNumberInRow(sudoku, number, row) &&
                !isThisNumberInColumn(sudoku, number, column) &&
                !isThisNumberInSquare(sudoku, number, row, column);
    }

    private static boolean isThisNumberInRow(int[][] sudoku, int number, int row) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (sudoku[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isThisNumberInColumn(int[][] sudoku, int number, int column) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (sudoku[i][column] == number) {
                return true;
            }
        }
        return false;
    }


    private static boolean isThisNumberInSquare(int[][] sudoku, int number, int row, int column) {
        int localSquareRow = row - row % 3;
        int localSquareColumn = column - column % 3;

        for (int i = localSquareRow; i < localSquareRow + 3; i++) {
            for (int j = localSquareColumn; j < localSquareColumn + 3; j++) {
                if (sudoku[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean solveSudoku(int[][] sudoku) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                if (sudoku[row][column] == 0) {
                    for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if (isNumberValid(sudoku, numberToTry, row, column)) {
                            sudoku[row][column] = numberToTry;

                            if (solveSudoku(sudoku)) {
                                return true;
                            } else {
                                sudoku[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static void printSudoku(int[][] sudoku) {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("---------------------");
            }
            for (int column = 0; column < GRID_SIZE; column++) {
                if (column % 3 == 0 && column != 0) {
                    System.out.print("| ");
                }
                System.out.print(sudoku[row][column] + " ");
            }
            System.out.println();
        }
    }
}
