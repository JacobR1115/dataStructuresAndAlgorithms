import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int array[] = { 3, 4, 5, 6, 7, 8, 9 };
        int n = array.length;
        System.out.println("Input a target value");
        int target = Integer.valueOf(scanner.nextLine());
        int result = binarySearch(array, target, 0, n - 1);
        if (result == -1)
            System.out.println("Not found");
        else
            System.out.println("Element found at index " + result);
    }


    // "array" needs to be a sorted array
    // assumes it is sorted from least to greatest
    public static int binarySearch(int[] array, int target, int low, int high) {

        if (high >= low)  {
            int mid = low + (high - low) / 2;
            // If found at mid, then return it
            if (array[mid] == target) return mid;
            // Search the left half
            else if (array[mid] > target) return binarySearch(array, target, low, mid - 1);
            // Search the right half
            else return binarySearch(array, target, mid + 1, high);
        }

        return -1;
    }
}
