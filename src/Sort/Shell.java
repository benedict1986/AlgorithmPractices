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
public class Shell {
    
    public int[] ShellSort(int[] a, int gap)
    {
        if (gap == 0) return a;
        int n = a.length, m, i, j, k, g, temp;
        for(i = 0; i < gap; i++)
        {
            m = (n-i)%gap == 0?(n-i)/gap : (n-i)/gap+1;
            for(k = 1; k < m; k++)
            {
                for (g = k; g > 0; g--)
                {
                    if (a[(g-1)*gap+i] > a[g*gap+i])
                    {
                        temp = a[(g-1)*gap+i];
                        a[(g-1)*gap+i] = a[g*gap+i];
                        a[g*gap+i] = temp;
                    }
                }
            }
        }
        return ShellSort(a, gap/50);
    }
    
    public void InsertionSort(int[] a)
    {
        int n = a.length, i, j, temp;
        for(i = 1; i < n; i++)
        {
            for (j = i; j > 0; j--)
            {
                if (a[j-1] > a[j])
                {
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
    }
}
