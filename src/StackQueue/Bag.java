/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackQueue;

import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Bag<T> implements Iterable<T>
{
    
   public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Bag<String> bag = new Bag<String>();
        String s;
        while(!(s = scanner.nextLine()).isEmpty())
        {
            bag.put(s);
            Iterator<String> items = bag.iterator();
            while(items.hasNext())
            {
                System.out.println(items.next());
            }
        }
    }
    
    public int size;
    public Node first;

    private class Node
    {
        private T item;
        private Node next;

        public Node(T item)
        {
            this.item = item;
        }
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public void put(T item)
    {
        if (isEmpty())
        {
            first = new Node(item);
        }
        else
        {
            Node oldFirst = first;
            first = first.next;
            first = new Node(item);
            first.next = oldFirst;
        }
    }

    public Iterator<T> iterator()
    {
        return new BagIterator();
    }

    public class BagIterator<T> implements Iterator<T>
    {
        public Node current = first;
        public boolean hasNext() { return current.next != null; }
        public void remove() {}
        public T next() 
        {
            T item = (T)current.item;
            current = current.next;
            return item; 
        }
    }
}
