package com.coding.searching_sorting;

import java.util.Arrays;

/**
 * Sort the elements in wave form.
 * 
 * @author Rohit Dumbre
 * @since X.X
 */
public class SortElementsinWaveForm
{

    public static void sortElementsInWaveForm_I (int[] wave)
    {
        Arrays.sort(wave);

        for (int i = 1; i < wave.length; i++)
        {
            int temp = wave[i];
            wave[i] = wave[i - 1];
            wave[i - 1] = temp;
            i++;
        }

        for (int i = 0; i < wave.length; i++)
        {
            System.out.print(wave[i] + " ");
        }

        System.out.println();
    }
    
    
    public static void sortElementsInWaveForm_II(int[] wave)
    {
        for (int i = 0; i < wave.length; i++)
        {
            if(i > 0 && wave[i-1] > wave[i])
            {
                int temp = wave[i];
                wave[i] = wave[i - 1];
                wave[i - 1] = temp;
            }
            else if(i<wave.length-1 && wave[i] < wave[i+1])
            {
                int temp = wave[i];
                wave[i] = wave[i + 1];
                wave[i + 1] = temp;
            }
        }
        
        for (int i = 0; i < wave.length; i++)
        {
            System.out.print(wave[i] + " ");
        }
    }

    public static void main (String[] args)
    {
        System.out.println("Solution 1");
        SortElementsinWaveForm.sortElementsInWaveForm_I(new int[] {10, 5, 6, 3, 2, 20, 100, 80});
        System.out.println("Solution 2");
        SortElementsinWaveForm.sortElementsInWaveForm_II(new int[] {10, 5, 6, 3, 2, 20, 100, 80});

    }

}
