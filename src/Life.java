/**
 * ICA 3: Game of Life
 * Due: 9/21/2022
 * Cite Sources Here
 * 1. https://www.geeksforgeeks.org/program-for-conways-game-of-life/
 * 2. https://www.youtube.com/watch?v=ncRA1OAbMmk
 *
 * I just learned ctrl + d duplicates the line you are on in intellij
 */

public class Life {
    public static void main(String[] args) {
//        System.out.println("Hello");
        // make a grid, it should have some abirtrary live cells,
        // so that the game can start
        int[][] block = {{}, {}, {}};
        grid(11, 5);
    }

    /**
     * TODO: print a grid of stars. Make the size dynamic
     * a list of lists or an array of arrays?
     *
     * take in a third param that tells whether to draw a * or an O
     * use an if stmt
     */
    public static void grid(int width, int height) {
        // make a basic print
        // make columns using a loop
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                System.out.print("*");
            }
            System.out.println();
        }

//        System.out.println("***");
//        System.out.println("***");
//        System.out.println("***");
    }
}
