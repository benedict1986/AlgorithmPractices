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
public class Selection {
    
    public int[] SelectionSort(int[] a)
    {
        int i, j, min, minIndex, n=a.length;
        for(i = 0; i < n; i++)
        {
            min = a[i];
            minIndex = i;
            for(j = i+1; j < n; j++)
            {
                if (a[j] < min)
                {
                    min = a[j];
                    minIndex = j;
                }
            }
            a[minIndex] = a[i];
            a[i] = min;
        }
        return a;
    }
    
}
