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
public class Insertion {
    
    public int[] InsertionSort(int[] a)
    {
        
        int n = a.length, i, j, temp, moving;
        for(i = 1; i < n; i ++)
        {
            for (j = i; j > 0; j--)
            {
                if (a[j-1] > a[j])
                {
                    temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
                else
                    break;
            }
        }
        return a;
    }
}
