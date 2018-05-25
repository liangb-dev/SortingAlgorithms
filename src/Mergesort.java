public class Mergesort implements SortingAlgorithm {
    /* Fields */
    private int[] input;
    private static int count = 0;

    /* Constructor */
    Mergesort(int[] input) {
        this.input = input;
    }


    /* Methods */
    public void sort() {
        System.out.println("=== Merge Sort ===");
        System.out.println("You've asked to sort: ");
        printArray(input);
        System.out.println("\nThe sorted results are: ");
        printArray(mergesort());
        System.out.println("with " + count + " iterations.");
    }

    private int[] mergesort() {


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