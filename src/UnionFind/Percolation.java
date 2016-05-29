/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnionFind;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class Percolation {
    
    private int Opened = 1;
    private int Closed = 0;
    private UnionFind uf;
    private int[] PerStatus;
    private int[] probabilityArray;
    private double probability;
    private int m;
    private int vTop;
    private int vBottom;
    private int size;
    public Percolation(double p, int n)
    {
        this.size = n;
        this.m = n*n;
        this.vTop = this.m;
        this.vBottom = this.m+1;
        this.uf = new UnionFind(this.m+2);
        this.PerStatus = new int[m];
        this.probability = p;
        this.probabilityArray = new int[100];
        int P = (int)Math.round(p*100);
        for(int i = 0 ; i < P; i++)
        {
            this.probabilityArray[i] = 1;
        }
        int cell;
        int status;
        while(true)
        {
            cell = RandomNumber(0, this.m-1);
            if (this.PerStatus[cell] == this.Closed)
            {
                status = RandomNumberWithProbability(0, 99, this.probabilityArray);
                if (status == this.Opened)
                {
                    this.PerStatus[cell] = this.Opened;
                    this.CheckNeighbours(cell);
                    if (this.uf.Find(this.vBottom, this.vTop))
                        break;
                }
            }
        }
        int open = 0;
        for(int i = 0; i < m; i ++)
        {
            open += this.PerStatus[i];
        }
        System.out.println((double)open/m);
    }
    
    public int RandomNumber(int min, int max)
    {
        Random rand = new Random();
        return rand.nextInt((max-min)+1)+min;
    }
    
    public int RandomNumberWithProbability(int min, int max, int[] Parray)
    {
        Random rand = new Random();
        return Parray[rand.nextInt((max-min)+1)+min];
    }
    
    public int Up(int[] array, int i, int n, int m)
    {
        if (i < n)
            return array[m];
        return array[i-n];
    }
    
    public int Left(int[] array, int i, int n)
    {
        if (i%n == 0)
            return -1;
        return array[i-1];
    }
    
    public int Right(int[] array, int i, int n)
    {
        if (i%n == n-1)
            return -1;
        return array[i+1];
    }
    
    public int Down(int[] array, int i, int n, int m)
    {
        if (i >= (n-1)*n)
            return array[m+1];
        return array[i+n];
    }
    
    public void CheckNeighbours(int cell)
    {
        int maxSize = -1;
        int connectTo = -1;
        
        if (cell < this.size)
            this.uf.Union(cell, this.vTop);
        else if (cell >= this.m - this.size )
            this.uf.Union(cell, this.vBottom);
        else
        {
            if (cell > this.size )
                if (this.PerStatus[cell-this.size] == this.Opened && (this.uf.Find(cell-this.size, this.vTop) || this.uf.Find(cell-this.size, this.vBottom)))
                {
                    this.uf.Union(cell-this.size, cell);
                    connectTo = cell-this.size;
                }
            if (cell % this.size != 0)
                if (this.PerStatus[cell-1] == this.Opened && (this.uf.Find(cell-1, this.vTop) || this.uf.Find(cell-1, this.vBottom)))
                {
                    this.uf.Union(cell-1, cell);
                    connectTo = cell-1;
                }
            if (cell % this.size != this.size-1)
                if (this.PerStatus[cell+1] == this.Opened && (this.uf.Find(cell+1, this.vTop) || this.uf.Find(cell+1, this.vBottom)))
                {
                    this.uf.Union(cell+1, cell);
                    connectTo = cell+1;
                }
            if (cell < this.m - this.size)
                if (this.PerStatus[cell+this.size] == this.Opened && (this.uf.Find(cell+this.size, this.vTop) || this.uf.Find(cell+this.size, this.vBottom)))
                {
                    this.uf.Union(cell+this.size, cell);
                    connectTo = cell+this.size;
                }

            if (this.uf.GetElment(cell) == cell)
            {

                if (cell > this.size)
                    if( this.PerStatus[cell-this.size] == this.Opened  && this.uf.GetTreeSize(cell - this.size) > maxSize)
                    {
                        maxSize = this.uf.GetTreeSize(cell - this.size);
                        connectTo = cell - this.size;
                    }
                if (cell % this.size != 0)
                    if (this.PerStatus[cell-1] == this.Opened && this.uf.GetTreeSize(cell - 1) > maxSize)
                    {
                        maxSize = this.uf.GetTreeSize(cell - 1);
                        connectTo = cell - 1;
                    }
                if (cell % this.size != this.size-1)
                    if (this.PerStatus[cell+1] == this.Opened && this.uf.GetTreeSize(cell + 1) > maxSize)
                    {
                        maxSize = this.uf.GetTreeSize(cell + 1);
                        connectTo = cell + 1;
                    }
                if (cell < this.m - this.size)
                    if (this.PerStatus[cell+this.size] == this.Opened && this.uf.GetTreeSize(cell + this.size) > maxSize)
                    {
                        maxSize = this.uf.GetTreeSize(cell + this.size);
                        connectTo = cell + this.size;
                    }

                if (connectTo != -1)
                    this.uf.Union(cell, connectTo);
            }
        }
            if (cell > this.size)
                if (this.PerStatus[cell-this.size] == this.Opened  && cell-this.size !=  connectTo && !this.uf.Find(cell-this.size, cell))
                {
                    this.uf.Union(cell-this.size, cell);
                }
            if (cell % this.size != 0)
                if (this.PerStatus[cell-1] == this.Opened && cell-1 !=  connectTo && !this.uf.Find(cell-1, cell))
                {
                    this.uf.Union(cell-1, cell);
                }
            if (cell % this.size != this.size-1)
                if (this.PerStatus[cell+1] == this.Opened && cell+1 !=  connectTo &&  !this.uf.Find(cell+1, cell))
                {
                    this.uf.Union(cell+1, cell);
                }
            if (cell < this.m - this.size)
                if (this.PerStatus[cell+this.size] == this.Opened && cell+this.size !=  connectTo &&  !this.uf.Find(cell+this.size, cell))
                {
                    this.uf.Union(cell+this.size, cell);
                }
    }
}
