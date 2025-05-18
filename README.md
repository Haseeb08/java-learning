# java-learning

### ✅ Compile and run

    Compile - javac FileName.java
    Run - java package_name.FileName

Example

    javac src/sorting_algorithms/BubbleSort.java
    java sorting_algorithms.BubbleSort


<details>
<summary> 🔍 <strong>Searching Algorithms</strong></summary>

#### 📂 Contents

| #  | Algorithm       | File Name                                                           | Description                                                                              |
|----|-----------------|---------------------------------------------------------------------|------------------------------------------------------------------------------------------|
| 1  | Linear Search   | [LinearSearch.java](src/searching_algorithms/LinearSearch.java)     | Iteratively checks each element                                                          |
| 2  | Binary Search   | [BinarySearch.java](src/searching_algorithms/BinarySearch.java)     | Efficient search on sorted arrays (recursive + iterative) <br/> using low, mid and high. |


#### ⏱️ Time and Space Complexities

| #  | Algorithm       | Time Complexity (Best / Average / Worst) | Space Complexity                        |
|----|-----------------|-------------------------------------------|-----------------------------------------|
| 1  | Linear Search   | O(1) / O(n) / **O(n)**                   | O(1)                                    |
| 2  | Binary Search   | O(1) / O(log n) / **O(log n)**           | O(log n) (recursive), O(1) (iterative)  |

</details>

<details> <summary>🔁 <strong>Sorting Algorithms</strong></summary>

#### 📂 Contents

| #  | Algorithm       | File Name                                                     | Description                              |
|----|-----------------|---------------------------------------------------------------|------------------------------------------|
| 1  | Bubble Sort     | [BubbleSort.java](src/sorting_algorithms/BubbleSort.java)                 | Repeatedly swaps adjacent elements       |
| 2  | Selection Sort  | [SelectionSort.java](src/sorting_algorithms/SelectionSort.java)           | Selects the minimum element in each pass |
| 3  | Insertion Sort  | [InsertionSort.java](src/sorting_algorithms/InsertionSort.java)           | Builds sorted array one item at a time   |
| 4  | Merge Sort      | [MergeSort.java](src/sorting_algorithms/MergeSort.java)                   | Divide and conquer algorithm             |
| 5  | Quick Sort      | [QuickSort.java](src/sorting_algorithms/QuickSort.java)                   | Efficient divide and conquer sort        |
| 6  | Heap Sort(ToDo) |                      | Uses a binary heap to sort elements      |
| 7  | Counting Sort(ToDo)   |              | Non-comparative integer sorting algorithm|
| 8  | Radix Sort(ToDo)      |                    | Sorts using digit positions (radix base) |


#### ⏱️ Time and Space Complexities

| #  | Algorithm       | Time Complexity (Best / Average / Worst) | Space Complexity |
|----|-----------------|-------------------------------------------|------------------|
| 1  | Bubble Sort     | O(n) / O(n²) / **O(n²)**                  | O(1)             |
| 2  | Selection Sort  | O(n²) / O(n²) / **O(n²)**                 | O(1)             |
| 3  | Insertion Sort  | O(n) / O(n²) / **O(n²)**                  | O(1)             |
| 4  | Merge Sort      | O(n log n) / O(n log n) / **O(n log n)**  | O(n)             |
| 5  | Quick Sort      | O(n log n) / O(n log n) / **O(n²)**        | O(log n)         |


</details>