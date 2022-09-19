import java.util.Random;

/**
 * ICA 3: Game of Life
 * Due: 9/21/2022
 * Cite Sources Here
 * 1. https://www.geeksforgeeks.org/program-for-conways-game-of-life/
 * 2. https://www.youtube.com/watch?v=ncRA1OAbMmk
 * 3. https://playgameoflife.com/
 * <p>
 * I just learned ctrl + d duplicates the line you are on in intellij
 */

public class Life {
    public static void main(String[] args) {
        // make a grid, it should have some abirtrary live cells,
        // so that the game can start
        int Rows = 7;
        int Cols = 7;
        int[][] block = init_Grid(Rows, Cols);
        int[][] testCase = {
                {0, 1, 0, 0, 0, 0, 1},
                {0, 1, 1, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 1},
                {0, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 1},
                {1, 0, 0, 1, 1, 0, 0},
        };

        //        init_Grid(Rows, Cols);
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Cols; j++) {
                System.out.print(testCase[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }
        for (int i = 0; i < Cols * 2; i++) {
            System.out.print("*");
        }
        System.out.println();

        // increment the grid based on the rules
        testCase = gridStep(Rows, Cols, testCase);

        // print out the next iteration of the grid
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Cols; j++) {
                System.out.print(testCase[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }
        for (int i = 0; i < Cols * 2; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    /**
     * TODO: print a grid of stars. Make the size dynamic
     * a list of lists or an array of arrays?
     * <p>
     * take in a third param that tells whether to draw a * or an O
     * use an if stmt
     */
    public static int[][] init_Grid(int row, int col) {
        Random rand = new Random(); //init the array with random bytes
        int[][] grid = new int[row][col];

        // make a basic print
        // make columns using a loop
        for (int j = 0; j < row; j++) {
            for (int i = 0; i < col; i++) {
//                System.out.print("*");
                // randomly assigns 1 or 0 to a cell
                grid[j][i] = Math.abs(rand.nextInt() % 2);

            }
        }
        // test grid here

        return grid;
    }

    public static int[][] gridStep(int row, int col, int g[][]) {
        int[][] gridCopy = new int[row][col];

        // the first two loops are what cell we investigate
        // the next two loops go through the grid to count the neighbors
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {

                // next loops
                int numF = 0;
                for (int rr = -1; rr <= 1; rr++) {
                    for (int cc = -1; cc <= 1; cc++) {
                        // if the current cell is valid, not past any edge
                        // increment the numF
                        boolean rCheck = r + rr >= 0 && r + rr < row;
                        boolean cCheck = c + cc >= 0 && c + cc < col;
                        if (rCheck && cCheck) {
                            numF += g[r + rr][c + cc];
//                            numF;
                        }
                    }
                }
                // subtract a 1 from the living cell in case it counted itself as a neighbor
                numF -= g[r][c]; //at row r and col c, if the cell is 1 then decrement

                // the rules
                //1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
                // n < 2
                //2. Any live cell with two or three live neighbours lives on to the next generation.
                // n == 2 || n == 3
                //3. Any live cell with more than three live neighbours dies, as if by overpopulation.
                // n > 3
                //4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction
                // n == 3

                System.out.println("Location: " + "(" + r + "," + c + ") " + "Friends: " + numF);

                // if cell alive and less than 2 n, dies
                if (g[r][c] == 1 && numF < 2) {
                    gridCopy[r][c] = 0;
                } else if (g[r][c] == 1 && numF < 4) {
                    // if cell alive and less than 4 n, cell lives
                    gridCopy[r][c] = 1;
                } else if (g[r][c] == 1 && numF > 3) {
                    // if cell alive and n greater than 3, cell dies
                    gridCopy[r][c] = 0;
                } else if (g[r][c] == 0 && numF == 3) {
                    // if cell dead and friends equal 3, new cell born
                    gridCopy[r][c] = 1;
                } else {
                    //grid2[row][col] = 0;
                }
            }
        }

        // update the original grid here then ret it
        for(int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                g[r][c] = gridCopy[r][c];
            }
        }
        return g;
    }
}
