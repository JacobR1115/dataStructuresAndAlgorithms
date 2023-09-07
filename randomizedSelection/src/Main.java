import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] array = {4, 7, 8, 6, 10, 12, 13, 1, 19};
        // Want to return the second 2nd order statistic in this case 4
        int target = 4;
        int returned = selection(array, 0, array.length - 1, target);
        System.out.println(array[returned]);
    }

    public static int selection(int[] array, int low, int high, int target) {
        if (high == 0) return 0;
        // Partition the array and then return the index of the pivot
        int returned = partition(array, 0, array.length -1);

        // If the return index is the ith order statistic then return the element at the return index
        if ((returned + 1) == target) return returned;
        else if ((returned + 1) > target) {
            return selection(array, low, returned - 1, target);
        } else {
            return selection(array, returned + 1, high, target);
        }
    }

    public static int partition(int[] array, int low, int high) {
        // Partition the array and then return the index of the pivot
        random(array, low, high);

        int p = array[high];

        int i = low - 1;

        for (int j = low; j <= high; j++) {
            if (array[j] < p) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static void random(int[] array, int low, int high) {
        Random rand = new Random();

        int p = rand.nextInt(high - low) + low;

        int temp = array[high];
        array[high] = array[p];
        array[p] = temp;
    }
}

