package com.ds.main;

import java.util.Stack;

public class SpiralPrint {

}

class BinaryTree {

  Node root;

  // Function to print the spiral traversal of tree
  void printSpiral(Node root) {
    Stack<Node> leftStack = new Stack<>();
    Stack<Node> rightStack = new Stack<>();
    rightStack.push(root);
    boolean leftFirst = false;

    while (!leftStack.isEmpty() || !rightStack.isEmpty()) {
      if (leftFirst) {
        while (!leftStack.isEmpty()) {
          Node currentElement = leftStack.pop();
          System.out.print(currentElement);

          if (currentElement.left != null) {
            rightStack.push(currentElement.left);
          }

          if (currentElement.right != null) {
            rightStack.push(currentElement.right);
          }
        }
      } else {
        while (!rightStack.isEmpty()) {
          Node currentElement = rightStack.pop();
          System.out.print(currentElement);

          if (currentElement.right != null) {
            leftStack.push(currentElement.right);
          }
          if (currentElement.left != null) {
            leftStack.push(currentElement.left);
          }

        }
      }

      leftFirst = !leftFirst;

    }
  }

  static class Node {

    int data;
    Node left, right;

    public Node(int d) {
      data = d;
      left = right = null;
    }

    @Override
    public String toString() {
      return this.data + " ";
    }
  }
}
