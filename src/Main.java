/*
Available sorting methods:
- Bubblesort
- Selectionsort
- Insertionsort
- Quicksort
- Mergesort
- Heapsort

 */
public class Main {
    public static void main(String[] args) {

        int[] input = {18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};

    SortingAlgorithm object = new Insertionsort(input);
    object.sort();


    }

}
