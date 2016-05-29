/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

/**
 *
 * @author Admin
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    
    private class Node
    {
        Key key;
        Value value;
        Node left, right;
        boolean color;
        
        public Node(Key key, Value value, boolean color)
        {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }
    
    private boolean isRed(Node x)
    {
        if (x == null) return false;
        return x.color == RED;
    }
    
    private Node rotateLeft(Node h)
    {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }
    
    private Node rotateRight(Node h)
    {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }
    
    private void flipColors(Node h)
    {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    
    private Node put(Node h, Key key, Value value)
    {
        if (h == null) return new Node(key, value, RED);
        int cmp = h.key.compareTo(key);
        if (cmp == 0) h.value = value;
        else if (cmp > 0) h.left = put(h.left, key, value);
        else h.right = put(h.right, key, value);
        
        if (h.right.color == RED && h.left.color != RED) h = rotateLeft(h);
        if (h.left.color == RED && h.left.left.color == RED) h = rotateRight(h);
        if (h.left.color == RED && h.right.color == RED) flipColors(h);
        
        return h;
    }
}
