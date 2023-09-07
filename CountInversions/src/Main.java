import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {10, 9, 1, 3, 29, 54, 101, 98, 41, 5, 7, 8, 2, 4, 6};
        System.out.println(Arrays.toString(array));
        int numberOfInversions = sortAndCountInversions(array);
        System.out.println(Arrays.toString(array));
        System.out.println(numberOfInversions);
    }

    public static int sortAndCountInversions(int[] array) {
        int arrayLength = array.length;
        int numberOfInversions = 0;

        // Base case
        if (arrayLength <= 1) return numberOfInversions;

        // Split the array into a left and right
        int mid = (arrayLength / 2) + (arrayLength % 2);
        int[] left = Arrays.copyOfRange(array, 0 , mid);
        int[] right = Arrays.copyOfRange(array, mid, arrayLength);
        numberOfInversions += sortAndCountInversions(left);
        numberOfInversions += sortAndCountInversions(right);
        numberOfInversions += mergeAndCountSplitInversions(array, left, right);

        return numberOfInversions;
    }

    public static int mergeAndCountSplitInversions(int[] array, int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;

        int i = 0, j = 0, k = 0, numberOfInversions = 0;

        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
                numberOfInversions += leftLength - i;
            }
            k++;
        }

        while (i < leftLength) {
            array[k] = left[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            array[k] = right[j];
            j++;
            k++;
        }

        return numberOfInversions;
    }
}
