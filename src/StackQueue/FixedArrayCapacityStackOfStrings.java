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
public class FixedArrayCapacityStackOfStrings {
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        FixedArrayCapacityStackOfStrings stack = new FixedArrayCapacityStackOfStrings(10);
        String s;
        while(!(s = scanner.nextLine()).isEmpty())
        {
            if ("-".equals(s))
                System.out.println(stack.pop());
            else
                stack.push(s);
        }
    }
    
    private String[] s;
    private int N = 0;
    
    public FixedArrayCapacityStackOfStrings(int capacity)
    {
        this.s = new String[capacity];
    }
    
    public boolean isEmpty()
    {
        return N == 0;
    }
    
    public void push(String item)
    {
        s[N++] = item;
    }
    
    public String pop()
    {
        String item = s[--N];
        s[N] = null;
        return item;
    }
    
}
