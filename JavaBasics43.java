public class JavaBasics43 {
  static class Node {
    int data, height;
    Node left, right;

    Node(int data) {
      this.data = data;
      height = 1;
    }
  }

  public static Node root;

  public static int height(Node root) {
    if (root == null) {
      return 0;
    }

    return root.height;
  }

  static int max(int a, int b) {
    return (a > b) ? a : b;
  }

  public static Node rightRotate(Node y) {
    Node x = y.left;
    Node T2 = x.right;
    
    x.right = y;
    y.left = T2;

    y.height = max(height(y.left), height(y.right)) + 1;
    x.height = max(height(x.left), height(x.right)) + 1;

    return x;
  }

  public static Node leftRotate(Node x) {
    Node y = x.right;
    Node T2 = y.left;
    
    y.left = x;
    x.right = T2;

    x.height = max(height(x.left), height(x.right)) + 1;
    y.height = max(height(y.left), height(y.right)) + 1;

    return y;
  }

  public static int getBalance(Node root) {
    if (root == null) {
      return 0;
    }

    return height(root.left) - height(root.right);
  }

  public static Node insert(Node root, int key) {
    if (root == null) {
      return new Node(key);
    }

    if (key < root.data) {
      root.left = insert(root.left, key);
    } else if (key > root.data) {
      root.right = insert(root.right, key);
    } else {
      return root;
    }

    root.height = 1 + Math.max(height(root.left), height(root.right));

    int bf = getBalance(root);

    // Left Left Case
    if (bf > 1 && key < root.left.data) {
      return rightRotate(root);
    }

    // Right Right Case
    if (bf < -1 && key > root.right.data) {
      return leftRotate(root);
    }

    // Left Right Case
    if (bf > 1 && key > root.left.data) {
      root.left = leftRotate(root.left);
      return rightRotate(root);
    }

    // Right Left Case
    if (bf < -1 && key < root.right.data) {
      root.right = rightRotate(root.right);
      return leftRotate(root);
    }

    return root;
  }

  public static Node getMinNode(Node root) {
    Node curr = root;
    
    //MIN data is at left-most node
    while (curr.left != null) {
      curr = curr.left;
    }
    return curr;
  }

  public static Node deleteNode(Node root, int key) {
    // perform usual BST delete
    if (root == null) {
      return root;
    }
    
    // key < root's data => then it lies in leftsubtree
    if (key < root.data) {
      root.left = deleteNode(root.left, key);
    }
    
    // key > root's data => then it lies in rightsubtree
    else if (key > root.data) {
      root.right = deleteNode(root.right, key);
    }
    
    // key = root's data => then this is the node to be deleted
    else {
      // node with only one child or no child
      if ((root.left == null) || (root.right == null)) {
        Node temp = null;
        if (temp == root.left) {
          temp=root.right;
        } else {
          temp=root.left;
        }

        // No child case
        if (temp == null) {
          temp = root;
          root = null;
        } else {
          // One child case
          root = temp;
          // Copy the contents of the non-empty child
        }
      } else {
        // node with two children: Get theinorder
        // successor (smallest in the rightsubtree)
        Node temp = getMinNode(root.right);
        // Copy the inorder successor's data to this node
        root.data = temp.data;
        // Delete the inorder successor
        root.right = deleteNode(root.right, temp.data);
      }
    }

    if (root == null) {
      return root;
    }

    root.height = 1 + Math.max(height(root.left), height(root.right));

    int bf = getBalance(root);

    // Left Left Case
    if (bf > 1 && key < root.left.data) {
      return rightRotate(root);
    }

    // Right Right Case
    if (bf < -1 && key > root.right.data) {
      return leftRotate(root);
    }

    // Left Right Case
    if (bf > 1 && key > root.left.data) {
      root.left = leftRotate(root.left);
      return rightRotate(root);
    }

    // Right Left Case
    if (bf < -1 && key < root.right.data) {
      root.right = rightRotate(root.right);
      return leftRotate(root);
    }

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
    root = insert(root, 10);
    root = insert(root, 20);
    root = insert(root, 30);
    root = insert(root, 40);
    root = insert(root, 50);
    root = insert(root, 25);
    preorder(root);
    System.out.println();
    deleteNode(root, 10);
    preorder(root);
  }
}
