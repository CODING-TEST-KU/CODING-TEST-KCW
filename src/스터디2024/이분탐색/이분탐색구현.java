package 스터디2024.이분탐색;

public class 이분탐색구현 {
    static int[] arr;

    public static void main(String[] args) {

        arr = new int[5];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i*2 + 1;
        }
        int i = binarySearch(0, arr.length - 1, 0);
        System.out.println(i);

    }

    public static int binarySearch(int start, int end, int key){

        int middleIndex = (end + start) /2;
        if(end < start){
            if(end < 0)
                return 0;
            else
                return arr.length;
        }

        if(arr[middleIndex] == key){
            return middleIndex;
        }
        if(arr[middleIndex] > key){
            if(start == end)
                return middleIndex + 1;
            return binarySearch(start, middleIndex - 1, key);
        }
        if(arr[middleIndex] < key){
            if(start == end)
                return middleIndex;
            return binarySearch(middleIndex + 1, end, key);
        }

        return -1;
    }
}

