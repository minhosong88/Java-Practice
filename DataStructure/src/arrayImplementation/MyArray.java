package arrayImplementation;

public class MyArray {

    int[] intArr;
    int count;

    public static int ARRAY_SIZE;
    public final int ERROR_NUM = 99999999;

    public MyArray() {
        count = 0;
        ARRAY_SIZE = 10;
        intArr = new int[ARRAY_SIZE];
    }

    public int getSize() {
        return count;
    }

    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        else return false;
    }

    public int getElement(int position) {
        if (position < 0 || position > count - 1) { // 배열의 물리적 조건에 부합하지 않으면.
            System.out.println("Search Error, current count in the list is " + count+ ".");
            return ERROR_NUM;
        }
        return intArr[position]; //배열에서 입력된 지역변수의 값(정수)의 위치에 있는 값을 부른다.
    }

    public void addElement(int num) {
        if (count > ARRAY_SIZE) {
            System.out.println("not enough memory");
            return;
        }
        intArr[count++] = num; //intArr[count] = num 계산 후 count 값을 1 올려준다. count는 Element의 개수 이므로 1부터 카운트.
    }
    public void insertElement(int position, int num) {
        int i;
        if (count > ARRAY_SIZE) {
            System.out.println("not enough Memory");
            return;
        } else if (position < 0 || position >= count) {
            System.out.println("insert Error");
            return;
        }
        for (i = count - 1; i >= position; i--) {
            intArr[i + 1] = intArr[i]; // 들어가려는 자리보다 i(마지막 자리)가 크거나 같으면  한 자리씩 내려온다.
            //원래 position자리에 위치한 값은 [i+1]자리로 들어가고 intArr[position]은 빈자리가 된다.
        }
        intArr[position] = num; //num을 빈 자리에 채워준다.
        count++; // 숫자가 하나 끼어 들어갔으므로 count는 하나 늘어난다.
    }

    public int removeElement(int position) {
        int ret = ERROR_NUM;
        if (isEmpty()) {
            System.out.println("the list is currently empty.");
            return ret;
        }
        else if(position <0 || position > count -1){
            System.out.println("search error");
            return ret;
        }
        ret = intArr[position];
        int i;
        for(i = position; i <= count-1 ; i++){ // position 값에 있던 수가 빠져나갔다. 그 윗 수들을 아래로 당겨온다.
            intArr[i] = intArr[i + 1];
        }
        count --;
        return ret;
    }

    public void printAll() {
        if (count == 0) {
            System.out.println("no available data to print.");
        }
        int i;
        for(i = 0; i < count ; i++){
            System.out.print(intArr[i]);
            System.out.println();

        }
    }
}
