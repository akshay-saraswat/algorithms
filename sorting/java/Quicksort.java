/*
 * Time Complexity (Average Case) - O(NlogN)
 * Time Complexity (Worst Case) - O(N^2)
 * Space Complexity - O(logN) 
 */

import java.util.*;

// Define class
public class Quicksort {

    static final int SIZE = 10;

    public static void main (String[] args) {
        int[] array = getArray();

        System.out.println("\nBefore:");
        printArray(array);

        // Capture start time
        long start_time = System.nanoTime();

        // Sort array
        quickSort(array, 0, array.length - 1);

        // Cpature end time and calculate time elapsed in sorting
        long time_elapsed = System.nanoTime() - start_time;

        System.out.println("\nAfter:");
        printArray(array);

        System.out.println("\nTime-elapsed = " + time_elapsed + " nano seconds");
    }

    /*
     * Swap elements
     */
	public static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}


	public static void quickSort(int[] array, int start, int end)
	{
            // Left most point to move right
	        int i = start;

            // Right most element to move left
	        int k = end;

            // check that there are at least two elements to sort
	        if (end - start >= 1)
	        {
                    // set the pivot as the first element in the partition
	                int pivot = array[start];

                    // while the scan indices from left and right have not met,
	                while (k > i)
	                {
                            // from the left, look for the first element greater than the pivot
	                        while (array[i] <= pivot && k > i)
	                                i++;
                            // from the right, look for the first element not greater than the pivot
	                        while (array[k] > pivot && k >= i)
	                            k--;
                            // if the left seekindex is still smaller than the right index,
	                        if (k > i)
                                    // swap the corresponding elements
	                                swap(array, i, k);
	                }

                    // after the indices have crossed, swap the last element in the left partition with the pivot
	                swap(array, start, k);

                    // quicksort the left partition
	                quickSort(array, start, k - 1);

                    // quicksort the right partition
	                quickSort(array, k + 1, end);
            } else {
                // if there is only one element in the partition,
                // do not do any sorting the array is sorted, so exit
                return;
	        }
	}

    /*
     * Print existing array elements
     */
	public static void printArray(int[] array) {
			System.out.println(Arrays.toString(array));
	}

    /*
     * Create and fill an int array withe elements
     */
	public static int[] getArray() {
        // Create an array
		int[] array = new int[SIZE];

        // Fill array with randome numbers
        for(int i = 0; i < SIZE; i++)
            array[i] = (int)(Math.random()*100);

        return array;
	}
}
