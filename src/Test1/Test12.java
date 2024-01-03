package Test1;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test12 {

    public static void getIndex(int[] arr , int sum){
        //int[] arr = {1,2,3,6,7,21,22,24}
        int[] result =new int[2];
        int start = 0;
        int end = arr.length -1;
        while(start < end){
            int tempSum = arr[start] + arr[end];
            if(tempSum == sum){
                result[0] = start;
                result[1] = end;
                System.out.println("The two index are : " +start +" and " + end);
                start ++;
                end -- ;

         }
         else if(tempSum > sum){
             end --;
         }
         else {
             start ++;
         }
        }
    }

    public static void merge(int[] arr1 ,int[] arr2){
        int i = 0;
        int j = 0;
        int size1 = arr1.length -1;
        int size2 = arr2.length -1;
        while(i <= size1 && j <= size2){
            if(arr1[i] > arr2[j]){
                swap(arr1,arr2,i,j);
                i++;

            }else if (arr1[i] == 0) {
                swap(arr1, arr2, i, j);
                j++;
                i++;
            }
            else if (arr1[i] <= arr2[j]) {
                i++;
            }


        }
        }


    public static void swap(int[] arr1 , int[] arr2 , int idx1 ,int idx2){
        int temp =arr1[idx1];
        arr1[idx1] = arr2[idx2];
        arr2[idx2] = temp;
    }


    public static void main(String args[]){
        int[] arr = {1,2,3,6,7,21,22,24};
        getIndex(arr ,25);

        int arr1[] = {1,2,3,0,0,0};
        int arr2[] = {2,5,6};

        String input = "New York City, the most populous city in the United States, located in the state of NEW YORK";

        String output = Arrays.stream(input.split("\\s+")).
                filter(word -> word.length() < 5).
                map(word1 -> word1.toUpperCase())
                .distinct()
                .collect(Collectors.joining(" "));
        System.out.println(output);


    }

}
