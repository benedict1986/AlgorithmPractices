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
public class LinkedListQueueOfStrings {
    
        public static void main(String[] args)
        {
            Scanner scanner = new Scanner(System.in);
            LinkedListQueueOfStrings queue = new LinkedListQueueOfStrings();
            String s;
            while(!(s = scanner.nextLine()).isEmpty())
            {
                if ("-".equals(s))
                {
                    String item = "";
                    if (!queue.isEmpty())
                        item = queue.dequeue();
                    System.out.println(item);
                }
                else
                {
                    queue.enqueue(s);
                }
            }
        }
    
    public LinkedListQueueOfStringsNode first;
    public LinkedListQueueOfStringsNode last;
    
    public void enqueue(String item)
    {
        LinkedListQueueOfStringsNode oldLast = last;
        last = new LinkedListQueueOfStringsNode();
        last.item = item;
        last.next = null;
        if (this.isEmpty())
        {
            first = last;
        }
        else
        {
            oldLast.next = last;
        }
    }
    
    public String dequeue()
    {
        String item = first.item;
        first = first.next;
        return item;
    }
    
    public boolean isEmpty()
    {
        return first == null;     
    }
    
}
