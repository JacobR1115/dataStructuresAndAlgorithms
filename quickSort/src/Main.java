import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] array = {3, 8, 2, 5, 1, 4, 7, 6};
        System.out.println(Arrays.toString(array));
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array, int low, int high) {
        // base case
        if (high <= low) return;

        int i = partition(array, low, high);

        // Recursively sort the left and right halves
        sort(array, low, i);
        sort(array, i + 2, high);

    }

    public static int partition(int[] array, int low, int high) {

        random(array, low, high);
        int p = array[high];

        // i = divider between elements <p and elements >p
        // j = divider between the partitioned and unpartitioned elements
        int i = low - 1;

        // Partition the array around the pivot point p
        for (int j = low; j < high; j++) {
            if (array[j] < p) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // position the pivot element in its sorted index
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i;
    }

    public static void random(int[] array, int low, int high) {
        Random rand= new Random();
        int p = rand.nextInt(high - low) + low;

        int temp =  array[p];
        array[p] = array[high];
        array[high] = temp;
    }
}

