/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import StackQueue.Bag;
import edu.princeton.cs.algs4.In;

/**
 *
 * @author Admin
 */
public class Digraph {
    
    private int V;
    private Bag<Integer>[] adj;
    
    public Digraph(int V)
    {
        this.V = V;
        this.adj = new Bag[V];
        for(int v = 0; v < V; v++)
        {
            this.adj[v] = new Bag<Integer>();
        }
    }
    
    public Digraph(In in)
    {
        
    }
    
    public void addEdge(int v, int w)
    {
        this.adj[v].put(w);
    }
    
    public Iterable<Integer> adj(int v)
    {
        return this.adj(v);
    }
    
    public int V()
    {
        return this.V;
    }
//    
//    public int E()
//    {
//        
//    }
//    
//    public Digraph reverse()
//    {
//        
//    }
//    
//    public String toString()
//    {
//        
//    }
    
    
}
