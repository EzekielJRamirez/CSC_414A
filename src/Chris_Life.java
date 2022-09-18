import java.util.Random;

//public class Chris_Life {
//}

//import java.awt.*;
//        import java.awt.geom.Point2D;
//        import java.lang.reflect.Array;
//        import java.util.HashSet;
//        import java.util.Random;
//        import java.util.Set;
//        import java.util.Vector;

public class Chris_Life {
    final static int Tot_Rows = 5;
    final static int Tot_Cols = 5;
    static int[][] grid1 = new int[Tot_Rows][Tot_Cols]; // the init grid
    static int[][] grid2 = new int[Tot_Rows][Tot_Cols]; // the holder grid
    static int numSteps = 2;

    public static void main(String[] args) {
        Random rand = new Random(); //init the array with random bytes
        // grid[row][col]
        for (int i = 0; i < Tot_Rows; i++) {
            for (int j = 0; j < Tot_Cols; j++) {
                grid1[i][j] = Math.abs(rand.nextInt() % 2);
                // grid[r][c]
                /*grid1[i][j] = 0;*/
            }
        }
        printGrid(grid1);
        System.out.println("********************");
        /*grid1[2][1] = 1;
        grid1[2][2] = 1;
        grid1[2][3] = 1;*/

        // why is this col then row, I will try row then col
//        for (int w = 0; w < numSteps; w++) { // do this life simulation for 10 steps
//            for (int col = 0; col < maxGridLength; col++) {
//                for (int row = 0; row < maxGridHeight; row++) {
//                    int numFriends = getNumFriends(col, row, grid1);
//                    System.out.println("Location: " + "(" + row + "," + col + ") " + "Friends: " + numFriends);
//                    if (grid1[row][col] == 1 && numFriends < 2) {
//                        grid2[row][col] = 0;
//                    } else if (grid1[row][col] == 1 && numFriends < 4) {
//                        grid2[row][col] = 1;
//                    } else if (grid1[row][col] == 1 && numFriends > 3) {
//                        grid2[row][col] = 0;
//                    } else if (grid1[row][col] == 0 && numFriends == 3) {
//                        grid2[row][col] = 1;
//                    } else {
//                        //grid2[row][col] = 0;
//                    }
//
//                }
//            }
//            grid1 = grid2;
//            printGrid(grid2);
//            System.out.println();
//        }

        // Here is my solution
        for (int row = 0; row < Tot_Rows; row++) {
            for (int col = 0; col < Tot_Cols; col++) {
                // the rules
                //1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
                // n < 2
                //2. Any live cell with two or three live neighbours lives on to the next generation.
                // n == 2 || n == 3
                //3. Any live cell with more than three live neighbours dies, as if by overpopulation.
                // n > 3
                //4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction
                // n == 3

                // 1 = live cell
                // 0 = unpopulated cell
                int numFriends = getNumFriends(col, row, grid1);
                System.out.println("Location: " + "(" + row + "," + col + ") " + "Friends: " + numFriends);
                // if cell alive and less than 2 n, dies
                if (grid1[row][col] == 1 && numFriends < 2) {
                    grid2[row][col] = 0;
                } else if (grid1[row][col] == 1 && numFriends < 4) {
                    // if cell alive and less than 4 n, cell lives
                    grid2[row][col] = 1;
                } else if (grid1[row][col] == 1 && numFriends > 3) {
                    // if cell alive and n greater than 3, cell dies
                    grid2[row][col] = 0;
                } else if (grid1[row][col] == 0 && numFriends == 3) {
                    // if cell dead and friends equal 3, new cell born
                    grid2[row][col] = 1;
                } else {
                    //grid2[row][col] = 0;
                }
            }
            // make the original the same as the updated grid
            grid1 = grid2;
            // we could probably print the updated grid1
            printGrid(grid2);
            System.out.println();
        }
    }

    public static void printGrid(int[][] b) {
        for (int i = 0; i < Tot_Cols; i++) {
            printTop();
            for (int j = 0; j < Tot_Rows; j++) {
                System.out.print(grid1[i][j] + "|");

            }
            System.out.println();
        }
    }

    public static void printTop() {
        for (int i = 0; i < (Tot_Cols * 2) + 1; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.print("|");
    }

    // TODO do checks on values away from edges, then use if stmts to make edge cases
    // we are working with arrays, refer to that syntax
    // int[row][col]
    public static int getNumFriends(int col, int row, int[][] a) { // trying to implement wrap around
        int numF = 0; // glitched somewhere so that phantom friends are around
//        System.out.println("Central Coord: row-" + row + ", col-" + col + "\nValue: " + a[row][col]);
        // check values by row
        // -1 will check left side, 1 is the right side
        for (int i = -1; i < 1; i++) {
            // then check each col in a row
            for (int j = -1; j < 1; j++){
                // -1 is the upper side, 1 is the lower side
                // increment numF if friend is in the spot
                // this if stmt is checking that we are only updating values inside the boundaries
                if ((i + row >= 0 && i + row < row) && (col + j >= 0 && col + j < col)) {
                    numF += a[i + row][col + j];
                }
            }
        }

        return numF + 0;
    }


//    public static int getNumFriends(int col, int row, int[][] a) { // trying to implement wrap around
//        int numF = 0; // glitched somewhere so that phantom friends are around
//        System.out.println("Central Coord: row-" + row + ", col-" + col + "\nValue: " + a[row][col]);
//        // check values by row
//        for (int i = 0; i < 3; i++) {
//            int fx = col - (1 - i);
//
//            // check by column per one row
//            for (int j = 0; j < 3; j++) {
//                int fy = row - (1 - j);
//                //TODO make special cases for values at edge, use if statements. Then use loops to condense code
//                if (i == 1 && j == 1) { // must be a way better solution to this
//                    continue;
//                }
//                if (fy >= maxGridHeight) { // adjustments of the coordinates to simulate wrapping
//                    fy = 0;
//                } else if (fy < 0) {
//                    fy = maxGridHeight - 1;
//                }
//                if (fx >= maxGridLength) {
//                    fx = 0;
//                } else if (fx < 0) {
//                    fx = maxGridLength - 1;
//                }
//                if (a[fx][fy] == 1) {
//                    numF++;
//                }
//                System.out.println("\t checking coords: row-" + fx + ", col-" + fy + " Friend: " + a[fx][fy]);
//            }
//
//        }
//        return numF;
//    }
}

