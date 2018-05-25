/**
 * This is the sort where you find the smallest element
 * in given Array and push it to the result Array.
 * Although the official solution uses a method devoid
 * of result Array where the smallest element gets placed
 * by index of outer loop. I find it to be very clever.
 */
public class Selectionsort implements SortingAlgorithm {
    /* Fields */
    private int[] input;

    /* Constructor */
    Selectionsort(int[] input) {
        this.input = input;
    }


    /* Methods */
    public void sort() {
        selectionsort();
    }

    /**
     * The official method of selectionsort prevails
     * yet again. Superior to my method for using
     * 'swapping' to get around having to make a
     * second array, and also records index instead
     * of the actual number.
     * @return
     */
    private int[] selectionsort() {
        for (int i=0;i<input.length-1;i++) {
            int min_index = i;
            for (int j=i+1; j<input.length;j++) {
                if (input[min_index]> input[j]) {
                    min_index= j;
                }
            }
            // swap
            int tmp = input[min_index];
            input[min_index] = input[i];
            input[i] = tmp;
        }
        printArray(input);
        return input;
    }

    /**
     * My attempt at selectionsort.
     * There are two redundancies at least.
     * 1. I created a new array to store the sorted array.
     *    This caused excess overhead.
     *    It was clever of the official solution to use
     *    swapping to get around it. Since the value that
     *    was swapped out would find its right spot by
     *    replacement.
     * 2. Instead of recording the actual element value, I
     *    should have recorded its index. I would be able to
     *    get rid of one variable and a few lines of code
     *    this way.
     * @return
     */
    private int[] selectionsort2() {
        int[] result = new int[input.length];

        for (int j=0; j<result.length;j++) { // every spot in 'int[] result'
            int min = input[0];
            int count = 0;
            if (input.length != 0) {
                for (int i = 1; i < input.length; i++) { // smallest int
                    if (input[i] < min) {
                        min = input[i];
                        count = i;
                    }
                }
            }
            result[j] = min;
            input = removeElement(input,count);
            //printArray(input);
        }
        printArray(result);
        return result;
    }


    /**
     * Removes a number from given Array
     * @param arr0
     * @return
     */
    public int[] removeElement(int[] arr0, int index) {
        int[] arr = new int[arr0.length-1];
        int j = 0;
        for (int i=0; i<arr0.length-1; i++) {
            if (i != index) {
                arr[i]= arr0[j];
            }
            else {
                j++;
                arr[i] = arr0[j];
            }
            j++;
        }
        return arr;
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
