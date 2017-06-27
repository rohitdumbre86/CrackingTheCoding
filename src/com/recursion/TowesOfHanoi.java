package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * WIP to implement towers of hanoi problem.
 * 
 * @author Rohit Dumbre
 * @since X.X
 */
public class TowesOfHanoi
{
    private static int index = 0;

    public static void main (String[] args)
    {

        int[] arr2 = new int[7];
        int[] arr3 = new int[7];

        int[] arr1 = new int[] {7, 6, 5, 4, 3, 2, 1};

        System.out.println("Before calling Towers of Hanoi");
        System.out.print("Peg A : ");

        for (int i = 0; i < arr1.length; i++)
        {
            System.out.print(arr1[i] + " ");
        }
        
        System.out.println();

        System.out.print("Peg C : ");

        for (int i = 0; i < arr3.length; i++)
        {
            System.out.print(arr3[i] + " ");
        }

        towersOfHanoi(arr1, arr2, arr3);
        
        System.out.println();

        System.out.println("After calling Towers of Hanoi");
        System.out.print("Peg A : ");

        for (int i = 0; i < arr1.length; i++)
        {
            System.out.print(arr1[i] + " ");
        }

        System.out.println();

        System.out.print("Peg C : ");

        for (int i = 0; i < arr3.length; i++)
        {
            System.out.print(arr3[i] + " ");
        }

    }

    private static void towersOfHanoi (int[] arr1, int[] arr2, int[] arr3)
    {
        if (arr2[0] == 0 && arr1[0] == 0)
        {
            return;
        }
        else if (arr3[0] != 0 && (arr2[0] != 0 || arr1[0] != 0))
        {
            towerTransfer(arr1, arr2);
            resettingTower(arr1, arr2, arr3);
            towerTransfer(arr2, arr3);
            return;
        }

        while (arr1[0] != 0)
        {
            towerTransfer(arr1, arr2);
            towerTransfer(arr1, arr3);
            towerTransfer(arr2, arr3);

            towersOfHanoi(arr1, arr2, arr3);
        }

    }

    private static void resettingTower (int[] arr1, int[] arr2, int[] arr3)
    {

        int i = 0;
        while (i < arr2.length && arr2[i] != 0)
        {
            i = i + 1;
        }

        i = i == 0 ? 0 : i - 1;
        int topValue = arr2[i];

        int j = 0;
        while (j < arr3.length && topValue < arr3[j])
        {
            j++;
        }

        int k = 0;
        while (k < arr1.length && arr1[k] != 0)
        {
            k++;
        }

        for (int k2 = k; k2 < arr1.length && arr3[j] != 0; k2++)
        {
            arr1[k2] = arr3[j];
            arr3[j] = 0;
            j++;
        }

    }

    private static void towerTransfer (int[] arr1, int[] arr2)
    {
        int i = 0;
        while (i < arr1.length && arr1[i] != 0)
        {
            i++;
        }

        i = i == 0 ? 0 : i - 1;

        int j = 0;
        while (j < arr2.length && arr2[j] != 0)
        {
            j++;
        }

        arr2[j] = arr1[i];
        arr1[i] = 0;

    }

}
