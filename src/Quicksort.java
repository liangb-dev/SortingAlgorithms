
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
        printArray(quicksort());
        System.out.println("with " + count + " iterations.");
    }

    private int[] quicksort() {


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