import java.util.ArrayList;

/**
 * Bubblesort is the one where you take every element
 * and swap it with its neighbor until every element
 * has been put in its place.
 */
public class Bubblesort implements  SortingAlgorithm {
    /* Fields */
    private int[] input;
    private int count = 0;

    /* Constructor */
    Bubblesort(int[] input) {
        this.input = input;
    }

    /* Methods */
    public void sort() {
        System.out.println("=== Bubble Sort ===");
        System.out.println("You've asked to sort: ");
        printArray(input);
        System.out.println("\nThe sorted results are: ");
        printArray(bubblesort());
        System.out.println("with " + count + " iterations.");
    }


    /**
     * Official solution to bubblesort()
     * Only redundancy was that you really only need to
     * sort n-1 items since the last item is automatically
     * in order because everything else is sorted.
     * @return
     */
    private int[] bubblesort() {
        int n = input.length;
        int temp;

        for (int i=0; i<n; i++) { // 1 iteration redundancy
            for (int j=1; j<n-i; j++) {
                if (input[j-1] > input[j]) {
                    //swap elements
                    temp = input[j-1];
                    input[j-1] = input[j];
                    input[j] = temp;
                }
                count++;
            }
        }

        return input;
    }

    /**
     * My original take on bubblesort(). I used quite a few redundant
     * methods.
     * 1. I thought an Array would be easier to handle as an ArrayList.
     *    But it doesn't look like it was necessary, since very list
     *    transformations were necessary. This also increased a number
     *    of utility methods. Array conversion redundancy.
     * 2a. I originally used a while-method as outer loop that would
     *    keep on iterating until the Array was sorted, and each time
     *    it would check if the Array was sorted through a deprecated
     *    method called isArraySorted(). When I realized I could just
     *    use a for-loop that would iterate through each element exactly
     *    once, I substituted out the while-loop. While-loop redundancy.
     * 2b. The deprecated method isArraySorted() was replaced by a
     *    boolean flag 'isSorted'. This flag is false by default, meaning
     *    that the while-loop would break. However it is made true,
     *    everytime a swap occurs. In other words, only in the iteration
     *    through the array where no swaps occur (meaning everything is
     *    sorted) does the while-loop break. Method 'isArraySorted()'
     *    redundancy, but 'isSorted' was later also made redundant by
     *    the while-loop redundancy.
     * 3. The two for-loops each iterate n times, both of them. This
     *    doesn't take into account that the numbers that have already
     *    been sorted do not need to be sorted again. So this resulted
     *    in BigO = N^2 runtime. In order to counter that, I invented
     *    a boolean flag called 'firstTimer'. The flag lets you "step
     *    in" once an element swap happens and when they swapping "streak"
     *    ends, it also ends the rest of the for-loop (through 'break'),
     *    and skips over the numbers that have already been sorted.
     *    This method has two assumptions, one of them being wrong.
     *    1) as soon as the streak ends, there is no longer need to loop
     *    through the rest of the for-loop because the rest of the numbers
     *    are already sorted. Correct.
     *    2) You need to record when the swapping "streak" begins.
     *       Allowing you to jump over any initial numbers that dont
     *       need sorting. This is redundant because the comparator
     *       automatically filters out numbers that are sorted.
     *     This redundancy would easily be eliminated by taking into
     *     consideration the number of already sorted numbers when
     *     defining the inner nested loop, which happens to equal 'i'
     *     in the outer loop, since each outer loop iteration sorts one
     *     number. So the inner loop really only needs to iterate
     *     through n-i times.
     * @return
     */
    private int[] bubblesort2() {

        // Array converted to ArrayList for easier handling
        //List input_list = Arrays.asList(this.input);
        //ArrayList<Integer> input = new ArrayList<Integer>(input_list);

        ArrayList<Integer> input = Array2ArrayList(this.input);

        //int count = 0;
        //int count2 = 0;
        //boolean isSorted = true; // circumvents isArraySorted method
        boolean firstTimer; // flags when an element begins swapping sequence
        //int counter = input.size()-1;

        for (int j=0;j<input.size()-1;j++)
        //while (isSorted)
        {
            //isSorted = false; // exits while-loop unless disorder detected
            //System.out.println(count);
            firstTimer = true;

            for (int i = 0; i < input.size()-1; i++) {
                if (firstTimer && input.get(i) > input.get(i+1)) { // when an element begins swapping sequence
                    swapElements(input, i,i+1);
                    //isSorted = true; // disorder detected
                    //System.out.println("first timer");
                    //printArrayList(input);
                    firstTimer = false;
                }
                else if (firstTimer == false) {
                    if (input.get(i) > input.get(i + 1)) {
                        swapElements(input, i, i + 1);
                        //printArrayList(input);
                        //isSorted = true; // disorder detected
                    } else {
                        //System.out.println("streak broke");
                        //counter--;
                        break;
                    }
                }

                /*
                if (counter == 1) {
                    System.out.println("Ending");
                    break;
                }
                */
                //System.out.println("i: " + i);
                //System.out.println(count2);
                //count2++;

            }
            //count++;
        }

        return Arraylist2Array(input);
    }


    /**
     * Swaps the numbers of 'ArrayList input' at indexes 'int x' and
     * 'int y'
     * @param input
     * @param x
     * @param y
     */
    private void swapElements(ArrayList<Integer> input, int x, int y) {
        // Placeholder Integer variable for 'int x'
        int z = input.get(x);
        // Perform swaps
        input.set(x, input.get(y)); // Set index[x] = input.get(y);
        input.set(y, z); // Set index[y] = z;
    }

    /**
     * Just a method used to print the ArrayList
     * @param x
     */
    private void printArrayList(ArrayList<Integer> x) {
        String line = "";
        for (int num : x) {
            line += Integer.toString(num) + " ";
        }
        System.out.println(line + "\n");
    }

    /**
     * Converts an ArrayList into an Array
     * @param arr
     * @return
     */
    private int[] Arraylist2Array(ArrayList<Integer> arr) {
        int[] result = new int[arr.size()];
        int i = 0;
        for (int x : arr) {
            result[i] = x;
            i++;
        }
        return result;
    }

    /**
     * Converts an Array into an ArrayList
     * @param arr
     * @return
     */
    private ArrayList<Integer> Array2ArrayList(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        for (int x : arr) {
            result.add(arr[i]);
            i++;
        }
        return result;
    }

    /**
     * @deprecated Made redundant by boolean flag isSorted
     * Judges whether the given Array has been sorted.
     * @param arr
     * @return
     */
    private boolean isArraySorted(ArrayList<Integer> arr) {
        for (int i=0;i<arr.size()-1;i++) {
            if (arr.get(i) > arr.get(i+1)) {
                return false;
            }
        }
        return true;
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
