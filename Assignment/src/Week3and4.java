import java.util.*;

public class Week3and4 {

    static int linearSearch(int[] arr, int target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear Found at index: " + i + " | Comparisons: " + comparisons);
                return i;
            }
        }

        System.out.println("Linear Not Found | Comparisons: " + comparisons);
        return -1;
    }

    static int binaryInsertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Insertion Index: " + low + " | Comparisons: " + comparisons);
        return low;
    }

    static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] <= target) {
                ans = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    static int ceiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                ans = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] risks = {10, 25, 50, 100};
        int target = 30;

        linearSearch(risks, target);

        int insertionIndex = binaryInsertionPoint(risks, target);
        int floorValue = floor(risks, target);
        int ceilingValue = ceiling(risks, target);

        System.out.println("Floor: " + floorValue);
        System.out.println("Ceiling: " + ceilingValue);
    }
}