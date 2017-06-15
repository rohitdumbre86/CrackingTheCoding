package com.coding.searching_sorting;

/**
 * If the array is sorted but rotated search for any given element.
 * @author Rohit Dumbre 
 * @since X.X
 */
public class SearchFromRotatedArray
{

    private static int returnIndexFromRotatedSortedArray (int[] array, int value)
    {
        return pivotFromRotatedSortArray(array, 0, array.length - 1, value);
    }

    private static int pivotFromRotatedSortArray (int[] array, int left, int right, int value)
    {
       

        int pivot = (left + right) / 2;

        if (value == array[pivot])
            return pivot;
        
        if (right < left)
        {
            return -1;
        }
        
        if (value == array[left])
            return left;
        if (value == array[right])
            return right;

        if (array[left] < array[pivot]) // The left half is in increasing order.
        {
            if (array[left] <= value && value < array[pivot])
            {
                return pivotFromRotatedSortArray(array, left, pivot - 1, value);
            }

            return pivotFromRotatedSortArray(array, pivot + 1, right, value);
        }

        else if (array[left] > array[pivot])
        { // The right half is in increasing order.

            if (array[pivot] < value && value <= array[right])
            {
                return pivotFromRotatedSortArray(array, pivot+1, right, value);
            }
            return pivotFromRotatedSortArray(array, left, pivot-1, value);
        }
        else if (array[pivot] == array[left])
        {

            if (array[right] != array[left])
            {
                return pivotFromRotatedSortArray(array, pivot + 1, right, value);
            }

            int result = pivotFromRotatedSortArray(array, left, pivot - 1, value);
            if (result == -1)
            {
                return pivotFromRotatedSortArray(array, pivot + 1, right, value);
            }
            return result;
        }

        return -1;
    }

    public static void main (String[] args)
    {
        int[] array = new int[] {8,7, 1, 2, 4};
        for (int j = 0; j < array.length; j++)
        {
            System.out.println("Index : " + SearchFromRotatedArray.returnIndexFromRotatedSortedArray(array, array[j]));

        }
        
        System.out.println("Index :"+SearchFromRotatedArray.returnIndexFromRotatedSortedArray(new int[]{8,8,7,1,2,4}, 4));
    }

}
