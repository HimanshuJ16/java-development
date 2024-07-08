public class JavaBasics28 {
  static class Node {
    int data;
    Node next;
    // // UNCOMMENT THIS FOR CODE1
    // Node(int d) {
    //   data = d;
    //   next = null;
    // }
  }

  public Node getIntersectionNode(Node head1, Node head2) {
    while (head2 != null) {
      Node temp = head1;
      while (temp != null) {
        if(temp == head2) {
          return head2;
        }
        temp = temp.next;
      }
      head2 = head2.next;
    }
    return null;
  }

  static Node push(Node head_ref, int new_data) {
    Node new_node = new Node();
    new_node.data = new_data;
    new_node.next = (head_ref);
    (head_ref) = new_node;
    return head_ref;
  }
  
  static void printList(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.printf("%d ", temp.data);
      temp = temp.next;
    }
    System.out.printf("\n");
  }
  
  static void skipMdeleteN(Node head, int M, int N) {
    Node curr = head, t;
    int count;
    while (curr != null) {
      for (count = 1; count < M && curr != null; count++) {
        curr = curr.next;
      }
      if (curr == null) {
        return;
      }
      t = curr.next;
      for (count = 1; count <= N && t != null; count++) {
        Node temp = t;
        t = t.next;
      }
      curr.next = t;
      curr = t;
    }
  }
  public static void main(String[] args) {
    // // CODE1
    // JavaBasics28 list = new JavaBasics28();

    // Node head1, head2;
    // head1 = new Node(10);
    // head2 = new Node(3);
    
    // Node newNode = new Node(6);
    // head2.next = newNode;

    // newNode = new Node(9);
    // head2.next.next = newNode;

    // newNode = new Node(15);
    // head1.next = newNode;
    // head2.next.next.next = newNode;

    // newNode = new Node(30);
    // head1.next.next = newNode;

    // head1.next.next.next = null;

    // Node intersectionPoint = list.getIntersectionNode(head1, head2);

    // if (intersectionPoint == null) {
    //   System.out.println("No Intersection Point \n");
    // } else {
    //   System.out.println("Intersection Point: " + intersectionPoint.data);
    // }

    // // CODE2
    // Node head = null;
    // int M = 2, N = 3;
    // head = push(head, 10);
    // head = push(head, 9);
    // head = push(head, 8);
    // head = push(head, 7);
    // head = push(head, 6);
    // head = push(head, 5);
    // head = push(head, 4);
    // head = push(head, 3);
    // head = push(head, 2);
    // head = push(head, 1);
    // System.out.printf("M = %d, N = %d \n" + "Linked list we have is :\n", M, N);
    // printList(head);
    // skipMdeleteN(head, M, N);
    // System.out.printf("\nLinked list on deletion is :\n");
    // printList(head);
  }
}
