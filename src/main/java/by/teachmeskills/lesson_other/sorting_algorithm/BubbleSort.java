package by.teachmeskills.lesson_other.sorting_algorithm;

//Эффективность любого алгоритма измеряют с помощью нотации «О».
// «О» отвечает за количество простых операций, которые должен выполнить алгоритм, и может измерять потраченное время или память.
// Например, сколько операций нужно сделать, чтобы отсортировать массив чисел или найти наименьшее значение.

//O(n^2) — количество проверок будет равно n^2, где n — количество элементов.
public class BubbleSort {
    public void bubbleSort(int[] array) {
        boolean isSorted = false;
        int temp;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
    }
}
