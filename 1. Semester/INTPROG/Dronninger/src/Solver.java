/**
 * Solves the N-Queens problem using backtracking and prints or counts all solutions.
 *
 * <p>The board is represented by a one-dimensional array where the index is the row
 * and the value at that index is the column of the queen in that row.</p>
 *
 * @author Martin Due & Mathias Bøttger
 * @since 21/10/2025
 * @version 1.0
 */
public class Solver {
    /**
     * Number of queens to place (also the board size N).
     */
    private int noOfQueens;

    /**
     * Board state where {@code queens[row] = col} denotes a queen at (row, col).
     */
    private int[] queens;

    /**
     * Counter for the number of solutions found.
     */
    private int noOfSolutions;

    /**
     * Flag controlling whether each found solution is printed to standard output.
     * When {@code true}, {@link #printSolution()} prints coordinate strings for each queen.
     */
    private boolean showSolution;

    /**
     * Finds and prints (when enabled) all solutions for an N x N board.
     * Initializes internal state, runs the backtracking search, and reports the total count.
     *
     * @param noOfQueens the board size N and number of queens to place; must be {@code >= 1}
     */
    public void findAllSolutions(int noOfQueens){
        this.noOfQueens = noOfQueens;
        this.queens = new int[noOfQueens];
        this.noOfSolutions = 0;

        System.out.println("*************");
        positionQueens(0);
        System.out.println("Found a total of: " + noOfSolutions + " solutions");
        System.out.println("*************");
    }

    /**
     * Recursively places queens row by row using backtracking.
     *
     * @param row the current row to place a queen on; when equal to {@code noOfQueens},
     *            a complete solution has been formed
     */
    public void positionQueens(int row){
        if(row == noOfQueens){
            printSolution();
            noOfSolutions++;
            return;
        }
        for(int i = 0; i < queens.length; i++){
            if(legal(row, i)) {
                queens[row] = i;
                positionQueens(row + 1);
            }
        }
    }

    /**
     * Checks whether placing a queen at the given row and column is legal
     * with respect to queens already placed in previous rows.
     *
     * @param row the row index to check
     * @param col the column index to check
     * @return {@code true} if no conflicts occur horizontally or diagonally; {@code false} otherwise
     */
    public boolean legal(int row, int col){
        for(int i = 0; i < row; i++){
            // Check same column.
            if(queens[i] == col){
                return false;
            }
            // Check diagonals.
            if(Math.abs(queens[i] - col) == Math.abs(row - i)){
                return false;
            }
        }
        return true;
    }

    /**
     * Prints the current solution to standard output as space-separated coordinates.
     * Each coordinate uses a letter for the row starting at 'a' and a 1-based column number.
     * Example output for a solution: {@code a1 b3 c2 ...}
     *
     * <p>The method prints only when {@link #showSolution} is {@code true}.</p>
     */
    public void printSolution(){
        if(showSolution){
            for(int i = 0; i < queens.length; i++){
                System.out.printf("%s ", convert(i, queens[i]));
            }
            System.out.print("\n");
        }
    }

    /**
     * Converts a board position to a human-readable coordinate string.
     * The row is mapped to a lowercase letter starting from 'a', and the column is 1-based.
     *
     * @param row zero-based row index
     * @param col zero-based column index
     * @return the coordinate string, e.g., {@code a1}, {@code c4}
     */
    public String convert(int row, int col){
        return String.valueOf((char)('a'+ row)) + (col+1);
    }

    /**
     * Measures and prints the number of solutions for board sizes in the inclusive range
     * {@code [min, max]}. For each size the method times the search and prints a table
     * row with the board size, solution count, elapsed time in milliseconds, and solutions/ms.
     *
     * @param min the minimum board size to evaluate ({@code >= 1})
     * @param max the maximum board size to evaluate ({@code >= min})
     */
    public void findNoOfSolutions(int min, int max){
        System.out.println("***************************");
        System.out.format("%6s %12s %10s %12s %n", "Queens", "Solutions", "Times (ms)", "Solutions/ms");
        for (int i = min; i <= max; i++) {
            this.noOfQueens = i;
            this.queens = new int[noOfQueens];
            this.noOfSolutions = 0;
            long timeStart = System.currentTimeMillis();

            positionQueens(0);

            long timeEnd = System.currentTimeMillis();
            long duration = Math.max(1, timeEnd-timeStart);
            System.out.format("%6d %,12d %,10d %,12d %n", noOfQueens, noOfSolutions, duration, noOfSolutions/duration);
        }
    }

    /**
     * Quick manual test harness for the solver.
     * Toggles {@link #showSolution} and runs a few example sizes, then prints performance data.
     */
    public static void testSolver(){
        Solver solver = new Solver();

        solver.showSolution = true;
        solver.findAllSolutions(1);
        solver.findAllSolutions(2);
        solver.findAllSolutions(6);

        solver.showSolution = false;
        solver.findNoOfSolutions(1, 12);
    }
}
