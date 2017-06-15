package com.coding.searching_sorting;

/**
 * Given an MxN matrix sorted row-wise and coloumn wise. Find the co-ordinates if it exists.
 * 
 * @author Rohit Dumbre
 * @since X.X
 */
public class SearchingThroughMatrix
{

    private static void printSearchCoordValueFromMatrix (int[][] array, int key)
    {

        int[] columnArray = new int[array.length];

        for (int i = 0; i < columnArray.length; i++)
        {
            columnArray[i] = array[i][0];
        }

        int row = getRange(columnArray, key);

        if (row == -1)
        {
            System.out.println("Value " + key + " not found");
            return;
        }

        if (array[row][0] == key)
        {
            System.out.println("The element " + key + " exists at row:" + row + " column:0");
            return;
        }

        int coloumn = getElementIfItExist(array[row], 0, array[row].length - 1, key);

        if (row >= 0 && coloumn >= 0)
        {
            System.out.println("The element " + key + " exists at row:" + row + " column:" + coloumn);
        }
        
        if(coloumn == -1)
        {
            System.out.println("Value " + key + " not found");
            return;
        }
    }

    private static int getElementIfItExist (int[] array, int low, int high, int key)
    {
        int mid = (low + high) / 2;

        if (high < low)
            return -1;

        if (array[mid] == key)
            return mid;
        if (array[low] == key)
            return low;
        if (array[high] == key)
            return high;

        if (array[mid] > key)
        {
            return getElementIfItExist(array, low, mid - 1, key);
        }

        return getElementIfItExist(array, mid + 1, high, key);

    }

    private static int getRange (int[] array, int key)
    {
        if (array[0] == key)
            return 0;
        if (array[array.length - 1] < key)
            return array.length - 1;

        for (int i = 1; i <= array.length - 1; i++)
        {
            if (array[i - 1] <= key && key < array[i])
            {
                return i - 1;
            }
            if (key == array[i])
            {
                return i;
            }
        }

        return -1;
    }

    public static void main (String[] args)
    {
        int[][] matrix = {{1, 2, 3, 4}, //
                {5, 7, 9, 11}, //
                {15, 19, 22, 24}, //
                {31, 34, 35, 37}, //
                {45, 49, 50, 54}, //
                {66, 67, 68, 69}, //
        };

        for (int[] levels : matrix)
        {
            for (int element : levels)
            {
                SearchingThroughMatrix.printSearchCoordValueFromMatrix(matrix, element);
            }
        }

        SearchingThroughMatrix.printSearchCoordValueFromMatrix(matrix, 78);

    }

}
