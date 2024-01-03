package Test1;

import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] arr , int number){
        int low = 0;
        int size = arr.length;
        int high = size -1;
        int mid = size /2 ;
        while(low <= high){
            if(arr[mid] == number)
                return mid;
            if(number > arr[mid]){
                low = mid +1;
            }
            else
                high = mid -1;
            mid = (low + high )/2;
        }
        return -1;
    }

    public static int searchWithPivot(int[] arr , int h,int l,int key){
        if(h < l)
            return -1;
        int mid = h +l /2;
        if(arr[mid] == key)
            return mid;

        if(arr[l] <= arr[mid]){
            if(key >= arr[l] && key <= arr[mid])
               return searchWithPivot(arr ,mid -1,l,key);
          return searchWithPivot(arr, h,mid+1,key);
        }
        if(key >= arr[mid] && key <= arr[h])
            return searchWithPivot(arr ,h ,mid+1 ,key);
        return searchWithPivot(arr , mid-1 ,l ,key);

    }

    public static void rotateLeft(int[] arr , int d){
        // 1,2,3,4,5,6,7 -> 3,4,5,6,7,1,2
        rotate(arr ,0,d-1);
        rotate(arr,d,arr.length-1);
        rotate(arr ,0,arr.length-1);
    }
    public static void rotate(int[] arr , int start ,int end){
        while(start < end){
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end-- ;

        }

    }
 public static int[] merge(int[] arr1 , int[] arr2){
        int size1 = arr1.length;
        int size2 = arr2.length;
        int[] result = new int[size1 + size2];
        int i=0,j=0,k =0;
        while (i < size1 && j <size2){
            if(arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            }
            else {
                result[k++] = arr2[j++];
            }
        }
        while(j < size2) {
            result[k++] =arr2[j++];
        }
        while(i <size1){
            result[k++] = arr1[i++];
        }
        return result;

 }

    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(binarySearch(arr, 2));

        int[] arr1 = {4,5,6,7,1,2,3};
        System.out.println(searchWithPivot(arr1, arr1.length-1, 0,8));

        rotateLeft(arr,2);
        Arrays.stream(arr).forEach(System.out::println);
        int[] a1 = {1,2,3,4,5};
        int[] a2 = {6,7};
        System.out.println("Merge");
        Arrays.stream(merge(a1,a2)).forEach(System.out::println);

    }


}
