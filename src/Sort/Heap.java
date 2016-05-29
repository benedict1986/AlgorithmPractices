/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

/**
 *
 * @author Admin
 */
public class Heap {
    public int[] HeapSort(int[] a)
    {
        int i = 0, temp, n = a.length, end = n-1;
        MaxHeap(a, n);
        while(end > 0)
        {
            temp = a[0];
            a[0] = a[end];
            a[end] = temp;
            end--;
            AdjustHeap(a, end, 0);
        }
        return a;
    }
    
    public int[] AdjustHeap(int[] a, int end, int i)
    {
        if (i < 0)
            return a;
        int max, maxIndex, leftChildIndex, rightChildIndex, n = a.length;
        max = a[i];
        maxIndex = i;
        leftChildIndex = LeftChild(i);
        rightChildIndex = RightChild(i);
        if (leftChildIndex <= end && a[leftChildIndex] > max)
        {
            max = a[leftChildIndex];
            maxIndex = leftChildIndex;
        }
        if (rightChildIndex <= end && a[rightChildIndex] > max)
        {
            max = a[rightChildIndex];
            maxIndex = rightChildIndex;
        }
        if (maxIndex != i)
        {
            a[maxIndex] = a[i];
            a[i] = max;
            AdjustHeap(a, end, maxIndex);
        }
        
        return a;
    }
    
    public int[] MaxHeap(int[] a, int end)
    {
        for (int i = (end-1)/2; i >= 0; i--)
        {
            AdjustHeap(a, end-1, i);
        }  
        return a;
    }
    
    public int Parent(int i)
    {
        return i/2;
    }
    
    public int LeftChild(int i)
    {
        return i*2+1;
    }
    
    public int RightChild(int i)
    {
        return (i+1)*2;
    }
    
    public int[] DeleteMax(int[] a)
    {
        int n = a.length, temp;
        temp = a[0];
        a[0] = a[n-1];
        a[n-1]= temp;
        AdjustHeap(a, n-2, 0);
        return ResizeArray(a, n-2);
    }
    
    public int[] ResizeArray(int[] a, int newSize)
    {
        int[] b = new int[newSize];
        int n = a.length;
        for(int i = 0; i < newSize; i++)
        {
            b[i] = a[i];
        }
        return b;
    }
}
