public class JavaBasics13 {
  public static void main(String[] args) {
    // // code1
    Pen p1 = new Pen();
    p1.setColor("green");
    System.out.println(p1.getColor());
    p1.setTip(5);
    System.out.println(p1.getTip());
    p1.setColor("red");
    System.out.println(p1.getColor());
  
    // // code2
    // BankAccount myAcc = new BankAccount();
    // myAcc.username = "himanshujangir";
    // myAcc.setPassword("himorewww");

    // // code3

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