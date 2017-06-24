package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * WIP To find the magic key such that in a sorted array of distinct number the index of the array equals the value at that index.
 * 
 * @author Rohit Dumbre
 * @since X.X
 */
public class FindMagicIndex
{

    private static int getMagicIndex (int[] array, int low, int high)
    {
        if(low > high) return -1;

        int mid = (low + high) / 2;

        if (array[low] == low)
        {
            return low;
        }
        if (array[high] == high)
        {
            return high;
        }
        if (array[mid] == mid)
        {
            return mid;
        }

        
        int lowestDup = mid-1;
        int highestDup = mid+1;

        while (lowestDup > 0 && array[lowestDup] == array[mid])
        {
            lowestDup--;
        }
        

        while (highestDup <  array.length-1 && array[highestDup] == array[mid])
        {
            highestDup++;
        }

        if (lowestDup >=0 && array[lowestDup] >= lowestDup && array[lowestDup]< mid)
        {
            return getMagicIndex(array, lowestDup, mid);
        }
        else if(lowestDup >=0 && array[lowestDup] < lowestDup && array[lowestDup] >= 0)
        {
            return getMagicIndex(array, low, lowestDup);
        }
       
        if(highestDup<= array.length-1 && array[highestDup] > mid && array[highestDup]<=highestDup)
        {
            return getMagicIndex(array, mid, highestDup);
        }

        return getMagicIndex(array, highestDup, high);
    }

    public static void main (String[] args)
    {
        int[] arr = new int[] {1, 2, 2, 4, 5, 6, 7};
        
        
        
        int magicIndex = FindMagicIndex.getMagicIndex(arr, 0, arr.length - 1);
        System.out.println("arr[" + magicIndex + "]=" + arr[magicIndex]);

        int[] arr1 = new int[] {1, 1, 1, 1, 2, 2, 3, 3, 4, 5, 6};
        int magicIndex1 = FindMagicIndex.getMagicIndex(arr1, 0, arr1.length - 1);
        if (magicIndex1 > -1)
        {
            System.out.println("arr[" + magicIndex1 + "]=" + arr1[magicIndex1]);
        }
       
        int[] arr2 = new int[] {-10, -3, 0, 2, 4, 8};
        int magicIndex2 = FindMagicIndex.getMagicIndex(arr2, 0, arr2.length - 1);
        if (magicIndex2 > -1)
        {
            System.out.println("arr[" + magicIndex2 + "]=" + arr2[magicIndex2]);
        }
        
        
        int[] arr3 = new int[] {-10, -5, 0, 3, 7};
        int magicIndex3 = FindMagicIndex.getMagicIndex(arr3, 0, arr3.length - 1);
        if (magicIndex3 > -1)
        {
            System.out.println("arr[" + magicIndex3 + "]=" + arr3[magicIndex3]);
        }
        
        int[] arr4 = new int[] {-10, -5, 3, 4, 7, 9};
        int magicIndex4 = FindMagicIndex.getMagicIndex(arr4, 0, arr4.length - 1);
        if (magicIndex4 > -1)
        {
            System.out.println("arr[" + magicIndex4 + "]=" + arr4[magicIndex4]);
        }
        else 
        {
            System.out.println("No fixed point");
        }
        
        int[] arr5 = new int[] {0, 2, 5, 8, 17};
        int magicIndex5 = FindMagicIndex.getMagicIndex(arr5, 0, arr5.length - 1);
        if (magicIndex5 > -1)
        {
            System.out.println("arr[" + magicIndex5 + "]=" + arr5[magicIndex5]);
        }
        else 
        {
            System.out.println("No fixed point");
        }
    }

}
