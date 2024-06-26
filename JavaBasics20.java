public class JavaBasics20 {

static final int N = 4;

static boolean isValid(int maze[][], int row, int col) {
    return (row >= 0 && row < N && col >= 0 && col < N && maze[row][col] == 1);
}

static boolean findPath(int maze[][], int row, int col, int[][] sol) {
    // Reached destination
    if (row == N - 1 && col == N - 1) {
        sol[row][col] = 1;
        return true;
    }

    // Mark current cell as visited
    sol[row][col] = 1;

    // Try all four directions (right, down, left, up)
    int[] rowDir = {0, 1, 0, -1};
    int[] colDir = {1, 0, -1, 0};
    for (int i = 0; i < 4; i++) {
        int newRow = row + rowDir[i];
        int newCol = col + colDir[i];

        if (isValid(maze, newRow, newCol)) {
            if (findPath(maze, newRow, newCol, sol)) {
                return true; // Found a path from this point
            }
        }
    }

    sol[row][col] = 0;
    return false;
}
static void printSolution(int sol[][]) {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (sol[i][j] == 1) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
        System.out.println();
    }
}
public static void main(String[] args) {
    int maze[][] = {{1, 0, 0, 0},
                    {1, 1, 0, 1},
                    {0, 1, 0, 0},
                    {1, 1, 1, 1}};

    int[][] sol = new int[N][N];

    if (findPath(maze, 0, 0, sol)) {
        System.out.println("Solution found!");
        // Print the solution matrix (optional)
        printSolution(sol);
    } else {
        System.out.println("No path found");
    }
}
}
