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
public class FlexibleArrayCapacityStackOfStrings {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        FlexibleArrayCapacityStackOfStrings stack = new FlexibleArrayCapacityStackOfStrings();
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
    
    public FlexibleArrayCapacityStackOfStrings()
    {
        this.s = new String[2];
    }
    
    public boolean isEmpty()
    {
        return N == 0;
    }
    
    public void push(String item)
    {
        s[N++] = item;
        if (N == s.length)
        {
            this.resizeArray(s.length*2);
        }
    }
    
    public String pop()
    {
        String item = s[--N];
        s[N] = null;
        
        if (N < s.length/4)
        {
            if (s.length/2 > 0)
                this.resizeArray(s.length/2);
        }
        
        return item;
    }
    
    public void resizeArray(int newLength)
    {
        String[] newArray = new String[newLength];
        for(int i = 0; i < N; i ++)
        {
            newArray[i] = this.s[i];
        }
        this.s = newArray;
    }
}
