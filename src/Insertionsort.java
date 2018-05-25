public class Insertionsort implements SortingAlgorithm {
    /* Fields */
    private int[] input;

    /* Constructor */
    Insertionsort(int[] input) {
        this.input = input;
    }


    /* Methods */
    public void sort() {
        insertionsort();
    }


    /**
     * Official take on insertion sort.
     * Uses a for-loop to iterate forward through all the
     * elements, and then a while-loop backwards (as long
     * as swapping is necessary AND j>0.
     * @return
     */
    private int[] insertionsort() {
        int size = input.length;
        int count = 0;
        for (int i=1;i<size;i++) {
            int key = input[i];
            int j = i-1;

            while (j>=0 && input[j]>key) {
                input[j+1] = input[j];
                j--;
                count++;
                System.out.println(count);
            }
            input[j+1] = key;
            printArray(input);
        }
        return input;
    }

    /**
     * My first take on insertionsort.
     * I used two for-loop in order to iterate first
     * forward through each element, and then backwards
     * once an element was to be swapped.
     * I think the main difference is the official
     * solution used a while-loop and also integrated
     * into it the inner if-condition statement. However
     * his code iterates backward only as many times as
     * swapping is possible. Whereas my for-loop iterates
     * a fixed number of times, comparing each time,
     * regardless of if swapping is needed.
     *
     * His code is also more succinct.
     * @return
     */
    private int[] insertionsort2() {
        int count =0;
        // iterate through each element
        // except the first one
        for (int i=0; i<input.length-1; i++) {
            if (input[i] > input[i+1]) {
                int temp = input[i];
                input[i] = input[i+1];
                input[i+1] = temp;

                // now iterate backwards
                for (int j=i; j>0;j--) {
                    if (input[j] < input[j-1]) {
                        int temp2 = input[j];
                        input[j] = input[j-1];
                        input[j-1] = temp2;
                    }
                    count++;
                    System.out.println(count);
                }
            }
        }
        printArray(input);

        return input;
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

