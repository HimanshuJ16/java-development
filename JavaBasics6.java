public class JavaBasics6 {
  public static void hollow_rectangle(int totRows, int totCols) {
    for(int i=1; i<=totRows; i++) {
      for(int j=1; j<=totCols; j++) {
        if(i == 1 || i == totRows || j == 1 || j == totCols) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  public static void i_r_h_p(int n) {
    for(int i=1; i<=n; i++) {
      for(int j=1; j<=n-i; j++) {
        System.out.print(" ");
      }
      for(int j=1; j<=i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public static void i_h_p_w_num(int n) {
    for(int i=1; i<=n; i++) {
      for(int j=1; j<=n-i+1; j++) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }

  public static void floyds_triangle(int n) {
    int counter = 1;
    for(int i=1; i<=n; i++) {
      for(int j=1; j<=i; j++) {
        System.out.print(counter + " ");
        counter++;
      }
      System.out.println();
    }
  }

  public static void triangle01(int n) {
    for(int i=1; i<=n; i++) {
      for(int j=1; j<=i; j++) {
        if((i + j) % 2 == 0) {
          System.out.print("1");
        } else {
          System.out.print("0");
        }
      }
      System.out.println();
    }
  }

  public static void butterfly(int n) {
    for(int i=1; i<=n; i++)  {
      for(int j=1; j<=i; j++) {
        System.out.print("*");
      }
      for(int j=1; j<=2*(n-i); j++) {
        System.out.print(" ");
      }
      for(int j=1; j<=i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
    for(int i=n; i>=1; i--)  {
      for(int j=1; j<=i; j++) {
        System.out.print("*");
      }
      for(int j=1; j<=2*(n-i); j++) {
        System.out.print(" ");
      }
      for(int j=1; j<=i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public static void rhombus(int n) {
    for(int i=1; i<=n; i++) {
      for(int j=1; j<=n-i; j++) {
        System.out.print(" ");
      }
      for(int j=1; j<=n; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public static void hollow_rhombus(int n) {
    for(int i=1; i<=n; i++) {
      for(int j=1; j<=n-i; j++) {
        System.out.print(" ");
      }
      for(int j=1; j<=n; j++) {
        if(i == 1 || i == n || j == 1 || j == n) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  public static void diamond(int n) {
    for(int i=1; i<=n; i++) {
      for(int j=1; j<=n-i; j++) {
        System.out.print(" ");
      }
      for(int j=1; j<=2*i-1; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
    for(int i=n; i>=1; i--) {
      for(int j=1; j<=n-i; j++) {
        System.out.print(" ");
      }
      for(int j=1; j<=2*i-1; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
  public static void main(String[] args) {
    // hollow_rectangle(5, 15);
    // i_r_h_p(4);
    // i_h_p_w_num(5);
    // floyds_triangle(5);
    // triangle01(5);
    // butterfly(3);
    // rhombus(5);
    // hollow_rhombus(5);
    diamond(4);
  }
}
