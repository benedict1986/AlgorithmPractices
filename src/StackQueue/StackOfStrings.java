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
public class StackOfStrings {
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        StackOfStrings stack = new StackOfStrings();
        String s;
        while(!(s = scanner.nextLine()).isEmpty())
        {
            if ("-".equals(s))
                System.out.println(stack.pop());
            else
                stack.push(s);
        }
    }
    
    private StackOfStringsNode head;
    
    public StackOfStrings()
    {
        head = null;
    }
    
    public void push(String item)
    {
        StackOfStringsNode oldHead = head;
        head = new StackOfStringsNode(item, oldHead);
    }
    
    public String pop()
    {
        String item = head.getItem();
        head = head.getNode();
        return item;
    }
    
    public boolean isEmpty()
    {
        return head == null;
    }
    
    public int size()
    {
        int i = 0;
        StackOfStringsNode tempNode = head;
        while(tempNode.getNode() != null)
        {
            tempNode = tempNode.getNode();
            i++;
        }
        return i;
    }
}


