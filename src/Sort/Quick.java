/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

import java.util.Arrays;

/**
 *
 * @author Admin
 */
public class Quick {
    
    public int[] QuickSort(int[] a, int begin, int end)
    {
        if (begin >= end)
            return a;
        
        int base = a[begin], i = begin, j = end;
        while(i < j)
        {
            while(a[j] >= base && i < j)
            {
                j--;
            }
            if (i < j) a[i++] = a[j];
            while(a[i] <= base && i < j)
            {
                i++;
            }
            if (i < j) a[j--] = a[i];
        }
        a[i] = base;
        QuickSort(a, begin, i-1);
        QuickSort(a, i+1, end);
        return a;
    }
    
    public int[] QuickSort2(int[] a, int begin, int end)
    {
        if (begin >= end)
            return a;
        
        int base = a[begin], i = begin+1, j = end, temp;
        while(true)
        {
            while(i < end && a[i] <= base)
            {   
                i++;
                if (i == end)
                    break;
            }
            
            while(j >= begin && a[j] >= base)
            {
                j--;
                if ( j == begin)
                    break;
            }
            
            if (j <= i) break;
            
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        a[begin] = a[j];
        a[j] = base;
        QuickSort2(a, begin, j);
        QuickSort2(a, i, end);
        return a;
    }
}
