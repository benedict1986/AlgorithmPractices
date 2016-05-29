/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash;

/**
 *
 * @author Admin
 */
public class SeparateChainingHashST<Key, Value> {
    
    private int M = 97;
    private Node[] st = new Node[M];
    
    private static class Node 
    {
        private Object key;
        private Object value;
        private Node next;
        
        public Node(Object key, Object value)
        {
            this.key = key;
            this.value = value;
        }
    }
    
    private int hash(Key key)
    {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    
    public void put(Key key, Value value)
    {
        int hashcode = this.hash(key);
        Node pointer = st[hashcode];
        while(pointer != null)
        {
            if (pointer.key.equals(key))
                pointer.value = value;
            pointer = pointer.next;
        }
        pointer.next = new Node(key, value);
    }
    
    public Value get(Key key)
    {
        int hashcode = this.hash(key);
        Node pointer = st[hashcode];
        while (pointer != null) {
            if (pointer.key.equals(key)) {
                return (Value) pointer.value;
            }
            pointer = pointer.next;
        }
        return null;
    }
    
}
