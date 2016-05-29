/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import StackQueue.IterableStack;
import java.util.Iterator;
import java.util.Queue;

/**
 *
 * @author Admin
 * @param <Key>
 * @param <Value>
 */
public class BST<Key extends Comparable<Key>, Value> {

    private BSTNode root;

    public class BSTNode {

        public Key key;
        public Value value;
        public BSTNode parent, left, right;
        public int subNodesCount;

        public BSTNode(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.subNodesCount = 1;
        }
    }

    public boolean contains(Key key) {
        BSTNode pointer = root;
        while (pointer != null) {
            switch (pointer.key.compareTo(key)) {
                case 1:
                    pointer = pointer.left;
                    break;
                case -1:
                    pointer = pointer.right;
                    break;
                default:
                    return true;
            }
        }
        return false;
    }

    public Value get(Key key) {
        BSTNode pointer = root;
        while (pointer != null) {
            switch (pointer.key.compareTo(key)) {
                case 1:
                    pointer = pointer.left;
                    break;
                case -1:
                    pointer = pointer.right;
                    break;
                default:
                    return pointer.value;
            }
        }
        return null;
    }

    private BSTNode put(BSTNode node, BSTNode parent, Key key, Value value) {
        if (node == null) {
            BSTNode newNode = new BSTNode(key, value);
            newNode.parent = parent;
            return newNode;
        }
        int cmp = node.key.compareTo(key);
        if (cmp > 0) {
            node.left = put(node.left, node, key, value);
        } else if (cmp < 0) {
            node.right = put(node.right, node, key, value);
        } else {
            node.value = value;
        }
        node.subNodesCount = 1 + this.size(node.left) + this.size(node.right);
        return node;
    }

    public void put(Key key, Value value) {
        root = put(root, null, key, value);
    }

    public Value min() {
        BSTNode pointer = root;
        while (pointer.left != null) {
            pointer = pointer.left;
        }

        return pointer.value;
    }
    
    public BSTNode min(BSTNode pointer) {
        while (pointer.left != null) {
            pointer = pointer.left;
        }

        return pointer;
    }

    public Value max() {
        BSTNode pointer = root;
        while (pointer.right != null) {
            pointer = pointer.right;
        }

        return pointer.value;
    }

    public Key Floor(Key key)
    {
        BSTNode floorNode = Floor(root, key);
        return floorNode == null? null: floorNode.key;
    }
    
    private BSTNode Floor(BSTNode pointer, Key key) {
       
        if (pointer == null) return null;
        int cmp = pointer.key.compareTo(key);

        if (cmp == 0) {
            return pointer;
        } else if (cmp > 0) {
            return Floor(pointer.left, key);
        } else {
            BSTNode t = Floor(pointer.right, key);
            return t == null ? pointer:t;
        }        
    }

    public Key Ceiling(Key key) {
        BSTNode ceilingNode = Ceiling(root, key);
        return ceilingNode == null? null : ceilingNode.key;
    }
    
    private BSTNode Ceiling(BSTNode pointer, Key key)
    {
        if (pointer == null) return null;
        int cmp = pointer.key.compareTo(key);
        
        if (cmp == 0) return pointer;
        else if (cmp < 0)
            return Ceiling(pointer.right, key);
        else
        {
            BSTNode t = Ceiling(pointer.left, key);
            return t == null? pointer:t;
        }
    }
    
    public int size(BSTNode node)
    {
        if (node == null) return 0;
        return node.subNodesCount;
    }
    
    public int rank(Key key)
    {
        return rank(key, root);
    }
    
    private int rank(Key key, BSTNode pointer)
    {
        if (pointer == null) return 0;
        int cmp = pointer.key.compareTo(key);
        if (cmp == 0)
            return size(pointer.left);
        else if (cmp > 0)
            return rank(key, pointer.left);
        else
            return 1 + size(pointer.left) + rank(key, pointer.right);
    }
    
    public Iterable<Key> keys()
    {
        IterableStack<Key> q = new IterableStack<Key>();
        inorder(root, q);
        return q;
    }
    
    private void inorder(BSTNode pointer, IterableStack<Key> q)
    {
        if (pointer == null) return;
        inorder(pointer.left, q);
        q.push(pointer.key);
        inorder(pointer.right, q);
    }
    
    public void deleteMin()
    {
        root = deleteMin(root);

    }
    
    private BSTNode deleteMin(BSTNode pointer)
    {
        if (pointer.left == null) return pointer.right;
        pointer.left = deleteMin(pointer.left);
        pointer.subNodesCount = 1 + size(pointer.left) + size(pointer.right);
        return pointer;           
    }
    
    public void delete(Key key)
    {
        root = hibbardDeletion(root, key);
    }
    
    private BSTNode hibbardDeletion(BSTNode pointer, Key key)
    {
        if (pointer == null) return null;
        
        int cmp = pointer.key.compareTo(key);
        if (cmp > 0) pointer.left = hibbardDeletion(pointer.left, key);
        else if (cmp < 0) pointer.right = hibbardDeletion(pointer.right, key);
        else
        {   
            if (pointer.subNodesCount == 1)
                pointer = null;
            else if (pointer.right == null)
                return pointer.left;
            else if (pointer.left == null)
                return pointer.right;
            else
            {
                BSTNode newPointer = pointer;
                pointer = this.min(newPointer.right);
                pointer.right = this.deleteMin(newPointer.right); 
                pointer.left = newPointer.left;       
            }
        }
        pointer.subNodesCount = 1 + size(pointer.left) + size(pointer.right);
        return pointer;
    }
}
