/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SymbolTable;

import StackQueue.IterableStack;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author Admin
 */
public class BasicSymbolTable<Key, Value> {
    
    public class Node<Key, Value>
    {
        public Key key;
        public Value value;
        public Node next;
        
        public Node(Key key, Value value, Node node)
        {
            this.key = key;
            this.value = value;
            this.next = node;
        }
    }

    public Node head;
    
    public BasicSymbolTable()
    {
    }
    
    public void put(Key key, Value value)
    {
        if (head == null)
            head = new Node(key, value, null);
        else
        {
            if (this.contains(key))
            {
                if (head.key.equals(key))
                {
                    head.value = value;
                    return;
                }
                Node temp = new Node(head.key, head.value, head.next);
                while(temp != null)
                {
                    if (temp.key.equals(key))
                    {
                        temp.value = value;
                        return;
                    }
                    else
                        temp = temp.next;
                }
            }
            Node oldNode = head;
            head = new Node(key, value, oldNode);
        }
    }
    
    public Value get(Key key)
    {
        Node temp = new Node(head.key, head.value, head.next);
        while(temp != null)
        {
            if (temp.key.equals(key))
                return (Value)temp.value;
            else
                temp = temp.next;
        }
        return null;
    }
    
    public void delete(Key key)
    {
        Node temp = new Node(head.key, head.value, head.next);
        while(temp.next == null)
        {
            if (temp.next.key.equals(key))
            {
                temp.next = temp.next.next;
            }
            else
                temp = temp.next;
        }
    }
    
    public boolean contains (Key key)
    {
        return get(key) != null;
    }
    
    public boolean isEmpty()
    {
        return head == null;
    }
    
    public int size()
    {
        int i = 1;
        Node temp = new Node(head.key, head.value, head.next);
        while(temp.next != null)
        {
            temp = temp.next;
            i++;
        }
        return i;
    }
    
    public Iterable<Key> keys()
    {
        Key[] allKeys = (Key[])new Object[this.size()];
        int i = 0;
        Node temp = new Node(head.key, head.value, head.next);
        while(temp != null)
        {
            allKeys[i++] = (Key)temp.key;
            temp = temp.next;
        }
        return Arrays.asList(allKeys);
    }
}
