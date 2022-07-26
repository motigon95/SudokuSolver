# SUDOKU

![logo](https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/220px-Sudoku-by-L2G-20050714.svg.png)

## Running the aplication

Run example

```
java -jar sudoku.jar -p 0 sudoku1
```

* Dinamic parameters:

    - n
    - filename

Where
- n = 0, 1
- filename = sudoku1, sudoku2

#### About the parameters
When passing 0 as n parameter the software will solve the problem on a multithreading basis.

filename is the text representation of the Sudoku. Representation for each column will be done in a coma separated format; each Sudoku line will be represented in a file line. The missing values will be represented as blank.


## About the solution

The sudoku should be solved either using multithreading or not. The implementation for the solution using multithreading
is missing.