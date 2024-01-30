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
  
    // // code4
    // Fish shark = new Fish();
    // shark.eat();
    
    // // code5
    // Dog dobby = new Dog();
    // dobby.eat();
    // dobby.legs = 4;
    // System.out.println(dobby.legs);

    // // code6
    // Calculator calc = new Calculator();  
    // System.out.println(calc.sum(1, 2));
    // System.out.println(calc.sum((float)1.5, (float)2.5));
    // System.out.println(calc.sum(1, 2, 3));

    // // code7
    // Deer d = new Deer();
    // d.eat();

    // // code8
    // Horse h = new Horse();
    // h.eat();
    // h.walk();
    // System.out.println(h.color);
    // Chicken c = new Chicken();
    // c.eat();;
    // c.walk();

    // // code9
    // Mustang myHorse = new Mustang();

    // // code10
    // Queen q = new Queen();
    // q.moves();

    // // code11
    // Student s1 = new Student();
    // s1.schoolName = "ABC";
    // System.out.println(s1.schoolName);   

    // // code12

  }  
}

interface Herbivore {

}

interface Carnivore {

}

class Bear implements Herbivore, Carnivore {
  // you can write methods
}

interface ChessPlayer {
  void moves();
}

class Queen implements ChessPlayer {
  public void moves() {
    System.out.println("up, down, left, right, diagonal (in all 4 dirns)");
  }
}

class Rook implements ChessPlayer {
  public void moves() {
    System.out.println("up, down, left, right");
  }
}

class King implements ChessPlayer {
  public void moves() {
    System.out.println("up, down, left, right, diagonal (by 1 step)");
  }
}

abstract class Animal {
  String color;
  Animal() {
    color = "brown";
    System.out.println("animal constructor called...");
  }
  void eat() {
    System.out.println("animal eats");
  }  

  abstract void walk();
}

class Horse extends Animal {
  Horse() {
    super();
    super.color = "brown";
    System.out.println("Horse constructor called...");
  }
  void changeColor() {
    color = "dark brown";
  }
  void walk() {
    System.out.println("walks on 4legs");
  }
}

class Mustang extends Horse {
  Mustang() {
    System.out.println("Mustang constructor called...");
  }
}

class Chicken extends Animal {
  void changeColor() {
    color = "yellow";
  }
  void walk() {
    System.out.println("walks on 2 legs");
  }
}

class Calculator {
  int sum(int a, int b) {
    return a + b;
  }

  float sum(float a, float b) {
    return a + b;
  }

  int sum(int a, int b, int c) {
    return a + b + c;
  }
}

// class Animal {
//   String color;
//   void eat() {
//     System.out.println("eats anything");
//   }
//   void breathe() {
//     System.out.println("breathes");
//   }
// }

// class Deer extends Animal {
//   void eat() {
//     System.out.println("eats grass");
//   }
// }

class Mammals extends Animal {
  int legs;

  void walk() {
    System.out.println("walks");
  }
}

class Dog extends Mammals {
  String breed;
}

// class Bird extends Animal {
//   void fly() {
//     System.out.println("fly");
//   }
// }

// class Fish extends Animal {
//   int fins;
//   void swim() {
//     System.out.println("swims in water");
//   }
// }

class Student {
  String name;
  int roll;
  String password;
  int marks[];

  static String schoolName;

  void setName(String name) {
    this.name = name;
  }
  String getName() {
    return this.name;
  }

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