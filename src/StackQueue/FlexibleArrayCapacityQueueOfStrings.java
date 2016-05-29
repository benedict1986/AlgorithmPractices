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
public class FlexibleArrayCapacityQueueOfStrings {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        FixedArrayCapacityQueueOfStrings queue = new FixedArrayCapacityQueueOfStrings(10);
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
    
    
    private int head;
    private int tail;
    private String[] items;
    
    public FlexibleArrayCapacityQueueOfStrings()
    {
        head = 0;
        tail = 0;
        items = new String[2];
    }
    
    public void enqueue(String item)
    {
        items[tail++] = item;
    }
    
    public String dequeue()
    {
        String item = items[head];
        items[head] = null;
        head++;
        return item;
    }
    
    public boolean isEmpty()
    {
        return head == tail; 
    }
}
