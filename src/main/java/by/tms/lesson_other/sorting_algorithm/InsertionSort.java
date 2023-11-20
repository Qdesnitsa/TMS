package by.tms.lesson_other.sorting_algorithm;

//O(n^2)
public class InsertionSort {
//Sorted - all items to the left are smaller
    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int currentValue = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > currentValue) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = currentValue;
        }
    }
}
