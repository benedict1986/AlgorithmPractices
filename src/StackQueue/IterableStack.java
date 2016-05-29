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
public class IterableStack<T> implements Iterable<T> 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        IterableStack<String> stack = new IterableStack<String>();
        String s;
        while(!(s = scanner.nextLine()).isEmpty())
        {
            if ("-".equals(s))
                stack.pop();
            else if ("=".equals(s))
                break;
            else
                stack.push(s);
            
            Iterator<String> items = stack.iterator();
            while(items.hasNext())
            {
                System.out.println(items.next());
            }
        }
    }
    
   private class Node<T>
   {
       public T item;
       public Node next;
   }
   
   private class ListIterator implements Iterator<T>
   {
       private Node<T> current = first;
       public boolean hasNext(){return current != null;}
       public void remove() {}
       public T next()
       {
           T item = current.item;
           current = current.next;
           return item;
       }
   }
   
   public Node first;
   
   public void push(T item)
   {
       Node oldFirst = first;
       first = new Node();
       first.item = item;
       if (oldFirst != null)
       {
           first.next = oldFirst;
       }
   }
   
   public T pop()
   {
       T item = null;
       if (first != null)
       {
           item = (T)first.item;
           first = first.next;
       }
       return item;
   }
   
   public boolean isEmpty()
   {
       return first == null;
   }
   
   public Iterator<T> iterator()
   {
        return new ListIterator();
   }
}
