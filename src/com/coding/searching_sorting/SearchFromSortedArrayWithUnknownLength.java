package com.coding.searching_sorting;

/**
 * TODO Description.
 * @author Rohit Dumbre (RD025989)
 * @since X.X
 */
public class SearchFromSortedArrayWithUnknownLength
{
    private static int getIndexForValue(int[] array, int value)
    {
        int index = 1;
        while(index<array.length && array[index]!=-1 && array[index]<=value)
        {
            index *=2;
        }
        
        return getElementFromOrdinaryBinarySearch(array, 0, index, value);
    }
    
    private static int getElementFromOrdinaryBinarySearch(int[] array, int low, int high, int key)
    {
        if(high < low) return -1;
        
        int mid = (low+high)/2;
        if(array[mid] == key) return mid;
        
        if(array[low]==key) return low;
        if(array[high]==key) return high;
        
        if(array[mid] < key)
        {
           return getElementFromOrdinaryBinarySearch(array, mid+1, high, key);
        }
        
        return getElementFromOrdinaryBinarySearch(array, low, mid-1, key);        
    }

    public static void main (String[] args)
    {
        int[] array = new int[]{2,3,4,5,6,7,8,10,11,12};
        
        System.out.println("The key was found at index "+SearchFromSortedArrayWithUnknownLength.getIndexForValue(array, 7));
    }

}
