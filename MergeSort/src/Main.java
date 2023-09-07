import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] list = {5, 2, 1, 4, 7, 3, 6};
        System.out.println(Arrays.toString(list));
        mergeSort(list);
        System.out.println(Arrays.toString(list));
    }

    public static void mergeSort(int[] list) {
        int listLength = list.length;
        // Base case
        if (listLength <= 1) return;

        // Create two new empty arrays
        int[] a = new int[(listLength / 2) + (listLength % 2)];
        int[] b = new int[listLength / 2];
        // Fill the arrays with the values from the parent array
        int x = 0;
        for (int i = 0; i < listLength; i++) {
            if (i < a.length) {
                a[i] = list[i];
            } else if (i >= a.length) {
                b[x] = list[i];
                x++;
            }
        }
        // Recursively sort these new arrays
        mergeSort(a);
        mergeSort(b);

        merge(a, b, list);
    }

    public static void merge(int[] left, int[] right, int[] list) {

        int aSize = left.length;
        int bSize = right.length;
        // Merge the sorted arrays
        int i = 0, j = 0, k = 0;

        while (i < aSize && j < bSize) {
            if (left[i] <= right[j]) {
                list[k] = left[i];
                i++;
            } else {
                list[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < aSize) {
            list[k] = left[i];
            i++;
            k++;
        }

        while (j < bSize) {
            list[k] = right[j];
            j++;
            k++;
        }
    }
}
