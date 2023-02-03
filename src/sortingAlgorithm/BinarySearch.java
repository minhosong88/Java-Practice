package sortingAlgorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//배열에서 중간 값을 선택해서 찾는 값과 비교, 그 값보다 크면 오른쪽 작으면 왼쪽으로 보내서 범위를 좁힌다.
public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = {45, 88, 74, 62, 22, 23, 41, 6, 9, 12};
        for (int i = 0; i < numbers.length; i++) {
            int j = i; //temp 처럼 치환한다.
            int temp = numbers[i];
            while (j > 0 && (numbers[j-1] > temp)) {
                numbers[j] = numbers[j - 1];
                j--;
            }
            numbers[j] = temp; //마지막에 배열 내 위치를 정해준다.
        }
        System.out.print("{");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]+" ");

        }
        System.out.print("}");
        System.out.println();
        int target = 9;

        int left = 0; // index
        int right = numbers.length-1; // index = length -1 bc it starts from 0.
        int mid = (left+right)/2;

        int temp = numbers[mid];
        boolean find = false;

        while (left <= right) {
            if (target == temp) {
                find = true;
                break;
            }
            if (target < temp) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (left+right)/2;
            temp = numbers[mid]; // insert new mid value
        }
        if (find == true) {
            mid++; // index starts from 0;
            System.out.println("Target is located at " + mid);
        } else {
            System.out.println("Target is unable to be found");
        }

    }
}
