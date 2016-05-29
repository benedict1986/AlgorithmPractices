/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class KnuthShuffle {
    
    public static void main(String[] args)
    {
        KnuthShuffle knuthShuffle = new KnuthShuffle();
        int[] a = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(knuthShuffle.KnuthShuffleSort(a)));
    }
    
    public int[] KnuthShuffleSort(int[] a)
    {
        Random random= new Random();
        int n = a.length, i, j, temp;
        for(i = 0; i < n; i++)
        {
            j = random.nextInt(i+1);
            if (j != i)
            {
                temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        return a;
    }
}
