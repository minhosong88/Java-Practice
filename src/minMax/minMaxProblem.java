package minMax;

public class minMaxProblem {
//배열의 첫 숫자를 max와 min으로 가정해서 처음부터 배열 마지막까지 비교하면서 더 큰 수나 작은 수가 나올 때 min, max
//값을 바꾸도록 한다.
    public static void main(String[] args) {

        int[] numbers = {11, 54, 27, 65, 7, 3, 88, 46, 33, 79};

        int min = numbers[0]; // number in the index
        int max = numbers[0];
        int minPos = 0; // index
        int maxPos = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
                minPos = i + 1;
            }
            if (max < numbers[i]) {
                max = numbers[i];
                maxPos = i + 1;
            }

        }
        System.out.println("Min : " + min + " Position: " + minPos);
        System.out.println("Max : " + max + " Position: " + maxPos);

    }
}
