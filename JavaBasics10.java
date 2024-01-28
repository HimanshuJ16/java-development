import java.util.*;

public class JavaBasics10 {
  public static boolean search(int matrix[][], int key) {
    for(int i=0; i<matrix.length; i++) {
      for(int j=0; j<matrix[0].length; j++) {
        if(matrix[i][j] == key) {
          System.out.println("found at cell (" + i + "," + j + ")");
          return true;
        }
      }
    }
    System.out.println("key not found!");
    return false;
  }

  public static void printKeys(int matrix[][], int key) {
    int count = 0; 
    for(int i=0; i<matrix.length; i++) {
      for(int j=0; j<matrix[0].length; j++) {
        if(matrix[i][j] == key) {
          count++;
        }
      }
    }
    System.out.print(count);
  }
 
  public static void printMatrix(int [][]matrix) {
    System.out.println("The matrix is: ");
    for(int i=0; i<matrix.length; i++) {
      for(int j=0; j<matrix[0].length; j++) {
        System.out.print(matrix[i][j] + "   ");
      }
      System.out.println();
    }
  }

  public static void printSpiral(int matrix[][]) {
    int startRow = 0;
    int startCol = 0;
    int endRow = matrix.length-1;
    int endCol = matrix[0].length-1;
    while(startRow <= endRow && startCol <= endCol) {
      for(int j=startCol; j<=endCol; j++) {
        System.out.print(matrix[startRow][j] + " ");
      }
      for(int i=startRow+1; i<=endRow; i++) {
        System.out.print(matrix[i][endCol] + " ");
      }
      for(int j=endCol-1; j>=startCol; j--) {
        if(startRow == endRow) {
          break;
        }
        System.out.print(matrix[endRow][j] + " ");
      }
      for(int i=endRow-1; i>=startCol+1; i--) {
        if(startCol == endCol) {
          break;
        }
        System.out.print(matrix[i][startCol] + " ");
      }
      startCol++;
      startRow++;
      endCol--;
      endRow--;
    }
    System.out.println();
  }

  public static int diagonalSum(int matrix[][]) {
    int sum = 0;
    // for(int i=0; i<matrix.length; i++) {
    //   for(int j=0; j<matrix[0].length; j++) {
    //     if(i == j) {
    //       sum += matrix[i][j];
    //     }
    //     else if(i+j == matrix.length-1) {
    //       sum += matrix[i][j];
    //     }
    //   }
    // }
    for(int i=0; i<matrix.length; i++) {
      sum += matrix[i][i];
      if(i != matrix.length-1-i) {
        sum += matrix[i][matrix.length-1-i];
      }
    }
    return sum;
  }

  public static boolean staircaseSearch(int matrix[][], int key) {
    int row = 0, col = matrix[0].length-1;
    while(row < matrix.length && col >= 0) {
      if(matrix[row][col] == key) {
        System.out.println("found key at (" + row + "," + col + ")");
        return true;
      }
      else if(key < matrix[row][col]) {
        col--;
      }
      else {
        row++;
      }
    }
    System.out.println("key not found!");
    return false;
  }
  public static void main(String[] args) {
    // // code1
    // int matrix[][] = new int[3][3];
    // int n =matrix.length, m = matrix[0].length;
    // Scanner sc = new Scanner(System.in);
    // for(int i=0; i<n; i++) {
    //   for(int j=0; j<m; j++) {
    //     matrix[i][j] = sc.nextInt();
    //   }
    // }
    // for(int i=0; i<n; i++) {
    //   for(int j=0; j<m; j++) {
    //     System.out.print(matrix[i][j] + " ");
    //   }
    //   System.out.println();
    // }
    // search(matrix, 5);
  
    // // code2
    // int matrix[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};  
    // printSpiral(matrix);
    
    // // code3
    // int matrix[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};  
    // System.out.println(diagonalSum(matrix));

    // // code4
    // int matrix[][] = {{10, 20, 30, 40}, {15, 25 ,35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}};
    // int key = 33;
    // staircaseSearch(matrix, key);
  
    // // assign1
    // int matrix[][] = {{4, 7, 8}, {8, 8, 7}};
    // printKeys(matrix, 7);  

    // // assign2
    // int matrix[][] = {{4, 7, 8}, {8, 8, 7}, {2, 2, 3}};
    // int sum = 0;
    // for(int j=0; j<matrix[0].length; j++) {
    //   sum += matrix[1][j];
    // }
    // System.out.println("sum is : " + sum);  

    // // assign3
    // int row = 2, column = 3;
    // int [][]matrix = {{2, 3, 7}, {5, 6, 7}};
    // printMatrix(matrix);
    // int [][]transpose = new int[column][row];
    // for(int i=0; i<row; i++) {
    //   for(int j=0; j<column; j++) {
    //     transpose[j][i] = matrix[i][j];
    //   }
    // }
    // printMatrix(transpose);  
  }
}
