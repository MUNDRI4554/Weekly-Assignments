import java.util.*;

class Client {
    String name;
    int riskScore;
    double accountBalance;

    Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    public String toString() {
        return name + ":" + riskScore;
    }
}

public class Week3and4 {

    static void bubbleSort(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        System.out.println("Bubble Sort (Ascending): " + Arrays.toString(arr));
        System.out.println("Swaps: " + swaps);
    }

    static void insertionSort(Client[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && compare(arr[j], key) < 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        System.out.println("Insertion Sort (Descending): " + Arrays.toString(arr));
    }

    static int compare(Client a, Client b) {
        if (a.riskScore != b.riskScore)
            return Integer.compare(a.riskScore, b.riskScore);
        return Double.compare(a.accountBalance, b.accountBalance);
    }

    static void topRisks(Client[] arr) {
        int limit = Math.min(10, arr.length);
        System.out.print("Top Risks: ");
        for (int i = 0; i < limit; i++) {
            System.out.print(arr[i].name + "(" + arr[i].riskScore + ") ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Client[] clients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 2000),
                new Client("clientB", 50, 3000)
        };

        bubbleSort(clients);
        insertionSort(clients);
        topRisks(clients);
    }
}