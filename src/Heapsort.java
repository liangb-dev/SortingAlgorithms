public class Heapsort implements SortingAlgorithm {
    /* Fields */
    private int[] input;

    /* Constructor */
    Heapsort(int[] input) {
        this.input = input;
    }


    /* Methods */
    public void sort() {
        heapsort();
    }

    private int[] heapsort() {


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