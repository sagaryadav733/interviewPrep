package Test1;

public class SingleElementInArray {

    public static int findSingleElement(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 4, 3, 2};
        int singleElement = findSingleElement(nums);
        System.out.println("The single element is: " + singleElement);
    }
}
