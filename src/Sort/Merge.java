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
public class Merge {
    
    public int[] MergeSort(int[] a, int begin, int end)
    {
        if (begin >= end) return a;
        int n = end-begin, k = begin, mid = n/2 + begin, i = begin, j = mid+1, g;
        
        MergeSort(a, begin, mid);
        MergeSort(a, mid+1, end);
        
        int[] b = a.clone();
        
        for(;k<=end;k++)
        {
            if (i > mid) a[k] = b[j++];
            else if (j > end) a[k] = b[i++];
            else if (b[i] > b[j]) a[k] = b[j++];
            else a[k] = b[i++];
        }
        return a;
    }
}
