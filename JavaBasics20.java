public class JavaBasics20 {
   private static final int N = 4;

   // Original maze
   private static int maze[][] = {
      {1, 0, 0, 0},
      {1, 1, 0, 1},
      {0, 1, 0, 0},
      {1, 1, 1, 1}
   };

   // To store the final solution of the maze path
   private static int[][] sol = new int[N][N];

   // to display path
   private static void showPath() {
      System.out.println("The solution maze:");
      for(int i = 0; i < N; i++) {
         for(int j = 0; j < N; j++) {
            if(sol[i][j] == 1) {
               System.out.print("1 ");
            }else {
               System.out.print("0 ");
            }
         }
         System.out.println();
      }
   }

   // Function to check if a place is inside the maze and has value 1
   private static boolean isValidPlace(int x, int y) {
      return x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1;
   }
   
   private static boolean solveRatMaze(int x, int y) {
      // When (x,y) is the bottom right room
      if (x == N - 1 && y == N - 1) {
         sol[x][y] = 1;
         return true;
      }
      // Check whether (x,y) is valid or not
      if (isValidPlace(x, y)) {
         // Set 1 when it is a valid place
         sol[x][y] = 1;
         // Find path by moving in the right direction
         if (solveRatMaze(x + 1, y)) {
            return true;
         }
         // When the x direction is blocked, go for the bottom direction
         if (solveRatMaze(x, y + 1)) {
            return true;
         }
         // If both directions are closed, there is no path
         sol[x][y] = 0;
         return false;
      }
      return false;
   }

   public static void main(String[] args) {
      if (solveRatMaze(0, 0)) {
         showPath();
      } else {
         System.out.println("There is no path");
      }
   }
}