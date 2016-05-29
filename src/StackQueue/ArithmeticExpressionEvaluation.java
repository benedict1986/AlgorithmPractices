/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackQueue;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ArithmeticExpressionEvaluation {
    public static void main(String[] args)
    {
        String expression = "( 1 + ( ( 2 - 3 ) * ( 4 * 5 ) ) )";
        String[] expressionArray = expression.split(" ");
        
        IterableStack<Integer> valueStack = new IterableStack<Integer>();
        IterableStack<String> operatorStack = new IterableStack<String>();
        
        for (String s : expressionArray)
        {
            if (!"(".equals(s))
            {
                if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s))
                {
                    operatorStack.push(s);
                }
                else if (")".equals(s))
                {
                    int v1 = valueStack.pop();
                    int v2 = valueStack.pop();
                    int result = 0;
                    switch(operatorStack.pop())
                    {
                        case "+":
                            result = v2 + v1;
                            break;
                        case "-":
                            result = v2 - v1;
                            break;
                        case "*":
                            result = v2 * v1;
                            break;
                        case "/":
                            result = v2 / v1;
                            break;
                        default:
                            break;
                    }
                    valueStack.push(result);
                }
                else
                {
                    valueStack.push(Integer.parseInt(s));
                }
            }
        }
        System.out.println(valueStack.pop());
    }
}
