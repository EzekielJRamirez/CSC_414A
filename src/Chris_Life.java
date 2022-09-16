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
    final static int maxGridHeight = 3;
    final static int maxGridLength = 3;
    static int[][] grid1 = new int[maxGridLength][maxGridHeight]; // the init grid
    static int[][] grid2 = new int[maxGridLength][maxGridHeight]; // the holder grid
    static int numSteps = 2;

    public static void main(String[] args) {
        Random rand = new Random(); //init the array with random bytes
        // grid[row][col]
        for (int i = 0; i < maxGridLength; i++) {
            for (int j = 0; j < maxGridHeight; j++) {
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

        for (int w = 0; w < numSteps; w++) { // do this life simulation for 10 steps
            for (int col = 0; col < maxGridLength; col++) {
                for (int row = 0; row < maxGridHeight; row++) {
                    int numFriends = getNumFriends(col, row, grid1);
                    System.out.println("Location: " + "(" + row + "," + col + ") " + "Friends: " + numFriends);
                    if (grid1[row][col] == 1 && numFriends < 2) {
                        grid2[row][col] = 0;
                    } else if (grid1[row][col] == 1 && numFriends < 4) {
                        grid2[row][col] = 1;
                    } else if (grid1[row][col] == 1 && numFriends > 3) {
                        grid2[row][col] = 0;
                    } else if (grid1[row][col] == 0 && numFriends == 3) {
                        grid2[row][col] = 1;
                    } else {
                        //grid2[row][col] = 0;
                    }

                }
            }
            grid1 = grid2;
            printGrid(grid2);
            System.out.println();
        }
    }

    public static void printGrid(int[][] b) {
        for (int i = 0; i < maxGridLength; i++) {
            printTop();
            for (int j = 0; j < maxGridHeight; j++) {
                System.out.print(grid1[i][j] + "|");

            }
            System.out.println();
        }
    }

    public static void printTop() {
        for (int i = 0; i < (maxGridLength * 2) + 1; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.print("|");
    }

    // TODO do checks on values away from edges, then use if stmts to make edge cases
    // we are working with arrays, refer to that syntax
    // int[row][col]
    public static int getNumFriends(int col, int row, int[][] a) {
        return 0;
    }

//    public static int getNumFriends(int col, int row, int[][] a) { // trying to implement wrap around
//        int numF = 0; // glitched somewhere so that phantom friends are around
//        System.out.println("Central Coord: " + col + "," + row + "\nValue: " + a[col][row]);
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
//                System.out.println("\t checking coords: " + fx + "," + fy + " Friend: " + a[fx][fy]);
//            }
//
//        }
//        return numF;
//    }
}

