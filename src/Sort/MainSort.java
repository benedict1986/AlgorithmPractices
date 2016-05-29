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
public class MainSort {
    
    public static void main(String[] args)
    {
        Random random= new Random();
        int length = 10;
        int A[]= new int[length];
        for (int i = 0; i < length; i++) 
        {
            int number= random.nextInt(100);
            A[i]=number;
        }
        System.out.println(Arrays.toString(A));
        
        Selection selection = new Selection();
        long startTime = System.currentTimeMillis();
        int[] selectionSortResult = selection.SelectionSort(A.clone());
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("SelectionSortResult  "+(double)totalTime/1000);
        //System.out.println(Arrays.toString(selectionSortResult));
        
        Insertion insertion = new Insertion();
        startTime = System.currentTimeMillis();
        int[] insertionSortResult = insertion.InsertionSort(A.clone());
        endTime   = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("InsertionSortResult  "+(double)totalTime/1000);
//        System.out.println(Arrays.toString(insertionSortResult));

        Shell shell = new Shell();
        startTime = System.currentTimeMillis();
        int[] shellSortResult = shell.ShellSort(A.clone(), A.length/50);
        endTime   = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("ShellSortResult  "+(double)totalTime/1000);
//        System.out.println(Arrays.toString(shellSortResult));

        Merge merge = new Merge();
        startTime = System.currentTimeMillis();
        int[] mergeSortResult = merge.MergeSort(A.clone(), 0, A.length-1);
        endTime   = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("MergeSortResult  "+(double)totalTime/1000);
//        System.out.println(Arrays.toString(mergeSortResult));
        
        Quick quick = new Quick();
        startTime = System.currentTimeMillis();
        int[] quickSortResult = quick.QuickSort2(A.clone(), 0, A.length-1);
        endTime   = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("QuickSortResult  "+(double)totalTime/1000);
//        System.out.println(Arrays.toString(quickSortResult));
        
        Heap heap = new Heap();
        startTime = System.currentTimeMillis();
        int[] heapSortResult = heap.HeapSort(A.clone());
        endTime   = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("HeapSortResult  "+(double)totalTime/1000);
        System.out.println(Arrays.toString(heapSortResult));
    }
}
