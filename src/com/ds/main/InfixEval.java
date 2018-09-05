package com.ds.main;

import java.util.Stack;

public class InfixEval {


  public static int evaluateInfix(String infix) {

    Stack<Integer> operands = new Stack<>();
    Stack<Character> operators = new Stack<>();

    for (int i = 0; i < infix.length(); i++) {
      char currentChar = infix.charAt(i);

      if (currentChar == ' ') {
        continue;
      } else if (currentChar == '(') {
        operators.push(currentChar);
      } else if (currentChar == ')') {
        while (!operators.isEmpty() && operators.peek() != '(') {
          int arg2 = operands.pop();
          int arg1 = operands.pop();

          operands.push(doOperation(arg1, arg2, operators.pop()));
        }

        operators.pop();
      } else if (isDigit(currentChar)) {
        StringBuilder sb = new StringBuilder();

        do {
          sb.append(currentChar);
          i++;
        } while (i < infix.length() && isDigit(currentChar = infix.charAt(i)));

        operands.push(Integer.parseInt(sb.toString()));
      }

      // it is operator
      else {

        while (!operators.isEmpty() && comparePrecedence(operators.peek(), currentChar) >= 0) {
          int arg2 = operands.pop();
          int arg1 = operands.pop();

          operands.push(doOperation(arg1, arg2, operators.pop()));

        }
        operators.push(currentChar);
      }
    }

    while (!operators.isEmpty()) {
      int arg2 = operands.pop();
      int arg1 = operands.pop();

      operands.push(doOperation(arg1, arg2, operators.pop()));
    }

    return operands.pop();
  }

  public static boolean isDigit(char character) {

    return character >= '0' && character <= '9';
  }

  public static int doOperation(int a, int b, char operator) {
    switch (operator) {
      case '+':
        return a + b;
      case '-':
        return a - b;
      case '*':
        return a * b;
      case '/':
        return a / b;
      case '^':
        return a ^ b;

      default:
        throw new IllegalArgumentException("Invalid operation. Not supported");
    }
  }

  public static int precedence(char operator) {

    switch (operator) {
      case '+':
      case '-':
        return 1;

      case '*':
      case '/':
        return 2;

      case '^':
        return 3;

      default:
        return -1;
    }
  }

  public static int comparePrecedence(char op1, char op2) {
    return precedence(op1) - precedence(op2);
  }
}
