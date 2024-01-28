public class JavaBasics13 {
  public static void main(String[] args) {
    // // code1
    // Pen p1 = new Pen();
    // p1.setColor("green");
    // System.out.println(p1.getColor());
    // p1.setTip(5);
    // System.out.println(p1.getTip());
    // p1.setColor("red");
    // System.out.println(p1.getColor());
  
    // // code2
    // BankAccount myAcc = new BankAccount();
    // myAcc.username = "himanshujangir";
    // myAcc.setPassword("himorewww");

    // // code3
    // Student s1 = new Student();
    // s1.name = "Himanshu";
    // s1.roll = 546;
    // s1.password = "abcd";
    // s1.marks[0] = 100;
    // s1.marks[1] = 90;
    // s1.marks[2] = 80;
    // Student s2 = new Student(s1);
    // s2.password = "xys";
    // s1.marks[2] = 100;
    // for(int i=0; i<3; i++) {
    //   System.out.println(s2.marks[i]);
    // }
  }  
}

class Student {
  String name;
  int roll;
  String password;
  int marks[];

  // // shallow copy constructor
  // Student(Student s1) {
  //   marks = new int[3];
  //   this.name = s1.name;
  //   this.roll = s1.roll;
  //   this.marks = s1.marks;
  // }

  // // deep copy constructor
  Student(Student s1) {
    marks = new int[3];
    this.name = s1.name;
    this.roll = s1.roll;
    for(int i=0; i<marks.length; i++) {
      this.marks[i] = s1.marks[i];
    }
  }

  Student() {
    marks = new int[3];
    System.out.println("constructor is called...");
  }

  Student(String name) {
    marks = new int[3];
    this.name = name;
  }

  Student(int roll) {
    marks = new int[3];
    this.roll = roll;
  }
}

class BankAccount {
  public String username;
  private String password;
  public void setPassword(String pwd) {
    password = pwd;
  }
}

class Pen {
  private String color;
  private int tip;

  String getColor() {
    return this.color;
  }

  int getTip() {
    return this.tip;
  }

  void setColor(String newColor) {
    this.color = newColor;
  }

  void setTip(int tip) {
    this.tip = tip;
  }
}