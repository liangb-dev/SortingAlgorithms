# SortingAlgorithms

A collection of common sorting algorithms for practice. 
Each is written in its own class and implements a common interface - <a href=/src/SortingAlgorithm.java>SortingAlgorithm</a> -
and the common method - <i>sort()</i>, which looks something like this:
```java
1    public void sort() {
2        System.out.println("=== Insertion Sort ===");
3        System.out.println("You've asked to sort: ");
4        printArray(input);
5        System.out.println("\nThe sorted results are: ");
6        printArray(insertionsort());
7        System.out.println("with " + count + " iterations.");
8    }
```
Some classes have a sort1() or even sort2() because my original attempt was inferior to
the official solution but I wanted to keep the history for future record. 

<h2>Content</h2> 
<h3><a href=/src/Bubblesort.java>Bubblesort.java</a></h3></a>
<pre>
1    private int[] bubblesort() {
2        int n = input.length;
3        int temp;
4        for (int i = 0; i < n; i++) { // 1 iteration redundancy
5            for (int j = 1; j < n-i; j++) {
6                if (input[j-1] > input[j]) {
7                    //swap elements
8                    temp = input[j-1];
9                    input[j-1] = input[j];
10                    input[j] = temp;
11                }
12            }
13        }
14        return input;
15    }
</pre>
<a href=/src/Heapsort.java><h3>Heapsort.java</h3></a>
<pre>

</pre>
<h3><a href=/src/Insertionsort.java>Insertionsort.java</a></h3>
<pre>
1    private int[] insertionsort() {
2        int size = input.length;
3        for (int i = 1; i < size; i++) {
4            int key = input[i];
5            int j = i-1;
6            while (j >= 0 && input[j] > key) {
7                input[j+1] = input[j];
8                j--;
9            }
10            input[j+1] = key;
11       }
12        return input;
13    }
</pre>
<h3><a href=/src/Mergesort.java>Mergesort.java</a></h3>
<pre>

</pre>
<h3><a href=/src/Quicksort.java>Quicksort.java</a></h3>
<pre>
1  private int[] quicksort(int[] arr, int low, int high) {
2        if (low < high) {
3            int pi = partition(arr, low, high);
4            quicksort(arr, low, pi-1);
5            quicksort(arr, pi+1, high);
6        }
7        return arr;
8    }
9   private int partition(int[] arr, int low, int high) {
10        int pivot = arr[high]; // pivot is last element
11        int i = (low-1); // the "wall"
12        for (int j = low; j < high; j++) {// iterate between low and high
13            if (arr[j] <= pivot) {
14                i++; // incremenet the "wall"
15                // swap to left of wall
16                int temp = arr[i];
17                arr[i] = arr[j];
18                arr[j] = temp;
19            }
20        }
21        // swap the pivot
22        int temp = arr[i+1];
23        arr[i+1] = arr[high];
24        arr[high] = temp;
25        return i+1;
26    }
</pre>
<h3><a href=/src/Selectionsort.java>Selectionsort.java</a></h3>
<pre>
1    private int[] selectionsort() {
2        for (int i = 0;i < input.length-1; i++) {
3            int min_index = i;
4            for (int j = i+1; j < input.length; j++) {
5                if (input[min_index] > input[j]) {
6                    min_index= j;
7                }
8                count++;
9            }
10            // swap
11            int tmp = input[min_index];
12            input[min_index] = input[i];
13            input[i] = tmp;
14        }
15        printArray(input);
16        return input;
17    }
</pre>
