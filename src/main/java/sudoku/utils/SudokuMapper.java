package sudoku.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class SudokuMapper {
    int [][] sudoku = new int[9][9];
    ArrayList<String> sudokuRow = new ArrayList<>();
    public int [][] mapSudoku(String filename) {


        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        assert inputStream != null;

        try {
            String fileLine;
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream) );

            while( (fileLine = bufferedReader.readLine()) != null )
                sudokuRow.add(fileLine);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(int i = 0; i < sudokuRow.size()  ; i++){
            String column = sudokuRow.get(i);
            int maxColumns = 0;
            for(int j = 0; j < column.length() ; j++){
                String c = String.valueOf(column.charAt(j));
                if(!c.equals(Constant.SEPARATOR)){
                    if(c.equals(Constant.EMPTY_CELL_SYMBOL))
                        sudoku[i][maxColumns] = 0;
                    else sudoku[i][maxColumns] = Integer.parseInt(c);
                    maxColumns++;
                }
            }
        }
        return sudoku;
    }
}
