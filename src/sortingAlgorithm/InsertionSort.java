package sortingAlgorithm;

public class InsertionSort {

    public static void insertionSort(int[] arr, int count) {
        int i = 0, j = 0;
        int temp = 0;

        for (i = 1; i < count; i++) {
            j = i;
            temp = arr[i];
            while ((j>0)&&(arr[j-1]>temp)) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
            System.out.println("Repeat - " + i);
            printsort(arr, count);
        }
    }

    public static void printsort(int value[], int count) {
        int i = 0;
        for (i = 0; i < count; i++) {
            System.out.print(value[i]+"\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {45, 88, 74, 62, 22, 23, 41, 6, 9, 12};
        insertionSort(arr, 10);

    }
}
