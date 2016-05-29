/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnionFind;

import java.util.Arrays;

/**
 *
 * @author Admin
 */
public class UnionFind {
    
    private int[] ufArray;
    private int[] treeSize;
    private int length;
    
    public UnionFind(int n)
    {
        this.length = n;
        this.ufArray = new int[this.length];
        this.treeSize = new int[this.length];
        for(int i=0;i < this.length; i++)
        {
            this.ufArray[i] = i;
            this.treeSize[i] = 1;
        }
    }
    
    public void Union(int a, int b)
    {
        int ra = FindRoot(a);
        int rb = FindRoot(b);
        if (ra == this.length*this.length || ra == this.length*this.length + 1)
        {
            this.ufArray[rb] = ra;
            this.treeSize[ra] += this.treeSize[rb];
            return;
        }
        else if (ra == this.length*this.length || ra == this.length*this.length + 1)
        {
            this.ufArray[ra] = rb;
            this.treeSize[rb] += this.treeSize[ra];
            return;
        }
        
        if (this.treeSize[ra] <= this.treeSize[rb])
        {
            this.ufArray[ra] = rb;
            this.treeSize[rb] += this.treeSize[ra];
        }
        else
        {
            this.ufArray[rb] = ra;
            this.treeSize[ra] += this.treeSize[rb];
        }
    }
    
    public boolean Find(int a, int b)
    {
        return FindRoot(a) == FindRoot(b);
    }
    
    public int FindRoot(int a)
    {
        if (this.ufArray[a] == a)
            return a;
        
        return FindRoot(this.ufArray[a]);
    }
    
    public int GetElment(int a)
    {
        return this.ufArray[a];
    }
    
    public int GetTreeSize(int a)
    {
        return this.treeSize[this.FindRoot(a)];
    }
}
