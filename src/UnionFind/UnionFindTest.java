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
public class UnionFindTest {
    
    public void TestV1()
    {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = i;
        }
        System.out.println(Arrays.toString(array));
        UnionV1(array, 4, 3);
        UnionV1(array, 3, 8);
        UnionV1(array, 6, 5);
        UnionV1(array, 9, 4);
        UnionV1(array, 2, 1);
        System.out.println(FindV1(array, 8, 9));
        System.out.println(FindV1(array, 5, 0));
        UnionV1(array, 5, 0);
        UnionV1(array, 7, 2);
        UnionV1(array, 6, 1);
    }
    
    public int[] UnionV1(int[] array, int a, int b)
    {
        int va = array[a];
        int vb = array[b];
        int n = array.length;
        for (int i = 0 ; i < n; i++)
        {
            if (array[i] == va)
            {
                array[i] = vb;
            }
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
    
    public boolean FindV1(int[] array, int a, int b)
    {
        return array[a] == array[b];     
    }
    
    public void TestV2()
    {
        int[] array = new int[10];
        int[] size = new int[10];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = i;
            size[i] = 1;
        }
        System.out.println(Arrays.toString(array));
        UnionV2(array, size, 4, 3);
        UnionV2(array, size, 3, 8);
        UnionV2(array, size, 6, 5);
        UnionV2(array, size, 9, 4);
        UnionV2(array, size, 2, 1);
        System.out.println(FindV2(array, 8, 9));
        System.out.println(FindV2(array, 5, 0));
        UnionV2(array, size, 5, 0);
        UnionV2(array, size, 7, 2);
        UnionV2(array, size, 6, 1);
        UnionV2(array, size, 7, 3);
    }
    
    public int[] UnionV2(int[] array, int[] size, int a, int b)
    {
        int ra = FindRoot(array, a);
        int rb = FindRoot(array, b);
        if (size[ra] < size[rb])
        {
            array[ra] = rb;
            size[rb] += size[ra];
        }
        else
        {
            array[rb] = ra;
            size[ra] += size[rb];
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
    
    public boolean FindV2(int[] array, int a, int b)
    {
        return FindRoot(array, a) == FindRoot(array, b);
    }
    
    public int FindRoot(int[] array, int a)
    {
        if (array[a] == a)
            return a;
        
        return FindRoot(array, array[a]);
    }
}
