import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quicksort implements SortingAlgorithm {
    /* Fields */
    private int[] input;
    private static int count = 0;

    /* Constructor */
    Quicksort(int[] input) {
        this.input = input;
    }


    /* Methods */
    public void sort() {
        System.out.println("=== Quick Sort ===");
        System.out.println("You've asked to sort: ");
        printArray(input);
        System.out.println("\nThe sorted results are: ");
        printArray(quicksort(input,0,input.length-1));
        System.out.println("with " + count + " iterations.");
    }

    /**
     * I found quicksort a little harder to grasp. In the end I
     * copied the official solution for it and studied it while
     * I typed it.
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private int[] quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quicksort(arr,low,pi-1);
            quicksort(arr,pi+1,high);
        }

        return arr;
    }

    /**
     * Pivot partition for quicksort
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // pivot is last element
        int i = (low-1); // the "wall"
        for (int j=low; j<high; j++) {// iterate between low and high
            if (arr[j] <= pivot) {
                i++; // incremenet the "wall"

                // swap to left of wall
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap the pivot
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /**
     * Prints an Array inline
     * @param arr
     */
    private void printArray(int[] arr) {
        String line = "";
        for (int obj : arr) {
            line += Integer.toString(obj) + " ";
        }
        System.out.println("'" + line.substring(0,line.length()-1) + "'");
    }


}