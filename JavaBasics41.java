import java.util.*;

public class JavaBasics41 {
  static class Node {
    int data;
    Node right;
    Node left;

    Node(int data) {
      this.data = data;
    }
  }

  public static Node insert(Node root, int val) {
    if (root == null) {
      root = new Node(val);
      return root;
    }

    if (root.data > val) {
      root.left = insert(root.left, val);
    } else {
      root.right = insert(root.right, val);
    }
    
    return root;
  } 

  public static void inorder(Node root) {
    if (root == null) {
      return;
    }

    inorder(root.left);
    System.out.print(root.data + " ");
    inorder(root.right);
  }

  public static boolean search(Node root, int key) {
    if (root == null) {
      return false;
    }

    if (root.data == key) {
      return true;
    }

    if (root.data > key) {
      return search(root.left, key);
    } else {
      return search(root.right, key);
    }
  }

  public static Node delete(Node root, int val) {
    if (root.data < val) {
      root.right = delete(root.right, val);
    } else if (root.data > val) {
      root.left = delete(root.left, val);
    } else {
      //case1 - leaf node
      if (root.left == null && root.right == null) {
        return null;
      }

      //case2 - single child
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      }

      //case3 - both children
      Node IS = findInorderSuccessor(root.right);
      root.data = IS.data;
      root.right = delete(root.right, IS.data);
    }

    return root;
  }

  public static Node findInorderSuccessor(Node root) {
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }

  public static void printInRange(Node root, int k1, int k2) {
    if (root == null) {
      return;
    }
    if (root.data >= k1 && root.data <= k2) {
      printInRange(root.left, k1, k2);
      System.out.print(root.data + " ");
      printInRange(root.right, k1, k2);
    } else if (root.data < k1) {
      printInRange(root.left, k1, k2);
    } else {
      printInRange(root.right, k1, k2);
    }
  }

  public static void printPath(ArrayList<Integer> path) {
    for(int i=0; i<path.size(); i++) {
      System.out.print(path.get(i)+"->");
    }
    System.out.println("null");
  }

  public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
    if (root == null) {
      return;
    }
    path.add(root.data);
    if (root.left == null && root.right == null) {
      printPath(path);
    }
    printRoot2Leaf(root.left, path);
    printRoot2Leaf(root.right, path);
    path.remove(path.size()-1);
  }

  public static boolean isValidBST(Node root, Node min, Node max) {
    if (root == null) {
      return true;
    }

    if (min != null && root.data <= min.data) {
      return false;
    } else if (max != null && root.data >= max.data) {
      return false;
    }

    return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
  }

  public static Node createMirror(Node root) {
    if (root == null) {
      return null;
    }

    Node leftMirror = createMirror(root.left);
    Node rightMirror = createMirror(root.right);

    root.left = rightMirror;
    root.right = leftMirror;

    return root;
  }

  public static void preorder(Node root) {
    if (root == null) {
      return;
    }

    System.out.print(root.data + " ");
    preorder(root.left);
    preorder(root.right);
  }
  public static void main(String[] args) {
    // // CODE1
    // int values[] = {8, 5, 3, 6, 10, 11, 14};
    // Node root = null;

    // for(int i=0; i<values.length; i++) {
    //   root = insert(root, values[i]);
    // }

    // // inorder(root);
    // // System.out.println();

    // // if (search(root, 1)) {
    // //   System.out.println("found");
    // // } else {
    // //   System.out.println("not found");
    // // }

    // // root = delete(root, 1);
    // // System.out.println();

    // inorder(root);
    // System.out.println();
    // printInRange(root, 5, 12);
    // System.out.println();
    // printRoot2Leaf(root, new ArrayList<>());

    // if (isValidBST(root, null, null)) {
    //   System.out.println("valid");
    // } else {
    //   System.out.println("not valid");
    // }

    // // CODE2
    Node root = new Node(8);
    root.left = new Node(5);
    root.right = new Node(10);
    root.left.left = new Node(3);
    root.left.right = new Node(6);
    root.right.right = new Node(11);

    root = createMirror(root);
    preorder(root);
  }
}
